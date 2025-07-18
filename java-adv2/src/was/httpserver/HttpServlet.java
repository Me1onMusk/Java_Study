package was.httpserver;

import java.io.IOException;

public interface HttpServlet {
    public void service(HttpRequest request, HttpResponse response) throws IOException;
}
