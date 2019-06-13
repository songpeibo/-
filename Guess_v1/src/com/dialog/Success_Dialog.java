package com.dialog;

import com.list.RankList;
import com.model.Rank;
import com.util.FileList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.*;

public class Success_Dialog extends JFrame implements WindowListener, MouseListener {

    private String number;

    private Button yes,no;
    private JLabel jLabel;

    public Success_Dialog(String number){
        this.number = number;
        open();
    }

    public void open(){

        yes = new Button("确定");
        no = new Button("取消");

        yes.addMouseListener(this);
        no.addMouseListener(this);

        JPanel jPanel = new JPanel();
        jPanel.setLayout(new GridLayout(1,2));
        jPanel.add(yes);
        jPanel.add(no);

        jLabel = new JLabel("你猜对了，是否继续保存记录。");

        this.add(jPanel,BorderLayout.NORTH);
        this.add(jLabel,BorderLayout.SOUTH);

        this.setSize(200,100);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setTitle("Success");
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == yes){
            Rank rank = new Rank();
            rank.setId(String.valueOf(RankList.getList().size()));
            rank.setNum(this.number);
            File file = new File("file/player.txt");


            if (file.exists() == false){
                try {
                    file.createNewFile();
                }catch (IOException e1){
                    System.out.println("创建新文件失败");
                    e1.printStackTrace();
                }
            }else {

//通过文件读取获取player中的名字
                BufferedReader bufferedReader = null;
                try {
                    bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("file/player.txt"),"UTF-8"));
                    String tempString = null;
                    if ((tempString = bufferedReader.readLine()) != null){
                        String s[] = tempString.split(",");
                        rank.setName(s[1]);
                    }
                }catch (IOException e1){
                    e1.printStackTrace();
                }finally {
                    if (bufferedReader != null){
                        try {
                            bufferedReader.close();
                        }catch (IOException e1){

                        }
                    }
                }


            }
            RankList.add(rank);
            this.dispose();
        }else if (e.getSource() == no){
            this.dispose();
        }
    }
    //num可以写入player.txt，但是name仍无法获取
    //其实这里不需要再写入player.txt,可以直接写入RankList中
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
