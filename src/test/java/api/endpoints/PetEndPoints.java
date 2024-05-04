package api.endpoints;

import static io.restassured.RestAssured.given;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.ResourceBundle;

import api.payload.Pet;
import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PetEndPoints {
	
	static ResourceBundle getUrl() throws IOException {
		
		ResourceBundle routes= ResourceBundle.getBundle("routes");
		return routes;
	}
	
	public static Response addPet(Pet payload) throws IOException {
		
		String postUrl = getUrl().getString("postUrl");
		Response response = given()
								.contentType(ContentType.JSON)
								.accept(ContentType.JSON)
								.body(payload)
							.when()
								.log().all()
								.post(postUrl);									
		return response;
	}
	
	public static Response getPet(int id) throws IOException {
		String getUrl = getUrl().getString("getUrl");
		Response response = given()
								.accept(ContentType.JSON)
								.pathParam("id",id)	
								
							.when()
								.log().all()
								.get(getUrl);
		return response;
	}
	
	public static Response updatePet(Pet petPayload,int id) throws IOException {
		String putUrl = getUrl().getString("putUrl");
		Response response = given()
								.contentType(ContentType.JSON)
								.accept(ContentType.JSON)
								.pathParam("id",id)
								.body(petPayload)
							.when()
								.log().all()
								.put(putUrl);
		return response;
	}
	
	public static Response deletePet(int id) throws IOException {
		String deleteUrl = getUrl().getString("deleteUrl");
		return given()
			.pathParam("id", id)							
		.when()
			.log().all()
			.delete(deleteUrl);		
	}
}
