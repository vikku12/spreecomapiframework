package pk.util;

import static io.restassured.RestAssured.given;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class RestassuredUtil {
	// Sets Base URI
	public static void setBaseURI() {
		// RestAssured.baseURI = "https://chercher.tech";
		RestAssured.baseURI = "https://demo.spreecommerce.org";
	}

	// Sets base path
	public static void setBasePath(String basePathTerm) {
		RestAssured.basePath = basePathTerm;
	}

	// Reset Base URI (after test)
	public static void resetBaseURI() {
		RestAssured.baseURI = null;
	}

	// Reset base path
	public static void resetBasePath() {
		RestAssured.basePath = null;
	}

	// Sets ContentType
	public static void setContentType(ContentType Type) {
		given().contentType(Type);
	}

	// Returns response by given path
	public static Response getResponse(String path) {
		return given().get(path);
	}

	// Returns response
	public static Response getResponse() {
		return given().get();
	}

	// Returns JsonPath object
	public static JsonPath getJsonPath(Response res, String Jsonvalue) {
		// String json = res.asString();
		JsonPath jsonPathEvaluator = res.getBody().jsonPath();
		String json = jsonPathEvaluator.get(Jsonvalue).toString();

		return new JsonPath(json);
	}
}