package com.shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

abstract public class FillableShape extends Shape{
    boolean filled;

    FillableShape() {

    }

    public boolean isFilled() {
        return true;
    }

    public void setFilled(boolean filled) {

    }
}
