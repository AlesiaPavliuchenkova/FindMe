package com.app.servlet.DTO;

import com.app.servlet.exceptions.PersonDTOValidatorException;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import static com.app.servlet.utilities.PersonDTOValidator.*;

/**
 * Created by apavliuchenkova on 04/11/2016.
 */
public class PersonDTO { /*POJO can contain some logic
                           DTO can't. Is it correct to call this class DTO???????*/

    private int userId;
    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private int age;
    private String gender;private int countryId;
    private int cityId;
    private boolean isAdmin;
    //private String email;

    public PersonDTO(){   }

    public PersonDTO (String userName
                , String password
                , String firstName
                , String lastName
                , String dateOfBirth
                , String gender
                , String countryId
                , String cityId) throws PersonDTOValidatorException {
        /*try{*/
            this.userName = validateUserName(userName);
            this.password = validatePassword(password);
            this.firstName = validateFirstName(firstName);
            this.lastName = validateLastName(lastName);
            if(dateOfBirth.length()>0) {
                this.dateOfBirth = validateDateOfBirth(setDateOfBirth(dateOfBirth));
                setAge();
            }
            this.gender = validateGender(gender);
            this.countryId = Integer.parseInt(validateCountryId(countryId));
            this.cityId = Integer.parseInt(validateCityId(cityId));
            this.isAdmin = false;
        /*} catch (PersonDTOValidatorException ex){
            ex.printStackTrace();
        }*/

    }

    public String getUserName() {return userName; }

    public void setUserName(String userName) { this.userName = userName; }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateOfBirth() {return dateOfBirth; }

    public Date setDateOfBirth(String dateOfBirth) {
        /*move to controller?????*/
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date birthDate = new Date();
        try {
            //System.out.println(dateOfBirth);
            birthDate = format.parse(dateOfBirth);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return birthDate;
    }

    public int getAge() {
        return calculateAge();
    }

    public void setAge() {
        this.age = calculateAge();
    }

    public String getGender() {return gender;}

    public void setGender(String gender) {this.gender = gender;}

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int city) {
        this.cityId = city;
    }

    public boolean isAdmin() {return isAdmin;}

    /*move to controller?????*/
    private int calculateAge(){
        Calendar birthDay = Calendar.getInstance();
        birthDay.setTime(this.dateOfBirth);
        Calendar today = Calendar.getInstance();
        int age = today.get(Calendar.YEAR)-birthDay.get(Calendar.YEAR);
        if (today.get(Calendar.DAY_OF_YEAR) < birthDay.get(Calendar.DAY_OF_YEAR)) age--;
        return age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", countryId=" + countryId +
                ", cityId=" + cityId +
                '}';
    }
}
