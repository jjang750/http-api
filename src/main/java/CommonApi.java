import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Type;
import java.net.InetSocketAddress;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class CommonApi {

    private final static int port = 8000;
    private static Log log = null;
    public static void main(String[] args) throws IOException {

        log = new Log();
        try {

            log.println("===================================================================");
            log.println("====================== Start Common-Api Server ==================");
            log.println("====================== http://127.0.0.1:8000/ ==================");
            log.println("===================================================================");

            // Create an HTTP server instance listening on port 8000
            HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);

            // Set up the root context to handle requests
            server.createContext("/api", new RootHandler());

            // Start the server in a separate thread
            server.setExecutor(null); // creates a default executor
            server.start();

            log.println("Server started on port : " + port);

        } catch (IOException e) {
            log.println(e.getLocalizedMessage());
        }
    }

    // Define a handler to process HTTP requests
    static class RootHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            if ("POST".equals(exchange.getRequestMethod())) {
                URI requestURI = exchange.getRequestURI();
                log.println(" URL : " + requestURI.getPath());
                String body = getRequestBody(exchange);
                log.println("body : " + body);
                Map<String, String> queryParams = queryToMap(body);
                String response = "{}";
                if ("/api/test-call".equals(requestURI.getPath())) {
                    response = body;
                } else {
                    exchange.sendResponseHeaders(404, -1); // Page Not Found
                    return;
                }

                log.println(response);

                exchange.sendResponseHeaders(200, response.length());
                OutputStream os = exchange.getResponseBody();
                os.write(response.getBytes(StandardCharsets.UTF_8));
                os.close();

            } else {
                // Handle other HTTP methods if needed
                exchange.sendResponseHeaders(405, -1); // Method Not Allowed
            }
        }

        // Helper method to convert query string to a map
        private Map<String, String> queryToMap(String query) {
            Map<String, String> result = null;
            if (query != null) {
                Gson gson = new Gson();
                Type type = new TypeToken<HashMap<String,String>>(){}.getType();
                result = gson.fromJson(query, type);
            }
            return result;
        }

        private String getRequestBody(HttpExchange exchange) throws IOException{
            InputStream inputStream = exchange.getRequestBody();
            byte[] bytes = new byte[inputStream.available()];
            inputStream.read(bytes);
            return new String(bytes, StandardCharsets.UTF_8);
        }
    }
}
