package com.list;

import com.model.Rank;

import java.util.*;

public class RankList {
    private static ArrayList<Rank> list;

    static {
        if (list == null){
            System.out.println("新建排行榜");
            list = new ArrayList<Rank>();
        }
    }

    public static void add(Rank rank){
        list.add(rank);
    }

    public static ArrayList<Rank> getList() {
        return list;
    }

}
