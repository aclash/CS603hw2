package htmlfuzzing;
import htmlfuzzing.spi.Fuzzer;
public class TagReplacer implements Fuzzer{
    @Override
    public String fuzz(String str){
        String res = str.replaceFirst("<[^>]+>","<script>"); //repalce the first tag to <script>
        return res;
    }
}
