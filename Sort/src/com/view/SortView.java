package com.view;

import com.sort.sort_type.bubble.Char_Bubble;
import com.sort.sort_type.bubble.Double_Bubble;
import com.sort.sort_type.bubble.Int_Bubble;
import com.sort.sort_type.bubble.String_Bubble;
import com.sort.sort_type.heap.Char_Heap;
import com.sort.sort_type.heap.Double_Heap;
import com.sort.sort_type.heap.Int_Heap;
import com.sort.sort_type.insertion.Char_Insertion;
import com.sort.sort_type.insertion.Double_Insertion;
import com.sort.sort_type.insertion.Int_Insertion;
import com.sort.sort_type.merge.Char_Merge;
import com.sort.sort_type.merge.Double_Merge;
import com.sort.sort_type.merge.Int_Merge;
import com.sort.sort_type.quick.Char_Quick;
import com.sort.sort_type.quick.Double_Quick;
import com.sort.sort_type.quick.Int_Quick;
import com.sort.sort_type.selection.Char_Selection;
import com.sort.sort_type.selection.Double_Selection;
import com.sort.sort_type.selection.Int_Selection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SortView extends JFrame implements MouseListener, WindowListener {

    private JComboBox jBox1,jBox2;
    private JLabel jl1,jl2,jl3;
    private JTextArea jTa1,jTa2;
    private JButton bubble,clear;
    private int []mode = new int[2];

    public SortView(){
        open();
    }

    public void open(){
        JPanel jPanel1 = new JPanel();
        JPanel jPanel2 = new JPanel();
        JPanel jPanel3 = new JPanel();

        JPanel jp1 = new JPanel();
        JPanel jp2 = new JPanel();

        String []method = {"冒泡排序","插入排序","选择排序","归并排序","快速排序","堆排序"};
        jBox1 = new JComboBox(method);
        jBox1.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getItem().equals("冒泡排序"))
                    mode[0] = 0;
                if (e.getItem().equals("插入排序"))
                    mode[0] = 1;
                if (e.getItem().equals("选择排序"))
                    mode[0] = 2;
                if (e.getItem().equals("归并排序"))
                    mode[0] = 3;
                if (e.getItem().equals("快速排序"))
                    mode[0] = 4;
                if (e.getItem().equals("堆排序"))
                    mode[0] = 5;
            }
        });

        String []type = {"int","double","char","string","object","file"};
        jBox2 = new JComboBox(type);
        jBox2.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getItem().equals("int"))
                    mode[1] = 0;
                if (e.getItem().equals("double"))
                    mode[1] = 1;
                if (e.getItem().equals("char"))
                    mode[1] = 2;
                if (e.getItem().equals("string"))
                    mode[1] = 3;
                if (e.getItem().equals("object"))
                    mode[1] = 4;
                if (e.getItem().equals("file"))
                    mode[1] = 5;
            }
        });

        jPanel1.setLayout(new GridLayout(1,2));
        jPanel1.add(jBox1);
        jPanel1.add(jBox2);

        jl1 = new JLabel("输入区域：");
        jl2 = new JLabel("输出区域：");
        jl3 = new JLabel("注意：输入每项请用“,”隔开！");

        jp1.setLayout(new GridLayout(2,1));
        jp1.add(jl3);
        jp1.add(jl1);

        bubble = new JButton("开始排序");
        clear = new JButton("清空内容");

        bubble.addMouseListener(this);
        clear.addMouseListener(this);

        jp2.setLayout(new GridLayout(1,2));
        jp2.add(bubble);
        jp2.add(clear);

        jTa1 = new JTextArea(5,25);
        jTa2 = new JTextArea(5,25);

        jTa1.setBackground(Color.green);
        jTa2.setBackground(Color.green);

        jPanel2.setLayout(new GridLayout(3,1));
        jPanel2.add(jp1);
        jPanel2.add(jTa1);
        jPanel2.add(jp2);

        jPanel3.setLayout(new GridLayout(3,1));
        jPanel3.add(jl2);
        jPanel3.add(jTa2);

        this.add(jPanel1,BorderLayout.NORTH);
        this.add(jPanel2,BorderLayout.CENTER);
        this.add(jPanel3,BorderLayout.SOUTH);

        this.setVisible(true);
        this.setTitle("排序");
        this.setSize(300,525);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == bubble){
            if (mode[0] == 0 && mode[1] == 0){
                //int bubble
                int []array;
                String string = jTa1.getText();
                Int_Bubble int_bubble = new Int_Bubble();
                array = int_bubble.bubble_Int(string);
                String string1 = int_bubble.test(array);
                int_bubble.out(array);
                jTa2.setText(string1);
            }else if (mode[0] == 0 && mode[1] == 1){
                //double bubble
                double []array;
                String string = jTa1.getText();
                Double_Bubble double_bubble = new Double_Bubble();
                array = double_bubble.bubble_Double(string);
                String string1 = double_bubble.test(array);
                double_bubble.out(array);
                jTa2.setText(string1);
            }else if (mode[0] == 0 && mode[1] == 2){
                //char bubble
                char []array;
                String string = jTa1.getText();
                Char_Bubble char_bubble = new Char_Bubble();
                array = char_bubble.bubble_Char(string);
                String string1 = char_bubble.test(array);
                char_bubble.out(array);
                jTa2.setText(string1);
            }else if (mode[0] == 0 && mode[1] == 3){
                //string bubble
                String []array;
                String string = jTa1.getText();
                String_Bubble string_bubble = new String_Bubble();
                array = string_bubble.bubble_String(string);
                String string1 = string_bubble.test(array);
                string_bubble.out(array);
                jTa2.setText(string1);
            }else if (mode[0] == 0 && mode[1] == 4){
                //object bubble
            }else if (mode[0] == 0 && mode[1] == 5){
                //file bubble
            }else if (mode[0] == 1 && mode[1] == 0){
                //int insertion
                int []array;
                String string = jTa1.getText();
                Int_Insertion int_insertion = new Int_Insertion();
                array = int_insertion.insertion_Int(string);
                String string1 = int_insertion.test(array);
                int_insertion.out(array);
                jTa2.setText(string1);
            }else if (mode[0] == 1 && mode[1] == 1){
                //double insertion
                double []array;
                String string = jTa1.getText();
                Double_Insertion double_insertion = new Double_Insertion();
                array = double_insertion.insertion_Double(string);
                String string1 = double_insertion.test(array);
                double_insertion.out(array);
                jTa2.setText(string1);
            }else if (mode[0] == 1 && mode[1] == 2){
                //char insertion
                char []array;
                String string = jTa1.getText();
                Char_Insertion char_insertion = new Char_Insertion();
                array = char_insertion.insertion_Char(string);
                String string1 = char_insertion.test(array);
                char_insertion.out(array);
                jTa2.setText(string1);
            }else if (mode[0] == 1 && mode[1] == 3){
                //string insertion
            }else if (mode[0] == 1 && mode[1] == 4){
                //object insertion
            }else if (mode[0] == 1 && mode[1] == 5){
                //file insertion
            }else if (mode[0] == 2 && mode[1] == 0){
                //int selection
                int array[];
                String string = jTa1.getText();
                Int_Selection int_selection = new Int_Selection();
                array = int_selection.selection_Int(string);
                String string1 = int_selection.test(array);
                int_selection.out(array);
                jTa2.setText(string1);
            }else if (mode[0] == 2 && mode[1] == 1){
                //double selection
                double []array;
                String string = jTa1.getText();
                Double_Selection double_selection = new Double_Selection();
                array = double_selection.selection_Double(string);
                String string1 = double_selection.test(array);
                double_selection.out(array);
                jTa2.setText(string1);
            }else if (mode[0] == 2 && mode[1] == 2){
                //char selection
                char []array;
                String string = jTa1.getText();
                Char_Selection char_selection = new Char_Selection();
                array = char_selection.selection_Char(string);
                String string1 = char_selection.test(array);
                char_selection.out(array);
                jTa2.setText(string1);
            }else if (mode[0] == 2 && mode[1] == 3){
                //string selection
            }else if (mode[0] == 2 && mode[1] == 4){
                //object selection
            }else if (mode[0] == 2 && mode[1] == 5){
                //file selection
            }else if (mode[0] == 3 && mode[1] == 0){
                //int merge
                int []array;
                String string = jTa1.getText();
                Int_Merge int_merge = new Int_Merge();
                array = int_merge.merge_Int(string);
                String string1 = int_merge.test(array);
                int_merge.out(array);
                jTa2.setText(string1);
            }else if (mode[0] == 3 && mode[1] == 1){
                //double merge
                double []array;
                String string = jTa1.getText();
                Double_Merge double_merge = new Double_Merge();
                array = double_merge.merge_Double(string);
                String string1 = double_merge.test(array);
                double_merge.out(array);
                jTa2.setText(string1);
            }else if (mode[0] == 3 && mode[1] == 2){
                //char merge
                char []array;
                String string = jTa1.getText();
                Char_Merge char_merge = new Char_Merge();
                array = char_merge.merge_Char(string);
                String string1 = char_merge.test(array);
                char_merge.out(array);
                jTa2.setText(string1);
            }else if (mode[0] == 3 && mode[1] == 3){
                //string merge
            }else if (mode[0] == 3 && mode[1] == 4){
                //object merge
            }else if (mode[0] == 3 && mode[1] == 5){
                //file merge
            }else if (mode[0] == 4 && mode[1] == 0){
                //int quick
                int []array;
                String string = jTa1.getText();
                Int_Quick int_quick = new Int_Quick();
                array = int_quick.quick_Int(string);
                String string1 = int_quick.test(array);
                int_quick.out(array);
                jTa2.setText(string1);
            }else if (mode[0] == 4 && mode[1] == 1){
                //double quick
                double []array;
                String string = jTa1.getText();
                Double_Quick double_quick = new Double_Quick();
                array = double_quick.quick_Double(string);
                String string1 = double_quick.test(array);
                double_quick.out(array);
                jTa2.setText(string1);
            }else if (mode[0] == 4 && mode[1] == 2){
                //char quick
                char []array;
                String string = jTa1.getText();
                Char_Quick char_quick = new Char_Quick();
                array = char_quick.quick_Char(string);
                String string1 = char_quick.test(array);
                char_quick.out(array);
                jTa2.setText(string1);
            }else if (mode[0] == 4 && mode[1] == 3){
                //string quick
            }else if (mode[0] == 4 && mode[1] == 4){
                //object quick
            }else if (mode[0] == 4 && mode[1] == 5){
                //file quick
            }else if (mode[0] == 5 && mode[1] == 0){
                //int heap
                int []array;
                String string = jTa1.getText();
                Int_Heap int_heap = new Int_Heap();
                array = int_heap.heap_Int(string);
                String string1 = int_heap.test(array);
                int_heap.out(array);
                jTa2.setText(string1);
            }else if (mode[0] == 5 && mode[1] == 1){
                //double heap
                double []array;
                String string = jTa1.getText();
                Double_Heap double_heap = new Double_Heap();
                array = double_heap.heap_Double(string);
                String string1 = double_heap.test(array);
                double_heap.out(array);
                jTa2.setText(string1);
            }else if (mode[0] == 5 && mode[1] == 2){
                //char heap
                char []array;
                String string = jTa1.getText();
                Char_Heap char_heap = new Char_Heap();
                array = char_heap.heap_Char(string);
                String string1 = char_heap.test(array);
                char_heap.out(array);
                jTa2.setText(string1);
            }else if (mode[0] == 5 && mode[1] == 3){
                //string heap
            }else if (mode[0] == 5 && mode[1] == 4){
                //object heap
            }else if (mode[0] == 5 && mode[1] == 5){
                //file heap
            }
//mode[0]表示排序方法选择，mode[1]表示数据类型选择

        }else if (e.getSource() == clear){
            jTa1.setText("");
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
