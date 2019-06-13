package mygame;

import com.list.ViewList;
import com.view.RankView;
import com.view.StartView;

import javax.swing.*;

/*public class start {
    public static void main(String args[]){
        if (ViewList.getList().size() == 0){
            RankView rankView = new RankView();
            ViewList.add(rankView);
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            }catch (Exception e){
                e.printStackTrace();0,Sari,1
0,Sari,3
0,12,1
0,11,null
            }
        }
        System.out.println("启动排行榜");
        StartView startView = new StartView();
    }
}*/


public class start{
    public static void main(String args[]){
        StartView startView = new StartView();
    }
}