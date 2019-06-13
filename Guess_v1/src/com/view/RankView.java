package com.view;

import com.list.RankList;
import com.list.ViewList;
import com.model.Model;
import com.model.Rank;
import com.util.FileList;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class RankView extends JFrame implements WindowListener, MouseListener {

    private JPanel[] jPanels;
    private Button clear,rank_s,rank_x;
    private RankList rankList;
    private Model model;
    private JTable jTable;
    private JScrollPane jScrollPane;

    public RankView(){
        System.out.println(ViewList.getList().size());
        if (ViewList.getList().size() == 0){
            open();
        }
    }

    public void open(){

        JPanel jPanel1 = new JPanel();
        JPanel jPanel2 = new JPanel();

        clear = new Button("清空记录");
        rank_s = new Button("倒序排序");
        rank_x = new Button("正序排序");
        clear.addMouseListener(this);
        rank_s.addMouseListener(this);
        rank_x.addMouseListener(this);

        jPanel2.add(clear);
        jPanel2.add(rank_x);
        jPanel2.add(rank_s);

        jPanels = new JPanel[rankList.getList().size()];
        for (int i = 0;i < rankList.getList().size();i++){
            Rank rank = rankList.getList().get(i);
            JPanel jPanel = new MyPanel(rank);
            JLabel jLabel = new JLabel(rank.getName()+" "+rank.getNum(),SwingConstants.CENTER);
            jLabel.setSize(300,10);
            jLabel.setHorizontalTextPosition(JLabel.CENTER);
            jPanel.setBackground(Color.WHITE);
            jPanels[i] = jPanel;
            jPanel.addMouseListener(this);
            jPanel.add(jLabel);
            jPanel1.add(jPanel);
        }
        jPanel1.setBackground(Color.WHITE);
        jPanel1.setLayout(new GridLayout(10,1));
        jPanel1.setSize(320,500);

        model = new Model();
        jTable = new JTable(model){
            public Component preparerenderer(TableCellRenderer renderer,int row,int col){
                Component component = super.prepareRenderer(renderer,row,col);
                if (component instanceof JComponent){
                    ((JComponent) component).setOpaque(false);
                }
                return component;
            }
        };
        jTable.setOpaque(false);
        jTable.setRowHeight(30);
        jTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jTable.setShowHorizontalLines(false);
        jTable.setSelectionBackground(Color.green);
        jTable.addMouseListener(this);

        jScrollPane = new JScrollPane(jTable);
        jScrollPane.setOpaque(false);
        jScrollPane.getViewport().setOpaque(false);

        ImageIcon icon = new ImageIcon("img/p_bg.jpg");
        JLabel jLabel = new JLabel(icon);
        jLabel.setBounds(0,0,icon.getIconWidth(),icon.getIconHeight());

        Container container = this.getContentPane();
        ((JPanel) container).setOpaque(false);

        jPanel1.setOpaque(false);
        jPanel2.setOpaque(false);

        this.add(jScrollPane,BorderLayout.NORTH);
        this.add(jPanel2,BorderLayout.SOUTH);

        this.getContentPane().add(jLabel,-1);
        this.getContentPane().add(jScrollPane,0);

//        this.setDefaultCloseOperation(EXIT_ON_CLOSE);//关闭界面退出程序
        this.addWindowListener(this);
        this.setTitle("排行榜");
        this.setLocation(400,200);
        this.setSize(337,525);
        this.setResizable(false);
        this.setVisible(true);
    }

    @Override
    public void windowOpened(WindowEvent e) {
        System.out.println("open");
        File file = new File("file/ranklist.txt");
        if (file.exists() == false){
            try {
                file.createNewFile();
            }catch (IOException e1){
                e1.printStackTrace();
            }
        }else {
            FileList.readFileByLines("file/ranklist.txt");
            jTable.setModel(new Model());
        }
    }

    @Override
    public void windowClosing(WindowEvent e) {
        System.out.println("closing");
        if (RankList.getList().size() != 0){
            System.out.println("写入文件");
            FileList.clear("file/ranklist.txt");
            ArrayList<Rank> list = RankList.getList();
            for (int i = 0;i < list.size();i++){
                FileList.writeFile("file/ranklist.txt",list.get(i).getId()+","+list.get(i).getName()
                        +","+list.get(i).getNum()+"\n");
            }
        }
        this.dispose();
        ViewList.getList().remove(rankList);
    }

    @Override
    public void windowClosed(WindowEvent e) {
        System.out.println("关闭界面");
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

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == clear){
            //清空界面中列表的内容
            for (int i = RankList.getList().size() - 1;i >= 0;i--){
                RankList.getList().remove(i);
            }
            jTable.setModel(new Model());
            System.out.println("写入文件");
            //清空文件中的内容
            FileList.clear("file/ranklist.txt");
        }else if (e.getSource() == rank_x){
            //正序排序是指从上至下数目依次增加
            //获得排序完成数组
            Rank rank[] = x_sort();
            //将排好序的数组写入文件中
            if (RankList.getList().size() != 0){
                System.out.println("正序排序写入文件");
                FileList.clear("file/ranklist.txt");
                for (int i = 0;i < RankList.getList().size();i++){
                    String num = i < 10?"0"+(i+1):(i+1)+"";
                    FileList.writeFile("file/ranklist.txt",num+","+rank[i].getName()
                            +","+rank[i].getNum()+"\n");
                }
            }
            //将页面中列表置为空，以便读取文件
            for (int i = RankList.getList().size() - 1;i >= 0;i--){
                RankList.getList().remove(i);
            }
            //从文件中读取排好序的列表
            System.out.println("正序排序读取文件");
            File file1 = new File("file/ranklist.txt");
            if (file1.exists() == false){
                try {
                    file1.createNewFile();
                }catch (IOException e1){
                    e1.printStackTrace();
                }
            }else {
                FileList.readFileByLines("file/ranklist.txt");
                jTable.setModel(new Model());
            }

        }else if (e.getSource() == rank_s){
            //倒序排序是指从上至下数目依次减少
            //获得排序完成数组
            Rank rank[] = s_sort();
            //将排好序的数组写入文件中
            if (RankList.getList().size() != 0){
                System.out.println("正序排序写入文件");
                FileList.clear("file/ranklist.txt");
                for (int i = 0;i < RankList.getList().size();i++){
                    String num = i < 10?"0"+(i+1):(i+1)+"";
                    FileList.writeFile("file/ranklist.txt",num+","+rank[i].getName()
                            +","+rank[i].getNum()+"\n");
                }
            }
            //将页面中列表置为空，以便读取文件
            for (int i = RankList.getList().size() - 1;i >= 0;i--){
                RankList.getList().remove(i);
            }
            //从文件中读取排好序的列表
            System.out.println("正序排序读取文件");
            File file1 = new File("file/ranklist.txt");
            if (file1.exists() == false){
                try {
                    file1.createNewFile();
                }catch (IOException e1){
                    e1.printStackTrace();
                }
            }else {
                FileList.readFileByLines("file/ranklist.txt");
                jTable.setModel(new Model());
            }
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

    public static Rank[] x_sort(){
        Rank rank[] = new Rank[RankList.getList().size()];
        for (int i = 0;i < RankList.getList().size();i++){
            rank[i] = RankList.getList().get(i);
        }
        for (int i = 0;i < RankList.getList().size()-1;i++){
            int j = Integer.parseInt(RankList.getList().get(i).getNum()) - Integer.parseInt(RankList.getList().get(i+1).getNum());
            int k = Integer.parseInt(RankList.getList().get(i).getId()) - Integer.parseInt(RankList.getList().get(i+1).getId());
            if (j > 0){
                Rank rank11 = RankList.getList().get(i);
                rank[i] = rank[i+1];
                rank[i+1] = rank11;
            }else if (j == 0){
                if (k > 0){
                    Rank rank12 = RankList.getList().get(i);
                    rank[i] = rank[i+1];
                    rank[i+1] = rank12;
                }
            }
        }
        System.out.println("正序排序写入文件");
        return rank;
    }

    public static Rank[] s_sort(){
        Rank rank1[] = new Rank[RankList.getList().size()];
        for (int i = 0;i < RankList.getList().size();i++){
            rank1[i] = RankList.getList().get(i);
        }
        for (int i = 0;i < RankList.getList().size()-1;i++){
            int j = Integer.parseInt(RankList.getList().get(i).getNum()) - Integer.parseInt(RankList.getList().get(i+1).getNum());
            int k = Integer.parseInt(RankList.getList().get(i).getId()) - Integer.parseInt(RankList.getList().get(i+1).getId());
            if (j < 0){
                Rank rank11 = RankList.getList().get(i);
                rank1[i] = rank1[i+1];
                rank1[i+1] = rank11;
            }else if (j == 0){
                if (k < 0){
                    Rank rank12 = RankList.getList().get(i);
                    rank1[i] = rank1[i+1];
                    rank1[i+1] = rank12;
                }
            }
        }
        System.out.println("倒序排序写入文件");
        return rank1;
    }
}