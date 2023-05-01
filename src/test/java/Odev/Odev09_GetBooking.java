package Odev;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.BookingDatesPojo;
import pojos.BookingPojo;
import pojos.BookingResponsePojo;
import util.ObjectMapperUtils;

import static io.restassured.RestAssured.given;
import static junit.framework.TestCase.assertEquals;

public class Odev09_GetBooking extends HerOkuAppBaseUrl {
    /*

 Given
 1.Set the url: https://restful-booker.herokuapp.com/booking/1 \
 2.Set the expected data: HTTP Request Method: PUT Request {
    "firstname" : "James",
    "lastname" : "Brown",
    "totalprice" : 111,
    "depositpaid" : true,
    "bookingdates" : {
        "checkin" : "2018-01-01",
        "checkout" : "2019-01-01"
    },
    "additionalneeds" : "Breakfast"
}'
When
 3.Send the request and get the response
  I send PUT Request to the Url
 Test Case: Type by using Gherkin Language

  4. Do Assert:
    Then            i) Status code is 200
    And           ii) Response body should be like the following
{
    "firstname" : "James",
    "lastname" : "Brown",
    "totalprice" : 111,
    "depositpaid" : true,
    "bookingdates" : {
        "checkin" : "2018-01-01",
        "checkout" : "2019-01-01"
    },
    "additionalneeds" : "Breakfast"
}

     */

    @Test
    public void odevPut909(){
        //1.set the url
        spec.pathParams("first","booking","second",1);
        //2.Set the expected data
        BookingDatesPojo bookingData=new BookingDatesPojo("2018-01-01","2019-01-01");
        BookingPojo expectedData=new BookingPojo("James","Brown",111,true,bookingData,"Breakfast");

        System.out.println("expectedData = " + expectedData);
        //3.Send the request and get the response
        Response response=given().spec(spec).when().body(expectedData).put("/{first}/{second}");
        response.prettyPrint();

        //4.Do Assert
       BookingResponsePojo actualData= ObjectMapperUtils.convertJsonToJava(response.asString(), BookingResponsePojo.class);
       assertEquals(200,response.statusCode());
        assertEquals(expectedData.getFirstname(),actualData.getBooking().getFirstname());
        assertEquals(expectedData.getLastname(),actualData.getBooking().getLastname());
        assertEquals( expectedData.getTotalprice(),actualData.getBooking().getTotalprice());
        assertEquals(expectedData.getDepositpaid(),actualData.getBooking().getDepositpaid());
        assertEquals(expectedData.getBookingdates().getCheckin(),actualData.getBooking().getBookingdates().getCheckin());
        assertEquals(expectedData.getBookingdates().getCheckout(),actualData.getBooking().getBookingdates().getCheckout());
        assertEquals(expectedData.getAdditionalneeds(),actualData.getBooking().getAdditionalneeds());

    }
}
