package get_requests;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Odev2 extends JsonPlaceHolderBaseUrl {
    /*
       Given
           https://reqres.in/api/users/23
       When
           User send a GET Request to the url
       Then
           HTTP Status code should be 404
       And
           Status Line should be HTTP/1.1 404 Not Found
       And
           Server is "cloudflare"
       And
           Response body should be empty
    */
    @Test
    public void odev2() {
        spec.pathParam("first", "22");
        Response response = given().when().spec(spec).get("/{first}");
        response.prettyPrint();

        response.
                then().
                statusCode(404).
                statusLine("HTTP/1.1 404 Not Found").
                header("server","cloudflare");
        response.body().prettyPrint().isEmpty();




    }
}
