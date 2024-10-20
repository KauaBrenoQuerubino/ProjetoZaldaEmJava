import java.awt.*;

public class Player extends Rectangle{

    public int spd = 3;
    public boolean right, up, down, left;

    public int curAnimation = 0;

    public int curFrame = 0, targetFrame = 15;
    public Player(int x, int y) {
        super(x,y,38,75);
    }

    public void tick() {
        boolean moved = false;
        if (right && World.isFree(x+spd, y)) {
            x+=spd;
            moved = true;
        } else if (left && World.isFree(x-spd, y)) {
            x-=spd;
            moved = true;
        }
        if (up && World.isFree(x, y-spd)) {
            y-=spd;
            moved = true;
        } else if (down && World.isFree(x, y+spd)) {
            y+=spd;
            moved = true;
        }
        if (moved) {
            curFrame++;
            if (curFrame == targetFrame) {
                curFrame = 0;
                curAnimation++;
                if (curAnimation == Spritesheet.player_front.length) {
                    curAnimation = 0;
                }
            }
        }
    }

    public void render(Graphics g){
        //g.setColor(Color.blue);
        //g.fillRect(x,y,width,height);
        g.drawImage(Spritesheet.player_front[curAnimation], x, y, 42, 42,null);
    }


}
