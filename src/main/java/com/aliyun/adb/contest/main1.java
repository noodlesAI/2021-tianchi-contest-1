package com.aliyun.adb.contest;
import java.util.Scanner;

public class main1{

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        String[] s=new String[b];
        for (int i=1;i<=b;i++){
            s[i]=in.nextLine();
        }
        StringBuffer stringBuffer=new StringBuffer();


        for(int i=1;i<=b;i++){// 总共b行
            for (int j=0;j<=s[j].length();i=i+a){
                stringBuffer.append(s[j].substring(j,j+a));
            }

        }

    }
}
