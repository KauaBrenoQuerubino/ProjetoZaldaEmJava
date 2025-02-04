import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Spritesheet {

    public static BufferedImage spritesheet;

    public static BufferedImage[] player_front;

    public static BufferedImage tileWall;
    public static BufferedImage[] enemy_front;


    //292 238

    public Spritesheet() {
        try {
            spritesheet = ImageIO.read(getClass().getResource("/spritesheet.png"));
        } catch (IOException e) {
           e.printStackTrace();

        }

        player_front = new BufferedImage[2];
        player_front[0] = Spritesheet.getSprite(0,10, 16, 16);
        player_front[1] = Spritesheet.getSprite(17,10, 16, 16);

        enemy_front = new BufferedImage[2];
        enemy_front[0] = Spritesheet.getSprite(292,238, 18, 18);
        enemy_front[1] = Spritesheet.getSprite(310,238, 18, 18);

        tileWall = Spritesheet.getSprite(268,240, 16, 16);
    }

    public static BufferedImage getSprite(int x, int y, int width, int height){
        return spritesheet.getSubimage(x, y, width, height);
    }

}
