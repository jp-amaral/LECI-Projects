package JavaSwing;
import javax.swing.*;
import java.awt.*;
import java.util.concurrent.TimeUnit;

public class DrawCircle extends JFrame {

    public DrawCircle(){
        setTitle("Drawing a Circle");
        setSize(400, 400);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        translation(g2d,50, 200,200);


    }

    public static void main(String[] args) {
       new DrawCircle();
    }
    public static void translation(Graphics2D g2d,int x , int y, int raio){
        int i = 0;
        int flag = 1;
        while(true){
            g2d.setColor(Color.red);
            g2d.drawOval(x+i, y,raio,raio);

            try { Thread.sleep(5); }
            catch(InterruptedException ex) { Thread.currentThread().interrupt(); }

            g2d.setColor(g2d.getBackground());
            g2d.drawOval(x+i, y,raio,raio);

            if(i == -x+400-raio){
                flag = -1;
            }else if(i == 0){
                flag = 1;
            }
            if(flag == 1){
                i++;
            }else{
                i--;
            }
        }
    }
}