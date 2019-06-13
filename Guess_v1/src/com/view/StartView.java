package com.view;

import com.util.FileList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.IOException;

public class StartView extends JFrame implements WindowListener, MouseListener {

    private JLabel jLabel;
    private Button keep,start;
    private JTextField jTextField;

    public StartView(){
        open();
    }

    public void open(){

        JPanel jPanel1 = new JPanel();
        JPanel jPanel2 = new JPanel();

        keep = new Button("保存");
        start = new Button("开始游戏");

        keep.addMouseListener(this);
        start.addMouseListener(this);

        jLabel = new JLabel("PlayerName:");
        jTextField = new JTextField(10);

        jPanel1.setLayout(new GridLayout(1,2));
        jPanel1.add(jLabel);
        jPanel1.add(jTextField);

        jPanel2.setLayout(new GridLayout(1,2));
        jPanel2.add(keep);
        jPanel2.add(start);

        this.add(jPanel1,BorderLayout.NORTH);
        this.add(jPanel2,BorderLayout.SOUTH);
        this.addWindowListener(this);

        this.setSize(200,100);
        this.setLocationRelativeTo(null);
        this.setTitle("初始界面");
        this.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == keep){
            String name = jTextField.getText();
            String id = null;
            String num = null;
            System.out.println("存储新玩家");
            File file = new File("file/player.txt");
            if (file.exists() == false){
                try {
                    file.createNewFile();
                }catch (IOException e1){
                    System.out.println("创建新文件失败");
                    e1.printStackTrace();
                }
            }else {
                FileList.clear("file/player.txt");
                FileList.writeFile("file/player.txt",id+","+name+","+num);
            }
        }else if (e.getSource() == start){
            //有一步判断，是否玩家名字为空，如果不为空继续，如果为空弹出界面，让玩家必须输入名字(拓展)
            try {
                GameView gameView = new GameView();
                gameView.setVisible(true);
                System.out.println("游戏界面启动成功");
            }catch (Exception e2){
                e2.printStackTrace();
                System.out.println("游戏界面启动失败");
            }
            this.dispose();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        this.dispose();
        System.out.println("初始界面正在关闭");
    }

    @Override
    public void windowClosed(WindowEvent e) {
        System.out.println("初始界面已关闭");
    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
