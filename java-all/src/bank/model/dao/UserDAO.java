package bank.model.dao;

import bank.model.dto.UserDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    // 모든 사용자 조회 //
    public List<UserDTO> getAllUsers(Connection conn) throws SQLException {
        List<UserDTO> list = new ArrayList<>();
        String SQL = "select * from users";
        try (
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(SQL)
        ) {
            while (rs.next()) {
                UserDTO user = new UserDTO(
                        rs.getInt("uid"),
                        rs.getString("name"),
                        rs.getString("id"),
                        rs.getString("password"),
                        rs.getString("email"),
                        rs.getString("phone")
                );
                list.add(user);
            }

        } catch (Exception e) { throw new SQLException(e); }
        return list;
    }

    // 사용자 추가 //
    public void addUser(Connection conn, UserDTO user) throws SQLException {
        String SQL = "insert into UserDAO (name, id, password, email, phone) values (?, ?, ?, ?, ?)";

        try (PreparedStatement pstmt = conn.prepareStatement(SQL)) {
            pstmt.setString(1, user.getName());
            pstmt.setString(2, user.getId());
            pstmt.setString(3, user.getPassword());
            pstmt.setString(4, user.getEmail());
            pstmt.setString(5, user.getPhone());
            pstmt.executeUpdate();
            System.out.println("고객 추가 완료 : " + user.getName());
        } catch (Exception e) {e.printStackTrace();}

    }

    // 로그인 //
    public UserDTO login (Connection conn, String id, String password) {
        String SQL = "select * from users where id = ? and password = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(SQL)) {
            pstmt.setString(1, id);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()) {
                return new UserDTO(
                        rs.getInt("uid"),
                        rs.getString("name"),
                        rs.getString("id"),
                        rs.getString("password"),
                        rs.getString("email"),
                        rs.getString("phone")
                );
            }
        } catch (Exception e) { e.printStackTrace(); }
        return null;
    }

    // 특정 사용자 조회 //
    public UserDTO findByUid(Connection conn, int uid) {
        String SQL = "select * from users where uid = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(SQL)) {
            pstmt.setInt(1, uid);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()) {
                return new UserDTO(
                        rs.getInt("uid"),
                        rs.getString("name"),
                        rs.getString("id"),
                        rs.getString("password"),
                        rs.getString("email"),
                        rs.getString("phone")
                );
            }
        } catch (Exception e) { e.printStackTrace(); }
        return null;
    }

    // 사용자 삭제 //
    public void deleteUser(Connection conn, int uid) throws SQLException {
        String SQL = "delete from users where uid = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(SQL)) {
            pstmt.setInt(1, uid);
            int rows = pstmt.executeUpdate();
            if(rows > 0)
                System.out.println("[ " + uid + " ] 사용자 삭제 완료");
            else
                System.out.println("해당 ID의 사용자가 존재하지 않습니다.");
        } catch (Exception e) { e.printStackTrace(); }
    }

    // id 찾기 //

    // id 변경 //

    // id 찾기 -> pw 변경 //

}
