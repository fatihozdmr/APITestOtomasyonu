package tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class C09_Get_TestYaparkenTekrarlardanKurtulma {
    /*
    https://restful-booker.herokuapp.com/booking/10 url’ine
     bir GET request gonderdigimizde
donen Response’un,
status code’unun 200,
ve content type’inin application-json,
ve response body’sindeki
"firstname“in, "Susan",
ve "lastname“in, "Jackson",
ve "totalprice“in, 1000'den kucuk oldugunu,
ve "depositpaid“in, false,
ve "additionalneeds“in, bos birakilmadigini
oldugunu test edin
     */
    @Test
    public void test01(){
        //1- endpoint ve request body hazırlamak
        String url ="https://restful-booker.herokuapp.com/booking/10";
        //2- expected data olustur
        //3- request gonderip donen responseu kaydetmek
        Response response = given().when().get(url);
                //4- Assertion
        response.prettyPrint();
        /* ikinci yontem ile yaptigimizda bu testimizdeki
        yazilanlar degismesin diye yoruma alındı

        response
                .then()
                .assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("firstname", Matchers.equalTo("Mark"))
                .body("lastname",Matchers.equalTo("Ericsson"))
                .body("totalprice",Matchers.lessThan(1000))
                .body("depositpaid",Matchers.equalTo(true))
                .body("additionalneeds",Matchers.notNullValue());
        */
        response
                .then()
                .assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("firstname", equalTo("Mary"),
                        "lastname", equalTo("Jones"),
                        "totalprice",lessThan(1000),
                        "depositpaid",equalTo(true),
                        "additionalneeds",notNullValue());
    }
}
