package com.aliyun.adb.contest.spi;
public class Test2{
    static int i=0;
    public static void main(String[] args){
//        long startTime = System.currentTimeMillis();
//        double sum=0;
//        double n=1;
//        while (sum <=10000){
//            sum=sum+1000/n;
//            n++;
//
//        };
//        System.out.println(n-2);
//        long endTime = System.currentTimeMillis();    //获取结束时间
//        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");
//        double sum1=1000.0/1.0;
//        double sum2=sum1+1000.0/2.0;
//        double sum3=sum2+1000.0/3.0;
//        System.out.println();
        double count;
        int n=1;
        do{
            count=sum(n);
            n++;
         }while(count <= 1000);
//         System.out.println(n-1);
//        System.out.println(sum(12363));
    }
    private static double sum(int n) {

        i++;
            System.out.println(i);
        if (n==1)
            return 1000;
        else
            return sum(n-1)+1000/n;
    }
}
