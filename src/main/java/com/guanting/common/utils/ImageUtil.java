package com.guanting.common.utils;

import javax.imageio.stream.FileImageInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;


public class ImageUtil {

    /**
     * 图片转二进制数据
     *
     * @param path 图片路径
     * @return byte[]
     */
    public static byte[] image2byte(String path) {
        byte[] data = null;
        FileImageInputStream input = null;
        ByteArrayOutputStream output = null;
        try {
            input = new FileImageInputStream(new File(path));
            output = new ByteArrayOutputStream();
            byte[] buf = new byte[1024];
            int numBytesRead = 0;
            while ((numBytesRead = input.read(buf)) != -1) {
                output.write(buf, 0, numBytesRead);
            }
            data = output.toByteArray();
            output.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try{
                if (input != null) {
                    input.close();
                }
                if (output != null) {
                    output.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return data;
    }
}
