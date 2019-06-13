package com.util;

import com.list.RankList;
import com.model.Rank;

import java.io.*;
import java.util.ArrayList;

public class FileList {

    public static void writeFile(String filePathAndName,String fileContent){
        try {
            File file = new File(filePathAndName);
            if (!file.exists()){
                file.createNewFile();
            }
            OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(file,true),"UTF-8");
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write(fileContent);
            bufferedWriter.close();
        }catch (Exception e){
            System.out.println("写文件内容操作错误");
            e.printStackTrace();
        }
    }

    public static void clear(String path){
        try {
            new FileOutputStream(path).write(new String("").getBytes());
        }catch (Exception e){
            System.out.println("清空文件错误"+e.getMessage());
        }
    }

    public static void readFileByLines(String fileName){
        File file = new File(fileName);
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName),"UTF-8"));
            String tempString = null;
            ArrayList<Rank> list = RankList.getList();
            while ((tempString = bufferedReader.readLine()) != null){
                String []s = tempString.split(",");
                Rank rank = new Rank();
                rank.setId(s[0]);
                rank.setName(s[1]);
                rank.setNum(s[2]);
                list.add(rank);
            }
            bufferedReader.close();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if (bufferedReader != null){
                try {
                    bufferedReader.close();
                }catch (IOException e){

                }
            }
        }
    }
}
//split是字符串分割的意思，这里根据','对字符串进行分割，分割的结果保存在字符串数组中