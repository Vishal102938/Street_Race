import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class EnemyCar {
    int x,y;
    int width=120;
    int height=180;
    int speed=5;
    BufferedImage bufferImage;

    public EnemyCar(int y,int x){
        this.y=y;

        this.x=x;
        CarImage();
    }
    public void CarImage(){
        try {
            bufferImage=ImageIO.read(AppPanel.class.getResource("sportCar2.png"));
            bufferImage=ImageIO.read(AppPanel.class.getResource("sportCar2.png"));

        }
        catch(IOException e){
            e.getStackTrace();
        }
    }
    public void paint(Graphics g){
        g.drawImage(bufferImage,x,y,120,180,null);
    }
    public void move(){
        if(y<600){
            y=y+speed;
        }
        else{
            y=0;
        }
    }
}


