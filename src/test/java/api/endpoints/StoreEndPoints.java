package api.endpoints;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import api.payload.Pet;
import api.payload.Store;
import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class StoreEndPoints {
	
	public static Response createOrder(Store payload) {

		Response response = given()
								.contentType(ContentType.JSON)
								.accept(ContentType.JSON)
								.body(payload)
							.when()
								.post(Routes.postStoreUrl);
		return response;
	}
	
	public static Response viewStoreOrder(int id) {

		Response response = given()
								.accept(ContentType.JSON)
								.pathParam("id", id)	
								
							.when()
								.log().all()
								.get(Routes.getStoreOrderUrl);
		return response;
	}
	
	public static Response virewStoreInventory() {

		Response response = given()
								.accept(ContentType.JSON)
							.when()
								.log().all()
								.get(Routes.getStoreInventoryUrl);
		return response;
	}
	
	public static Response deleteStoreOrder(int id) {

	return   given()
				.pathParam("id", id)							
			.when()
				.log().all()
				.delete(Routes.deleteStoreOrderUrl);		
	}
}
