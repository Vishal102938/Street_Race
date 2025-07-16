import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;
public class AppPanel extends JPanel implements ActionListener{
    private Car mycar;
    private int yPosition=0;
    private EnemyCar yourcar;
    private EnemyCar yourcar1;
    boolean up,down,left,right;
    private Image image;
    BufferedImage bufferImage;
    int x=0;
    int y=0;
    int yAxis;
    int speed =5;
    
    Timer timer;
    public AppPanel(){
        image=new ImageIcon("r2.jpg").getImage();

        mycar=new Car(240,400);
        yourcar=new EnemyCar(50, 400);
        yourcar1=new EnemyCar(50, 70);

        timer = new Timer(30, this);
        timer.start();

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();
                if (key == KeyEvent.VK_UP) up = true;    
                if (key == KeyEvent.VK_DOWN) down = true; 
                if (key == KeyEvent.VK_LEFT) left = true; 
                if (key == KeyEvent.VK_RIGHT) right = true; 
            }
            
            @Override
            public void keyReleased(KeyEvent e) {
                int key = e.getKeyCode();
                if (key == KeyEvent.VK_UP) up = false;   
                if (key == KeyEvent.VK_DOWN) down = false; 
                if (key == KeyEvent.VK_LEFT) left = false; 
                if (key == KeyEvent.VK_RIGHT) right = false; 
            }
            
        });
        // printBgImage();
        // apploop();

        setFocusable(true);
    }

    public void actionPerformed(ActionEvent e) {
        yPosition += 5;
        if (yPosition > getHeight()) {
            yPosition = 0;
        }    
        repaint();
        yourcar.move();
        yourcar1.move();
        update();
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, x, yPosition,600,650, this);
        g.drawImage(image, x, yPosition-630,600,650, this);
        mycar.paintImage(g);
        yourcar.paint(g);
        yourcar1.paint(g);
        
    }
    public void update(){
        if(up){
            mycar.moveUP();
        }
        if(down){
            mycar.moveDown();
        }
        if(left){
            mycar.moveLeft();
        }
        if(right){
            mycar.moveRight();
        }
    }

    // void printBgImage(){
    //     try {
    //         bufferImage = ImageIO.read(AppPanel.class.getResource("hello.gif"));
    //     } catch (IOException e) {
    //         // TODO Auto-generated catch block
    //         System.out.println("No image Found");
    //         e.printStackTrace();
    //     }
    // }

    private ImageIcon ImageIcon(String sportCarpng) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
