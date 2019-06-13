package com.model;

import com.list.RankList;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.util.Vector;

public class Model extends AbstractTableModel {

    Vector rowData,columnName;
    JTable jTable = null;
    JScrollPane jScrollPane = null;
    private RankList list;

    public Model(){
        columnName = new Vector();
        columnName.add("排行榜");

        rowData = new Vector();
        for (int i = 0;i < list.getList().size();i++){
            Vector row = new Vector();
            String num = i < 10?"0"+(i+1):(i+1)+"";
            row.add(num+" "+list.getList().get(i).getName()+" "+list.getList().get(i).getNum());
            rowData.add(row);
        }
    }

    @Override
    public int getRowCount() {
        return this.rowData.size();
    }

    @Override
    public int getColumnCount() {
        return this.columnName.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return ((Vector) this.rowData.get(rowIndex)).get(columnIndex);
    }

    @Override
    public String getColumnName(int arg0){
        return (String) this.columnName.get(arg0);
    }
}
