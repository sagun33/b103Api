package Alistirmalarim;

import base_urls.ApiZipopotamBaseUrl;

import io.restassured.response.Response;
import org.junit.Test;
import pojos.ApiZipopotamPlacesPojo;
import pojos.ApiZipopotamPojo;

import static io.restassured.RestAssured.given;


public class CanHocaSoru2 extends ApiZipopotamBaseUrl {


    /*     Given
       set the url     http://api.zippopotam.us/ES/01001
       When
            Kullanıcı GET Methodu ile Request Gönder
        Then
             Status Code un "200" olduğunu Assert et
        And
            Response body nin bu şekilde olduğunu doğrula
            {
    "post code": "01001",
    "country": "Spain",
    "country abbreviation": "ES",
    "places": [
        {
            "place name": "Vitoria-Gasteiz",
            "longitude": "-2.6667",
            "state": "Pais Vasco",
            "state abbreviation": "PV",
            "latitude": "42.85"
        }
    ]
}
     */
    
    @Test
    public void canHocaSoru2(){
        //1.set the url
        spec.pathParams("first","ES","second","01001");
        //2.Set the expected data
        ApiZipopotamPlacesPojo placesData=new ApiZipopotamPlacesPojo("Vitoria-Gasteiz","-2.6667","Pais Vasco","PV","42.85");
        ApiZipopotamPojo expectedData=new ApiZipopotamPojo("01001","Spain","ES",placesData);
        System.out.println("expectedData = " + expectedData);

        //3.Send the request and get the expected data
        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();
    }
}
