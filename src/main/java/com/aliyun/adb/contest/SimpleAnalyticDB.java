package com.aliyun.adb.contest;

import com.aliyun.adb.contest.spi.AnalyticDB;

import java.io.File;

public class SimpleAnalyticDB implements AnalyticDB {

    /**
     *
     * The implementation must have a public no-argument constructor.
     *
     */
    public SimpleAnalyticDB() {
    }

    @Override
    public void load(String tpchDataFileDir, String workspaceDir) {
        File dir = new File(tpchDataFileDir);

        for (File dataFile : dir.listFiles()) {
            String tableName = dataFile.getName();
            System.out.println("Load table " + tableName);
        }

    }

    @Override
    public String quantile(String table, String column, double percentile) {
        return null;
    }

}
