package com.sda.tosta.servlet.User;

import com.sda.tosta.servlet.DAO.DAOUserDb;
import com.sda.tosta.servlet.DAO.User;
import org.apache.commons.codec.digest.DigestUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    private DAOUserDb db;

    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        httpServletRequest
                .getRequestDispatcher("/login.jsp")
                .forward(httpServletRequest, httpServletResponse);
    }

    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        String login = httpServletRequest.getParameter("login");
        String password = httpServletRequest.getParameter("password");
        String sha256hex = DigestUtils.sha256Hex(password);

        if (login != null && password != null) {
            Optional<User> optionalUser = db.findByLoginAndPassword(login, sha256hex);
            if (optionalUser.isPresent()) {
                httpServletRequest.getSession().setAttribute("loggedUser", optionalUser.get());
                httpServletResponse.sendRedirect("/home");
            } else {
                httpServletRequest.setAttribute("Error", "User is not exist");
            }
        } else {
            httpServletRequest.setAttribute("Error", "Wrong login or password");
        }
    }

    @Override
    public void init() throws ServletException {
        db = DAOUserDb.getInstance();
    }
}
