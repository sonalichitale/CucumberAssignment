package StepDef;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import io.cucumber.java.en.*;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import io.restassured.http.ContentType;
import org.joda.time.tz.FixedDateTimeZone;
import org.junit.Assert;

import static io.restassured.RestAssured.given;

public class assignmentpost2 {

   public String name1,year1,price1;
   public XmlPath xml_path_obj;
    public String request_body;

   Response response;

    @Given("User enter name {string} and {string} and {string}")
    public void user_enter_name_and_and(String name, String year, String price) {
    name1 = name;
    year1 = year;
    price1 = price;
    }

    @Then("User create the conversion body")
    public void user_create_the_conversion_body() {

        request_body ="{\"name\":\""+name1+"\",\n" +
                "\"data\":{\"year\":"+year1+",\n" +
                "\"price\":"+price1+",\n" +
                "\"CPU model\":\"Intel Core i9\",\n" +
                "\"Hard disk size\":\"1 TB\"\n" +
                "}\n" +
                "}";

    }
    @When("User post the url {string}")
    public void user_post_the_url(String url) {
        response = given().contentType(ContentType.JSON).body(request_body).when().post(url);
        System.out.println("Response: "+response.getBody().asString());

    }
    @When("User validate the status code {string}")
    public void user_validate_the_status_code(String status_code) {
        int stauscodenew = response.statusCode();
        Assert.assertEquals(String.valueOf(stauscodenew),status_code);
    }




    @When("User validate the year in response {string}")
    public void user_validate_the_year_in_response(String responseyear) {
        String year1 = response.getBody().jsonPath().getString("data.year");
        System.out.println(year1);
        Assert.assertEquals(String.valueOf(year1),responseyear);



    }
    @When("User validate the price in response {string}")
    public void user_validate_the_price_in_response(String price) {
        String price1 = response.getBody().jsonPath().getString("data.price");
        System.out.println(price1);
        Assert.assertEquals(String.valueOf(price1),price);

    }
    @When("User validate the created date should not null")
    public void user_validate_the_created_date_should_not_null() {
        String createdatenew = response.getBody().jsonPath().getString("createdAt");
        System.out.println(createdatenew);
        //Assert.assertEquals(String.valueOf(createdatenew),createdate1);
    }
}
