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

public class Odev9_PostBooking extends HerOkuAppBaseUrl {

    /*
   "https://restful-booker.herokuapp.com/apidoc/index.html" dökümanını kullanarak;
    Bir booking oluşturan, o booking'i güncelleyen ve sonra silen ve bu adımları doğrulayan positif ve negatif testler içeren bir otomasyon testi yazınız.
Given
   1. set the url: https://restful-booker.herokuapp.com/booking



   2.Set the expected data
  {
    "firstname" : "Jim",
    "lastname" : "Brown",
    "totalprice" : 111,
    "depositpaid" : true,
    "bookingdates" : {
        "checkin" : "2018-01-01",
        "checkout" : "2019-01-01"
    },
    "additionalneeds" : "Breakfast"
}
When
 3. send the requeat and get the response
 I send POST Request to the Url
    Test Case: Type by using Gherkin Language
 4.Do Assert
    Then
    HTTP/1.1 200 OK
    And

{
    "bookingid": 14136,
    "booking": {
        "firstname": "Jim",
        "lastname": "Brown",
        "totalprice": 111,
        "depositpaid": true,
        "bookingdates": {
            "checkin": "2018-01-01",
            "checkout": "2019-01-01"
        },
        "additionalneeds": "Breakfast"
    }
}
    */
    
    @Test
    public void odev9_PostBooking(){
        
        //set the url
        
        spec.pathParam("first","booking");
        
        //set the expected data

        BookingDatesPojo bookingDatesPojo=new BookingDatesPojo("2018-01-01","2019-01-01");
        BookingPojo expectedData=new BookingPojo("Jim","Brown",111,true,bookingDatesPojo,"Breakfast");
        System.out.println("expectedData = " + expectedData);
        
        //send the request and get the response
        Response response=given().spec(spec).when().body(expectedData).post("/{first}");
        response.prettyPrint();
        
        //do assertion

        BookingResponsePojo actualData=ObjectMapperUtils.convertJsonToJava(response.asString(), BookingResponsePojo.class);
        System.out.println("actualData = " + actualData);

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
