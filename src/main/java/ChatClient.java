import java.io.*;
import java.net.*;

public class ChatClient {
    private Socket socket;
    private BufferedReader reader;
    private PrintWriter writer;

    public ChatClient(String host, int port) throws IOException {
        socket = new Socket(host, port);
        reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        writer = new PrintWriter(socket.getOutputStream(), true);
        System.out.println("Mit Server verbunden: " + host);
    }

    public void sendMessage(String message) {
        writer.println(message);
    }

    public String receiveMessage() throws IOException {
        return reader.readLine();
    }

    public void close() throws IOException {
        socket.close();
        reader.close();
        writer.close();
    }
}
