package com.app.servlet.servlet;

import com.app.servlet.DAO.PersonDAO;
import com.app.servlet.DTO.PersonDTO;
import com.app.servlet.exceptions.PersonDTOValidatorException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by apavliuchenkova on 04/11/2016.
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("register.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{

        try {
            savePerson(request);
        } catch (PersonDTOValidatorException e) {
            e.printStackTrace(); /*write exception to log and return to the screen*/
            e.logException(e);//???????????????????????????????????????????????????
            request.getRequestDispatcher("/register.jsp").forward(request,response);
            /*show message what was wrong to user*/
        }
        response.sendRedirect("/profile.jsp");
    }

    private PersonDTO savePerson(HttpServletRequest request) throws PersonDTOValidatorException {
        String userName    = request.getParameter("userName");
        String password    = request.getParameter("password");
        String firstName   = request.getParameter("firstName");
        String lastName    = request.getParameter("lastName");
        String dateOfBirth = request.getParameter("dateOfBirth");
        String gender      = request.getParameter("gender");
        String countryId   = request.getParameter("country");
        String cityId      = request.getParameter("city");

        PersonDTO person = new PersonDTO(userName,password,firstName,lastName,dateOfBirth,gender,countryId,cityId);
        PersonDAO personDAO = new PersonDAO();
        personDAO.insertPersonData(person);
        System.out.println(person.toString());

        return person;
    }

    private String buildRegisterForm(){
        String registerForm = "";

        PersonDTO.class.getDeclaredFields();

        return registerForm;
    }
}
