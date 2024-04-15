package baseUrl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class BaseUrlJsonPlaceholderApi {

    protected RequestSpecification specJsonPlaceholderApi;

    @Before
    public void setUp(){
        specJsonPlaceholderApi = new RequestSpecBuilder()
                .setBaseUri("https://jsonplaceholder.typicode.com")
                .build();
    }
}
