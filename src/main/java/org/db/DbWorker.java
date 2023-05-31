package org.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbWorker {

    public static String demoQuery(String capacity) {
        Connection conn = DbConnection.getConnection();
        String grpdb = null;
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM ssd WHERE capacity = 480");
            while (rs.next()) {
            grpdb = rs.getString("size");
            }
            System.out.println(rs.getString("size"));
            rs.close();
            st.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return grpdb;
    }

   public static void dirtyReadDemo(String capacity, String size) {
        Runnable first = () -> {
            Connection conn1 = DbConnection.getNewConnection();
            if (conn1 != null) {
                try {
                    Statement upd = conn1.createStatement();
                    upd.executeUpdate("UPDATE student SET size='size' WHERE capacity ='capacity'");
                    Thread.sleep(2000);
                    upd.close();
                    conn1.close();
                } catch (SQLException | InterruptedException throwables) {
                    throwables.printStackTrace();
                }
            }
        };

        Thread th1 = new Thread(first);
        th1.start();
    }
}
