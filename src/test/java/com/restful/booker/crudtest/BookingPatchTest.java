package com.restful.booker.crudtest;

import com.restful.booker.model.CustomerPojo;
import com.restful.booker.utils.TestUtils;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class BookingPatchTest {

    @BeforeClass
    public static void inIt(){
        RestAssured.baseURI= "https://restful-booker.herokuapp.com";
        RestAssured.basePath = "/booking";

    }

    @Test
    public void createBooking() {
        CustomerPojo customerPojo = new CustomerPojo();


        HashMap<Object, Object> bookingDates = new HashMap<>();
        bookingDates.put("check in", 2024 - 01 - 01);
        bookingDates.put("checkout", 2025 - 01 - 01);

        customerPojo.setFirstName("Ajira" + TestUtils.getRandomValue());
        customerPojo.setLastName("Gajera");
        customerPojo.setTotalprice(121);
        customerPojo.setDepositpaid(true);
        customerPojo.setBookingdates(bookingDates);
        customerPojo.setAdditionalneeds("Breakfast");

        Response response = given()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .header("Cookie", "token=caeca772a95cc06")
                .body(customerPojo)
                .when()
                .patch("/" + 677);
        response.then().statusCode(200);
        response.prettyPrint();
    }
}
