package api.endpoints;

import static io.restassured.RestAssured.*;
import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserEndPoints {

	public static Response createUser(User payload) {

		Response response = given()
								.contentType(ContentType.JSON)
								.accept(ContentType.JSON)
								.body(payload)
							.when()
								.post(Routes.postUrl);
		return response;
	}

	public static Response viewUser(String username) {

		Response response = given()
								.accept(ContentType.JSON)
								.pathParam("username", username)	
								
							.when()
								.log().all()
								.get(Routes.getUrl);
		return response;
	}
	
	public static Response updateUser(User payload,String  username) {

		Response response = given()
								.contentType(ContentType.JSON)
								.accept(ContentType.JSON)
								.pathParam("username", username)
								.body(payload)
							.when()
								.log().all()
								.put(Routes.putUrl);
		return response;
	}
	
	public static Response deleteUser(String username) {

		return given()
			.pathParam("username", username)							
		.when()
			.log().all()
			.delete(Routes.deleteUrl);		
	}

}
