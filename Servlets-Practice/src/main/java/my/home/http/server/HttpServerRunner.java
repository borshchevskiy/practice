package my.home.http.server;

public class HttpServerRunner {
    public static void main(String[] args) {
        HttpServer server = new HttpServer(9000, 100);
        server.run();

    }
}
