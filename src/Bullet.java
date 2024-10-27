import java.awt.*;

public class Bullets extends Rectangle {

    public int dir = 1;
    public int speed = 8;

    public Bullets(int x, int y){
        super(x,y,20,20);
    }

    public void tick() {
        x+=speed*dir;
    }

    public void render(Graphics g){
        g.setColor(Color.red);
        g.fillRect(x,y,width,height);
    }

}
