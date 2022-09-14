package com.homework.javaec;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.homework.javaec.bean.ProductBean;
import com.homework.javaec.dao.DAOException;
import com.homework.javaec.dao.ProductDAO;

@WebServlet("/showProductServlet")
public class showProductServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            ProductDAO dao = new ProductDAO();
            List<ProductBean> list = dao.findAll();
            request.setAttribute("products", list);
            RequestDispatcher rd = request.getRequestDispatcher("/showProduct.jsp");
            rd.forward(request, response);
        } catch (DAOException e) {
            e.printStackTrace();
            request.setAttribute("message", "内部エラーが発生しました。");
            RequestDispatcher rd = request.getRequestDispatcher("/errInternal.jsp");
            rd.forward(request, response);
        }
    }
}
