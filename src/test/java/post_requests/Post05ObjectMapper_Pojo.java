package post_requests;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.JsonPlaceHolderPojo;
import util.ObjectMapperUtils;

import static io.restassured.RestAssured.given;

public class Post05ObjectMapper_Pojo extends JsonPlaceHolderBaseUrl {
     /*
         Given
           1) https://jsonplaceholder.typicode.com/todos
           2) {
                 "userId": 55,A
                 "title": "Tidy your room",
                 "completed": false
               }


            I send POST Request to the Url
        Then
            Status code is 201
        And
            response body is like  {
                                    "userId": 55,
                                    "title": "Tidy your room",
                                    "completed": false,
                                    "id": 201
                                    }
     */

    @Test
    public void post05() {
        //Set the URL
        spec.pathParam("first","todos");

        //Set the expected data
        JsonPlaceHolderPojo expectedData = new JsonPlaceHolderPojo(55,"Tidy your room",false);

        //Send the request and get the response
        Response response = given().spec(spec).when().body(expectedData).post("{first}");
        response.prettyPrint();

        //Do Assertion
        JsonPlaceHolderPojo actualData = ObjectMapperUtils.convertJsonToJava(response.asString(),JsonPlaceHolderPojo.class);
        System.out.println("actualData = " + actualData);


    }


}