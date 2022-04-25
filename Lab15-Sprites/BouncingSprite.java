public class BouncingSprite extends MobileSprite {
    public BouncingSprite(double x, double y, int width, int height, String image, double vx, double vy) {
        super(x, y, width, height, image, vx, vy);
    }

    @Override
    public void step(World world) {
        bounce(world.getWidth(), world.getHeight());
        super.step(world);
    }

    private void bounce(double width, double height) {
        if (getX() - getWidth() <= -getWidth() / 2 || getX() + getWidth() >= width + getWidth() / 2) {
            setVx(getVx() * -1);
        }
        if (getY() - getHeight() <= -getHeight() / 2 || getY() + getHeight() >= height + getHeight() / 2) {
            setVy(getVy() * -1);
        }
    }
}