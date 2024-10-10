package com.shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Rectangle extends FillableShape {

    double width, height;

    public Rectangle(double width, double height, Color color) {
        super();
        this.width = width;
        this.height = height;
    }

    public Rectangle() {
        super();
        this.width = 75;
        this.height = 75;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public void paint(GraphicsContext gc) {
        gc.setStroke(getColor());
        gc.strokeRect(getX(), getY(), width, height);
    }

    @Override
    protected void move(long elapsedTimeNs) {
        super.move(elapsedTimeNs);
        setX(getX() + getDx() * elapsedTimeNs / BILLION);
        setY(getY() + getDy() * elapsedTimeNs / BILLION);
    }

    @Override
    protected void constrain(double boxX, double boxY, double boxWidth, double boxHeight) {
        super.constrain(boxX, boxY, boxWidth, boxHeight);
        double dx = getDx();
        double dy = getDy();

        if (getX() < boxX) {
            setX(boxX);
            dx = Math.abs(dx);
        } else if (getX() + width > boxWidth) {
            setX(boxWidth - width);
            dx = -Math.abs(dx);
        }

        if (getY() < boxY) {
            setY(boxY);
            dy = Math.abs(dy);
        } else if (getY() + height > boxHeight) {
            setY(boxHeight - height);
            dy = -Math.abs(dy);
        }
        setVelocity(dx,dy);
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "width=" + width +
                ", height=" + height +
                '}';
    }
}
