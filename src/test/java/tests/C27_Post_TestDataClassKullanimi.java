package tests;

import baseUrl.BaseUrlHerokuapp;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import testData.TestDataHerokuapp;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C27_Post_TestDataClassKullanimi extends BaseUrlHerokuapp {
    @Test
    public void test01(){
        /*
                https://restful-booker.herokuapp.com/booking url’ine
                asagidaki body'ye sahip bir POST request gonderdigimizde
                donen response’un id haric asagidaki gibi oldugunu test edin.
                Request body
                       {
                        "firstname" : "Ahmet",
                        "lastname" : “Bulut",
                        "totalprice" : 500,
                        "depositpaid" : false,
                        "bookingdates" : {
                                "checkin" : "2021-06-01",
                                "checkout" : "2021-06-10"
                                },
                        "additionalneeds" : "wi-fi"
                        }
               Expected response body
                        {
                         "bookingid":24,
                         "booking":{
                            "firstname":"Ahmet",
                            "lastname":"Bulut",
                            "totalprice":500,
                            "depositpaid":false,
                            "bookingdates":{
                                    "checkin":"2021-06-01",
                                    "checkout":"2021-06-10"
                                            },
                            "additionalneeds":"wi-fi"
                                    }
                          }
         */

        // 1- endpoint ve request body olustur
        specHerokuapp.pathParam("pp1","booking");
        JSONObject requestBody = TestDataHerokuapp.jsonRequestBodyOlustur();

        // 2- Soruda varsa expected data olustur
        JSONObject expectedData = TestDataHerokuapp.jsonResponseBodyOlustur();
        System.out.println(expectedData);

        // 3- Request gonder donen response'i kaydet
        Response response = given().spec(specHerokuapp).contentType(ContentType.JSON)
                                .when().body(requestBody.toString())
                                .post("{pp1}");

        // Assertion
        JsonPath responseJsonPath = response.jsonPath();

        assertEquals(expectedData.getJSONObject("booking").getString("firstname")
                    ,responseJsonPath.getString("booking.firstname"));
        assertEquals(expectedData.getJSONObject("booking").getString("lastname")
                    ,responseJsonPath.getString("booking.lastname"));
        assertEquals(expectedData.getJSONObject("booking").getInt("totalprice")
                    ,responseJsonPath.getInt("booking.totalprice"));
        assertEquals(expectedData.getJSONObject("booking").getBoolean("depositpaid")
                    ,responseJsonPath.getBoolean("booking.depositpaid"));
        assertEquals(expectedData.getJSONObject("booking").getString("additionalneeds")
                    ,responseJsonPath.getString("booking.additionalneeds"));
        assertEquals(expectedData.getJSONObject("booking").getJSONObject("bookingdates").getString("checkin")
                    ,responseJsonPath.getString("booking.bookingdates.checkin"));
        assertEquals(expectedData.getJSONObject("booking").getJSONObject("bookingdates").getString("checkout")
                ,responseJsonPath.getString("booking.bookingdates.checkout"));
    }
}
