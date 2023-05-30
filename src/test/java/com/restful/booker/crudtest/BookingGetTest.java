package com.restful.booker.crudtest;

import com.restful.booker.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class BookingGetTest extends TestBase {

    //get all booking ids
    @Test
    public void getAllBookingIds(){
        Response response = given()
                .when()
                .get("/booking");
        response.then().statusCode(200);
        response.prettyPrint();

    }

    //get single booking id
    @Test
    public void getSingleBookingId(){
        Response response = given()
                .when()
                .get("/booking/4860");
        response.then().statusCode(200);
        response.prettyPrint();
    }
}
