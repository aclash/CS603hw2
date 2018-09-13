package htmlfuzzing;
import htmlfuzzing.spi.Fuzzer;
public class ScriptTagInserter implements Fuzzer{
    @Override
    public String fuzz(String str){
        return "ScriptTagInserter";
    }
}
