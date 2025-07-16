
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class CarCollisionGame {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Car Collision Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setResizable(false);
        frame.add(new GamePanel());
        frame.setVisible(true);
    }
}

class GamePanel extends JPanel {
    private int playerX = 50, playerY = 300, carWidth = 50, carHeight = 100;
    private int enemyX = 200, enemyY = 100;

    public GamePanel() {
        setFocusable(true);

        // Add key listener for player movement
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();
                if (key == KeyEvent.VK_LEFT) playerX -= 10;
                if (key == KeyEvent.VK_RIGHT) playerX += 10;
                if (key == KeyEvent.VK_UP) playerY -= 10;
                if (key == KeyEvent.VK_DOWN) playerY += 10;
                repaint(); // Redraw the panel
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw player car
        g.setColor(Color.BLUE);
        g.fillRect(playerX, playerY, carWidth, carHeight);

        // Draw enemy car
        g.setColor(Color.RED);
        g.fillRect(enemyX, enemyY, carWidth, carHeight);

        // Check for collision
        if (isColliding()) {
            g.setColor(Color.BLACK);
            g.drawString("Collision Detected!", 150, 50);
        }
    }

    private boolean isColliding() {
        return playerX < enemyX + carWidth &&
               playerX + carWidth > enemyX &&
               playerY < enemyY + carHeight &&
               playerY + carHeight > enemyY;
    }
}

