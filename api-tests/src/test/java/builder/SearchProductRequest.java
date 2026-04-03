package builder;

import java.util.HashMap;
import java.util.Map;

public class SearchProductRequest {

    public static Map<String, String> build(String product) {

        Map<String, String> body = new HashMap<>();
        body.put("search_product", product);

        return body;
    }
}