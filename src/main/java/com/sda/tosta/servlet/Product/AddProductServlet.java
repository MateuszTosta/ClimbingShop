package com.sda.tosta.servlet.Product;

import com.sda.tosta.servlet.DAO.DAOProductDb;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

@WebServlet(urlPatterns = "/addProduct", name = "addProductServlet")
public class AddProductServlet extends HttpServlet {
    private DAOProductDb db;

    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        String name = httpServletRequest.getParameter("name");
        String description = httpServletRequest.getParameter("description");
        String category = httpServletRequest.getParameter("categories");
        String price = httpServletRequest.getParameter("price");
        String image = httpServletRequest.getParameter("image");

        long newProduct = db.createNewProduct(name, description, Arrays.asList(category.split(",")),
                Long.valueOf(price), image);
        httpServletResponse.sendRedirect(String.format("/viewProduct?id=%s", newProduct));
    }

    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        httpServletRequest
                .getRequestDispatcher("/addProduct.jsp")
                .forward(httpServletRequest, httpServletResponse);
    }

    @Override
    public void init() throws ServletException {
        db = DAOProductDb.getInstance();
    }
}
