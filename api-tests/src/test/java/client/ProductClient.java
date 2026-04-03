package client;

import io.restassured.response.Response;
import utils.ConfigReader;

import static io.restassured.RestAssured.*;

import java.util.Map;

public class ProductClient {

    public Response getAllProducts() {

        String baseUrl = ConfigReader.get("api_base_url");

        return given()
                .baseUri(baseUrl)
                .when()
                .get("/api/productsList")
                .then()
                .extract()
                .response();
    }

    public Response searchProduct(Map<String, String> body) {

        String baseUrl = ConfigReader.get("api_base_url");

        return given()
                .baseUri(baseUrl)
                .formParams(body)
                .when()
                .post("/api/searchProduct")
                .then()
                .extract()
                .response();
    }

    public Response createUser(Map<String, String> body) {

        String baseUrl = ConfigReader.get("api_base_url");

        return given()
                .baseUri(baseUrl)
                .formParams(body)
                .when()
                .post("/api/createAccount")
                .then()
                .extract()
                .response();
    }

    public Response deleteUser(String email, String password) {

        String baseUrl = ConfigReader.get("api_base_url");

        return given()
                .baseUri(baseUrl)
                .formParam("email", email)
                .formParam("password", password)
                .when()
                .delete("/api/deleteAccount")
                .then()
                .extract()
                .response();
    }

    public Response updateUser(Map<String, String> body) {

        String baseUrl = ConfigReader.get("api_base_url");

        return given()
                .baseUri(baseUrl)
                .formParams(body)
                .when()
                .put("/api/updateAccount")
                .then()
                .extract()
                .response();
    }

    public Response loginUser(String email, String password) {

        String baseUrl = ConfigReader.get("api_base_url");

        return given()
                .baseUri(baseUrl)
                .formParam("email", email)
                .formParam("password", password)
                .when()
                .post("/api/verifyLogin")
                .then()
                .extract()
                .response();
    }
}