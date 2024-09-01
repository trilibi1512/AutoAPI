package org.example;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.jupiter.api.BeforeAll;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.Properties;

import static io.restassured.RestAssured.given;

/**
 * Unit test for simple App.
 */
public class AppTest{

    @Test
    public void getToken() {
        RestAssured.baseURI = "https://kiosk-qms-api-test.epayservices.com.vn";
        RequestSpecification httpReq = given().log().body().contentType(ContentType.JSON)
                .header("User-Agent", "PostmanRuntime/7.41.2")
                .header("Accept-Encoding", "gzip, deflate, br")
                .header("Connection", "keep-alive")

                .body("{ \"username\": \"tuha\",\n" +
                        "  \"password\": \"tuha\",\n" +
                        "  \"userAgent\": \"1\"}");

        Response response = httpReq.when().post("/api/ext/v1/auth/login");
        response.then().assertThat().statusCode(200);
        String accessToken = response.jsonPath().getString("data.accessToken");
        System.out.println("Access Token: " + accessToken);

    }
}


