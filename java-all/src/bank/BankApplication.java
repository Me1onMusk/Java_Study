package bank;

import bank.model.User;
import bank.model.UserDAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

/// /        List<bank.model.Account> accountList = new ArrayList<>();
//        Map<String, Account> accountList = new HashMap<>();  // <키 : 계좌번호 & 값 : 계좌>
//
//        centerAlign("은행");
//        String msg1 = """
//                | 1.계좌생성 | 2.계좌목록 | 3.예금 | 4.출금 | 5.종료 |
//                """;
//        Scanner scanner = new Scanner(System.in);
//
//        while (true) {
//            System.out.print(msg1);
//            line();
//            System.out.print("| 선택 > ");
//            String input = scanner.nextLine();
//            switch (input) {
//                case "1" -> makeAccount(scanner, accountList);
//                case "2" -> accountList(accountList);
//                case "3" -> deposit(scanner, accountList);
//                case "4" -> withdraw(scanner, accountList);
//                case "5" -> exit();
//                default -> format("올바른 번호를 입력하세요.");
//            }
//        }
//    }
//
//    // 계좌 생성 //
//    private static void makeAccount(Scanner scanner, Map<String, Account> accountList) {
//        centerAlign("계좌생성");
//
//        try {
//            inputFormat("계좌번호");
//            String accountNo = scanner.nextLine();
//
//            // 계좌번호 중복 체크 //
//            if (checkAccount(accountList, accountNo))
//                return;
//
//            inputFormat("계좌주");
//            String accountName = scanner.nextLine();
//
//            inputFormat("비밀번호");
//            String password = scanner.nextLine();
//            if (password.length() > 4) {
//                format("비밀번호는 4자리 입니다.");
//                line();
//                return;
//            }
//
//            inputFormat("비밀번호 재확인");
//            String password2 = scanner.nextLine();
//            if (!password.equals(password2)) {
//                format("비밀번호가 다릅니다.");
//                line();
//                return;
//            }
//
//            inputFormat("초기 입금액");
//            long balance = Long.parseLong(scanner.nextLine());
//            if (balance < 0) {
//                format("초기 금액은 0보다 커야 합니다.");
//                return;
//            }
//
//            accountList.put(accountNo, new Account(accountNo, accountName, password, balance));
//            centerAlign("계좌가 생성되었습니다");
//            accountStatus(accountList.get(accountNo));
//            line();
//        } catch (NumberFormatException e) {
//            scanner.nextLine();
//            line();
//            centerAlign("계좌정보가 올바르지 않습니다.");
//        }
//
//    }
//
//    // 계좌번호 중복 검사 //
//    private static boolean checkAccount(Map<String, Account> accountList, String accountNo) {
//        if(accountList.containsKey(accountNo)) {
//            format("해당 계좌번호가 이미 존재합니다.");
//            return true;
//        }
//        return false;
//    }
//
//    // 계좌 목록 //
//    private static void accountList(Map<String, Account> accountList) {
//        centerAlign("계좌목록");
//        if (accountList.isEmpty())
//            centerAlign("없음");
//        else {
//            for (String checkNo : accountList.keySet()) {
//                Account account = accountList.get(checkNo);  // 해당 계좌번호와 일치하는 계좌
//                accountStatus(account);
//                line();
//            }
//        }
//    }
//
//    // 예금 //
//    private static void deposit(Scanner scanner, Map<String, Account> accountList) {
//        centerAlign("예금");
//        System.out.print("| 계좌번호 : ");
//        String accountNo = scanner.nextLine();
//
//        if (accountList.isEmpty()) {
//            line();
//            centerAlign("계좌정보가 없습니다.");
//        }
//
//        // 해당 계좌번호를 찾지 못했다면~
//        if(!accountList.containsKey(accountNo)){
//            format("해당 계좌번호가 없습니다. 다시 입력해주세요");
//            line();
//            return;
//        }
//
//        // 해당 계좌번호를 찾았다면~
//        while (true) {
//            Account account = accountList.get(accountNo);  // 해당 계좌번호와 일치하는 계좌
//            System.out.print("| 예금할 금액 : ");
//            long deposit = Long.parseLong(scanner.nextLine());
//            if (deposit <= 0)
//                format("예금할 금액을 정확히 입력해 주세요");
//            else {
//                account.setBalance(account.getBalance() + deposit);
//                accountStatus(account);
//                return;
//            }
//        }
//
//    }
//
//    // 출금 //
//    private static void withdraw(Scanner scanner, Map<String, Account> accountList) {
//        centerAlign("출금");
//        System.out.print("| 계좌번호 : ");
//        String accountNo = scanner.nextLine();
//        for (String checkNo : accountList.keySet()) {
//            if (!checkNo.equals(accountNo)) {
//                format("해당 계좌번호가 없습니다. 다시 입력해주세요.");
//                line();
//                break;
//            }
//            Account account = accountList.get(checkNo);  // 해당 계좌번호 계좌
//            System.out.println("| 잔액 : " + account.getBalance() + "원");
//            System.out.print("| 출금할 금액 : ");
//            long withdraw = Long.parseLong(scanner.nextLine());
//            if (withdraw <= 0)
//                format("출금할 금액을 정확하게 입력하세요.");
//            else if (withdraw > account.getBalance())
//                format("출금할 금액이 잔액보다 많습니다.");
//            else {
//                account.setBalance(account.getBalance() - withdraw);
//                accountStatus(account);
//                return;
//            }
//        }
//    }
//
//    // 시스템 종료 //
//    private static void exit() {
//        centerAlign("시스템을 종료합니다");
//        System.exit(0);
//    }
//
//    // 계좌 현황 //
//    private static void accountStatus(Account account) {
//        System.out.printf("| 계좌번호: %-10s | 이름: %-6s | 잔액: %4s원 |\n", account.getAccountNo(), account.getAccountName(), account.getBalance());
//    }
//
//    // 글자 가운데 정렬 //
//    private static void centerAlign(String str) {
//        line();
//        int totalWidth = lineLength() - 4;
//        int leftPadding = (totalWidth - str.length()) / 2;
//        int rightPadding = totalWidth - str.length() - leftPadding;
//        String result = " ".repeat(leftPadding) + str + " ".repeat(rightPadding);
//        System.out.println("|" + result + "|");
//        line();
//    }
//
//    // 문자열 포맷 //
//    private static void format(String str) {
//        String message = String.format("| %-3s", str);
//        System.out.println(message);
//    }
//
//    // 입력 문자열 포맷 //
//    private static void inputFormat(String s1) {
//        System.out.printf("| %-14s : ", s1);
//    }
//
//    // 선 디자인 //
//    private static void line() {
//        String line = "|----------------------------------------------------|";
//        System.out.println(line);
//    }
//
//    // 선 길이 //
//    private static int lineLength() {
//        String line = "|----------------------------------------------------|";
//        return line.length()-2;
//    }
//}

public class BankApplication {

    static User currentUser = null;

    public static void main(String[] args) throws SQLException {

        Scanner scanner = new Scanner(System.in);
        UserDAO dao = new UserDAO();

        while (true) {
            if (currentUser == null) {
                dao.connect();

                System.out.println("1.회원가입 | 2.로그인 | 3.모든사용자 조회 | 4.특정사용자 조회 | 5.사용자 삭제 | 6.종료");
                int option = Integer.parseInt(scanner.nextLine());

                switch (option) {
                    case 1:
                        signUp(scanner, dao);
                        break;
                    case 2:
                        signIn(scanner, dao);
                        break;
                    case 3:
                        showAll(dao);
                        break;
                    case 4:
                        System.out.println("특정 사용자 조회");
                        System.out.print("사용자 UID : ");
                        int uid = Integer.parseInt(scanner.nextLine());
                        User user = dao.findById(uid);
                        if (user == null)
                            System.out.println("해당 사용자가 없습니다.");
                        else
                            System.out.println(user);
                        break;
                    case 5:
                        System.out.println("특정 사용자 삭제");
                        deleteUser(scanner, dao);
                        break;
                    case 6:
                        dao.disconnect();
                        System.exit(0);
                    default:
                        System.out.println("잘못 입력했습니다.");
                        break;
                }

                dao.disconnect();
            } else {
                System.out.println(currentUser.getName()+ "님 환영합니다.");

                dao.connect();

                System.out.println("1.회원가입 | 2.로그인 | 3.모든사용자 조회 | 4.특정사용자 조회 | 5.사용자 삭제 | 6.종료");
                int option = Integer.parseInt(scanner.nextLine());

                switch (option) {
                    case 1:
                        signUp(scanner, dao);
                        break;
                    case 2:
                        signIn(scanner, dao);
                        break;
                    case 3:
                        showAll(dao);
                        break;
                    case 4:
                        System.out.println("특정 사용자 조회");
                        System.out.print("사용자 UID : ");
                        int uid = Integer.parseInt(scanner.nextLine());
                        User user = dao.findById(uid);
                        if (user == null)
                            System.out.println("해당 사용자가 없습니다.");
                        else
                            System.out.println(user);
                        break;
                    case 5:
                        System.out.println("특정 사용자 삭제");
                        deleteUser(scanner, dao);
                        break;
                    case 6:
                        dao.disconnect();
                        System.exit(0);
                    default:
                        System.out.println("잘못 입력했습니다.");
                        break;
                }

                dao.disconnect();

            }
        }

    }

    private static void signIn(Scanner scanner, UserDAO dao) {
        System.out.println("로그인");
        System.out.print("ID : ");
        String id = scanner.nextLine();
        System.out.print("비밀번호 : ");
        String password = scanner.nextLine();

        currentUser = dao.login(id, password);
        if (currentUser == null)
            System.out.println("해당 사용자가 없습니다.");
    }

    private static void deleteUser(Scanner scanner, UserDAO dao) {
        System.out.println("회원삭제");
        System.out.print("회원UID : ");
        int uid = Integer.parseInt(scanner.nextLine());
        dao.deleteUser(uid);
    }

    private static void signUp(Scanner scanner, UserDAO dao) {
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

        dao.addUser(new User(name,id, password, email, phone));
    }

    private static void showAll(UserDAO dao) throws SQLException {
        List<User> users = dao.getAllUsers();
        for (User user : users) {
            System.out.println(user);
        }
    }

}