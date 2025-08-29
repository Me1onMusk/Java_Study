import java.sql.*;

public class DBConnectTest {
    public static void main(String[] args) throws SQLException {

        Connection conn = makeConnection();
//        Statement stmt = conn.createStatement();

        String sql = "insert into person (name, phone, email) values (?, ?, ?)";

//        ResultSet rs = stmt.executeQuery(sql);  //DB에 SQL 쿼리를 보내 실행하고, 그 결과로 반환된 데이터 집합을 받아오기 위해 사용

        PreparedStatement pstmt = conn.prepareStatement(sql);
        //코드는 Statement 객체보다 향상된 성능과 강력한 보안을 제공하기 때문에 사용
        //미리 SQL 쿼리의 틀을 만들어 놓고, 필요한 값만 나중에 채워 넣는 방식

        pstmt.setString(1, "테스트");
        pstmt.setString(2, "010-1234-5678");
        pstmt.setString(3, "test@test.com");

        // SQL문 실행 //
        if(pstmt.executeUpdate() == 1)
            System.out.println("레코드 추가 성공");
        else
            System.out.println("레코드 추가 실패");

        // 연결 종료 //
//        stmt.close();
        pstmt.close();
        conn.close();

    }

    public static Connection makeConnection() {
        String url = "jdbc:mysql://localhost:3306/testdb?serverTimezone=Asia/Seoul";

        // 커넥션 //
        Connection conn = null;

        // 1. 드라이버 로드
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("데이터베이스 연결중...");
            conn = DriverManager.getConnection(url, "root", "");
            System.out.println("데이터베이스 연결 성공");
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC 드라이버를 찾지 못했습니다");
        } catch (SQLException e) {
            System.out.println("데이터베이스 연결 실패");
        } catch (Exception e) {
            System.out.println("데이터베이스 연결 중 오류 발생");
        }

        return conn;
    }
}
