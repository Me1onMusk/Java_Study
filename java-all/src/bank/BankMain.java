package bank;

import bank.model.dao.AccountDAO;
import bank.model.dao.UserDAO;
import bank.model.dto.AccountDTO;
import bank.model.dto.UserDTO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class BankMain {

    static UserDTO currentUser = null;

    public static void main(String[] args) throws SQLException {

        Scanner scanner = new Scanner(System.in);

        // DB 연결 //
        Connection conn = DBConnection.getConnection();

        AccountDAO accountDAO = new AccountDAO();
        UserDAO userDao = new UserDAO();

        while (true) {
            // 로그인 안한 경우 //
            if (currentUser == null) {
                System.out.println("1.회원가입 | 2.로그인 | 3.종료");
                int option = Integer.parseInt(System.console().readLine());
                switch (option) {
                    case 1:
                        signUp(scanner, conn, userDao);
                        break;
                    case 2:
                        login(scanner, conn, userDao);
                        break;
                    case 3:
                        System.out.println("프로그램을 종료합니다");
                        System.exit(0);
                    default:
                        System.out.println("잘못 입력했습니다.");
                }
            }
            // 로그인 한 경우 //
            else {
                // 관리자 //
                if (currentUser.getId().equals("admin")) {
                    System.out.println("1.회원입력 | 2.로그아웃 | 3.모든사용자 조회 | 4.특정사용자 조회 | 5.사용자 삭제 | 6.종료");
                    int option = Integer.parseInt(System.console().readLine());
                    switch (option) {
                        case 1:
                            break;
                        case 2:
                            logout();
                            break;
                        case 6:
                            System.out.println("프로그램을 종료합니다");
                            System.exit(0);
                        default:
                            System.out.println("잘못 입력했습니다.");

                    }
                } else {
                    System.out.println("1.로그아웃 | 2.계좌 생성 | 3.입금 | 4.출금 | 5.종료");
                    int option = Integer.parseInt(System.console().readLine());
                    switch (option) {
                        case 1:
                            logout();
                            break;
                        case 2:
                            makeAccount(scanner, conn, accountDAO);
                            break;
                        case 5:
                            System.out.println("프로그램을 종료합니다");
                            System.exit(0);
                        default:
                            System.out.println("잘못 입력했습니다.");
                    }
                }

            }
            DBConnection.close(conn);
        }
    }

    // 계좌 생성 //
    private static void makeAccount(Scanner scanner, Connection conn, AccountDAO accountDAO) {
        System.out.println("계좌 생성");
        System.out.print("계좌번호 : ");
        String accountNo = String.valueOf(scanner.nextLine());
        System.out.print("계좌 비밀번호 : ");
        int password = Integer.parseInt(scanner.nextLine());
        if (accountDAO.createAccount(conn, new AccountDTO(
                currentUser.getUid(),
                accountNo,
                password
        )))
            System.out.println("계좌가 생성되었습니다. 계좌번호 : " + accountNo);
        else
            System.out.println("계좌 생성에 실패했습니다.");
    }

    // 로그아웃 //
    private static void logout() {
        System.out.println("[ " + currentUser.getName() + "님] 로그아웃");
        currentUser = null;
    }

    // 로그인 //
    private static void login(Scanner scanner, Connection conn, UserDAO userDao) {
        System.out.println("로그인");
        System.out.println("아이디 : ");
        String id = String.valueOf(scanner.nextLine());
        System.out.println("비밀번호 : ");
        String password = String.valueOf(scanner.nextLine());
        currentUser = userDao.login(conn, id, password);
        if (currentUser == null)
            System.out.println("로그인 실패");
        else
            System.out.println("[" + currentUser.getName() + "님] 환영합니다");
    }

    // 회원가입 //
    private static void signUp(Scanner scanner, Connection conn, UserDAO userDao) throws SQLException {
        System.out.println("회원가입");
        System.out.print("이름 : ");
        String name = scanner.nextLine();
        System.out.print("아이디 : ");
        String id = scanner.nextLine();
        System.out.print("비밀번호 : ");
        String password = scanner.nextLine();
        System.out.print("비밀번호 재입력 : ");
        String password2 = scanner.nextLine();
        if (!password.equals(password2)) {
            System.out.println("비밀번호가 서로 다릅니다.");
            return;
        }
        System.out.print("이메일 : ");
        String email = scanner.nextLine();
        System.out.print("전화번호 : ");
        String phone = scanner.nextLine();
        userDao.addUser(conn, new UserDTO(
                name,
                id,
                password,
                email,
                phone
        ));
    }
}
