package com.restful.booker.crudtest;

import com.restful.booker.model.CustomerPojo;
import com.restful.booker.utils.TestUtils;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class BookingPostTest {

    @BeforeClass
    public static void inIt(){
        RestAssured.baseURI= "https://restful-booker.herokuapp.com";
        RestAssured.basePath = "/booking";

    }

    //create booking
    @Test
    public void createBooking(){
        CustomerPojo customerPojo = new CustomerPojo();

        String email = "piyusha" + TestUtils.getRandomValue() + "gajera@gmail.com";

        HashMap<Object,Object> bookingDates = new HashMap<>();
        bookingDates.put("check in", 2024 - 01 -01);
        bookingDates.put("checkout", 2025 - 01 -01);

        customerPojo.setFirstName("Piyusha001");
        customerPojo.setLastName("Gajera");
        customerPojo.setEmail(email);
        customerPojo.setTotalprice(121);
        customerPojo.setDepositpaid(true);
        customerPojo.setBookingdates(bookingDates);
        customerPojo.setAdditionalneeds("Breakfast");

        Response response = given()
                .header("Content-Type","application/json")
                .header("Cookie","token=caeca772a95cc06")
                .header("Accept", "application/json")
                .body(customerPojo)
                .post();
        response.then().statusCode(201);
        response.prettyPrint();
    }
}
