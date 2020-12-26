import java.awt.*;

public class BlueBall extends Ball implements BallObserver{
    private boolean collided;

    @Override
    public boolean isCollided() {
        return collided;
    }

    public BlueBall(Color color, int xSpeed, int ySpeed, int ballSize) {
        super(color, xSpeed, ySpeed, ballSize);
        collided = false;
    }

    public void update(char keyChar){
        this.setXSpeed(-1 * this.getXSpeed());
        this.setYSpeed(-1 * this.getYSpeed());
    }

    @Override
    public void update(int x, int y) {
        if (isClose(x,y)){
            if (x>this.getX()) this.setX(this.getX()-30);
            else this.setX(this.getX()+30);
            if (y>this.getY()) this.setY(this.getY()-30);
            else this.setY(this.getY()+30);

            this.setXSpeed(-1 * this.getXSpeed());
            this.setYSpeed(-1 * this.getYSpeed());

            this.setColor(new Color(51, 153,255));

            collided = true;
        }
    }

    @Override
    public boolean isClose(int x, int y) {
        int diffX = this.getX() - x;
        int diffY = this.getY() - y;
        return (diffX * diffX) + (diffY * diffY) < 80 * 80;
    }
}
