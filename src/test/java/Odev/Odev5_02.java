package Odev;

import base_urls.RegresInApiBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class Odev5_02 extends RegresInApiBaseUrl {


    @Test
    public void odv(){
        spec.pathParam("first","3");

        Map<String, Map<String,Object>> expectedData=new HashMap<>();

        expectedData.put("data",Map.of("id",3.0,"name","true red","year",2002.0,"color","#BF1932","pantone_value","19-1664"));
        expectedData.put("support",Map.of("url","https://reqres.in/#support-heading","text","To keep ReqRes free, contributions towards server costs are appreciated!"));

        System.out.println(expectedData);
        Response response=given().when().spec(spec).contentType(ContentType.JSON).get("/{first}");
        response.prettyPrint();

        response.then().statusCode(200).contentType("application/json; charset=utf-8");

        SoftAssert softAssert=new SoftAssert();

        Map<String,Map<String,Object>> actualData=response.as(HashMap.class);

        System.out.println(actualData);

        softAssert.assertEquals(expectedData.get("data"),actualData.get("data"));
        softAssert.assertEquals(expectedData.get("support"),actualData.get("support"));

        softAssert.assertAll();





    }
}

