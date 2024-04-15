package tests;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C01_GetRequestResponseBodyYazdirma {
    @Test
    public void get01(){
        //https://restful-booker.herokuapp.com/booking/10
        //bir get request gönder ve dönen responseu yazdır
        //1- request body ve endpoint hazırlama
        String url ="https://restful-booker.herokuapp.com/booking/10";
        //2- expected data hazırlama
        //3- request gönderip dönen responseu kaydetme
        Response response = given().when().get(url);
        response.prettyPrint(); // response body'sini yazdırma
        //4- assertion işlemi
    }
}
