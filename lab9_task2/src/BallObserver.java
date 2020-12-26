public interface BallObserver {//only red balls and blue balls
    public void update(int x, int y); //green ball's x and y
    public boolean isClose(int x, int y);

    public boolean isCollided();
}
