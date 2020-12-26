import java.awt.*;

public class RedBall extends Ball implements BallObserver{
    private boolean collided;

    @Override
    public boolean isCollided() {
        return collided;
    }

    public RedBall(Color color, int xSpeed, int ySpeed, int ballSize) {
        super(color, xSpeed, ySpeed, ballSize);
        collided = false;
    }

    public void update(char keyChar){
        if(keyChar == 'a' || keyChar == 'd'){
            int temp = this.getXSpeed();
            this.setXSpeed(this.getYSpeed());
            this.setYSpeed(temp);
        }

    }

    @Override
    public void update(int x, int y) {
        if (isClose(x,y)){
            if (x>this.getX()) this.setX(this.getX()-40);
            else this.setX(this.getX()+40);
            if (y>this.getY()) this.setY(this.getY()-40);
            else this.setY(this.getY()+40);

            this.setXSpeed(-1 * this.getXSpeed());
            this.setYSpeed(-1 * this.getYSpeed());

            this.setColor(new Color(255,102,102));

            collided = true;
        }
    }

    @Override
    public boolean isClose(int x, int y) {
        int diffX = this.getX() - x;
        int diffY = this.getY() - y;
        return (diffX * diffX) + (diffY * diffY) < 70 * 70;
    }
}
