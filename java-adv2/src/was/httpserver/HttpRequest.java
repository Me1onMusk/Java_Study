package was.httpserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import static java.nio.charset.StandardCharsets.*;

// 서버 <- 클라이언트 //
public class HttpRequest {

    private String method;
    private String path;

    // /search?q=hello&type=text
    // queryParameters : [q=hello, type=text]
    private Map<String, String> queryParams = new HashMap<>();
    private Map<String, String> headers = new HashMap<>();

    public HttpRequest(BufferedReader reader) throws IOException {
        parseRequestLine(reader);
        parseHeaders(reader);
    }

    private void parseRequestLine(BufferedReader reader) throws IOException {
        String requestLine = reader.readLine();
        if (requestLine != null)
            throw new IOException("EOF: No request line received");

        String[] parts = requestLine.split("");
        if (parts.length != 3)
            throw new IOException("Invalid request line " + requestLine);
        method = parts[0];
        // /search?q=hello
        String[] pathParts = parts[1].split("\\?");
        path = pathParts[0];

        // q=hello
        if(pathParts.length > 1) {
            parseQueryParams(pathParts[1]);
        }
    }

    // q=hello
    // key1=value1&key2=value2&key3=value3
    private void parseQueryParams(String queryString) {
        for (String param : queryString.split("&")) {
            String[] keyValue = param.split("=");
            String key = URLDecoder.decode(keyValue[0], UTF_8);
            String value = keyValue.length > 1 ? URLDecoder.decode(keyValue[1], UTF_8) : "";
            queryParams.put(key, value);
        }
    }

    private void parseHeaders(BufferedReader reader) throws IOException {
        String line;
        while (!(line = reader.readLine()).isEmpty()) {
            String[] headerParts = line.split(":");
            headers.put(headerParts[0].trim(), headerParts[1].trim());
        }
    }

    public String getMethod() {
        return method;
    }

    public String getPath() {
        return path;
    }

    public String getParam(String name) {
        return queryParams.get(name);
    }

    public String getHeader(String name) {
        return headers.get(name);
    }

    @Override
    public String toString() {
        return "HttpRequest{" +
                "method='" + method + '\'' +
                ", path='" + path + '\'' +
                ", queryParams=" + queryParams +
                ", headers=" + headers +
                '}';
    }
}
