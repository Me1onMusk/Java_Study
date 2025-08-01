package mid1.enumeration.ex2;

import static mid1.enumeration.ex2.ClassGrade.*;

public class ClassRefMain {
    public static void main(String[] args) {

        System.out.println("class BASIC = " + BASIC.getClass());
        System.out.println("class GOLD = " + GOLD.getClass());
        System.out.println("class DIAMOND = " + DIAMOND.getClass());
        System.out.println("ref BASIC = " + BASIC);
        System.out.println("ref GOLD = " + GOLD);
        System.out.println("ref DIAMOND = " + DIAMOND);

    }
}
