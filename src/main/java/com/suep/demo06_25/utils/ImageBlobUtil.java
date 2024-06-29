package com.suep.demo06_25.utils;

import java.io.*;
import java.sql.Blob;
import java.sql.SQLException;

public class ImageBlobUtil {

    /**
     * 将图片文件转换为byte数组
     *
     * @param imagePath 图片文件的路径
     * @return 图片文件的byte数组
     * @throws IOException 如果读取文件时出错
     */
    public static byte[] imageToByteArray(String imagePath) throws IOException {
        File imageFile = new File(imagePath);
        InputStream inputStream = new FileInputStream(imageFile);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        byte[] buffer = new byte[4096];
        int bytesRead;
        while ((bytesRead = inputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, bytesRead);
        }

        inputStream.close();
        return outputStream.toByteArray();
    }

    /**
     * 将byte数组转换为BLOB对象
     *
     * @param imageBytes 图片文件的byte数组
     * @return BLOB对象
     * @throws SQLException 如果创建BLOB对象时出错
     */
    public static Blob byteArrayToBlob(byte[] imageBytes) throws SQLException {
        // 这里需要根据你的数据库实现来创建Blob对象
        // 例如，如果你使用的是Apache Derby，可以这样创建Blob：
        // Blob blob = new SerialBlob(imageBytes);
        // 对于其他数据库，请参考相应的JDBC文档
        return null;
    }

    /**
     * 将数据库中的BLOB对象转换为图片文件
     *
     * @param blob      BLOB对象
     * @param outputPath 图片文件的输出路径
     * @throws SQLException    如果访问BLOB对象时出错
     * @throws IOException     如果写入文件时出错
     */
    public static void blobToImageFile(Blob blob, String outputPath) throws SQLException, IOException {
        byte[] imageBytes = blob.getBytes(1, (int) blob.length());
        ByteArrayInputStream inputStream = new ByteArrayInputStream(imageBytes);
        File outputFile = new File(outputPath);
        OutputStream outputStream = new FileOutputStream(outputFile);

        byte[] buffer = new byte[4096];
        int bytesRead;
        while ((bytesRead = inputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, bytesRead);
        }

        inputStream.close();
        outputStream.close();
    }
}
