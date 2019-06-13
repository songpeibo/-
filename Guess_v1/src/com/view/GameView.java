package com.view;

import com.dialog.Success_Dialog;
import com.dialog.Sure_Dialog;
import com.list.RankList;
import com.list.ViewList;
import com.model.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class GameView extends JFrame implements WindowListener, MouseListener {

    private Button start,close,look,c_look;
    private JLabel input,output,output_AB,user_num;
    private JLabel output_text;
    private JTextField input_num;
    private JLabel output_num_AB;
    private JLabel user_text;
    private Game game = new Game();
    private RankList rankList;

    String random_num = game.random_number();
    int count = 0;

    public GameView(){
        open();
    }

    public void open(){
        JPanel jPanel1 = new JPanel();
        JPanel jPanel2 = new JPanel();

        start = new Button("开始游戏");
        close = new Button("退出游戏");
        look = new Button("查看排行");
        c_look = new Button("关闭排行");

        start.addMouseListener(this);
        close.addMouseListener(this);
        look.addMouseListener(this);
        c_look.addMouseListener(this);

        input = new JLabel("猜测数字：");
        output = new JLabel("对错结果“");
        output_AB = new JLabel("ＡＢ结果：");
        user_num = new JLabel("使用次数：");
        input_num = new JTextField(10);
        output_text = new JLabel();
        output_num_AB = new JLabel();
        user_text = new JLabel();

        jPanel1.setLayout(new GridLayout(4,2));
        jPanel1.add(input);
        jPanel1.add(input_num);
        jPanel1.add(output);
        jPanel1.add(output_text);
        jPanel1.add(output_AB);
        jPanel1.add(output_num_AB);
        jPanel1.add(user_num);
        jPanel1.add(user_text);

        jPanel2.setLayout(new GridLayout(2,2));
        jPanel2.add(start);
        jPanel2.add(close);
        jPanel2.add(look);
        jPanel2.add(c_look);

        this.add(jPanel1,BorderLayout.NORTH);
        this.add(jPanel2,BorderLayout.SOUTH);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(300,525);
        this.setLocationRelativeTo(null);
        this.setVisible(false);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == start){
            String in_num = input_num.getText();
            boolean ok = game.equal_num(random_num,in_num);
            if (ok == true) {
                output_text.setText("恭喜你，猜对了！");
                count++;
                Success_Dialog success_dialog = new Success_Dialog(Integer.toString(count));
            }
            else {
                output_text.setText("哎呀，差一点点，加油哦！");
                count++;
            }
            String result = game.equal_AB(random_num,in_num);
            output_num_AB.setText(result);
            user_text.setText(""+count);
        }else if (e.getSource() == close){
            Sure_Dialog sure_dialog = new Sure_Dialog();
            //退出程序
        }else if (e.getSource() == look){
            if (ViewList.getList().size() == 0){
                RankView rankView = new RankView();
                ViewList.add(rankView);
            }
        }else if (e.getSource() == c_look){
            if (ViewList.getList().size() != 0){
                ViewList.getList().remove(ViewList.getList().size()-1);
            }
        }
    }
//其实这里的关闭排行榜并没有实现，也就是说不能从ViewList中移除RankView,还需进一步测试
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
//编写了游戏类，但是需要先声明游戏对象，但如果在start中声明的话，每次点击便会生成一次随机数，这是我们不想要的，因此将Game作为全局变量来声明。
//显然游戏不是一次性的(可能)，因此可以编写一个游戏类，对于类中方法可以在多处使用