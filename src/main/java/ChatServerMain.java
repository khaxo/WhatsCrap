import java.io.IOException;
import java.net.Socket;

public class ChatServerMain {
    public static void main(String[] args) {
        try {
            ChatServer server = new ChatServer(12345);
            System.out.println("Server gestartet auf Port 12345. Warte auf Client-Verbindung...");

            Socket clientSocket = server.acceptClient();
            System.out.println("Client verbunden: " + clientSocket.getInetAddress());

            // Nachrichten-Handling in einem Thread
            ServerHandler handler = new ServerHandler(clientSocket);
            handler.start();

        } catch (IOException e) {
            System.err.println("Fehler beim Starten des Servers: " + e.getMessage());
        }
    }
}
