package com.homework.javaec.dao;

import com.homework.javaec.bean.PurchaseBean;

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
}
