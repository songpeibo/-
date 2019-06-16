package com.sort.sort_exam;

import com.sort.sort_abstract.Sort_Abstract;

public class Selection_Sort extends Sort_Abstract {

    public void selection(Object []objects){
        int size = size(objects);
        for (int i = 0;i < size;i++){
            Object o = objects[i];
            for (int j = 0;j < size - i;j++){
                if (lessThan(objects[j],o))
                    o = objects[j];
            }
            swap(o,objects[size - i - 1]);
        }
    }

    @Override
    public int size(Object[] objects) {
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
