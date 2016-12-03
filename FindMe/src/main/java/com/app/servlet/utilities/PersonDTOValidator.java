package com.app.servlet.utilities;

import com.app.servlet.DTO.PersonDTO;
import com.app.servlet.exceptions.PersonDTOValidatorException;

import java.util.Calendar;
import java.util.Date;


/**
 * Created by apavliuchenkova on 25/11/2016.
 */
public final class PersonDTOValidator implements Validator<PersonDTO, PersonDTOValidatorException>{
    private static final PersonDTOValidator _instance = new PersonDTOValidator();

    private PersonDTOValidator() {
        // Pure utility class, do NOT instantiate.
    }

    public static PersonDTOValidator getInstance() {
        return _instance;
    }

    public void validate(PersonDTO person) throws PersonDTOValidatorException {

    }

    public static String validateUserName(final String userName)
            throws PersonDTOValidatorException {
        String exceptionText = "";
        String tab = "\t";
        final int minLength = 5;
        final int maxLength = 30;
        final String userNamePattern = "^[.+\\w\\s]*$";

        if(!isLengthValid(userName,minLength,maxLength))
            exceptionText = exceptionText + "User Name length should be " + minLength + "-" + maxLength+ " symbols" + tab;
        if(!isMatcherValid(userName,userNamePattern))
            exceptionText = exceptionText + "User Name can contain only alpha, digits, _ , ." + tab;

        if(exceptionText.length()>0){throw new PersonDTOValidatorException(exceptionText);}

        return userName;
    }

    public static String validatePassword(final String password)
            throws PersonDTOValidatorException {
        String exceptionText = "";
        String tab = "\t";
        final int minLength = 7;
        final int maxLength = 30;
        final String passwordPattern = "^[.+\\w\\s]*$";

        if(!isLengthValid(password,minLength,maxLength))
            exceptionText = exceptionText + "Password length should be " + minLength + "-" + maxLength+ " symbols." + tab;
        if(!isMatcherValid(password,passwordPattern))
            exceptionText = exceptionText + "Password can contain only alpha, digits, _ , ." + tab;

        if(exceptionText.length()>0){throw new PersonDTOValidatorException(exceptionText);}

        return password;
    }

    public static String validateFirstName(final String firstName)
            throws PersonDTOValidatorException {
        String exceptionText = "";
        String tab = "\t";
        final int minLength = 1;
        final int maxLength = 75;
        final String firstNamePattern = "^[a-zA-Z]*$";

        if(!isLengthValid(firstName,minLength,maxLength))
            exceptionText = exceptionText + "First Name length should be " + minLength + "-" + maxLength+ " symbols." + tab;
        if(!isMatcherValid(firstName,firstNamePattern))
            exceptionText = exceptionText + "First Name can contain only alpha, digits." + tab;

        if(exceptionText.length()>0){throw new PersonDTOValidatorException(exceptionText);}

        return firstName;
    }

    public static String validateLastName(final String lastName)
            throws PersonDTOValidatorException {
        String exceptionText = "";
        String tab = "\t";
        final int minLength = 1;
        final int maxLength = 50;
        final String lastNamePattern = "^[a-zA-Z]*$";

        if(!isLengthValid(lastName,minLength,maxLength))
            exceptionText = exceptionText + "Last Name length should be " + minLength + "-" + maxLength+ " symbols." + tab;
        if(!isMatcherValid(lastName,lastNamePattern))
            exceptionText = exceptionText + "Last Name can contain only alpha, digits." + tab;

        if(exceptionText.length()>0){throw new PersonDTOValidatorException(exceptionText);}

        return lastName;
    }

    public static String validateGender(final String gender)
            throws PersonDTOValidatorException {
        String exceptionText = "";
        String tab = "\t";
        final String genderPattern = "male|female";

        if(!isMatcherValid(gender,genderPattern))
            exceptionText = exceptionText + "Gender " + gender +" doesn't exist." + tab;

        if(exceptionText.length()>0){throw new PersonDTOValidatorException(exceptionText);}

        return gender;
    }

    public static Date validateDateOfBirth(final Date birthDate)
            throws PersonDTOValidatorException {
        Calendar now = Calendar.getInstance();
        Calendar dob = Calendar.getInstance();
        dob.setTime(birthDate);
        if (dob.after(now)) {
            throw new PersonDTOValidatorException("You can't be born in the future.");
        }
        return birthDate;
    }

    public static String validateCountryId(final String countryId){
        String exceptionText = "";
        String tab = "\t";
        final String countryIdPattern = "\\d+";

        if(!isMatcherValid(countryId,countryIdPattern))
            exceptionText = exceptionText + "Country with id = " + countryId +" doesn't exist." + tab;

        return countryId;
    }

    public static String validateCityId(final String cityId){
        String exceptionText = "";
        String tab = "\t";
        final String cityIdPattern = "\\d+";

        if(!isMatcherValid(cityId,cityIdPattern))
            exceptionText = exceptionText + "City with id = " + cityId +" doesn't exist." + tab;

        return cityId;
    }


    private static boolean isLengthValid(final String str, final int minLength, final int maxLength){
        if(str.length() <= minLength || str.length() >= maxLength){
            return false;
        } else {
            return true;
        }
    }

    private static boolean isMatcherValid(final String matcher, final String pattern){
        if(matcher.matches(pattern)){
            return true;
        } else {
            return false;
        }
    }
}
