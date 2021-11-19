package com.firebasky.fastjson.poc1268.p1g3;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.sun.xml.internal.fastinfoset.util.CharArray;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class tool {
    public char[] buf = getChars(FiletoBytes("E:\\java安全\\java框架\\fastjson\\code\\src\\main\\java\\com\\firebasky\\fastjson\\poc1268\\p1g3\\hack.txt"));

    public tool() throws Exception {
    }

    public static byte[] getBytes(char[] chars) {
        Charset cs = Charset.forName("UTF-8");
        CharBuffer cb = CharBuffer.allocate(chars.length);
        cb.put(chars);
        cb.flip();
        ByteBuffer bb = cs.encode(cb);
        return bb.array();
    }

    public static char[] getChars(byte[] bytes) {
        Charset cs = Charset.forName("UTF-8");
        ByteBuffer bb = ByteBuffer.allocate(bytes.length);
        bb.put(bytes).flip();
        CharBuffer cb = cs.decode(bb);
        return cb.array();
    }

    public static byte[] charToByte(char c) {
        byte[] b = new byte[2];
        b[0] = (byte) ((c & 0xFF00) >> 8);
        b[1] = (byte) (c & 0xFF);
        return b;
    }

    public static char byteToChar(byte[] b) {
        int hi = (b[0] & 0xFF) << 8;
        int lo = b[1] & 0xFF;
        return (char) (hi | lo);
    }
    public static byte[] FiletoBytes(String filename) throws Exception {
        byte[] buf = null;
        File file = new File(filename);
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
            int size = fis.available();
            byte[] bytes = new byte[size];
            fis.read(bytes);
            return bytes;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return buf;
    }

    public static void main(String[] args) throws Exception {
        String arg ="漱壕   4 8";
        char[] chars = arg.toCharArray();
        System.out.println(chars);
        //tool tool = new tool();
        //String str = JSONObject.toJSONString(tool, SerializerFeature.WriteClassName);
        //System.out.println(str);
    }
}
