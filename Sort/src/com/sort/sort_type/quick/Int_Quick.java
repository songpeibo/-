package com.sort.sort_type.quick;

import com.sort.sort_exam.Quick_Sort;

public class Int_Quick extends Quick_Sort {

    private int[] array;

    public int[] quick_Int(String string){
        String []strings = getStrings(string);
        System.out.println(strings.length);
        test_out(strings);
        int []array = getArray(strings);
        int size = size(array);
        Quickk(array,0,size-1);
        out(array);
        return array;
/*        int []array1 = Quick(array,0,size-1);
        out(array1);
        return array1;*/
    }

    public void Quickk(int []array,int start,int end){
        int i,j,temp,t;
        if (start > end)
            return;
        i = start;
        j = end;
        temp = array[start];
        while (i < j){
            while (temp <= array[j] && i < j)
                j--;
            while (temp >= array[i] && i < j)
                i++;
            if (i < j){
                t = array[j];
                array[j] = array[i];
                array[i] = t;
            }
        }
        array[start] = array[i];
        array[i] = temp;
        Quickk(array,start,j-1);
        Quickk(array,j+1,end);
    }

/*    public int[] Quick(int []array,int start,int end){
        if (array.length < 1 || start < 0 || end >= array.length || start > end)
            return null;
        int smallIndex = quick(array,start,end);
        if (smallIndex > start)
            Quick(array,start,smallIndex - 1);
        if (smallIndex < end)
            Quick(array,smallIndex + 1,end);
        return array;
    }

    public int quick(int []array,int start,int end){
        int pivot = (int) (start+Math.random() * (end-start+1));
        int smallIndex = start - 1;
        swap(array,pivot,end);
        int num = array[pivot];
        array[pivot] = array[end];
        array[end] = array[pivot];
        for (int i = start;i <= end;i++){
            if (array[i] <= array[end]){
                smallIndex++;
                if (i > smallIndex){
                    int num1 = array[i];
                    array[i] = array[smallIndex];
                    array[smallIndex] = num1;
                }
                    swap(array,i,smallIndex);
            }
        }
        return smallIndex;
    }

    public void swap(int []array,int num1,int num2){
        int num = array[num1];
        array[num1] = array[num2];
        array[num2] = array[num1];
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
