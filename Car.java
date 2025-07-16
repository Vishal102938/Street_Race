import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Car {
    int x;
    int y;
    int width=150;
    int height=180;
    int speed=10;
    BufferedImage bufferImage;

    public Car(int x,int y){
        this.x=x;
        this.y=y;
        CarImage();
    }
    void CarImage(){
        try {
            bufferImage=ImageIO.read(AppPanel.class.getResource("sportCar.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void paintImage(Graphics g){
        g.drawImage(bufferImage,x,y,width,height,null);
    }
    public void moveUP(){
        if(y>0){
            y=y-speed;
        }
    }
    public void moveDown(){
        if(y<400){
            y=y+speed;
        }
    }
    public void moveLeft(){
        if(x>30){
            x=x-speed;
        }
    }
    public void moveRight(){
        if(x<400){
            x=x+speed;
        }
    }
}
