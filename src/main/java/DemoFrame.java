package main.java;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

//生成窗口
public class DemoFrame extends JFrame {

    //窗口初始化
    public DemoFrame() throws Exception{
        //1.窗口标题
        this.setTitle("Demo");
        //2.窗口退出方式
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //3.窗体大小
        this.setSize(600,500);

        //4.窗口可见性
        this.setVisible(true);//默认为fales

        //5.画板初始化
        Demo myself = new Demo();
        Demo enemy = new Demo();
        Demo bullet = new Demo();
        myself.setY(350);
        bullet.setY(500);
        DemoPanel plane = new DemoPanel(myself ,enemy, bullet);
        this.add(plane);//把Panel添加到Frame中

        //6.画板更新：相交判定
        while(true){
            Thread.sleep(5);

            enemy.setX(enemy.getX() + 1);
            if(enemy.getX() > 500){
                enemy.setX(0);
            }

            if(bullet.getY() < 500){
                bullet.setY(bullet.getY() - 5);
                Rectangle enemyRectangle = new Rectangle(enemy.getX(), enemy.getY(), enemy.getWidth(), enemy.getHeight());
                Rectangle bulletRectangle = new Rectangle(bullet.getX(), bullet.getY(), bullet.getWidth(), bullet.getHeight());
                if(enemyRectangle.intersects(bulletRectangle)){
                    break;
                }
            }
            plane.repaint();
        }

        //7.窗口交互：键盘监听
        this.addKeyListener(new KeyListener() {

            @Override
            //有按键操作时
            public void keyTyped(KeyEvent e) {}

            //按下某键时
            @Override
            public void keyPressed(KeyEvent e) {
                if(KeyEvent.VK_A == e.getKeyCode()){
                    myself.setX(myself.getX() - 10);
                }
                else if(KeyEvent.VK_D == e.getKeyCode()){
                    myself.setX(myself.getX() + 10);
                }
                else if(KeyEvent.VK_J == e.getKeyCode()){

                    bullet.setX(myself.getX()); //因为最开始我们为子弹设置了500的Y坐标，而玩家设置为350的Y坐标
                    bullet.setY(myself.getY()); //当我们按下J键时，把当前玩家的坐标赋予给了子弹
                    //则当子弹的Y坐标此时小于500，开始移动
                    //只是为了演示，实际情况可别这么干
                }
            }

            //松开某键时
            @Override
            public void keyReleased(KeyEvent e) {}
        });
    }

    public static void main(String[] args) throws Exception{
        new DemoFrame();
    }
}
