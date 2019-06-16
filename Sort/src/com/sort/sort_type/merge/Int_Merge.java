package com.sort.sort_type.merge;

import com.sort.sort_exam.Merge_Sort;

import java.util.Arrays;

public class Int_Merge extends Merge_Sort {

    private int[] array;

    public int[] merge_Int(String string){
        String []strings = getStrings(string);
        System.out.println(strings.length);
        test_out(strings);
        int []array = getArray(strings);
        int size = size(array);
        int []array1 = Merge(array);
        out(array1);
        return array1;
    }

    public int[] Merge(int []array){
        if (array.length < 2)
            return array;
        int mid = array.length / 2;
        int []left = Arrays.copyOfRange(array,0,mid);
        int []right = Arrays.copyOfRange(array,mid,array.length);
        return merge(Merge(left),Merge(right));
    }

    public int[] merge(int []left,int []right){
        int []result = new int[left.length+right.length];
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

    public int[] getArray(String []strings){
        int []array = new int[strings.length];
        for (int i = 0;i < strings.length;i++){
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
