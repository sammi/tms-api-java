package com.hanyun.tms.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import static com.hanyun.tms.utils.Base64Utils.encode;

public class ImageUtils {
    private ImageUtils() {

    }

    public static String imageToBase64(String path) throws IOException {
        byte[] data = null;
        InputStream in = null;
        try {
            in = new FileInputStream(path);
            data = new byte[in.available()];
            in.read(data);
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    throw e;
                }
            }
        }
        String suffix = path.substring(path.lastIndexOf(".") + 1);
        return getDataUrlBySuffix(suffix) + encode(data);
    }

    private static String getDataUrlBySuffix(String suffix) {
        StringBuilder sb = new StringBuilder("data:image/");
        switch (suffix) {
            case "jpg": {
                sb.append("jpeg");
                break;
            }
            case "png": {
                sb.append("png");
                break;
            }
            case "gif": {
                sb.append("gif");
                break;
            }
            default: {
                throw new RuntimeException("not support file type!");
            }
        }
        sb.append(";base64,");

        return sb.toString();
    }

    public static void main(String[] args) {
        String path = ImageUtils.class.getResource("/").getPath() + "com/hanyun/tms/client/image1.jpg";
        try {
            System.out.println(imageToBase64(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
