package com.sort.sort_type.quick;

public class Double_Quick {

    private double[] array;

    public double[] quick_Double(String string){
        String []strings = getStrings(string);
        System.out.println(strings.length);
        test_out(strings);
        double []array = getArray(strings);
        int size = size(array);
        Quick(array,0,size-1);
        out(array);
        return array;
    }

    public void Quick(double []array,int start,int end){
        int i,j;
        double temp,t;
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
        Quick(array,start,j-1);
        Quick(array,j+1,end);
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
