package builder;

import utils.ConfigReader;
import utils.TestContext;

import java.util.HashMap;
import java.util.Map;

public class CreateUserRequest {

    public static Map<String, String> build() {

        Map<String, String> body = new HashMap<>();

        String email = "test" + System.currentTimeMillis() + "@mail.com";

        body.put("name", ConfigReader.get("name"));
        body.put("email", email);  
        body.put("password", ConfigReader.get("password"));
        body.put("title", "Mr");

        body.put("birth_date", "10");
        body.put("birth_month", "May");
        body.put("birth_year", "1995");

        body.put("firstname", ConfigReader.get("firstname"));
        body.put("lastname", ConfigReader.get("lastname"));
        body.put("address1", ConfigReader.get("address"));
        body.put("address2", ConfigReader.get("address"));
        body.put("country", "India");
        body.put("zipcode", ConfigReader.get("zipcode"));
        body.put("state", ConfigReader.get("state"));
        body.put("city", ConfigReader.get("city"));
        body.put("mobile_number", ConfigReader.get("mobile"));

        TestContext.setEmail(email);
        TestContext.setPassword(ConfigReader.get("password"));

        return body;
    }
}