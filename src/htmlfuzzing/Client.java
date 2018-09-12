package htmlfuzzing;
import htmlfuzzing.FuzzingService;
public class Client {
    public static void main(String[] args) {

        FuzzingService fuzzService = FuzzingService.getInstance();
        System.out.println(Client.lookup(fuzzService, "some words"));
    }

    public static String lookup(FuzzingService service, String word) {
        String outputString = "";
        String fuzzedStr = service.fuzz(word);
        if (fuzzedStr == null) {
            return outputString + "Cannot find definition for this word.";
        } else {
            return outputString + fuzzedStr;
        }
    }
}
