package Odev;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.*;


import static io.restassured.RestAssured.*;
import static junit.framework.TestCase.*;

public class odev4 extends HerOkuAppBaseUrl {


    /*
        Given
            https://restful-booker.herokuapp.com/booking?firstname=Almedin&lastname=Alikadic
        When
            User sends get request to the URL
        Then
            Status code is 200
	  	And
	  		Among the data there should be someone whose firstname is "Almedin" and lastname is "Alikadic"

     */


@Test
    public void odev4(){
    spec.
            pathParam("first","booking").
            queryParams("firstname","Almedin",
                    "lastname","Alikadic");

   Response response= given().spec(spec).when().get("/{first}");
   response.prettyPrint();

   response.then().statusCode(200);
    assertTrue(response.asString().contains("bookingid"));


}


}
