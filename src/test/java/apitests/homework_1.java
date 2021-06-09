package apitests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.ConfigurationReader;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class homework_1 {
    /*
    Q1:
    - Given accept type is Json
    - Path param value- US
    - When users sends request to /countries
    - Then status code is 200
    - And Content - Type is Json
    - And country_id is US___  "country_id": "US",
    - And Country_name is United States of America ____ "country_name": "United States of America",
    - And Region_id is____ "region_id": 2,



     */
    @BeforeClass
    public void beforeclass(){
        baseURI= ConfigurationReader.get("hr_api_url");
    }

    @Test
    public void question_1(){

        Response response = given().accept(ContentType.JSON)
                .when().get("hr_api_url"+ "/countries/US");
        //.and().queryParam("q", "{\"region_id\":2}")
        //.when().get("/countries");
        assertEquals(response.statusCode(),200);
        assertEquals(response.contentType(),"JSON");


        //assertEquals(response.statusCode(),200);
        //assertEquals(response.contentType(),"application/json");
        //assertTrue(response.body().asString().contains("United States of America"));
    }
}
