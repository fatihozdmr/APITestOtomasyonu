package tests;

import io.restassured.response.Response;
import org.junit.Test;

import java.lang.module.ResolutionException;

import static io.restassured.RestAssured.given;

public class C03_Get_ResponseDegerleriniOtomasyonIleTestEtme {
    /*https://restful-booker.herokuapp.com/booking/10 url’ine bir GET request
    gonderdigimizde donen Response’un,
    status code’unun 200,
    ve content type’inin application/json; charset=utf-8,
    ve Server isimli Header’in degerinin Cowboy,
    ve status Line’in HTTP/1.1 200 OK
    Test edin*/
    @Test
    public void test02(){
        //1- endpoint ve request body olustur
        String url = "https://restful-booker.herokuapp.com/booking/10";
        //2- expected body olustur
        //3- request gonderip donen responseu kaydet
        Response response = given().when().get(url);
        //4- Assertion
        response
                .then()
                .assertThat().statusCode(200)
                .contentType("application/json; charset=utf-8")
                .header("Server", "Cowboy")
                .statusLine("HTTP/1.1 200 OK");
    }
}
