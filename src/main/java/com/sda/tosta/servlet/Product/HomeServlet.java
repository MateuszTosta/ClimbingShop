package com.sda.tosta.servlet.Product;

import com.sda.tosta.servlet.DAO.DAOProductDb;
import com.sda.tosta.servlet.DAO.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@WebServlet(urlPatterns = "/home")
public class HomeServlet extends HttpServlet {
    private DAOProductDb db;

    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
            throws ServletException, IOException {
        //PrintWriter writer = httpServletResponse.getWriter();
        //writer.print("Hello World");
        httpServletRequest.setAttribute("name", "Pawel");

        String name = httpServletRequest.getParameter("name");
        String category = httpServletRequest.getParameter("category");
        List<Product> byName = new ArrayList<>();
        List<Product> byCategory = new ArrayList<>();
        if (name != null) {
            byName = db.getProductList().stream()
                    .filter(product -> product.getName().equalsIgnoreCase(name)).collect(Collectors.toList());
        }
        if (category != null) {
            byCategory = db.getProductList().stream()
                    .filter(product -> product.getCategories().contains(category)).collect(Collectors.toList());
        }

        httpServletRequest.setAttribute("products", Stream.concat(byCategory.stream(), byName.stream())
                .collect(Collectors.toList()));

        Cookie[] cookies = httpServletRequest.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("lastView")) {
                    httpServletRequest.setAttribute("advertisement",
                            db.getProductById(Integer.parseInt(cookie.getValue())).get().getImage());
                }
            }
        }

        httpServletRequest
                .getRequestDispatcher("/index.jsp")
                .forward(httpServletRequest, httpServletResponse);
    }

    private List<Product> getProductListByName(HttpServletRequest httpServletRequest) {
        String name = httpServletRequest.getParameter("name");
        List<Product> productListByName = db.getProductList();
        if (name != null) {
            productListByName = productListByName.stream()
                    .filter(x -> x.getName().equals(name))
                    .collect(Collectors.toList());
        }
        return productListByName;
    }

    private List<Product> getProductListByCategory(HttpServletRequest httpServletRequest) {
        String category = httpServletRequest.getParameter("category");
        List<Product> productList = db.getProductList();
        if (category != null) {
            productList = productList.stream()
                    .filter(x -> x.getCategories().contains(category))
                    .collect(Collectors.toList());
        }
        return productList;
    }

    @Override
    public void init() throws ServletException {
        db = DAOProductDb.getInstance();
    }
}
