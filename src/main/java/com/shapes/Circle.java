package com.shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Circle extends FillableShape {

    double diameter;

    public Circle(double diameter, Color color) {
        super();
        this.diameter = diameter;
    }

    public Circle() {
        super();
        this.diameter = 50;
    }

    public double getDiameter() {
        return diameter;
    }
    public void setDiameter(double diamater) {
        this.diameter = diamater;
    }

    @Override
    public void paint(GraphicsContext gc) {
        gc.setStroke(getColor());

        double radius = diameter / 2;

        gc.strokeOval(getX() - radius, getY() - radius, diameter, diameter);

    }

    @Override
    protected void move(long elapsedTimeNs) {
        super.move(elapsedTimeNs);
        setX(getX() + getDx()*elapsedTimeNs /BILLION);
        setY(getY() + getDy()*elapsedTimeNs /BILLION);
    }

    @Override
    protected void constrain(double boxX, double boxY, double boxWidth, double boxHeight) {
        super.constrain(boxX, boxY, boxWidth, boxHeight);
        double radius = diameter / 2;
        double dx = getDx();
        double dy = getDy();

        if(getX() - radius < boxX) {
            setX(boxX + radius);
            dx = Math.abs(dx);
        }
        else if (getX() + radius > boxX + boxWidth) {
            setX(boxWidth - radius);
            dx = -Math.abs(dx);
        }

        if(getY() - radius < boxY) {
            setY(boxY + radius);
            dy = Math.abs(dy);
        }
        else if (getY() + radius > boxY + boxWidth) {
            setY(boxWidth - radius);
            dy = -Math.abs(dy);
        }
    }

    @Override
    public String toString() {
        return "Circle{" +
                "diameter=" + diameter +
                '}';
    }
}
