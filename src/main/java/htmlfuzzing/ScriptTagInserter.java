package htmlfuzzing;
import htmlfuzzing.spi.Fuzzer;
import java.util.Random;

public class ScriptTagInserter implements Fuzzer{
    @Override
    public String fuzz(String str){
        String extraStr = "<script type=\"text/javascript\">\n" +
                "document.write(\"Hello World!\")\n" +
                "</script>";
        Random rand = new Random();
        int rdNum = rand.nextInt(100);
        rdNum = rdNum % str.length();
        String res = new StringBuilder(str).insert(rdNum, extraStr).toString();
        return res;
    }
}
