package com.sort.sort_exam;

import com.sort.sort_abstract.Sort_Abstract;

public class Insertion_Sort extends Sort_Abstract {

    public void insertion(Object []objects){
        int size = size(objects);
        for (int i = 0;i < size;i++){
            if (lessThan(objects[i],objects[i+1]))
                swap(objects[i],objects[i+1]);
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
