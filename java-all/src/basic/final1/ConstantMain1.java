package basic.final1;

public class ConstantMain1 {
    public static void main(String[] args) {

        System.out.println("프로그램 최대 참여자 수 " + 1000);
        int currentUserCount = 999;
        process(currentUserCount++);
        // 1. 999
        // 2. 1000

        process(currentUserCount++);
        // 1. 1000
        // 2. 1001

        process(currentUserCount++);
        // 1. 1001 -> 대기자 등록

    }

    private static void process(int currentUserCount) {
        System.out.println("참여자 수:" + currentUserCount);
        if (currentUserCount > 1000)
            System.out.println("대기자로 등록합니다.");
        else
            System.out.println("게임에 참가합니다.");

    }
}
