package com.homework.javaec;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.homework.javaec.dao.DAOException;
import com.homework.javaec.dao.PurchaseDAO;
import com.homework.javaec.bean.CartBean;

@WebServlet("/PurchaseServlet")
public class PurchaseServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String action = request.getParameter("action");
            if (action == null) {
                gotoPage(request, response, "/purchase.jsp");
            } else if (action.equals("buy")) {
                HttpSession session = request.getSession(true);
                CartBean cart = (CartBean) session.getAttribute("cart");
                String name = request.getParameter("name");
                String address = request.getParameter("address");
                PurchaseDAO dao = new PurchaseDAO();
                dao.insert(cart, name, address);
                session.removeAttribute("cart");
                gotoPage(request, response, "/purchase.jsp");
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
