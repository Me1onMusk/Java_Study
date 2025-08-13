import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class BankApplication {
    public static void main(String[] args) {

        List<Account> accountList = new ArrayList<>();

        centerAlign("은행");
        String msg1 = """
                | 1.계좌생성 | 2.계좌목록 | 3.예금 | 4.출금 | 5.종료 |
                |----------------------------------------------------|
                """;
        String msg2 = "| 선택 > ";
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print(msg1);
            System.out.print(msg2);
            String input = scanner.nextLine();
            switch (input) {
                case "1" -> makeAccount(scanner, accountList);
                case "2" -> accountList(accountList);
                case "3" -> deposit(scanner, accountList);
                case "4" -> withdraw(scanner, accountList);
                case "5" -> exit();
                default -> System.out.println("| 올바른 번호를 입력하세요");
            }
        }
    }

    // 계좌 생성 //
    private static void makeAccount(Scanner scanner, List<Account> accountList) {
        System.out.println("|----------------------------------------------------|");
        System.out.printf("| %25s%n", "계좌생성");
        System.out.println("|----------------------------------------------------|");

        try {
            System.out.print("| 계좌번호    : ");
            String accountNo = scanner.nextLine();

            if(checkAccount(accountList, accountNo))
                return;

            System.out.print("| 계좌주      : ");
            String accountName = scanner.nextLine();

            System.out.print("| 초기 입금액 : ");
            long balance = scanner.nextLong();
            scanner.nextLine();
            if( balance < 0) {
                System.out.println("초기 금액은 0보다 커야 합니다.");
                return;
            }

            accountList.add(new Account(accountNo, accountName, balance));
            System.out.println("|----------------------------------------------------|");
            System.out.printf("| %25s%n", "계좌가 생성되었습니다");
        } catch (InputMismatchException e) {
            scanner.nextLine();
            System.out.println("|----------------------------------------------------|");
            System.out.printf("| %25s%n", "계좌정보가 올바르지 않습니다.");
        }

    }

    // 계좌번호 중복 검사 //
    private static boolean checkAccount(List<Account> accountList, String accountNo) {
        for(Account account : accountList) {
            if(account.getAccountNo().equals(accountNo)) {
                System.out.println("| 해당 계좌번호가 이미 존재합니다.");
                return true;
            }
        }
        return false;
    }

    // 계좌 목록 //
    private static void accountList(List<Account> accountList) {
        System.out.println("|----------------------------------------------------|");
        System.out.printf("| %25s%n", "계좌목록");
        System.out.println("|----------------------------------------------------|");
        if(accountList.isEmpty())
            System.out.printf("| %25s%n", "없음");
        else {
            for (Account account : accountList) {
                System.out.printf("| 계좌번호: %-10s | 이름: %-6s | 잔액: %4s원 |\n", account.getAccountNo(), account.getAccountName(), account.getBalance());
            }
        }
    }

    // 예금 //
    private static void deposit(Scanner scanner, List<Account> accountList) {
        System.out.println("|----------------------------------------------------|");
        System.out.printf("| %25s%n", "예금");
        System.out.println("|----------------------------------------------------|");
        System.out.print("| 계좌번호 : ");
        String accountNo = scanner.nextLine();

        if(accountList.isEmpty()){
            System.out.println("|----------------------------------------------------|");
            System.out.printf("| %25s%n", "계좌정보가 없습니다.");
        }

        for (Account account : accountList) {
            if (!account.getAccountNo().equals(accountNo)) {
                System.out.println("| 해당 계좌번호가 없습니다. 다시 입력해주세요.");
                System.out.println("|----------------------------------------------------|");
                break;
            }
            System.out.print("| 예금할 금액 : ");
            long deposit = scanner.nextLong();
            scanner.nextLine();
            if (deposit <= 0)
                System.out.println("| 예금할 금액을 정확히 입력해 주세요");
            else {
                account.setBalance(account.getBalance() + deposit);
                accountStatus(account);
                return;
            }
        }
    }

    // 출금 //
    private static void withdraw(Scanner scanner, List<Account> accountList) {
        System.out.println("|----------------------------------------------------|");
        System.out.printf("| %25s\n", "출금");
        System.out.println("|----------------------------------------------------|");
        System.out.print("| 계좌번호 : ");
        String accountNo = scanner.nextLine();
        for (Account account : accountList) {
            if (!account.getAccountNo().equals(accountNo)) {
                System.out.println("| 해당 계좌번호가 없습니다. 다시 입력해주세요.");
                System.out.println("|----------------------------------------------------|");
                break;
            }
            System.out.println("| 잔액 : " + account.getBalance() + "원");
            System.out.print("| 출금할 금액 : ");
            long withdraw = scanner.nextLong();
            scanner.nextLine();
            if (withdraw <= 0)
                System.out.println("| 출금할 금액을 정확하게 입력하세요.");
            else if (withdraw > account.getBalance())
                System.out.println("| 출금할 금액이 잔액보다 많습니다.");
            else {
                account.setBalance(account.getBalance() - withdraw);
                accountStatus(account);
                return;
            }
        }
    }

    // 시스템 종료 //
    private static void exit() {
        System.out.println("|----------------------------------------------------|");
        System.out.printf("| %25s%n", "시스템을 종료합니다");
        System.out.println("|----------------------------------------------------|");
        System.exit(0);
    }

    // 계좌 현황 //
    private static void accountStatus(Account account) {
        System.out.println("|----------------------------------------------------|");
        System.out.printf("| %25s%n", "계좌현황");
        System.out.println("|----------------------------------------------------|");
        System.out.printf("| 계좌번호: %-10s | 이름: %-6s | 잔액: %4s원 |\n", account.getAccountNo(), account.getAccountName(), account.getBalance());
    }

    // 글자 가운데 정렬 및 디자인 //
    private static void centerAlign(String str) {
        String line = "|----------------------------------------------------|";
        System.out.println(line);
        int totalWidth = line.length()-4;
        int leftPadding = (totalWidth - str.length()) / 2;
        int rightPadding = totalWidth - str.length() - leftPadding;
        String result = " ".repeat(leftPadding) + str + " ".repeat(rightPadding);
        System.out.println("|" + result + "|");
        System.out.println(line);
    }
}
