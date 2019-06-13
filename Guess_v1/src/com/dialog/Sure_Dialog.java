package com.dialog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Sure_Dialog extends JFrame implements WindowListener, MouseListener {

    private JButton yes,no;
    private JLabel jLabel;

    public Sure_Dialog(){
        open();
    }

    public void open(){

        yes = new JButton("确定");
        no = new JButton("取消");

        yes.addMouseListener(this);
        no.addMouseListener(this);

        JPanel jPanel = new JPanel();
        jPanel.setLayout(new GridLayout(1,2));
        jPanel.add(yes);
        jPanel.add(no);

        jLabel = new JLabel("你确定要退出游戏吗");

        this.add(jLabel,BorderLayout.NORTH);
        this.add(jPanel,BorderLayout.SOUTH);

        this.setSize(200,100);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setTitle("退出");
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == yes){
//            this.dispose();
            System.exit(0);
        }else if (e.getSource() == no){
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
    }

    @Override
    public void windowClosed(WindowEvent e) {

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
