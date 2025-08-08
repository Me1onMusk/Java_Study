package adv2.reflection;

import adv2.reflection.data.BasicData;

public class BasicV1 {
    public static void main(String[] args) throws ClassNotFoundException {

        // 클래스 메타데이터 조회 방법 //
        // 1. 클래스에서 찾기
        Class<BasicData> basicDataClass1 = BasicData.class;
        System.out.println("basicDataClass1 = " + basicDataClass1);
        // basicDataClass1 = class adv2.reflection.data.BasicData

        // 2. 인스턴스에서 찾기
        BasicData basicInstance = new BasicData();
        Class<? extends BasicData> basicDataClass2 = basicInstance.getClass();
        System.out.println("basicDataClass2 = " + basicDataClass2);
        // basicDataClass2 = class adv2.reflection.data.BasicData

        // 3. 문자로 찾기
        String className = "adv2.reflection.data.BasicData";
        Class<?> basicDataClass3 = Class.forName(className);
        System.out.println("basicDataClass3 = " + basicDataClass3);
        // basicDataClass3 = class adv2.reflection.data.BasicData

    }
}
