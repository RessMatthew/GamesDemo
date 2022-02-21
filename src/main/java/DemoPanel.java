package main.java;

import javax.swing.*;
import java.awt.*;

//生成画板
public class DemoPanel extends JPanel {

    private Demo[] demos;

    public DemoPanel(Demo...demos){ //Java特性：数组类型：数组对象 ： 对象数量不定
        this.demos = demos;
    }

    //重写画板的paint方法
    @Override
    public void paint(Graphics g){

        //JPanel与DemoPanel相同部分
        super.paint(g);

        //JPanel与DemoPanel不同部分
        for(Demo demo:demos){
            g.drawImage(demo.getImage(), demo.getX(),demo.getY(), demo.getWidth(), demo.getHeight(), null);
        }
    }
}
