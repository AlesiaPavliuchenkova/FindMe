package com.app.servlet.DAO;

import com.app.servlet.DTO.CityDTO;
import com.app.servlet.DTO.CountryDTO;
import com.app.servlet.utilities.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.TreeSet;

/**
 * Created by apavliuchenkova on 24/11/2016.
 */
public class CountryDAO {
    private Connection conn = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;
    private String selectCountries = "select country_id, country_name from country";

    public TreeSet<CountryDTO> getCountryCityList() {
        TreeSet<CountryDTO> countryCityList = new TreeSet<CountryDTO>();

        try{
            ConnectionFactory cn = new ConnectionFactory();
            conn = cn.getConn();
            conn.setAutoCommit(false);
            pstmt = conn.prepareStatement(selectCountries);
            rs = pstmt.executeQuery();
            while(rs.next()){
                int countryId = rs.getInt("country_id");
                String countryName = rs.getString("country_name");
                ArrayList<CityDTO> cityList = new ArrayList<CityDTO>();
                cityList.addAll(CityDAO.getCityList(countryId,conn));
                CountryDTO country = new CountryDTO(countryId,countryName,cityList);
                countryCityList.add(country);
            }
            close(conn,pstmt,rs);

        } catch (SQLException e) {e.printStackTrace();
        } finally {close(conn,pstmt,rs);}

        return countryCityList;
    }

    private void close(Connection conn, PreparedStatement pstmt, ResultSet rs){
        if(conn  != null){try {conn.close();}  catch (SQLException e) {e.printStackTrace();}}
        if(pstmt != null){try {pstmt.close();} catch (SQLException e) {e.printStackTrace();}}
        if(rs    != null){try {rs.close();}    catch (SQLException e) {e.printStackTrace();}}
    }
}