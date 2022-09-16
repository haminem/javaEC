package com.homework.javaec.dao;

import com.homework.javaec.bean.CartBean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PurchaseDAO {
    private final String url = "jdbc:postgresql://localhost:5432/postgres";
    private final String user = "postgres";
    private final String password = "postgres";

    public PurchaseDAO() throws DAOException {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new DAOException("ドライバの登録に失敗しました。");
        }
    }

    public void insert(CartBean cart , String name, String address) throws DAOException {
        for (int i = 0; i < cart.getItems().size(); i++) {
            String sql = "INSERT INTO purchase ( product_id, product_name, product_price, customer_name, customer_address ) VALUES ( ?, ?, ?, ?, ? )";
            try (Connection con = DriverManager.getConnection(url, user, password);
                 PreparedStatement st = con.prepareStatement(sql)) {
                st.setInt(1, cart.getItems().get(i).getId());
                st.setString(2, cart.getItems().get(i).getName());
                st.setInt(3, cart.getItems().get(i).getPrice());
                st.setString(4, name);
                st.setString(5, address);
                st.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
                throw new DAOException("レコードの追加に失敗しました。");
            }
        }
    }
}
