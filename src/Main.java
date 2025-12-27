import WindowPackages.LogInWindow;

import java.awt.EventQueue;
public class Main {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                System.out.println("Running...");
                new LogInWindow().setVisible(true);
            }
        });
    }
}
