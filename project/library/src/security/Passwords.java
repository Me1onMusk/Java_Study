package security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

// 비밀번호 해시 검증 //
public class Passwords {

    // 해시 알고리즘 //
    public static String hash(String rawPw) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(rawPw.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : hash) sb.append(String.format("%02x", b));
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("해시 알고리즘 오류", e);
        }
    }

    // 비밀번호 일치 함수 //
    public static boolean matches(String rawPw, String hashedPw) {
        return hash(rawPw).equals(hashedPw);
    }

}
