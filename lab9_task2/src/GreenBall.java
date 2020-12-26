import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GreenBall extends Ball {
    //observerList
    private List<BallObserver> observers = new ArrayList<>();

    public GreenBall(Color color, int xSpeed, int ySpeed, int ballSize) {
        super(color, xSpeed, ySpeed, ballSize);
    }

    //update
    public void update(char keyChar){
        switch (keyChar) {
            case 'a':
                this.setXSpeed(Math.abs(this.getXSpeed()) * -1);
                break;
            case 'd':
                this.setXSpeed(Math.abs(this.getXSpeed()));
                break;
            case 'w':
                this.setYSpeed(Math.abs(this.getYSpeed()) * -1);
                break;
            case 's':
                this.setYSpeed(Math.abs(this.getYSpeed()));
                break;
        }
    }

    //register
    public void registerObserver(BallObserver ballObserver){
        observers.add(ballObserver);
    }

    //remove：elegance
    public void removeObserver(){
        List<BallObserver> newObservers = new ArrayList<>();
        for (BallObserver o:observers){
            if (o.isCollided()){
                newObservers.add(o);
            }
        }
        observers.removeAll(newObservers);
//        observers.clear();
//        observers.addAll(newObservers);
    }

    //notify
    public void notifyObservers(){//every time move()
        for (BallObserver observer : observers) {
            observer.update(this.getX(),this.getY());
        }
    }

    //override move(): add notifyObservers and removeObserver
    @Override
    public void move() {
//        int newX = this.getX() + this.getXSpeed();
//        int newY = this.getY() + this.getYSpeed();
//
//        this.setX(newX);
//        this.setY(newY);
//
//        if (newX <= 0) {
//            this.setXSpeed(Math.abs(getXSpeed()));
//        } else if (newX >= 600 - this.getBallSize()) {
//            this.setXSpeed(-1 * Math.abs(getXSpeed()));
//        }
//
//        if (newY <= 0) {
//            this.setYSpeed(Math.abs(getYSpeed()));
//        } else if (newY > 600 - this.getBallSize()) {
//            this.setYSpeed(-1 * Math.abs(getYSpeed()));
//        }
        super.move();

        notifyObservers();
        removeObserver();
    }

}
