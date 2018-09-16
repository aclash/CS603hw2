package htmlfuzzing;
import htmlfuzzing.spi.Fuzzer;

import java.util.ArrayList;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TagReplacer implements Fuzzer{
    @Override
    public String fuzz(String str){
        ArrayList<Integer> list = new ArrayList<>();
        String regex = "(<[^>]+>)|(<[^>]+/>)";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(str);
        while(m.find()) {
            list.add(m.start());                                //find all the tag and put into arraylist
        }
        Random rand = new Random();
        int rdIndex = rand.nextInt(list.size());                //randomly pick a tag could be <xxx> or <xxx/>
        String res1 = str.substring(0, list.get(rdIndex));
        String res2 = str.substring(list.get(rdIndex));
        res2 = res2.replaceFirst("(<[^>]+>)|(<[^>]+/>)","</script>"); //remove the start tag or close tag
        return res1 + res2;
    }
}
