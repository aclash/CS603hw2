package htmlfuzzing;
import htmlfuzzing.spi.Fuzzer;
public class TagRemover implements Fuzzer{
    @Override
    public String fuzz(String str){
        String res = str.replaceFirst("<[^>]+>",""); //remove the first tag
        return res;
    }
}
