package was.httpserver;

import java.io.IOException;

// 서블릿 인터페이스 //
public interface HttpServlet {
    public void service(HttpRequest request, HttpResponse response) throws IOException;
}
