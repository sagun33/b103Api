package Odev;

import base_urls.RegresInApiBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Odev7 extends RegresInApiBaseUrl {
    //2)

  /*
        Given
            1) https://reqres.in/api/users
            2) {
                "name": "morpheus",
                "job": "leader"
                }
        When
            I send POST Request to the Url
        Then
            Status code is 201
            And response body should be like {
                                                "name": "morpheus",
                                                "job": "leader",
                                                "id": "496",
                                                "createdAt": "2022-10-04T15:18:56.372Z"
                                              }
     */
    
    @Test
    public void odev7(){
        
        
        //set the url
        spec.pathParam("first","users");
        
        //get the expected data
        Map<String,Object>expectedData=new HashMap<>();
        expectedData.put("name","morpheus");
        expectedData.put("job", "leader");
        System.out.println("expectedData = " + expectedData);

        //send the request and get the response
        Response response=given().spec(spec).body(expectedData).post("/{first}");
        response.prettyPrint();

        //do assertion
        Map<String,Object>actualData=response.as(HashMap.class);
        System.out.println("actualData = " + actualData);

        assertEquals(200,response.statusCode());
        assertEquals(expectedData.get("name"),actualData.get("name"));
        assertEquals(expectedData.get("job"),actualData.get("job"));


        
        
    }



}
