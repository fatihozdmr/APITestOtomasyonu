package testData;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class TestDataHerokuapp {

    public static JSONObject jsonRequestBodyOlustur(){
        JSONObject requestBody = new JSONObject();
        JSONObject bookingdatesBody = new JSONObject();

        bookingdatesBody.put("checkin","2021-06-01");
        bookingdatesBody.put("checkout","2021-06-10");

        requestBody.put("firstname","Ahmet");
        requestBody.put("lastname","Bulut");
        requestBody.put("totalprice",500);
        requestBody.put("depositpaid",false);
        requestBody.put("bookingdates",bookingdatesBody);
        requestBody.put("additionalneeds","wi-fi");

        return requestBody;
    }

    public static JSONObject jsonResponseBodyOlustur(){
        JSONObject responseBody = new JSONObject();
        JSONObject bookingBody = jsonRequestBodyOlustur();

        responseBody.put("bookingid",24);
        responseBody.put("booking",bookingBody);
        return responseBody;
    }

    /*  ------------> Request Bodu
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
     */
    public static Map<String, Object> mapRequestBodyOlustur(){
        Map<String,Object> requestBodyMap = new HashMap<>();
        requestBodyMap.put("firstname","Ahmet");
        requestBodyMap.put("lastname","Bulut");
        requestBodyMap.put("totalprice",500.0);
        requestBodyMap.put("depositpaid",false);
        requestBodyMap.put("bookingdates",mapBookingdatesOlustur());
        requestBodyMap.put("additionalneeds","wi-fi");
        return requestBodyMap;
    }
    public static Map<String, String> mapBookingdatesOlustur(){
        Map<String,String> bookingdatesMap = new HashMap<>();
        bookingdatesMap.put("chekin","2021-06-01");
        bookingdatesMap.put("chekout","2021-06-10");
        return bookingdatesMap;
    }
    /* ---------> Expected Body // Response Body
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
                            ,
                            "additionalneeds":"wi-fi"
                        }
     */
    public static Map<String,Object> responseBodyMapOlustur(){
        Map<String,Object> responseBodyMap = new HashMap<>();

        responseBodyMap.put("bookingid",24.0);
        responseBodyMap.put("booking",mapRequestBodyOlustur());
        return responseBodyMap;
    }
}
