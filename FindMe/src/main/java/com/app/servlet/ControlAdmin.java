package com.app.servlet;


import com.app.servlet.DAO.CountryDAO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by apavliuchenkova on 07/11/2016.
 */
public class ControlAdmin {

    public static void createJSONCountyCityData() {
        Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
        CountryDAO countryDAO = new CountryDAO();
        String json = gson.toJson(countryDAO.getCountryCityList());
        createJSONCountryCityFile(json);
    }

    private static void createJSONCountryCityFile(String json){
        File destination = new File("web/files/countriesCities.json");
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(destination));
            writer.write(json);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
