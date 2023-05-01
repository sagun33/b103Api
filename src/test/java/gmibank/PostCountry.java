package gmibank;

import base_urls.GmiBankBaseUrl;
import gmibank.pojos.Country;
import gmibank.pojos.States;
import io.restassured.response.Response;
import org.junit.Test;
import util.ObjectMapperUtils;

import javax.swing.plaf.nimbus.State;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static junit.framework.TestCase.assertEquals;

public class PostCountry extends GmiBankBaseUrl {
    //https://app.swaggerhub.com/apis/yasinaniltechpro/GmiBank/0.0.1 dokümanını kullanarak
    // en az 3 "state" içeren bir "country" oluşturan bir otomasyon testi yazınız.
    /*
    Given
        https://gmibank.com/api/tp-countries
    And
        {
          "name": "Banana Republic",
          "states": [
            {
              "id": 1,
              "name": "Apple"
            },
            {
              "id": 2,
              "name": "Orange"
            },
            {
              "id": 3,
              "name": "Pear"
            }
          ]
         }
    When
        User send Post request
    Then
        Status code should be 201
    And
        Body should be
        {
            "id": 176677,
            "name": "Banana Republic",
            "states": [
                {
                    "id": 1,
                    "name": "Apple",
                    "tpcountry": null
                },
                {
                    "id": 2,
                    "name": "Orange",
                    "tpcountry": null
                },
                {
                    "id": 3,
                    "name": "Pear",
                    "tpcountry": null
                }
            ]
        }
     */

    @Test
    public void postCountry() {
        //Set the url
        spec.pathParams("first", "api", "second", "tp-countries");

        //Set the expected data
        States state1 = new States(1, "Apple", null);
        States state2 = new States(2, "Orange", null);
        States state3 = new States(3, "Pear", null);

        List<States> statesList = new ArrayList<>();
        statesList.add(state1);
        statesList.add(state2);
        statesList.add(state3);

        Country expectedData = new Country("Banana Republic",statesList);
        System.out.println("expectedData = " + expectedData);

        //Send the request and get the response
        Response response = given(spec).body(expectedData).post("{first}/{second}");
        response.prettyPrint();

        //Do assertion
        Country actualData=ObjectMapperUtils.convertJsonToJava(response.asString(),Country.class);
        assertEquals(expectedData.getName(),actualData.getName());
        assertEquals(state1.getId(),actualData.getStates().get(0).getId());
        assertEquals(state1.getName(),actualData.getStates().get(0).getName());
        assertEquals(state1.getTpcountry(),actualData.getStates().get(0).getTpcountry());
        assertEquals(state2.getId(),actualData.getStates().get(1).getId());
        assertEquals(state2.getName(),actualData.getStates().get(1).getName());
        assertEquals(state2.getTpcountry(),actualData.getStates().get(1).getTpcountry());
        assertEquals(state3.getId(),actualData.getStates().get(2).getId());
        assertEquals(state3.getName(),actualData.getStates().get(2).getName());
        assertEquals(state3.getTpcountry(),actualData.getStates().get(2).getTpcountry());


    }
}