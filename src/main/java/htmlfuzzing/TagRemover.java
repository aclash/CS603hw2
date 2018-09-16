package htmlfuzzing;
import htmlfuzzing.spi.Fuzzer;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Random;

public class TagRemover implements Fuzzer{
    @Override
    public String fuzz(String str){                         //randomly pick a tag and remove it
        ArrayList<Integer> list = new ArrayList<>();
        String regex = "(<[^>]+>)|(<[^>]+/>)";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(str);
        while(m.find()) {
            list.add(m.start());                            //find all the tag and put into arraylist
        }
        Random rand = new Random();
        int rdIndex = rand.nextInt(list.size());
        String res1 = str.substring(0, list.get(rdIndex));
        String res2 = str.substring(list.get(rdIndex));
        res2 = res2.replaceFirst("(<[^>]+>)|(<[^>]+/>)",""); //remove the first tag
        return res1 + res2;
    }
}
