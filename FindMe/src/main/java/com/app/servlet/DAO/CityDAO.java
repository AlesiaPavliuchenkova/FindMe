package com.app.servlet.DAO;

import com.app.servlet.DTO.CityDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by apavliuchenkova on 24/11/2016.
 */
public class CityDAO {

    public static ArrayList<CityDTO> getCityList(int country_id, Connection conn)
            throws SQLException {
        ResultSet rs = null;
        ArrayList<CityDTO> cityList = new ArrayList<CityDTO>();
        String selectCity = "select city_id, city_name from city where city.country_id=?";

        try(PreparedStatement statement = conn.prepareStatement(selectCity)) {
            statement.setInt(1,country_id);
            rs = statement.executeQuery();
            while (rs.next()){
                CityDTO city = new CityDTO(rs.getInt("city_id"),rs.getString("city_name"));
                cityList.add(city);
            }
            statement.close();
        } finally {
            rs.close();
        }
        Collections.sort(cityList);
        return cityList;
    }
}
