package bank.model.dao;

import bank.model.dto.AccountDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AccountDAO {

    // 계좌 생성 //
    public boolean createAccount(Connection conn, AccountDTO account) {
        String SQL = "insert into accounts (uid, account_id, account_number, balance) values (?, ?, ?, ?)";

        try (PreparedStatement pstmt = conn.prepareStatement(SQL)){
            pstmt.setInt(1, account.getUid());
            pstmt.setInt(2, account.getAccountId());
            pstmt.setString(3, account.getAccountNo());
            pstmt.setLong(4, account.getBalance());

            int rows = pstmt.executeUpdate();
            return rows > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}
