package api.test;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.StoreEndPoints;
import api.endpoints.UserEndPoints;
import api.payload.Store;
import api.payload.User;
import io.restassured.response.Response;

public class TestStore {
	Store storePayload ;
	Faker faker ;
	String userName;
	public Logger logger;	
	
	@BeforeClass
	void setUp() {	
		
		storePayload = new Store();
		faker = new Faker();
		
		storePayload.setId(faker.number().randomDigit());
		storePayload.setPetId(823);
		storePayload.setQuantity(faker.number().randomDigit());
		storePayload.setShipDate(faker.date().future(3, TimeUnit.HOURS));
		storePayload.setStatus("status");
		storePayload.setComplete(faker.bool().bool());
			
		logger = LogManager.getLogger(this.getClass());
	}
	
	@Test(priority=1)
	void test_postStoreOrder() {
		logger.info("----------------Generating Order----------------------");
		Response response = StoreEndPoints.createOrder(storePayload);
		response.then().log().all();
		
		Assert.assertEquals(response.statusCode(),200);	
		logger.info("----------------Order info is displayed----------------------");
	}
	
	@Test(priority=2) 
	void test_getStoreOrder() {
		logger.info("----------------Get Order details ----------------------");
		Response response = StoreEndPoints.viewStoreOrder(storePayload.getId());
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(),200);	
		logger.info("----------------Get Order info displayed-------------------------");
	}
	
	@Test(priority=3)
	void test_viewStoreInventory() {
		logger.info("----------------View Store Inventory details ----------------------");
			
		Response response = StoreEndPoints.virewStoreInventory();
		response.then().log().all().extract().response().asString();
			
		Assert.assertEquals(response.statusCode(),200);		
		logger.info("----------------View Store Inventory details ----------------------");
	}
	
	@Test(priority=4)
	void test_deleteStoreOrder() {
		logger.info("----------------Deleting Store Order ----------------------");
		Response response = StoreEndPoints.deleteStoreOrder(storePayload.getId());
		response.then().log().all();
		
		Assert.assertEquals(response.statusCode(),200);	
		logger.info("----------------Store Order Deleted ----------------------");
	}
}