package tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C08_Post_ResponseBodyTesti {
    /*
    https://jsonplaceholder.typicode.com/posts url’ine asagidaki body ile bir POST request
gonderdigimizde
{
"title":"API",
"body":"API ogrenmek ne guzel",
"userId":10,
}
donen Response’un,
status code’unun 201,
ve content type’inin application/json
ve Response Body'sindeki,
"title"'in "API" oldugunu
"userId" degerinin 100'den kucuk oldugunu
"body" nin "API" kelimesi icerdigini
test edin.
     */
    @Test
    public void test01(){
        //1- endpoint ve request body hazirla
        String url = "https://jsonplaceholder.typicode.com/posts";
        JSONObject requestBody = new JSONObject();
        requestBody.put("title", "API");
        requestBody.put("body", "API ogrenmek ne guzel");
        requestBody.put("userId", 10);

        //2- expected data olustur
        //3- request gonderip donen responseu kaydet
        Response response = given().contentType(ContentType.JSON)
                .when().body(requestBody.toString())
                .post(url);
        //4- Asertion
        response
                .then()
                .assertThat()
                .statusCode(201)
                .contentType(ContentType.JSON)
                .body("title", Matchers.equalTo("API")) //Eşitlik
                .body("userId", Matchers.lessThan(100)) //100den küçük
                .body("body",Matchers.containsString("API")); //Body API Stringi içeriyor mu

    }
}
