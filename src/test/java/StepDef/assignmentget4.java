package StepDef;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import static io.restassured.path.xml.config.XmlPathConfig.xmlPathConfig;
import static io.restassured.RestAssured.get;

import java.util.ArrayList;

public class assignmentget4 {
    Response response;
    RestAssured restAssured;
    RequestSpecification requestSpecification;

    public XmlPath xml_path_obj;

    @Given("User launch url {string}")
    public void user_launch_url(String url) {
        restAssured.baseURI = url;

    }
    @Then("User hit a url")
    public void user_hit_a_url() {
        response = RestAssured.get();

    }
    @Then("user check the stuatus code {string}")
    public void user_check_the_stuatus_code(String statuscode) {
        int statuscodeactual = response.statusCode();
        Assert.assertEquals(String.valueOf(statuscodeactual),statuscode);

    }
    @Then("USer validate the currencies {string}")
    public void u_ser_validate_the_currencies(String currencies) {
        ArrayList<String> Titles = new ArrayList<>();
        int currencylist = xml_path_obj.get("wsdl:definitions.wsdl:types.s:schema.s:simpleType.name.size()");
        //System.out.println("Currencies "+currencylist);
        for (int i=0;i<currencylist;i++)
        {
            Titles.add(xml_path_obj.getString("wsdl:definitions.wsdl:types.s:schema.s:simpleType.name.s:restriction.s:enumeration["+i+"].value"));
        }
        System.out.println(Titles.toString());

    }
    @Then("User validate the forwardtypes {string}")
    public void user_validate_the_forwardtypes(String string) {

    }
    @Then("User validate outcometype as {string}")
    public void user_validate_outcometype_as(String string) {

    }

}
