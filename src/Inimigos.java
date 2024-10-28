import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Inimigos extends Rectangle{

    public int spd = 2;
    public int right = 1, up = 0, down = 0, left = 0;

    public int curAnimation = 0;

    public int curFrame = 0, targetFrame = 15;

    public static List<Bullet> bullets = new ArrayList<Bullet>();

    public boolean shoot = false;

    public int dir = 1;
    public Inimigos(int x, int y) {
        super(x,y,38,75);
    }

    public void perseguirPlayer() {
        Player p = Game.player;

        if (x < p.x && World.isFree(x + spd, y)) {
            dead(x, y);
            x+=spd;
        } else if (x> p.x && World.isFree(x - spd, y)) {
            x-=spd;
        }
        if (y< p.y && World.isFree(x,y + spd)){
            y+=spd;
        }else if (y> p.y  && World.isFree(x,y - spd)){
            y-=spd;
        }
    }



    public void dead(int x, int y){
        Player p = Game.player;
        if ( p.x == x && y == p.y){
            System.exit(0);
        }
    }

    public void tick() {
        boolean moved = true;
        perseguirPlayer();
        dead(x, y);
        if (moved) {
            curFrame++;
            if (curFrame == targetFrame) {
                curFrame = 0;
                curAnimation++;
                if (curAnimation == Spritesheet.enemy_front.length) {
                    curAnimation = 0;
                }
            }
        }

        if (shoot) {
            shoot = false;
            bullets.add(new Bullet(x,y,dir));
        }
        for (int i = 0; i < bullets.size(); i++){
            bullets.get(i).tick();
        }
    }

    public void render(Graphics g){
        //g.setColor(Color.blue);
        //g.fillRect(x,y,width,height);
        g.drawImage(Spritesheet.enemy_front[curAnimation], x, y, 42, 42,null);

        for (int i = 0; i < bullets.size(); i++){
            bullets.get(i).render(g);
        }
    }


}
