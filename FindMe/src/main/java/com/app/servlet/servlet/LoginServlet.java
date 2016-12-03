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
import java.io.PrintWriter;

/**
 * Created by apavliuchenkova on 04/11/2016.
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{

        //doGet(request,response);
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        PersonDAO personDAO = new PersonDAO();
        try {
            PersonDTO person = personDAO.selectPersonDataByName(userName);
            if (userName.length()==0 ||!(person.getPassword().equals(password))) {
                throw new PersonDTOValidatorException("Invalid login/password.");
            } else {
                response.sendRedirect("/profile.jsp");
            }
        } catch (PersonDTOValidatorException e) {
            request.setAttribute("errorMessage",e.getMessage());
            request.getRequestDispatcher("login.jsp").forward(request,response);
            //e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
                        throws ServletException, IOException{
        request.getRequestDispatcher("login.jsp").forward(request,response);
        }
}
