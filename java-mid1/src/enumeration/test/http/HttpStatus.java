package enumeration.test.http;

public enum HttpStatus {
    OK (200, "OK"),
    BAD_REQUEST (400, "BAD REQUEST"),
    NOT_FOUND (404, "NOT FOUND"),
    INTERNAL_SERVER_ERROR (500, "INTERNAL SERVER ERROR");

    private final int code;
    private final String message;

    HttpStatus(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() { return code; }
    public String getMessage() { return message; }

    public boolean isSuccess() {
        return this.code >= 200 && this.code <= 299;
    }

    public static HttpStatus findByCode(int code) {
        HttpStatus[] values = values();
        for (HttpStatus status : values) {
            if (status.getCode() == code)
                return status;
        }
        return null;
    }

}
