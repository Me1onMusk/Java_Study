package bank;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    private static String url = "jdbc:mysql://localhost:3306/bank?serverTimezone=UTC";
    private static String user = "root";
    private static String password = "";

    // DB 연결 //
    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(url, user, password);
        } catch (Exception e) { e.printStackTrace(); }
        return null;
    }

    // DB 연결 종료 //
    public static void close(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (Exception e) {
                System.out.println("연결 종료 실패 : " + e.getMessage());
            }
        }
    }

}
