package org.example;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.Properties;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.proxy;
import static org.example.verifyBody.requestBodyJson;
import static org.example.verifyBody.setHeader;
import static org.hamcrest.Matchers.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.example.verifyBody.requestBodyJson;
/**
 * Unit test for simple App.
 */
public class AppTest {
    @Test
    public void getToken(String username, String password) {
        RestAssured.baseURI = "https://kiosk-qms-api-test.epayservices.com.vn";
        RequestSpecification httpReq = given().log().all()
                .contentType(ContentType.JSON)
                .headers(setHeader())
                .when()
                .body(requestBodyJson(username, password).toString());

        Response response = httpReq.when().post("/api/ext/v1/auth/login");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
        response.then().assertThat().body(matchesJsonSchemaInClasspath("responseSucess.json"));
        response.then().contentType("application/json");
        response.then().body("accessToken", equalTo("data.accessToken"));
        response.then().body("accessTokenExpiration", equalTo("data.accessTokenExpiration"));
        response.then().body("refreshToken", equalTo("data.refreshToken"));
        response.then().body("refreshTokenExpiration", equalTo("data.refreshTokenExpiration"));
        response.then().body("isSuccess", equalTo("isSuccess"));
        response.then().body("isFailure", equalTo("isFailure"));
        response.then().body("code", equalTo("error.code"));
        response.then().body("message", equalTo("error.message"));
//        String accessToken = response.jsonPath().getString("data.accessToken");
//        System.out.println("Access Token: " + accessToken);
    }
}


