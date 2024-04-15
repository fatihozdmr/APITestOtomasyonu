package tests;

import baseUrl.BaseUrlJsonPlaceholderApi;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C17_BaseUrlDummyRestapi extends BaseUrlJsonPlaceholderApi {
    /*
    Class icinde 3 Test metodu olusturun ve asagidaki testleri yapin

3- https://jsonplaceholder.typicode.com/posts/50 endpointine bir DELETE request
gonderdigimizde donen response’un status code’unun 200 oldugunu ve response body’sinin
null oldugunu test edin
     */
    @Test
    public void test01(){
        /*
        1- https://jsonplaceholder.typicode.com/posts endpointine bir GET request gonderdigimizde
donen response’un status code’unun 200 oldugunu ve Response’ta 100 kayit oldugunu test
edin
         */
        //1- endpoint ve req body olustur
        specJsonPlaceholderApi.pathParam("pp1","posts");
        //2- expected data olustur
        //3- req gonder ve donen responseu kaydet
        Response response = given()
                                .when().spec(specJsonPlaceholderApi)
                                .get("/{pp1}");
        response
                .then()
                .assertThat().statusCode(200)
                .body("title",Matchers.hasSize(100));
    }

    @Test
    public void test02(){
        /*
        2- https://jsonplaceholder.typicode.com/posts/44 endpointine bir GET request gonderdigimizde
donen response’un status code’unun 200 oldugunu ve “title” degerinin
“optio dolor molestias sit” oldugunu test edin
         */

        //1 endpoint ve req body olustur
        specJsonPlaceholderApi.pathParams("pp1","posts","pp2",44);
        //2- expected body olustur
        //3- req gonder ve donen responseu kaydet
        Response response = given()
                                .when().spec(specJsonPlaceholderApi)
                                .get("/{pp1}/{pp2}");

        response
                .then()
                .assertThat()
                .statusCode(200)
                .body("title",Matchers.equalTo("optio dolor molestias sit"));


    }

}
