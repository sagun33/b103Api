package Odev;

import base_urls.AutomationExerciseBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static junit.framework.TestCase.assertEquals;

public class Odev11 extends AutomationExerciseBaseUrl {
    /*2)
	Given
		https://automationexercise.com/api/productsList
	When
		User sends Get request
	Then
		Assert that number of "Women" usertype is 12
		(Kadın usertype sayısının 12 olduğunu doğrulayın)

*/
    @Test
    public void automationExerciseTest(){
        spec.pathParam("first","productsList");
        Response response = given(spec).get("{first}");
        response.jsonPath().prettyPrint();
        JsonPath jsonPath = response.jsonPath();
        //Assert that number of "Women" usertype is 12 -->Kadın usertype sayısının 12 olduğunu doğrulayın
        int kadinUserTypeSayisi = jsonPath.getList("products.findAll{it.category.usertype.usertype=='Women'}").size();
        assertEquals(12,kadinUserTypeSayisi);
    }
}
