package com.homework.javaec.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerDAO {

    public CustomerDAO() throws DAOException {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new DAOException("ドライバの登録に失敗しました。");
        }
    }

    public boolean check(String login, String password) throws DAOException {
        String sql = "SELECT * FROM customer WHERE login = ? AND password = ?";
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String user = "postgres";
        try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement st = con.prepareStatement(sql)) {
            st.setString(1, login);
            st.setString(2, password);
            try (ResultSet rs = st.executeQuery()) {
                return rs.next();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DAOException("レコードの取得に失敗しました。");
        }
    }
}
