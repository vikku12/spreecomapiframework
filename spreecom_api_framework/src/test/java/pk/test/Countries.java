package pk.test;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import pk.util.RestassuredUtil;

public class Countries extends BaseTest{

	@Test
	public void T01_getDefaultCountries() {
		res = RestassuredUtil.getResponse("/countries/default");
		testUtil.checkStatusIs200(res);
		// jp = RestAssuredUtil.getJsonPath(res,"data.attributes.iso_name");
		// System.out.println(testUtil.getClients(jp));
		JsonPath jsonPathEvaluator = res.getBody().jsonPath();
		String isoname = jsonPathEvaluator.get("data.attributes.iso_name").toString();
		System.out.println("ISO Name is =>  " + isoname);

	}
	
	@Test
	public void T02_retrieveacountry() {
		res = RestassuredUtil.getResponse("/countries/IND");
		testUtil.checkStatusIs200(res);
		// jp = RestAssuredUtil.getJsonPath(res,"data.attributes.iso_name");
		// System.out.println(testUtil.getClients(jp));
		JsonPath jsonPathEvaluator = res.getBody().jsonPath();
		String isoname = jsonPathEvaluator.get("data.attributes.iso_name").toString();
		System.out.println("ISO Name is =>  " + isoname);

	}
	
	@Test
	public void T03_listallcountries() {
		res = RestassuredUtil.getResponse("/countries");
		testUtil.checkStatusIs200(res);
		// jp = RestAssuredUtil.getJsonPath(res,"data.attributes.iso_name");
		// System.out.println(testUtil.getClients(jp));
		JsonPath jsonPathEvaluator = res.getBody().jsonPath();
		String isoname = jsonPathEvaluator.get("data.attributes.iso_name").toString();
		System.out.println("ISO Name is =>  " + isoname);

	}

}
