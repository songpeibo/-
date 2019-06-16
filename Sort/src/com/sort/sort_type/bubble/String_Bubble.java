package com.sort.sort_type.bubble;

public class String_Bubble {

    private int []array;

    public String[] bubble_String(String string){
        //处理每个字符串，使之长度相同
        String []strings = getStrings(string);
        int maxSize = 0;
        for (int i = 0;i < strings.length;i++){
            if (maxSize < strings[i].length())
                maxSize = strings[i].length();
        }
        for (int i = 0;i < strings.length;i++){
            char []chars = new char[maxSize];
            char []chars1 = strings[i].toCharArray();
            strings[i] = "";
            for (int j = 0;j < chars1.length;j++)
                chars[j] = chars1[j];
            for (int k = 0;k < maxSize;k++)
                strings[i] += chars[k];
//            strings[i] = chars.toString();
            System.out.println(strings[i]);
        }
        System.out.println(strings.length);
        test_out(strings);

        int size = size(strings);
        String []strings1 = compare(strings);
        out(strings1);
        return strings1;
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

/*    public boolean lessThan(int num1,int num2){
        if(num1 > num2)
            return true;
        return false;
    }

    public void swap(int num1,int num2){
        int num = num1;
        num1 = num2;
        num2 = num;
    }*/

    public int size(String []array){
        return array.length;
    }

    public void out(String []array){
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

    public String test(String []array){
        String string = "";
        for (int i = 0;i < array.length;i++){
            string += String.valueOf(array[i]);
            if (i != array.length-1)
                string += ",";
        }
        return string;
    }

/*    public String[] bubble(String []strings){
        int Index = 0;
        char []charr = new char[strings.length];
        for (int i = 0;i < strings.length;i++){
            char []chari = strings[i].toCharArray();
            charr[i] = chari[Index];
        }

        for (int j = 0;j < strings.length-1;j++){
            if ((int)charr[j] > (int)charr[j+1]){
                String string = strings[j];
                strings[j] = strings[j+1];
                strings[j+1] = string;
            }else if ((int)charr[j] == (int)charr[j+1]){
                Index++;
                String stringj[] = bb(strings[j],strings[j+1],Index);
                strings[j] = stringj[0];
                strings[j+1] = stringj[1];
            }
        }
        return strings;
    }*/

    public String[] compare(String []strings){
        for (int i = 0;i < strings.length;i++){
            for (int j = 0;j < strings.length - i - 1;j++){
                bb(strings,j,j+1,0);
            }
        }
        return strings;
    }

    public void bb(String []strings,int i,int j,int Index){
        char []chars1 = strings[i].toCharArray();
        char []chars2 = strings[j].toCharArray();
        if ((int)chars1[Index] > (int)chars2[Index]){
            String string = strings[i];
            strings[i] = strings[j];
            strings[j] = string;
        }else if (chars1[Index] == chars2[Index]){
            Index++;
            bb(strings,i,j,Index);
        }
    }

}
//字符串比较一再使我怀疑人生，这东西只实现了一个，我怕继续实现下去可能一星期就不用睡觉了
//实现起来还是比较麻烦的，因为我采取的按字典顺序进行排序的方法
//才开始我想在for循环中取出每个字符串的相同位置的元素，然后进行比较，但显然我是失败了
    //原因是虽然第一位的元素十分好比较，很快就完成了比较，但是第二个元素开始就炸了，因为第二个元素的比较会影响到第一遍循环
    //另一种是第一遍相同元素之间进行第二遍，但很显然又失败了，因为这样需要标记哪些元素需要进行第二遍比较
//所以我决定采取每两个字符串之间进行比较，直接采用冒泡的方式进行字符串的排序，对于字符串第一个相同的再进行第二个元素排序
//也就是说务必使得两个字符串之间有一个顺序，这样就变成了两个不同大小的元素，就可以借鉴整形了