package my.home.http.client.example;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.nio.file.Path;

public class HttpClientExample {
    public static void main(String[] args) throws IOException, InterruptedException {
        HttpClient httpClient = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .build();

        HttpRequest requestGet = HttpRequest.newBuilder(URI.create("https://www.google.com"))
                .GET()
                .build();

        HttpRequest requestPost = HttpRequest.newBuilder(URI.create("https://www.google.com"))
                .POST(HttpRequest.BodyPublishers.ofString("Java"))
                .build();

        HttpResponse<String> responseGet = httpClient.send(requestGet, BodyHandlers.ofString());

        System.out.println(responseGet.body());
        System.out.println();
        System.out.println(responseGet.headers());
        System.out.println();
        System.out.println(responseGet.statusCode());
        System.out.println();
        System.out.println(responseGet.version());

        HttpResponse<String> responsePost = httpClient.send(requestPost,BodyHandlers.ofString());

        System.out.println(responsePost.body());
        System.out.println();
        System.out.println(responsePost.headers());
        System.out.println();
        System.out.println(responsePost.statusCode());
        System.out.println();
        System.out.println(responsePost.version());
    }
}
