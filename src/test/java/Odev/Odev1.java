package get_requests;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.parsing.Parser.JSON;

public class Odev1 extends JsonPlaceHolderBaseUrl {
    /*
        Given
            https://reqres.in/api/users/3
        When
            User sends a GET Request to the url
        Then
            HTTP Status Code should be 200
        And
            Content Type should be JSON
        And
            Status Line should be HTTP/1.1 200 OK
     */
//spec.pathParams("first", "todos", "second", "23");  id kismini bu sekilde ekliyoruz
@Test
    public void odev1(){
    spec.pathParam("first", "3");
    Response response = given().when().spec(spec).get("/{first}");
    response.prettyPrint();

    response.
            then().
            statusCode(200).
            contentType(ContentType.JSON).
            statusLine("HTTP/1.1 200 OK");



}



}
