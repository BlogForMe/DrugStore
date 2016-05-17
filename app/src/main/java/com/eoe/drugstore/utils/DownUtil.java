package com.eoe.drugstore.utils;

import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Jon on 2016/5/15.
 * 多线程下载
 */
public class DownUtil {
    private String path;    //定义下载资源的路劲
    private String targetFile; //指定所下载文件的保存位置
    private int threadNum; //定义下载的线程的对象
    private DownThread[] threads;
    private int fileSize; //定义下载的文件的总大小


    public DownUtil(String path, String targetFile, int threadNum, DownThread[] threads) {
        this.path = path;
        this.targetFile = targetFile;
        this.threadNum = threadNum;
        this.threads = new DownThread[threadNum];
    }

    public void download() throws Exception {
        URL url = new URL(path);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setConnectTimeout(5 * 1000);
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept", "image/gif,image/jpeg,image/pjpeg,image/pjpeg," +
                "application/x-shockwave-flash,application/aml_xml," +
                "application/vnd.ms-xpsdocument,application/x-ms-xbap," +
                "application/x-ms-application,application/vnd.ms-excel," +
                "application/vnd.ms-powerpoint,application/msword,*/*");
        conn.setRequestProperty("Accept-Language", "zh-CN");
        conn.setRequestProperty("Charset", "UTF-8");
        conn.setRequestProperty("Connection", "Keep-Alive");
        fileSize = conn.getContentLength();//得到文件大小
        conn.disconnect();
        int currentPartSize = fileSize / threadNum + 1;
        RandomAccessFile file = new RandomAccessFile(targetFile, "rw");
        file.setLength(fileSize);//设置本地文件的大小
        file.close();

        for (int i = 0; i < threadNum; i++) {
            int startPos = i * currentPartSize;  //计算每条线程的下载的开始位置
            RandomAccessFile currentPart = new RandomAccessFile(targetFile, "rw"); //每个线程使用一个RandomAccessFile进行下载
            currentPart.seek(startPos); //定位该线程的下载weiz
            threads[i] = new DownThread(startPos, currentPartSize, currentPart); //创建下载线程
            threads[i].start(); //启动下载线程
        }
    }

    //获取下载的完成百分比
    public double getCompleteRate() {
        int sumSize = 0;  //统计多天线程已经下载的总大小
        for (int i = 0; i < threadNum; i++)
            sumSize += threads[i].length;
        return sumSize * 1.0 / fileSize;  //返回已经完成的百分比
    }

    private class DownThread extends Thread {
        private int startPos; // 当前线程的下载位置
        private int cureentPartSize; // 定义当前线程负责下载的文件大小
        private RandomAccessFile currentPart; //当前线程需要下载的文件块
        public int length; //定义已经该线程下载的字节数

        public DownThread(int startPos, int cureentPartSize, RandomAccessFile currentPart) {
            this.startPos = startPos;
            this.cureentPartSize = cureentPartSize;
            this.currentPart = currentPart;
        }


        @Override
        public void run() {
            super.run();

            try {
                URL url = new URL(path);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setConnectTimeout(5 * 1000);
                conn.setRequestMethod("GET");
                conn.setRequestProperty("Accept", "image/gif,image/jpeg,image/pjpeg,image/pjpeg," +
                        "application/x-shockwave-flash,application/aml_xml," +
                        "application/vnd.ms-xpsdocument,application/x-ms-xbap," +
                        "application/x-ms-application,application/vnd.ms-excel," +
                        "application/vnd.ms-powerpoint,application/msword,*/*");
                conn.setRequestProperty("Accept-Language", "zh-CN");
                conn.setRequestProperty("Charset", "UTF-8");
                InputStream inStream = conn.getInputStream();
                inStream.skip(this.startPos); //跳过startPos个字节，表明该线程只下载自己负责哪部分文件
                byte[] buffer = new byte[1024];
                int hasRead = 0;
                //读取网络数据，并写入本地文件
                while (length < cureentPartSize && (hasRead = inStream.read(buffer)) > 0) {
                    currentPart.write(buffer, 0, hasRead);
                    length += hasRead;//累计该线程下载的总大小
                }
                currentPart.close();
                inStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }


        }
    }
}
