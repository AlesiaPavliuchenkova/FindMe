package com.app.servlet.DAO;

import com.app.servlet.DTO.PersonDTO;
import com.app.servlet.exceptions.PersonDTOValidatorException;
import com.app.servlet.utilities.ConnectionFactory;

import java.sql.*;

/**
 * Created by apavliuchenkova on 24/11/2016.
 */
public class PersonDAO {
    private Connection conn = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;
    PersonDTO personDTO = new PersonDTO();
    private String insertPerson =
                "insert into person " +
                "(user_name,password,first_name,last_name,date_of_birth,gender,country_id,city_id) " +
                "values (?,?,?,?,?,?,?,?)";
    private String updatePerson =
                "update person " +
                   "set person.user_name = ?" +
                      ",person.password = ?" +
                      ",person.first_name = ?" +
                      ",person.last_name = ?" +
                      ",person.date_of_birth = ?" +
                      ",person.gender = ?" +
                      ",person.country_id = ?" +
                      ",person.city_id = ?" +
                  " where person.user_id = ?";
    private String selectPersonById =
                "select user_id,user_name,password,first_name,last_name" +
                      ",date_of_birth,gender,country_id,city_id " +
                  "from person " +
                 "where person.user_id = ?";
    private String selectPersonByName =
                 "select user_id,user_name,password,first_name,last_name" +
                    ",date_of_birth,gender,country_id,city_id " +
                    "from person " +
                    "where person.user_name = ?";

    public void insertPersonData(PersonDTO person){
        try {
            int key;
            ConnectionFactory cn = new ConnectionFactory();
            conn = cn.getConn();
            conn.setAutoCommit(false);
            pstmt = conn.prepareStatement(insertPerson, pstmt.RETURN_GENERATED_KEYS);
            setPreparedStatementParameters(person);
            pstmt.executeUpdate();
            conn.commit();

            rs = pstmt.getGeneratedKeys();
            if(rs.next())person.setUserId(rs.getInt(1));

            close(conn,pstmt,rs);

        } catch (SQLException e) {e.printStackTrace();} //on duplicate userId throw message that such user exists
          finally {close(conn,pstmt,rs);}
    }

    public void updatePersonData(PersonDTO person){
        try {
            ConnectionFactory cn = new ConnectionFactory();
            conn = cn.getConn();
            conn.setAutoCommit(false);
            pstmt = conn.prepareStatement(updatePerson);
            setPreparedStatementParameters(person);
            pstmt.setInt   (9, person.getUserId());

            close(conn,pstmt,rs);

        } catch (SQLException e) {e.printStackTrace();}
          finally {close(conn,pstmt,rs);}
    }

    public PersonDTO selectPersonDataById(int userId)
            throws PersonDTOValidatorException{
        try {
            ConnectionFactory cn = new ConnectionFactory();
            conn = cn.getConn();
            pstmt = conn.prepareStatement(selectPersonById);
                pstmt.setInt(1, userId);
            rs = pstmt.executeQuery();
            resultSetToPersonDTO(rs);

            close(conn,pstmt,rs);

        } catch (SQLException e) {e.printStackTrace();}
          finally {close(conn,pstmt,rs);}

       return personDTO;
    }

    public PersonDTO selectPersonDataByName(String userName)
            throws PersonDTOValidatorException{
        try {
            ConnectionFactory cn = new ConnectionFactory();
            conn = cn.getConn();
            pstmt = conn.prepareStatement(selectPersonByName);
                pstmt.setString(1, userName);
            rs = pstmt.executeQuery();
            resultSetToPersonDTO(rs);

            close(conn,pstmt,rs);

        } catch (SQLException e) {e.printStackTrace();}
        finally {close(conn,pstmt,rs);}
        return personDTO;
    }

    private void setPreparedStatementParameters(PersonDTO person) throws SQLException {
        pstmt.setString(1, person.getUserName());
        pstmt.setString(2, person.getPassword());
        pstmt.setString(3, person.getFirstName());
        pstmt.setString(4, person.getLastName());
        pstmt.setDate  (5, new java.sql.Date(person.getDateOfBirth().getTime()));
        pstmt.setString(6, person.getGender());
        pstmt.setInt   (7, person.getCountryId());
        pstmt.setInt   (8, person.getCityId());
    }

    private void resultSetToPersonDTO(ResultSet rs) throws SQLException,PersonDTOValidatorException {
        if(!rs.isBeforeFirst()||!rs.isAfterLast()) throw new PersonDTOValidatorException("Invalid login/password.");
        while(rs.next()) {
            personDTO.setUserId(rs.getInt("user_id"));
            personDTO.setUserName(rs.getString("user_name"));
            personDTO.setPassword(rs.getString("password"));
            personDTO.setFirstName(rs.getString("first_name"));
            personDTO.setLastName(rs.getString("last_name"));
            personDTO.setDateOfBirth(rs.getString("date_of_birth"));
            personDTO.setCountryId(rs.getInt("country_id"));
            personDTO.setCityId(rs.getInt("city_id"));
            personDTO.setGender(rs.getString("gender"));
        }
    }

    private void close(Connection conn, PreparedStatement pstmt, ResultSet rs){
        if(conn  != null){try {conn.close();}  catch (SQLException e) {e.printStackTrace();}}
        if(pstmt != null){try {pstmt.close();} catch (SQLException e) {e.printStackTrace();}}
        if(rs    != null){try {rs.close();}    catch (SQLException e) {e.printStackTrace();}}
    }

}
