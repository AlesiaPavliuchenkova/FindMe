package com.app.servlet;

import com.app.servlet.DAO.PersonDAO;
import com.app.servlet.DTO.PersonDTO;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * Created by apavliuchenkova on 07/11/2016.
 */
public class TestRun {
    public static void main(String[] args){
        //Map<String, HashSet<String>> countryCityList = new HashMap<String, HashSet<String>>();
        //countryCityList.putAll(Database.getCountryCityList());
        //Iterator<Map.Entry<String, HashSet<String>>> itr1 = countryCityList.entrySet().iterator();

        /*while(itr1.hasNext()){
            Iterator<String> itr2 = itr1.next().getValue().iterator();

            //System.out.println(itr1.next().getKey());
            while(itr2.hasNext()){
                System.out.println("____"+itr2.next());
            }
        }*/
        //ControlAdmin.createJSONCountyCityData();

        /*String pattern = "^[.+\\w\\s]*$";
        String matcher = "al_i.PP9";

        if(matcher.matches(pattern)){
            System.out.println(matcher);
        } else {
            System.out.println(matcher + " isn't correct.");
        }*/

        //PersonDAO personDAO = new PersonDAO();
        //PersonDTO person = personDAO.selectPersonDataByName("jkjkkkkkkkkkkkkk");


        for (Field f:PersonDTO.class.getDeclaredFields()) {
            String fieldName = f.toString().substring(f.toString().lastIndexOf(".")+1,f.toString().length());
            System.out.println(fieldName);
        }

    }
}
