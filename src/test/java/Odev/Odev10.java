package Odev;

import base_urls.PetsoreBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static junit.framework.TestCase.assertTrue;

public class Odev10 extends PetsoreBaseUrl {

    /*
    //1) https://petstore.swagger.io/ dokumanını kullanarak statüsü "available" olan "pet" sayısını bulup 100'den fazla olduğunu assert eden bir otomasyon testi yazınız.

 /*
    Given
        https://petstore.swagger.io/v2/pet/findByStatus?status=available
    When
        User sens Get request
    Then
        Assert that number of pets whose status is "available" is more than 100
     */
    @Test
    public void petStoreAvailablePets() {
        spec.pathParams("first", "pet", "second", "findByStatus").
                queryParam("status", "available");

        Response response = given(spec).get("{first}/{second}");
        response.prettyPrint();
        JsonPath jsonPath=response.jsonPath();
        int availablePetSayisi = response.jsonPath().getList("id").size();
        assertTrue(availablePetSayisi > 100);

    }
}