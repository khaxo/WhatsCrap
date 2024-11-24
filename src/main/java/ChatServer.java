import java.io.*;
import java.net.*;

public class ChatServer {
    private ServerSocket serverSocket;

    public ChatServer(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        System.out.println("Server gestartet. Warte auf Verbindungen...");
    }

    public Socket acceptClient() throws IOException {
        return serverSocket.accept();
    }

    public void close() throws IOException {
        serverSocket.close();
    }

    public static void main(String[] args) {
        try {
            ChatServer server = new ChatServer(12345);
            Socket clientSocket = server.acceptClient();
            System.out.println("Client verbunden: " + clientSocket.getInetAddress());

            // Nachrichten-Handling
            MessageHandler handler = new MessageHandler(clientSocket);
            handler.start();

        } catch (IOException e) {
            System.err.println("Fehler im Server: " + e.getMessage());
        }
    }
}
