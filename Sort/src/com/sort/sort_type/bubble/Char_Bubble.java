package com.sort.sort_type.bubble;

public class Char_Bubble {

    private int []array;

    public char[] bubble_Char(String string){
        char []chars = getChars(string);
        System.out.println(chars.length);
        test_out(chars);
        int []array = getArray(chars);
        int size = size(array);
        for (int i = 0;i < size;i++){
            for (int j = 0;j < size - 1 -i;j++){
                if (array[j] > array[j+1]){
                    int num = array[j];
                    array[j] = array[j+1];
                    array[j+1] = num;
                }
            }
        }
        out(chars);
        char []chars1 = getChar(array);
        return chars1;
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
        for(int i = 0;i < array.length;i++){
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
