package de.fhro.inf.p3.uebung07;

/**
 * Ein Shape das sich an der Stelle (x,y) befindet und sich entlang des
 * Vectors (xSpeed, ySpeed) bewegt.
 *
 * @author brm
 */
public class MovingShape {
    private int x;
    private int y;
    private int xSpeed;
    private int ySpeed;

    private Shape shape;

    public MovingShape(Shape shape, int x, int y, int xSpeed, int ySpeed) {
        this.shape = shape;
        this.x = x;
        this.y = y;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public Shape getShape() {
        return shape;
    }

    public void setShape(Shape shape) {
        this.shape = shape;
    }


    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public int getXSpeed() {
        return this.xSpeed;
    }

    public int getYSpeed() {
        return this.ySpeed;
    }

    public void setSpeed(int xSpeed, int ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    /**
     * Bewegt das Shape einen "Schritt" entlang des Vectors innerhalb eines Rechteckes von (0,0) bis (maxX, maxY).
     */
    public void move(int maxX, int maxY) {
        x += xSpeed;
        y += ySpeed;
        if (x - shape.getXExtend() < 0) {
            x = shape.getXExtend();
            xSpeed *= -1;
        } else if (x + shape.getXExtend() > maxX) {
            x = maxX - shape.getXExtend();
            xSpeed *= -1;
        }
        if (y - shape.getYExtend() < 0) {
            y = shape.getYExtend();
            ySpeed *= -1;
        } else if (y + shape.getYExtend() > maxY) {
            y = maxY - shape.getYExtend();
            ySpeed *= -1;
        }
    }
}
