package common.validation;

import java.util.regex.Pattern;

// 이메일 정규식 //
public class Patterns {
    private static final Pattern EMAIL = Pattern.compile("^[^@\\s]+@[^@\\s]+\\.[^@\\s]+$");

    public static boolean isEmail(String email) {
        return EMAIL.matcher(email).matches();
    }
}
