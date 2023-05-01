package Alistirmalarim;

import base_urls.RegresInApiBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.RegresInApiDataPojo;
import pojos.RegresInApiDisBodyPojo;
import pojos.RegresInApiSupportPojo;
import util.ObjectMapperUtils;

import static io.restassured.RestAssured.given;
import static junit.framework.TestCase.assertEquals;

public class Get01 extends RegresInApiBaseUrl {

    /*

     Given
          https://reqres.in/api/users/2
       When
           User send a GET request to the URL
       Then
           HTTP Status Code should be 200
       And
           Response content type is "application/json"
       And
           Response body should be like;
   {
    "data": {
        "id": 2,
        "email": "janet.weaver@reqres.in",
        "first_name": "Janet",
        "last_name": "Weaver",
        "avatar": "https://reqres.in/img/faces/2-image.jpg"
    },
    "support": {
        "url": "https://reqres.in/#support-heading",
        "text": "To keep ReqRes free, contributions towards server costs are appreciated!"
    }
}
     */

    @Test
    public void get01(){

        //set the url
        spec.pathParams("first","users","second",2);

        //set the expected data
        RegresInApiDataPojo expectedData=new RegresInApiDataPojo(2,"janet.weaver@reqres.in","Janet","Weaver","https://reqres.in/img/faces/2-image.jpg");
        RegresInApiSupportPojo expectedSupport=new RegresInApiSupportPojo("https://reqres.in/#support-heading","To keep ReqRes free, contributions towards server costs are appreciated!");
        RegresInApiDisBodyPojo expectedBodyPojo=new RegresInApiDisBodyPojo(expectedData,expectedSupport);
        System.out.println("expectedBodyPojo = " + expectedBodyPojo);

        //set the request and get the response
        Response response=given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        //do assertion
        RegresInApiDisBodyPojo actuelData=ObjectMapperUtils.convertJsonToJava(response.asString(),RegresInApiDisBodyPojo.class);
        System.out.println("actuelData = " + actuelData);

//        assertEquals(expectedBodyPojo.getData().getId(),actuelData.getData().getId());
//        assertEquals(expectedBodyPojo.getData().getEmail(),actuelData.getData().getEmail());
//        assertEquals(expectedBodyPojo.getData().getFirstName(),actuelData.getData().getFirstName());
//        assertEquals(expectedBodyPojo.getData().getLastName(),actuelData.getData().getLastName());
//        assertEquals(expectedBodyPojo.getData().getAvatar(),actuelData.getData().getAvatar());
//        assertEquals(expectedBodyPojo.getSupport().getUrl(),actuelData.getSupport().getUrl());
//        assertEquals(expectedBodyPojo.getSupport().getUrl(),actuelData.getSupport().getText();
//

    }
}
