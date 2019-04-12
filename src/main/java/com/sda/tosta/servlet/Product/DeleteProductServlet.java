package com.sda.tosta.servlet.Product;

import com.sda.tosta.servlet.DAO.DAOProductDb;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/deleteProduct")
public class DeleteProductServlet extends HttpServlet {
    private DAOProductDb db;

    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        String id = httpServletRequest.getParameter("id");
        db.deleteProductById(Integer.valueOf(id));

        httpServletResponse.sendRedirect("/allProducts");
    }


    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        httpServletRequest
                .getRequestDispatcher("/deleteProduct.jsp")
                .forward(httpServletRequest, httpServletResponse);
    }

    @Override
    public void init() throws ServletException {
        db = DAOProductDb.getInstance();
    }
}
