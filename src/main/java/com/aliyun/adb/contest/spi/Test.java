package com.aliyun.adb.contest.spi;

public class Test{
    public static void main(String[] args){
        int n=1;
        double sum=0;
        while(true){
            if(n==1)
                sum=1000;
            else
                sum+=1000.0/n;

            System.out.println("n="+n+",sum="+sum);
            if((int)sum==10000)break;
            n++;
        }
        System.out.println(n);
    }
}
