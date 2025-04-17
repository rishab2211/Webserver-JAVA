import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

    public final ExecutorService threadPool;

    public Server(int poolSize) {
        this.threadPool = Executors.newFixedThreadPool(poolSize);
    }

    public void handleClient(Socket clienSocket) {
        try {
            PrintWriter toSocket = new PrintWriter(clienSocket.getOutputStream(), true);
            toSocket.println("Hello from the server " + clienSocket.getInetAddress());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        int port = 8080;
        int poolSize = 25;
        Server server = new Server(poolSize);

        try {
            ServerSocket serverSocket = new ServerSocket(port);
            serverSocket.setSoTimeout(60000);
            System.out.println("Server is listening on port " + port);

            while (true) {
                Socket cleintSocket = serverSocket.accept();

                server.threadPool.execute(() -> server.handleClient(cleintSocket));
            }
        } catch (Exception e) {

            e.printStackTrace();
        } finally {
            // shutdown the threadpool when the server exits
            server.threadPool.shutdown();
        }
    }

}