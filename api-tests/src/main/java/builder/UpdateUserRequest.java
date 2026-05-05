package builder;

// import utils.ConfigReader;
// import utils.TestContext;

import java.util.HashMap;
import java.util.Map;

public class UpdateUserRequest {

    public static Map<String, String> build(String email,String password) {

        Map<String, String> body = new HashMap<>();

        body.put("name", "UpdatedUser");
        // body.put("email", TestContext.getEmail());  // same user
        // body.put("password", TestContext.getPassword());
        body.put("email", email);
        body.put("password", password);

        body.put("firstname", "Updated");
        body.put("lastname", "User");
        body.put("address1", "New Address");
        body.put("city", "Hyderabad");
        body.put("state", "TS");
        body.put("zipcode", "500001");
        body.put("mobile_number", "8888888888");

        return body;
    }
}