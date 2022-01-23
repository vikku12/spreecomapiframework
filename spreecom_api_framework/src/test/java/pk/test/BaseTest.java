package pk.test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import pk.util.RestassuredUtil;
import pk.util.TestUtil;

public class BaseTest {
	
	public Response res = null; //Response
    public JsonPath jp  = null; //JsonPath

    //Instantiate a Helper Test Methods (testUtils) Object
    TestUtil testUtil = new TestUtil();



    @BeforeClass
    public void setup() {
        //Test Setup
    	RestassuredUtil.setBaseURI(); //Setup Base URI
    	RestassuredUtil.setBasePath("/api/v2/storefront"); //Setup Base Path
    	RestassuredUtil.setContentType(ContentType.JSON); //Setup Content Type
    }

    @AfterClass
    public void afterTest() {
        //Reset Values
    	RestassuredUtil.resetBaseURI();
    	RestassuredUtil.resetBasePath();
    }

}
