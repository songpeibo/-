package com.sort.sort_type.heap;

public class Double_Heap {

    private double[] array;
    private int len;

    public double[] heap_Double(String string){
        String []strings = getStrings(string);
        System.out.println(strings.length);
        test_out(strings);
        double []array = getArray(strings);
        int size = size(array);
        double []array1 = Heap(array);
        out(array1);
        return array1;
    }

    public double[] Heap(double []array){
        len = array.length;
        if (len < 1)
            return array;
        buildMaxHeap(array);
        while (len > 0){
            double num = array[0];
            array[0] = array[len-1];
            array[len-1] = num;
            len--;
            adjustHeap(array,0);
        }
        return array;
    }

    public void buildMaxHeap(double []array){
        for (int i = (len - 1) / 2;i >= 0;i--){
            adjustHeap(array,i);
        }
    }

    public void adjustHeap(double []array,int i){
        int maxIndex = i;
        if (i * 2 < len && array[i * 2] > array[maxIndex])
            maxIndex = i * 2;
        if (i * 2 + 1 < len && array[i * 2 + 1] > array[maxIndex])
            maxIndex = i * 2 + 1;
        if (maxIndex != i){
            double num = array[maxIndex];
            array[maxIndex] = array[i];
            array[i] = num;
            adjustHeap(array,maxIndex);
        }
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
