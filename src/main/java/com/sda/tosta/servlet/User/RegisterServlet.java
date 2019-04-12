package com.sda.tosta.servlet.User;

import com.sda.tosta.servlet.DAO.DAOUserDb;
import com.sda.tosta.servlet.DAO.User;
import org.apache.commons.validator.routines.EmailValidator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;

@WebServlet(urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    private DAOUserDb db;

    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        String login = httpServletRequest.getParameter("login");
        String password = httpServletRequest.getParameter("password");
        String email = httpServletRequest.getParameter("email");

        boolean valid = EmailValidator.getInstance().isValid(email);

        if (!db.findByLogin(login).isPresent() && !db.findByEmail(email).isPresent() && valid) {
            User newUser = db.createNewUser(login, password, email, Collections.singletonList(Roles.BASIC_USER));
            httpServletRequest.getSession().invalidate();
            httpServletRequest.getSession().setAttribute("loggedUser", newUser);
            httpServletResponse.sendRedirect("/home");
        } else if (!valid) {
            httpServletResponse.sendRedirect("/wrongEmail");
        } else {
            httpServletResponse.sendRedirect("/loginOrEmailExist");
        }
    }

    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        httpServletRequest
                .getRequestDispatcher("/register.jsp")
                .forward(httpServletRequest, httpServletResponse);
    }

    @Override
    public void init() throws ServletException {
        db = DAOUserDb.getInstance();
    }
}
