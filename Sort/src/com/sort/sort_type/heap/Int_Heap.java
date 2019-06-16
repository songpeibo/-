package com.sort.sort_type.heap;

import java.util.Arrays;

public class Int_Heap {

    private int[] array;
    private int len;

    public int[] heap_Int(String string){
        String []strings = getStrings(string);
        System.out.println(strings.length);
        test_out(strings);
        int []array = getArray(strings);
        int size = size(array);
        int []array1 = Heap(array);
        out(array1);
        return array1;
    }

    public int[] Heap(int []array){
        len = array.length;
        if (len < 1)
            return array;
        buildMaxHeap(array);
        while (len > 0){
//            swap(array[0],array[len-1]);
            int num = array[0];
            array[0] = array[len-1];
            array[len-1] = num;
            len--;
            adjustHeap(array,0);
        }
        return array;
    }

    public void buildMaxHeap(int []array){
        for (int i = (len - 1) / 2;i >= 0;i--){
            adjustHeap(array,i);
        }
    }

    public void adjustHeap(int []array,int i){
        int maxIndex = i;
        if (i * 2 < len && array[i * 2] > array[maxIndex])
            maxIndex = i * 2;
        if (i * 2 + 1 < len && array[i * 2 + 1] > array[maxIndex])
            maxIndex = i * 2 + 1;
        if (maxIndex != i){
//            swap(array[maxIndex],array[i]);
            int num = array[maxIndex];
            array[maxIndex] = array[i];
            array[i] = num;
            adjustHeap(array,maxIndex);
        }
    }

/*    public void swap(int num1,int num2){
        int num = num1;
        num1 = num2;
        num2 = num;
    }*/

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
