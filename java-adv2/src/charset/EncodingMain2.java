package charset;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import static java.nio.charset.StandardCharsets.*;

public class EncodingMain2 {

    private static final Charset EUC_KR = Charset.forName("EUC-KR");
    private static final Charset MS_949 = Charset.forName("MS949");

    public static void main(String[] args) {
        
        System.out.println("== 영문 ASCII 인코딩 ==");
        test("A", US_ASCII, US_ASCII);    //A -> [US-ASCII]인코딩 -> [65] 1byte -> [US-ASCII]디코딩 -> A
        test("A", US_ASCII, ISO_8859_1);  //ASCII 확장 (LATIN-1)
        test("A", US_ASCII, EUC_KR);      //ASCII 포함
        test("A", US_ASCII, MS_949);      //ASCII 포함
        test("A", US_ASCII, UTF_8);       //ASCII 포함
        test("A", US_ASCII, UTF_16BE);    //A -> [US-ASCII]인코딩 -> [65] 1byte -> [UTF-16BE]디코딩 -> �

        System.out.println();

        System.out.println("== 한글 인코딩 - 기본 ==");
        test("가", US_ASCII, US_ASCII);       //가 -> [US-ASCII]인코딩 -> [63] 1byte -> [US-ASCII]디코딩 -> ?
        test("가", ISO_8859_1, ISO_8859_1);  //가 -> [ISO-8859-1]인코딩 -> [63] 1byte -> [ISO-8859-1]디코딩 -> ?
        test("가", EUC_KR, EUC_KR);
        test("가", MS_949, MS_949);
        test("가", UTF_8, UTF_8);
        test("가", UTF_16, UTF_16);

        System.out.println();

        System.out.println("== 한글 인코딩 - 복잡 ==");
        test("뷁", EUC_KR, EUC_KR);  //뷁 -> [EUC-KR]인코딩 -> [63] 1byte -> [EUC-KR]디코딩 -> ?
        test("뷁", MS_949,MS_949);
        test("뷁", UTF_8, UTF_8);
        test("뷁", UTF_16, UTF_16);

        System.out.println();

        System.out.println("== 한글 인코딩 - 디코딩이 다른 경우 ==");
        test("가", EUC_KR, MS_949);  //가 -> [EUC-KR]인코딩 -> [-80, -95] 2byte -> [x-windows-949]디코딩 -> 가
        test("뷁", MS_949, EUC_KR);  //뷁 -> [x-windows-949]인코딩 -> [-108, -18] 2byte -> [EUC-KR]디코딩 -> ��
        test("가", EUC_KR, UTF_8);   //가 -> [EUC-KR]인코딩 -> [-80, -95] 2byte -> [UTF-8]디코딩 -> ��
        test("가", MS_949, UTF_8);   //가 -> [x-windows-949]인코딩 -> [-80, -95] 2byte -> [UTF-8]디코딩 -> ��
        test("가", UTF_8, MS_949);   //가 -> [UTF-8]인코딩 -> [-22, -80, -128] 3byte -> [x-windows-949]디코딩 -> 媛�

        System.out.println();

        System.out.println("== 영문 인코딩 - 디코딩이 다른 경우 ==");
        test("A", EUC_KR, UTF_8);    //A -> [EUC-KR]인코딩 -> [65] 1byte -> [UTF-8]디코딩 -> A
        test("A", MS_949, UTF_8);    //A -> [x-windows-949]인코딩 -> [65] 1byte -> [UTF-8]디코딩 -> A
        test("A", UTF_8, MS_949);    //A -> [UTF-8]인코딩 -> [65] 1byte -> [x-windows-949]디코딩 -> A
        test("A", UTF_8, UTF_16BE);  //A -> [UTF-8]인코딩 -> [65] 1byte -> [UTF-16BE]디코딩 -> �
    }

    private static void test(String text, Charset encodingCharset, Charset decodingCharset) {
        byte[] encoded = text.getBytes(encodingCharset);
        String decoded = new String(encoded, decodingCharset);
        System.out.printf("%s -> [%s]인코딩 -> %s %sbyte -> [%s]디코딩 -> %s\n",
                text, encodingCharset, Arrays.toString(encoded), encoded.length, decodingCharset, decoded);
    }
}
