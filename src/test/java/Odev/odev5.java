package Odev;

import base_urls.RegresInApiBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import java.util.jar.JarEntry;

import static io.restassured.RestAssured.given;

public class odev5 extends RegresInApiBaseUrl {
     /*
        Given
          https://reqres.in/api/unknown/3
        When
            User send a GET request to the URL
        Then
            HTTP Status Code should be 200
        And
            Response content type is “application/json; charset=utf-8”
        And
            Response body should be like;(Soft Assertion)
        {
        "data": {
            "id": 3,
            "name": "true red",
            "year": 2002,
            "color": "#BF1932",
            "pantone_value": "19-1664"
        },
        "support": {
            "url": "https://reqres.in/#support-heading",
            "text": "To keep ReqRes free, contributions towards server costs are appreciated!"
        }
}
      */

    @Test
    public void odev5() {

        //set the url

        spec.pathParams("first", "unknow", "second", 3);

        //Send the request and get the response
        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();


        //Do Assertion
        response.
                then().
                statusCode(200).contentType("application/json; charset=utf-8");

        JsonPath jsonPath = response.jsonPath();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(jsonPath.getInt("data.id"), 3, "id uyusmadi");
        softAssert.assertEquals(jsonPath.getString("data.name"), "true red", "name uyusmadi");
        softAssert.assertEquals(jsonPath.getInt("data.year"), 2002, "year uyusmadi");
        softAssert.assertEquals(jsonPath.getString("data.color"), "#BF1932", "color uyusmadi");
        softAssert.assertEquals(jsonPath.getString("pantone_value"), "19-1664", "pantone_value uyusmadi");
        softAssert.assertEquals(jsonPath.getString("support.url"), "https://reqres.in/#support-heading");
        softAssert.assertEquals(jsonPath.getString("support.text"), "To keep ReqRes free, contributions towards server costs are appreciated!", "text uyusmadi");
        softAssert.assertAll();
    }
}

