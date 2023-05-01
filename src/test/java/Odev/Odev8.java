package Odev;

import base_urls.PetsoreBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.commons.codec.language.MatchRatingApproachEncoder;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static junit.framework.TestCase.assertEquals;

public class Odev8 extends PetsoreBaseUrl {
    //3)

/*
   "https://petstore.swagger.io/" dökümanını kullanarak 'user' oluşturacak bir otomasyon testi yazınız
    Not: Test Case'i gherkin language ile yazınız.


*/
/*
         Given
           1) https://petstore.swagger.io/v2/user/123
           2)  [
  {

    "username": "Mut33",
    "firstName": "Salih",
    "lastName": "Akar",
    "email": "sakar@gmail.com",
    "password": "skr33",
    "phone": "05332342131",
    "userStatus": 0
  }
]
        When
         I send POST Request to the Url
        Then
            Status code is 201
        And
            response body is like {
  "code": 200,
  "type": "unknown",
  "message": "ok"
}
     */

    /*
        Given
            https://petstore.swagger.io/v2/user/123
        When
            User sends a GET Request to the url
        Then
            HTTP Status Code should be 200
        And
            Content Type should be JSON
        And
            Status Line should be HTTP/1.1 200 OK
     */

    /*
        Given
           1) https://jsonplaceholder.typicode.com/todos/198
           2)  [
  {
    "username": "Mutlu33",
    "firstName": "Saliha",
    "lastName": "Bakar",
    "email": "sakar@gmail.com",
    "password": "sbkr33",
    "phone": "05332342132",
    "userStatus": 0
  }
]
        When
         I send PUT Request to the Url
       Then
             Status code is 200
             And response body is like   {
                               "userId": 21,
                               "title": "Wash the dishes",
                               "completed": false
                               "id": 198
                              }
     */

    @Test
    public void post01() {
        spec.pathParam("first", "user");
        Map<String, Object> expectedData = new HashMap<>();//Pojo class ile de payload oluşturabilirsiniz
        expectedData.put("username", "JohnDoe");
        expectedData.put("firstName", "John");
        expectedData.put("lastName", "Doe");
        expectedData.put("email", "john@doe.com");
        expectedData.put("password", "1234");
        expectedData.put("phone", "1234");
        expectedData.put("userStatus", 123);

        Response response = given().spec(spec).contentType(ContentType.JSON).body(expectedData).when().post("/{first}");
        response.prettyPrint();

        Map<String ,Object> actualData =response.as(HashMap.class);
        assertEquals(200,response.statusCode());
        assertEquals(200,actualData.get("code"));
        assertEquals("unknown",actualData.get("type"));
    }
}
