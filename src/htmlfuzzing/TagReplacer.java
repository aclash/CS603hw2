package htmlfuzzing;
import htmlfuzzing.spi.Fuzzer;
public class TagReplacer implements Fuzzer{
    @Override
    public String fuzz(String str){
        return "TagReplacer";
    }
}
