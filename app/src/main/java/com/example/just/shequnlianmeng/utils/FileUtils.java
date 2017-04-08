package com.example.just.shequnlianmeng.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Environment;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 文件处理
 *
 * @author T-BayMax
 */
public class FileUtils {

    private String SDPATH;
    private Activity context;

    public String getSDPATH() {
        return SDPATH;
    }

    public FileUtils() {
        //得到当前外部存储设备的目录
        SDPATH = Environment.getExternalStorageDirectory() + "/";
    }

    public FileUtils(Activity context) {
        this.context = context;
        //得到当前外部存储设备的目录
        SDPATH = Environment.getExternalStorageDirectory() + "/";
    }

    /**
     * @param fileName
     * @param is
     */
    public void deepFile(String fileName,InputStream is) {
        try {

            FileOutputStream fos =  context.openFileOutput(fileName, Context.MODE_PRIVATE);
            byte[] buffer = new byte[1024];
            int count = 0;
            while (true) {
                count++;
                int len = is.read(buffer);
                if (len == -1) {
                    break;
                }
                fos.write(buffer, 0, len);
            }
            is.close();
            fos.close();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * @param filename 获得读取的文件的名称
     * @return 文件路径
     */
    public String redFilePath(String filename) {
        File file = context.getFileStreamPath(filename);

        return file != null ? file.getPath() : "";
    }

    /**
     * @param filename 获得读取的文件的名称
     * @return 文件路径
     */
    public File redFile(String filename) {
        File file = context.getFileStreamPath(filename);

        return file;
    }

    /**
     * 在SD卡上创建文件
     *
     * @throws IOException
     */
    public File creatSDFile(String fileName) throws IOException {
        File file = new File(SDPATH + fileName);
        if (!isFileExist(fileName)) {
            file.createNewFile();
        }

        return file;
    }

    /**
     * 在SD卡上创建目录
     *
     * @param dirName
     */
    public File creatSDDir(String dirName) {
        File dir = new File(SDPATH + dirName);
        dir.mkdir();
        return dir;
    }

    /**
     * 判断SD卡上的文件夹是否存在
     */
    public boolean isFileExist(String fileName) {

        File file = new File(SDPATH + fileName);
        //file.delete();
        return file.exists();

    }

    public boolean deleteFile(String filePath) {
        File file = new File(filePath);
        if (file.isFile() && file.exists()) {
            return file.delete();
        }
        return false;
    }


    /**
     * 将一个InputStream里面的数据写入到SD卡中
     */
    public File writeToSDFromInput(String path, String fileName, InputStream input) {
        File file = null;
        OutputStream output = null;
        try {
            if (input == null) {
                return null;
            }
            creatSDDir(path);
            String[] fileNames = fileName.split("/");
            for (int i = 0; i < fileNames.length - 1; i++) {
                path += "/" + fileNames[i];
                creatSDDir(path);
            }
            byte buffer[] = new byte[1024];
            int len = 0;
            //如果下载成功就开往SD卡里些数据
            while ((len = input.read(buffer)) != -1) {
                file = creatSDFile(path + "/" + fileNames[fileNames.length - 1]);
                if (output == null) {
                    output = new FileOutputStream(file);
                }
                output.write(buffer, 0, len);
            }
            output.flush();

            input.close();
            output.close();
        } catch (Exception e) {

        }
        return file;
    }
}