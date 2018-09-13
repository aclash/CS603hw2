package htmlfuzzing;
import htmlfuzzing.spi.Fuzzer;
public class TagRemover implements Fuzzer{
    @Override
    public String fuzz(String str){
        return "TagRemover";
    }
}
