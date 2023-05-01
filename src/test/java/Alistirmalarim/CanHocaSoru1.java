package Alistirmalarim;

import base_urls.GoRestBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.GoRestPojo;
import pojos.GoRestRequest;
import pojos.GoRestResponsePojo;
import util.ObjectMapperUtils;

import static io.restassured.RestAssured.given;
import static junit.framework.TestCase.assertEquals;

public class CanHocaSoru1 extends GoRestBaseUrl {

    /*
        Given
           https://gorest.co.in/public/v2/posts/174
       When
            Kullanıcı GET Methodu ile Request Gönder
        Then
             Status Code un "200" olduğunu Assert et
        And
            Response body nin bu şekilde olduğunu doğrula
 {
    "id": 174,
    "user_id": 612,
    "title": "Tertius valeo sint est vesica doloribus rerum casus cetera nisi sapiente vigor pecus voluptas asperiores et sto vapulus.",
    "body": "Et demens tergo. Cohors copia adeptio. Cotidie speciosus coaegresco. Concido crastinus degero. Tristis fugit supellex. 
    Sustineo cogo odit. Pel patria crur. Amplus comitatus modi. Ater omnis solutio. Voluptatem acies unde. Taceo delinquo ustilo.
     Alo possimus vaco. Sit cognomen thesaurus. Appositus vel amicitia. Cetera textus defungo."
}
     */

@Test
    public void soru1(){

    //set the url
    spec.pathParams("first","posts","second",174);

    // set the expected data
    GoRestRequest expectedData=new GoRestRequest(174,612,"Tertius valeo sint est vesica doloribus rerum casus cetera " +
            "nisi sapiente vigor pecus voluptas asperiores et sto vapulus.","Et demens tergo. Cohors copia adeptio." +
            " Cotidie speciosus coaegresco. Concido crastinus degero. Tristis fugit supellex. Sustineo cogo odit. Pel patria crur." +
            " Amplus comitatus modi. Ater omnis solutio. Voluptatem acies unde. Taceo delinquo ustilo. " +
            "Alo possimus vaco. Sit cognomen thesaurus. Appositus vel amicitia. Cetera textus defungo.");

    System.out.println("expectedData = " + expectedData);
    
    //send the request and get the response
    Response response=given().spec(spec).when().get("/{first}/{second}");
    response.prettyPrint();

    GoRestResponsePojo actualData=ObjectMapperUtils.convertJsonToJava(response.asString(), GoRestResponsePojo.class);
    System.out.println("actualData = " + actualData);

    assertEquals(200,response.getStatusCode());

    assertEquals(expectedData.getId(),actualData.getData().getId());
    assertEquals(expectedData.getUser_id(),actualData.getData().getUser_id());
    assertEquals(expectedData.getTitle(),actualData.getData().getTitle());
    assertEquals(expectedData.getBody(),actualData.getData().getBody());



}
}
