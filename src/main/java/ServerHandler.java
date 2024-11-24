import java.io.*;
import java.net.*;

public class ServerHandler extends Thread {
    private Socket socket;
    private BufferedReader reader;
    private PrintWriter writer;

    public ServerHandler(Socket socket) throws IOException {
        this.socket = socket;
        this.reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.writer = new PrintWriter(socket.getOutputStream(), true);
    }

    @Override
    public void run() {
        try {
            String message;
            while ((message = reader.readLine()) != null) {
                System.out.println("Empfangen: " + message);
                writer.println("Server Echo: " + message);
            }
        } catch (IOException e) {
            System.err.println("Verbindung unterbrochen: " + e.getMessage());
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                System.err.println("Fehler beim Schließen des Sockets: " + e.getMessage());
            }
        }
    }
}
