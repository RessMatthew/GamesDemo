package main.java;


import javax.swing.*;
import java.awt.*;

//图片image信息
public class Demo {
    private int x,y,width,height;
    private Image image;

    public Demo(){
        this.image = new ImageIcon("./src/main/resources/demo.jpg").getImage();
        this.width = 100;
        this.height = 100;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}
