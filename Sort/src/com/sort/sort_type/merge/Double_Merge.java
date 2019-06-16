package com.sort.sort_type.merge;

import java.util.Arrays;

public class Double_Merge {

    private double[] array;

    public double[] merge_Double(String string){
        String []strings = getStrings(string);
        System.out.println(strings.length);
        test_out(strings);
        double []array = getArray(strings);
        int size = size(array);
        double []array1 = Merge(array);
        out(array1);
        return array1;
    }

    public double[] Merge(double []array){
        if (array.length < 2)
            return array;
        int mid = array.length / 2;
        double []left = Arrays.copyOfRange(array,0,mid);
        double []right = Arrays.copyOfRange(array,mid,array.length);
        return merge(Merge(left),Merge(right));
    }

    public double[] merge(double []left,double []right){
        double []result = new double[left.length+right.length];
        for (int index = 0,i = 0,j = 0;index < result.length;index++){
            if (i >= left.length)
                result[index] = right[j++];
            else if (j >= right.length)
                result[index] = left[i++];
            else if (left[i] > right[j])
                result[index] = right[j++];
            else
                result[index] = left[i++];
        }
        return result;
    }

    public String[] getStrings(String string){
        String []strings = string.split(",");
        return strings;
    }

    public double[] getArray(String []strings){
        double []array = new double[strings.length];
        for (int i = 0;i < strings.length;i++){
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
