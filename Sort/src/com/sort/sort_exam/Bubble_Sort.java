package com.sort.sort_exam;

import com.sort.sort_abstract.Sort_Abstract;

import java.util.ArrayList;

public class Bubble_Sort extends Sort_Abstract {

    public void bubble(Object []objects) {
        int num = size(objects);
        for (int i = 0;i < num;i++){
            for (int j = 0;j < num-1;j++){
                if (lessThan(objects[j],objects[j+1])){
                    swap(objects[j],objects[j+1]);
                }
            }
        }
    }

    @Override
    public int size(Object []objects) {
        return objects.length;
    }

    @Override
    public boolean lessThan(Object o1, Object o2) {
        return false;
    }

    @Override
    public void swap(Object o1, Object o2) {
        Object o = o1;
        o1 = o2;
        o2 = o;
    }
}
