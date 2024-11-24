import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChatWindow extends JFrame {
    private JTextArea messageArea;
    private JTextField inputField;
    private JButton sendButton;
    private ChatClient client;

    public ChatWindow(ChatClient client) {
        this.client = client;

        setTitle("Chat");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        messageArea = new JTextArea();
        messageArea.setEditable(false);
        inputField = new JTextField();
        sendButton = new JButton("Send");

        sendButton.addActionListener(e -> sendMessage());

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(inputField, BorderLayout.CENTER);
        panel.add(sendButton, BorderLayout.EAST);

        add(new JScrollPane(messageArea), BorderLayout.CENTER);
        add(panel, BorderLayout.SOUTH);
    }

    private void sendMessage() {
        String message = inputField.getText().trim();
        if (!message.isEmpty()) {
            client.sendMessage(message);
            appendMessage("You: " + message);
            inputField.setText("");
        }
    }

    public void appendMessage(String message) {
        messageArea.append(message + "\n");
    }
}
