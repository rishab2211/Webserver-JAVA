import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.function.Consumer;

public class Server {

    public Consumer<Socket> getConsumer() {
        return (clientSocket) -> {
            try {
                PrintWriter toClient = new PrintWriter(clientSocket.getOutputStream(), true);
                toClient.println("Hello from the rishab server");
                toClient.close();
                clientSocket.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        };
    }

    public static void main(String[] args) {
        int port = 8080;
        Server server = new Server();

        try {
            try (ServerSocket serverSocket = new ServerSocket(port)) {
                serverSocket.setSoTimeout(10000); 

                System.out.println("Server is listening on port " + port);

                while (true) {
                    Socket acceptedSocket = serverSocket.accept();
                    System.out.println("Connection accepted from client" + acceptedSocket.getRemoteSocketAddress());
                    Thread thread = new Thread(() -> server.getConsumer().accept(acceptedSocket));
                    thread.start();
                }
            }
            

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
