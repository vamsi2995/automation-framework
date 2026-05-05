package client;

import io.restassured.specification.RequestSpecification;
import utils.ConfigReader;

import static io.restassured.RestAssured.*;

public class BaseClient {

    protected RequestSpecification request() {
        return given()
                .baseUri(ConfigReader.get("api_base_url"))
                .contentType("application/x-www-form-urlencoded")
                .log().all(); // optional but great for debugging
    }
}