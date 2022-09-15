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
import com.homework.javaec.dao.CustomerDAO;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String action = request.getParameter("action");
            if (action == null) {
                gotoPage(request, response, "/login.jsp");
            } else if (action.equals("login")) {
                String login = request.getParameter("login");
                String password = request.getParameter("password");
                CustomerDAO dao = new CustomerDAO();
                if (dao.check(login, password)) {
                    HttpSession session = request.getSession(true);
                    session.setAttribute("login", login);
                    gotoPage(request, response, "/index.jsp");
                } else {
                    request.setAttribute("message", "ログインに失敗しました。");
                    gotoPage(request, response, "/login.jsp");
                }
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
