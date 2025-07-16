import javax.swing.JFrame;

public class AppFrame extends JFrame{
    AppFrame(){
        setTitle("My Game");
        setSize(600,650);
        setLocationRelativeTo(null);
        AppPanel appPanel=new AppPanel();
        add(appPanel);
        setResizable(false);
        setVisible(true);
    }
}
