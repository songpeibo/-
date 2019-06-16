package com.sort.sort_type.bubble;

import com.sort.sort_exam.Bubble_Sort;

public class Double_Bubble extends Bubble_Sort {

    private double []array;

    public double[] bubble_Double(String string){
        String []strings = getStrings(string);
        System.out.println(strings.length);
        test_out(strings);
        double []array = getArray(strings);
        int size = size(array);
        for (int i = 0;i < size;i++){
            for (int j = 0;j < size - 1 -i;j++){
                if (array[j] > array[j+1]){
                    double num = array[j];
                    array[j] = array[j+1];
                    array[j+1] = num;
                }
            }
        }
        out(array);
        return array;
    }

    public String[] getStrings(String string){
        String []strings = string.split(",");
        return strings;
    }

    public double[] getArray(String []strings){
        double []array = new double[strings.length];
        for(int i = 0;i < strings.length;i++){
            array[i] = Double.valueOf(strings[i]);
        }
        return array;
    }

    public int size(double []array){
        return array.length;
    }

    public void out(double []array){
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

    public String test(double []array){
        String string = "";
        for (int i = 0;i < array.length;i++){
            string += String.valueOf(array[i]);
            if (i != array.length-1)
                string += ",";
        }
        return string;
    }
}
