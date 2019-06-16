package com.sort.sort_exam;

import com.sort.sort_abstract.Sort_Abstract;

public class Quick_Sort extends Sort_Abstract {
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

    }
}
