package start.array.ex;

import java.util.Scanner;

public class ProductAdminEx {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] productName = new String[10];
        String[] productPrices = new String[10];
        int productCount = 0;

        while (true) {
            System.out.println("1.상품 등록 | 2.상품 목록 | 3.종료");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    if(productCount >= 10)
                        System.out.println("더 이상 상품을 등록할 수 없습니다.");
                    System.out.print("상품 이름을 입력하세요: ");
                    productName[productCount] = scanner.nextLine();

                    System.out.print("상품 가격을 입력하세요: ");
                    productPrices[productCount] = scanner.nextLine();

                    productCount++;
                    break;
                case 2:
                    if(productCount == 0)
                        System.out.println("등록된 상품이 없습니다");
                    for (int i = 0; i < productCount; i++) {
                        System.out.print(productName[i] + " : " + productPrices[i] + "원\n");
                    }
                    break;
                case 3:
                    System.out.println("프로그램을 종료합니다.");
                    System.exit(0);
                default:
                    System.out.println("잘못 입력했습니다.");
            }

        }

    }
}
