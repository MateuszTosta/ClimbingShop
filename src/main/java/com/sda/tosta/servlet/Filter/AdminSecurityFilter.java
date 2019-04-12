package com.sda.tosta.servlet.Filter;

import com.sda.tosta.servlet.DAO.User;
import com.sda.tosta.servlet.User.Roles;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "adminSecurityServlet", servletNames = "addProductServlet")
public class AdminSecurityFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        Object loggedUser = req.getSession().getAttribute("loggedUser");
        User logUser = (User) loggedUser;

        if (!logUser.getRoles().contains(Roles.ADMIN)) {
            HttpServletResponse servletResponse1 = (HttpServletResponse) servletResponse;
            servletResponse1.sendRedirect("/home");
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
