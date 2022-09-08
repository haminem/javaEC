package com.homework.javaec.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.homework.javaec.bean.ProductBean;

public class ProductDAO {
    private final String url = "jdbc:postgresql://localhost:5432/postgres";
    private final String user = "postgres";
    private final String password = "postgres";

    public ProductDAO() throws DAOException {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new DAOException("ドライバの登録に失敗しました。");
        }
    }
    
    public List<ProductBean> findAll() throws DAOException {
        String sql = "SELECT * FROM product";
        try (Connection con = DriverManager.getConnection(url, user, password);
                PreparedStatement st = con.prepareStatement(sql);
                ResultSet rs = st.executeQuery()) {
            List<ProductBean> list = new ArrayList<>();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int price = rs.getInt("price");
                ProductBean product = new ProductBean(id, name, price);
                list.add(product);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DAOException("レコードの取得に失敗しました。");
        }
    }
}
