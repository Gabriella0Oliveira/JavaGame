import java.awt.*;

public class Shot {

    private final int x;
    private int y;
    private final int speed;


    public Shot(int X, int Y){
        this.x = X;
        this.y = Y;
        speed = 10;
    }

    public void paint(Graphics2D g){
        g.setColor(Color.yellow);
        g.fillRect(x,y,5,15);
    }

    public void update() {
        y -= speed;
    }

    public boolean destroy() {
        return y < 0;
    }
}