package com.homework.javaec;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.homework.javaec.bean.CartBean;
import com.homework.javaec.bean.ProductBean;
import com.homework.javaec.dao.DAOException;
import com.homework.javaec.dao.ProductDAO;

@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String action = request.getParameter("action");
            if (action == null) {
                gotoPage(request, response, "/cart.jsp");
            } else if (action.equals("add")) {
                HttpSession session = request.getSession(true);
                int id = Integer.parseInt(request.getParameter("id"));
                CartBean cart = (CartBean) session.getAttribute("cart");
                if (cart == null) {
                    cart = new CartBean();
                    session.setAttribute("cart", cart);
                }
                ProductDAO dao = new ProductDAO();
                ProductBean product = dao.findById(id);
                cart.addCart(product);
                gotoPage(request, response, "/cart.jsp");
            } else if (action.equals("delete")) {
                HttpSession session = request.getSession(false);
                CartBean cart = (CartBean) session.getAttribute("cart");
                int id = Integer.parseInt(request.getParameter("id"));
                cart.deleteCart(id);
                gotoPage(request, response, "/cart.jsp");
            }
        } catch (DAOException e) {
            e.printStackTrace();
            request.setAttribute("message", "内部エラーが発生しました。");
            RequestDispatcher rd = request.getRequestDispatcher("/errInternal.jsp");
            rd.forward(request, response);
        }
    }

    private void gotoPage(HttpServletRequest request, HttpServletResponse response, String page) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher(page);
        rd.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
