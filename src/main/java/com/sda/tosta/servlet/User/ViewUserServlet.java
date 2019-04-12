package com.sda.tosta.servlet.User;

import com.sda.tosta.servlet.DAO.DAOUserDb;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/viewUser")
public class ViewUserServlet extends HttpServlet {
    private DAOUserDb db;

    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        String login = httpServletRequest.getParameter("login");
        httpServletRequest.setAttribute("user", db.getUserByLogin(login));


        httpServletRequest
                .getRequestDispatcher("/viewUser.jsp")
                .forward(httpServletRequest, httpServletResponse);
    }

    @Override
    public void init() throws ServletException {
        db = DAOUserDb.getInstance();
    }
}
