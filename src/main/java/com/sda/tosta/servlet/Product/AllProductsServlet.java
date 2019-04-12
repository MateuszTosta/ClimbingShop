package com.sda.tosta.servlet.Product;

import com.sda.tosta.servlet.DAO.DAOProductDb;
import com.sda.tosta.servlet.DAO.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/allProducts")
public class AllProductsServlet extends HttpServlet {
    private DAOProductDb db;

    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        List<Product> productList = db.getProductList();
        httpServletRequest.setAttribute("allProducts", productList);

        httpServletRequest.getRequestDispatcher("/allProducts.jsp")
                .forward(httpServletRequest, httpServletResponse);
    }

    @Override
    public void init() throws ServletException {
        db = DAOProductDb.getInstance();
    }


}
