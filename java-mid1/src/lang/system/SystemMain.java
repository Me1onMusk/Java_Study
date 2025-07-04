package lang.system;

import java.lang.reflect.Array;
import java.util.Arrays;

public class SystemMain {
    public static void main(String[] args) {
        //현재 시간 (밀리초) 가져오기
        long currentTimeMillis = System.currentTimeMillis();
        System.out.println("currentTimeMillis = " + currentTimeMillis);

        //현재 시간 (나노초) 가져오기
        long currentTimeNano = System.nanoTime();
        System.out.println("currentTimeNano = " + currentTimeNano);

        //환경 변수를 읽기
        System.out.println("getenv = " + System.getenv());
        
        //시스템 속성을 읽기
        System.out.println("properties = " + System.getProperties());
        System.out.println("java version = " + System.getProperty("java.version"));

        //배열을 고속으로 복사
        char[] orginalArray = {'a', 'b', 'c'};
        char[] copyArray = new char[orginalArray.length];
        System.arraycopy(orginalArray, 0, copyArray, 0, orginalArray.length);

        //배열 출력
        System.out.println("copyArray = " + copyArray);
        System.out.println("copyArray = " + Arrays.toString(copyArray));

        //프로그램 종료
        System.exit(0);
    }
}
