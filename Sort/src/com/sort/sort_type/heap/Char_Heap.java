package com.sort.sort_type.heap;

public class Char_Heap {

    private char[] array;
    private int len;

    public char[] heap_Char(String string){
        char []chars = getChars(string);
        System.out.println(chars.length);
        test_out(chars);
        int []array = getArray(chars);
        int size = size(array);
        int []array1 = Heap(array);
        char []chars1 = getChar(array1);
        out(chars1);
        return chars1;
    }

    public int[] Heap(int []array){
        len = array.length;
        if (len < 1)
            return array;
        buildMaxHeap(array);
        while (len > 0){
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
            int num = array[maxIndex];
            array[maxIndex] = array[i];
            array[i] = num;
            adjustHeap(array,maxIndex);
        }
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

    public char[] getChars(String string){
        char []chars = string.toCharArray();
        return chars;
    }

    public int[] getArray(char []chars){
        int []array = new int[chars.length];
        for(int i = 0;i < chars.length;i++){
            array[i] = (int)chars[i];
        }
        return array;
    }

    public char[] getChar(int []array){
        char []chars1 = new char[array.length];
        for (int i = 0;i < array.length;i++){
            chars1[i] = (char)array[i];
        }
        return chars1;
    }

    public int size(int []array){
        return array.length;
    }

    public void out(char []array){
        for (int i = 0;i < array.length;i++){
            System.out.print(array[i]);
            System.out.print(' ');
        }
        System.out.println();
    }

    public void test_out(char []chars){
        for (int j = 0;j < chars.length;j++){
            System.out.print(chars[j]);
            System.out.print(' ');
        }
        System.out.println();
    }

    public String test(char []array){
        String string = "";
        for (int i = 0;i < array.length;i++){
            string += String.valueOf(array[i]);
            if (i != array.length-1)
                string += ",";
        }
        return string;
    }
}
