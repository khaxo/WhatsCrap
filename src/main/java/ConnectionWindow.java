import javax.swing.*;
import java.awt.*;

public class ConnectionWindow extends JFrame {
    private JTextField ipField;
    private JTextField portField;
    private JButton connectButton;

    public ConnectionWindow() {
        setTitle("Connect to Server");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ipField = new JTextField("127.0.0.1");
        portField = new JTextField("12345");
        connectButton = new JButton("Connect");

        connectButton.addActionListener(e -> connectToServer());

        JPanel panel = new JPanel(new GridLayout(3, 2));
        panel.add(new JLabel("IP Address:"));
        panel.add(ipField);
        panel.add(new JLabel("Port:"));
        panel.add(portField);
        panel.add(new JLabel());
        panel.add(connectButton);

        add(panel);
    }

    private void connectToServer() {
        String ip = ipField.getText().trim();
        int port = Integer.parseInt(portField.getText().trim());

        try {
            ChatClient client = new ChatClient(ip, port);
            ChatWindow chatWindow = new ChatWindow(client);
            chatWindow.setVisible(true);
            this.dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Fehler beim Verbinden: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ConnectionWindow window = new ConnectionWindow();
            window.setVisible(true);
        });
    }
}
