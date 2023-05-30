package com.restful.booker.crudtest;

import com.restful.booker.model.LoginPojo;
import com.restful.booker.testbase.TestBase;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class AuthCreateToken extends TestBase {


    //generating token
    @Test
    public void createToken(){
        LoginPojo loginPojo = new LoginPojo();
        loginPojo.setUsername("admin");
        loginPojo.setPassword("password123");
        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .body(loginPojo)
                .post("/auth");
        response.then().statusCode(200);
        response.then().extract().path("token");
        response.prettyPrint();

    }
}
