package com.aliyun.adb.contest;

import org.junit.Assert;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class TestSimpleAnalyticDB {

    @Test
    public void testCorrectness() throws Exception {
        long startTime = System.currentTimeMillis();    //获取开始时间
        File testDataDir = new File("./test_data");
        File testWorkspaceDir = new File("./target");
        File testResultsFile = new File("./test_result/results");
        SimpleAnalyticDB analyticDB = new SimpleAnalyticDB();

        // Step #1: load data
        analyticDB.load(testDataDir.getAbsolutePath(), testWorkspaceDir.getAbsolutePath());
        long endTime = System.currentTimeMillis();    //获取结束时间
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");    //输出程序运行时间
        // Step #2: test quantile function
        try (BufferedReader resReader = new BufferedReader(new FileReader(testResultsFile))) {
            String line;

            while ((line = resReader.readLine()) != null) {
                String resultStr[] = line.split(" ");
                String table = resultStr[0];
                String column = resultStr[1];
                double percentile = Double.valueOf(resultStr[2]);
                String answer = resultStr[3];

                Assert.assertEquals(answer, analyticDB.quantile(table, column, percentile));
            }
        }


        }


}
