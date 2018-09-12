package htmlfuzzing;
import htmlfuzzing.spi.Fuzzer;
import java.util.Iterator;
import java.util.ServiceLoader;
import java.util.ServiceConfigurationError;


public class FuzzingService {
    private static FuzzingService service;
    private ServiceLoader<Fuzzer> loader;

    private FuzzingService() {
        loader = ServiceLoader.load(Fuzzer.class);
    }

    public static synchronized FuzzingService getInstance() {
        if (service == null) {
            service = new FuzzingService();
        }
        return service;
    }

    public String fuzz(String str) {
        String modifiedStr = null;
        try {
            for (Fuzzer fu : loader) {
                System.out.println();
            }

            Iterator<Fuzzer> fuzzes = loader.iterator();
            while (fuzzes.hasNext()) {
                Fuzzer fuzzObj = fuzzes.next();
                modifiedStr = fuzzObj.fuzz(str);
            }
        } catch (ServiceConfigurationError serviceError) {
            modifiedStr = null;
            serviceError.printStackTrace();
        }
        return modifiedStr;
    }
}
