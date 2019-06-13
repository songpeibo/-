package com.model;

import java.util.Random;

public class Game {

    public String random_number(){
        Random random = new Random();
        int random1 = random.nextInt(9);
        int random2 = random.nextInt(9);
        while(random1 == random2){
            random2 = random.nextInt(9);
        }
        int random3 = random.nextInt(9);
        while (random1 == random3 || random2 == random3){
            random3 = random.nextInt(9);
        }
        int random4 = random.nextInt(9);
        while (random1 == random4 || random2 == random4 || random3 == random4){
            random4 = random.nextInt(9);
        }
        String num = "";
        num += random1;
        num += random2;
        num += random3;
        num += random4;
        System.out.println(num);
        return num;
    }

    public boolean equal_num(String number1,String number2){
        if (number1.equals(number2))
            return true;
        return false;
    }

    public String equal_AB(String number1,String number2){
        char number11[] = number1.toCharArray();
        char number22[] = number2.toCharArray();
        int count1 = 0;
        int count2 = 0;
        for (int i = 0;i < number11.length;i++){
            if (number11[i] == number22[i]){
                count1++;
                count2++;
            }
            else {
                for (int j = 0;j < number22.length;j++){
                    if (number11[i] == number22[j] && i != j)
                        count2++;
                }
            }
        }
        String AB = "";
        AB += count1;
        AB += 'A';
        AB += count2;
        AB += 'B';
        System.out.println(AB);
        return AB;
    }
}
