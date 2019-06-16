package com.sort.sort_type.selection;

import com.sort.sort_exam.Selection_Sort;

public class Int_Selection extends Selection_Sort {

    private int []array;

    public int[] selection_Int(String string){
        String []strings = getStrings(string);
        System.out.println(strings.length);
        test_out(strings);
        int []array = getArray(strings);
        int size = size(array);
        for (int i = size - 1;i >= 0;i--){
//            int max = array[i];
            int maxIndex = i;
            for (int j = i;j >= 0;j--){
                if (array[j] > array[maxIndex]){
//                if (array[j] > max){
//                    max = array[j];
                    maxIndex = j;
                }
            }
            int num = array[i];
            array[i] = array[maxIndex];
            array[maxIndex] = num;
        }
        out(array);
        return array;
    }

    public String[] getStrings(String string){
        String []strings = string.split(",");
        return strings;
    }

    public int[] getArray(String []strings){
        int []array = new int[strings.length];
        for(int i = 0;i < strings.length;i++){
            array[i] = Integer.parseInt(strings[i]);
        }
        return array;
    }

    public int size(int []array){
        return array.length;
    }

    public void out(int []array){
        for (int i = 0;i < array.length;i++){
            System.out.print(array[i]);
            System.out.print(' ');
        }
        System.out.println();
    }

    public void test_out(String []strings){
        for (int j = 0;j < strings.length;j++){
            System.out.print(strings[j]);
            System.out.print(' ');
        }
        System.out.println();
    }

    public String test(int []array){
        String string = "";
        for (int i = 0;i < array.length;i++){
            string += String.valueOf(array[i]);
            if (i != array.length-1)
                string += ",";
        }
        return string;
    }
}
