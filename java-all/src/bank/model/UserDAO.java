package bank.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    private Connection conn;
    
    // DB 연결 메서드 //
    public void connect() {
        String url = "jdbc:mysql://localhost:3306/bank?serverTimezone=UTC";
        String user = "root";
        String password = "";

        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("DB 연결 성공");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 모든 사용자 조회 (select) //
    public List<User> getAllUsers() throws SQLException {
        List<User> list = new ArrayList<>();
        String SQL = "select * from users";
        try (
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(SQL)
            ) {
            while (rs.next()) {
                User user = new User(
                        rs.getInt("uid"),
                        rs.getString("name"),
                        rs.getString("id"),
                        rs.getString("password"),
                        rs.getString("email"),
                        rs.getString("phone")
                );
                list.add(user);
            }

        } catch (Exception e) {
            throw new SQLException(e);
        }
        return list;
    }

    // 사용자 추가 (insert) //
    public void addUser(User user) {
        String SQL = "insert into users (name, id, password, email, phone) values (?, ?, ?, ?, ?)";

        try (PreparedStatement pstmt = conn.prepareStatement(SQL)) {
            pstmt.setString(1, user.getName());
            pstmt.setString(2, user.getId());
            pstmt.setString(3, user.getPassword());
            pstmt.setString(4, user.getEmail());
            pstmt.setString(5, user.getPhone());
            pstmt.executeUpdate();
            System.out.println("사용자 추가 완료 : " + user.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 로그인 //
    public User login (String id, String password) {
        String SQL = "select * from users where id = ? and password = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(SQL)) {
            pstmt.setString(1, id);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()) {
                return new User(
                        rs.getInt("uid"),
                        rs.getString("name"),
                        rs.getString("id"),
                        rs.getString("password"),
                        rs.getString("email"),
                        rs.getString("phone")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // 특정 사용자 조회 //
    public User findById (int uid) {
        String SQL = "select * from users where uid = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(SQL)) {
            pstmt.setInt(1, uid);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()) {
                return new User(
                        rs.getInt("uid"),
                        rs.getString("name"),
                        rs.getString("id"),
                        rs.getString("password"),
                        rs.getString("email"),
                        rs.getString("phone")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // 사용자 삭제 (delete) //
    public void deleteUser(int uid) {
        String SQL = "delete from users where uid = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(SQL)) {
            pstmt.setInt(1, uid);
            int rows = pstmt.executeUpdate();
            if(rows > 0)
                System.out.println("[ " + uid + " ] 사용자 삭제 완료");
            else
                System.out.println("해당 ID의 사용자가 존재하지 않습니다.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // DB 연결 종료 //
    public void disconnect() {
        try {
            if (conn != null) {
                conn.close();
                System.out.println("DB 연결 종료");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ID 입력 -> PW 변경 //

    // ID 찾기 //

    // PW 찾기 //
}
