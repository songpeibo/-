package com.sort.sort_type.bubble;

import com.sort.sort_exam.Bubble_Sort;


public class Int_Bubble extends Bubble_Sort {

    private int []array;

    public int[] bubble_Int(String string){
        String []strings = getStrings(string);
        System.out.println(strings.length);
        test_out(strings);
        int []array = getArray(strings);
        int size = size(array);
        for (int i = 0;i < size;i++){
            for (int j = 0;j < size - 1 -i;j++){
                if (array[j] > array[j+1]){
                    int num = array[j];
                    array[j] = array[j+1];
                    array[j+1] = num;
                }
//                if (lessThan(array[j],array[j+1]))
//                    swap(array[j],array[j+1]);
            }
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

    public boolean lessThan(int num1,int num2){
        if(num1 > num2)
            return true;
        return false;
    }

    public void swap(int num1,int num2){
        int num = num1;
        num1 = num2;
        num2 = num;
    }

    public int size(int []array){
        return array.length;
    }

    public void out(int []array){
        for(int i = 0;i < array.length;i++){
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
