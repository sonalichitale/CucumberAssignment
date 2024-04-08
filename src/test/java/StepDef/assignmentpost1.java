package StepDef;

import io.cucumber.java.en.*;
import io.restassured.http.ContentType;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import org.junit.Assert;

import static io.restassured.RestAssured.given;
import static io.restassured.path.xml.config.XmlPathConfig.xmlPathConfig;

public class assignmentpost1 {

public XmlPath xml_path_obj;
public String number;
public String request_body;

Response response;

    @Given("user enter the {string}")
    public void user_enter_the(String Celsius) {
    number = Celsius;

    }
    @Then("user create the conversion body")
    public void user_create_the_conversion_body() {
    request_body ="<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
            "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
            "  <soap12:Body>\n" +
            "    <CelsiusToFahrenheit xmlns=\"https://www.w3schools.com/xml/\">\n" +
            "      <Celsius>"+number+"</Celsius>\n" +
            "    </CelsiusToFahrenheit>\n" +
            "  </soap12:Body>\n" +
            "</soap12:Envelope>";


    }
    @When("User send post call {string}")
    public void user_send_post_call(String expectedurl) {
    response =given().contentType(ContentType.XML).header("Content-Type","text/xml; charset=utf-8")
            .body(request_body).when().post(expectedurl);
        System.out.println("Response: "+response.getBody().asString());

    }
    @When("User see the status code {string}")
    public void user_see_the_status_code(String status_code) {
        int stauscodenew = response.statusCode();
        Assert.assertEquals(String.valueOf(stauscodenew),status_code);


    }
    @When("USer see the celcius response {string}")
    public void u_ser_see_the_celcius_response(String CelsiustoFer) {

    xml_path_obj =new XmlPath(response.getBody().asString()).using(xmlPathConfig().namespaceAware(false));
    String data = xml_path_obj.getString("soap:Envelope.soap:Body.CelsiusToFahrenheitResponse.CelsiusToFahrenheitResult").trim();
        System.out.println(data);
    Assert.assertEquals(String.valueOf(data),CelsiustoFer);

    }

}
