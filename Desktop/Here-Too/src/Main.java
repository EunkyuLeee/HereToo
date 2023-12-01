import javax.swing.*;

public class Main {
    public static void main(String[] args){
        SwingUtilities.invokeLater(() -> {
            ReviewPanel frame = new ReviewPanel();
            frame.setVisible(true);
        });
    }
}

