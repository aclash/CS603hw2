package htmlfuzzing;
import org.jsoup.*;
import org.jsoup.nodes.*;
import org.jsoup.safety.Whitelist;

public class Client {
    public static void main(String[] args) {
        FuzzingService fuzzService = FuzzingService.getInstance();
        TestCreation(fuzzService);
        TestClean(fuzzService);
    }

    private static final int testNum = 100;

    public static void TestCreation(FuzzingService service){
        //single modification
        for (int i = 0; i < testNum; ++i){
            try {
                String html = "<html><head><title>First parse</title></head>" + "<body><p>Parsed HTML into a doc.</p></body></html>";
                String fuzzedHtml = service.SingleModification(html);
                Document doc = Jsoup.parse(fuzzedHtml);
            }catch(Exception e){
                e.getStackTrace();
            }
        }

        //combined modification
        for (int i = 0; i < testNum; ++i){
            try {
                String html = "<html><head><title>First parse</title></head>" + "<body><p>Parsed HTML into a doc.</p></body></html>";
                String fuzzedHtml = service.CombinedModification(html);
                Document doc = Jsoup.parse(fuzzedHtml);
            }catch(Exception e){
                e.getStackTrace();
            }
        }
        System.out.println("*************Creation Success!!!******************");
    }

    public static void TestClean(FuzzingService service){
        for (int i = 0; i < testNum; ++i){
            try {
                String unsafe = "<p><a href='http://example.com/' onclick='stealCookies()'>Link</a></p>";
                String fuzzedHtml = service.InsertHTML(unsafe);
                String safe = Jsoup.clean(fuzzedHtml, Whitelist.basic());
            }catch(Exception e){
                e.getStackTrace();
            }
        }
        System.out.println("*************Clean Success!!!******************");
    }
}
