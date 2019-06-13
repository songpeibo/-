package com.view;

import com.model.Rank;

import javax.swing.*;

public class MyPanel extends JPanel {

    private Rank rank;

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    public MyPanel(Rank rank){
        super();
        this.rank = rank;
    }
}
