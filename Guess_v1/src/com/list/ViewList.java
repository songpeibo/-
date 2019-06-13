package com.list;


import com.view.RankView;

import java.util.ArrayList;

public class ViewList {

    private static ArrayList<RankView> list;

    static {
        if (list == null){
            System.out.println("排行榜创建成功");
            list = new ArrayList<RankView>();
        }
    }

    public static void add(RankView rankView){
        list.add(rankView);
    }

    public static ArrayList<RankView> getList(){
        return list;
    }
}
