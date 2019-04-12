package com.sda.tosta.servlet.Product;

import com.sda.tosta.servlet.DAO.DAOProductDb;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/viewProduct")
public class ProductViewServlet extends HttpServlet {
    private DAOProductDb db;

    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        String id = httpServletRequest.getParameter("id");
        httpServletRequest.setAttribute("product", db.getProductById(Integer.valueOf(id)));
        Cookie cookie = new Cookie("lastView", id);
        httpServletResponse.addCookie(cookie);

        httpServletRequest
                .getRequestDispatcher("/viewProduct.jsp")
                .forward(httpServletRequest, httpServletResponse);
    }


    @Override
    public void init() throws ServletException {
        db = DAOProductDb.getInstance();
    }
}
