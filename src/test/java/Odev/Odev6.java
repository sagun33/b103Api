package Odev;

import base_urls.RegresInApiBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class Odev6 extends RegresInApiBaseUrl {//1)

  /*
       Given
              https://reqres.in/api/unknown/
       When
            I send GET Request to the URL
       Then

            1)Status code is 200
            2)Print all pantone_values
              (Tüm pantone_value değerlerini yazdırınız)
            3)Print all ids greater than 3 on the console
              (3'ten büyük id'leri yazdırınız)
              Assert that there are 3 ids greater than 3
              (3'ten büyük 3 adet id olduğunu doğrulayınız)
            4)Print all names whose ids are less than 3 on the console
              (id'si 3'ten küçük isimleri yazdırınız)
              Assert that the number of names whose ids are less than 3 is 2
              (id'si 3'ten küçük 2 isim olduğunu doğrulayınız)
    */

    //1.yol Grovy Language ile
//    @Test
//    public void odev6(){
//
//        //set the url
//        spec.pathParam("first","unknown");
//
//        //set the expected data
//
//
//        //send the request and get the response
//        Response response=given().spec(spec).when().get("/{first}");
//        response.prettyPrint();
//
//        //do assertion
//        // 1)Status code is 200
//        Assert.assertEquals(200,response.statusCode());
//
//        // 2)Print all pantone_values
//        // (Tüm pantone_value değerlerini yazdırınız)
//        JsonPath jsonPath=response.jsonPath();
//        List<String> pantone_valueList= jsonPath.getList("data.findAll{it.id<7}.pantone_value");
//        System.out.println("pantone_valueList = " + pantone_valueList);
//
//        //Print all ids greater than 3 on the console
//        // (3'ten büyük id'leri yazdırınız)
//
//        List<Integer>idList=jsonPath.getList("data.findAll{it.id>3}.id");
//        System.out.println("idList = " + idList);
//
//        // Assert that there are 3 ids greater than 3
//        //              (3'ten büyük 3 adet id olduğunu doğrulayınız)
//        Assert.assertEquals(3, idList.size());
//
//        //Print all names whose ids are less than 3 on the console
//        //              (id'si 3'ten küçük isimleri yazdırınız)
//
//        List<String>nameList=jsonPath.getList("data.findAll{it.id<3}.name");
//        System.out.println("nameList = " + nameList);
//
//        Assert.assertEquals(2,nameList.size());
//
//
//2.yol jsonPath ole


    //    }
    @Test
    public void odev6b() {

        //set the url
        spec.pathParam("first", "unknown");

        //set the expected data


        //send the request and get the response
        Response response = given().spec(spec).when().get("/{first}");
        response.prettyPrint();


        //do assertion

        // 1)Status code is 200
        Assert.assertEquals(200, response.statusCode());


        //Print all pantone_values

        JsonPath jsonPath = response.jsonPath();
        List<String> pantone_valueList = jsonPath.getList("data.pantone_value ");
        System.out.println("pantone_valueList = " + pantone_valueList);


        //3)Print all ids greater than 3 on the console


        List<Integer> idList = jsonPath.getList("data.id");
        int count = 0;
        for (Integer w : idList) {
            if (w > 3) {
                count++;

            }

        }
        //Assert that there are 3 ids greater than 3

        Assert.assertEquals(3, count);


        //            Print all names whose ids are less than 3 on the console
        //              (id'si 3'ten küçük isimleri yazdırınız)

        List<String>nameList=jsonPath.getList("data.findAll{it.id<3}.name");
        System.out.println("nameList = " + nameList);

        Assert.assertEquals(2, nameList.size());
      
        
        
        //              Assert that the number of names whose ids are less than 3 is 2
        //              (id'si 3'ten küçük 2 isim olduğunu doğrulayınız)


    }
}
