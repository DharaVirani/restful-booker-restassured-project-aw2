package com.restful.booker.crudtest;

import com.restful.booker.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class BookingDeleteTest extends TestBase {



    static String token = "token=caeca772a95cc06";

    @Test
    public void deleteUser(){
        Response response= given()
                 .header("Content-Type", "application-json")
                 .header("Cookie",token)
                 .when()
                .delete("booking/143");
        response.then().statusCode(201);
        response.prettyPrint();


    }
}
