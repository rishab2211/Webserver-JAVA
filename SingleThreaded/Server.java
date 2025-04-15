import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {

    public void run() {
        try {
            int port = 8080;
            try (ServerSocket socket = new ServerSocket(port)) {
                socket.setSoTimeout(10000);
                while (true) {
                    System.out.println("Server is litening on port" + port);
                    Socket acceptedConnection = socket.accept();
                    System.out.println("Connection accepted from client" + acceptedConnection.getRemoteSocketAddress());
                    PrintWriter toClient = new PrintWriter(acceptedConnection.getOutputStream());
                    BufferedReader fromClient = new BufferedReader(
                            new InputStreamReader(acceptedConnection.getInputStream()));

                    toClient.println("Hello from the server.");
                    toClient.close();
                    fromClient.close();
                    acceptedConnection.close();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {

        Server server = new Server();

        try {
            server.run();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
