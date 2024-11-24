import javax.swing.*;

public class ChatClientMain {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ConnectionWindow connectionWindow = new ConnectionWindow();
            connectionWindow.setVisible(true);
        });
    }
}
