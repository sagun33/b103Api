package Odev;

public class Odev8 {
    //3)

/*
   "https://petstore.swagger.io/" dökümanını kullanarak 'user' oluşturacak bir otomasyon testi yazınız
    Not: Test Case'i gherkin language ile yazınız.


*/
/*
         Given
           1) https://petstore.swagger.io/v2/user/123
           2)  [
  {

    "username": "Mut33",
    "firstName": "Salih",
    "lastName": "Akar",
    "email": "sakar@gmail.com",
    "password": "skr33",
    "phone": "05332342131",
    "userStatus": 0
  }
]
        When
         I send POST Request to the Url
        Then
            Status code is 201
        And
            response body is like {
  "code": 200,
  "type": "unknown",
  "message": "ok"
}
     */

    /*
        Given
            https://petstore.swagger.io/v2/user/123
        When
            User sends a GET Request to the url
        Then
            HTTP Status Code should be 200
        And
            Content Type should be JSON
        And
            Status Line should be HTTP/1.1 200 OK
     */

    /*
        Given
           1) https://jsonplaceholder.typicode.com/todos/198
           2)  [
  {
    "username": "Mutlu33",
    "firstName": "Saliha",
    "lastName": "Bakar",
    "email": "sakar@gmail.com",
    "password": "sbkr33",
    "phone": "05332342132",
    "userStatus": 0
  }
]
        When
         I send PUT Request to the Url
       Then
             Status code is 200
             And response body is like   {
                               "userId": 21,
                               "title": "Wash the dishes",
                               "completed": false
                               "id": 198
                              }
     */


}
