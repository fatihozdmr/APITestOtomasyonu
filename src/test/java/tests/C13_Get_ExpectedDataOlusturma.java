package tests;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class C13_Get_ExpectedDataOlusturma {
    /*
    https://jsonplaceholder.typicode.com/posts/22 url'ine bir GET request
yolladigimizda donen response body’sinin asagida verilen ile ayni oldugunutest ediniz
Response body :
{
"userId": 3,
"id": 22,
"title": "dolor sint quo a velit explicabo quia nam",
"body": "eos qui et ipsum ipsam suscipit autsed omnis non odioexpedita ear um mollitia molestiae aut atque rem suscipitnam impedit esse"
}
     */
    @Test
    public void test01(){
        //1- endpoint ve req body hazirla
        String url = "https://jsonplaceholder.typicode.com/posts/22";
        //2- expected data olustur
        JSONObject expectedData = new JSONObject();
        expectedData.put("userId",3);
        expectedData.put("id",22);
        expectedData.put("title","dolor sint quo a velit explicabo quia nam");
        expectedData.put("body","eos qui et ipsum ipsam suscipit aut\n" +
                "sed omnis non odio\n" +
                "expedita earum mollitia molestiae aut atque rem suscipit\n" +
                "nam impedit esse");

        //3- req gonder ve donen responseu kaydet

        Response response = given().when().get(url);

        //4- Assertion
        /* Bugune kadar yaptigimiz yontemle de testimizi yapabiliriz
        Ancak frameworkumuzu gelistirmeye devam etmeliyiz
        response.then().assertThat()
                .body("userId", equalTo(3),
                        "id", equalTo(22),
                        "title",equalTo("dolor sint quo a velit explicabo quia nam"));
        */
        JsonPath responseJsonPath = response.jsonPath();
        Assert.assertEquals(expectedData.get("id"),responseJsonPath.getInt("id"));
        Assert.assertEquals(expectedData.get("title"),responseJsonPath.getString("title"));
        Assert.assertEquals(expectedData.get("body"),responseJsonPath.getString("body"));
        Assert.assertEquals(expectedData.get("userId"),responseJsonPath.getInt("userId"));

    }
}
