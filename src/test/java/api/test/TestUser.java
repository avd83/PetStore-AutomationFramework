package api.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints;
import api.payload.User;
import io.restassured.response.Response;

public class TestUser {
	
	User userPayload ;
	Faker faker ;
	String userName;
	public Logger logger;
	
	
	@BeforeClass
	void setUp() {	
		
		userPayload = new User();
		faker = new Faker();
		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setUsername(faker.name().username());
		userPayload.setPassword(faker.internet().password());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		userPayload.setPhone(faker.phoneNumber().cellPhone());
		
		logger = LogManager.getLogger(this.getClass());
	}
	
	@Test(priority=1)
	void test_postUser() {
		logger.info("----------------Creating User----------------------");
		Response response = UserEndPoints.createUser(userPayload);
		response.then().log().all();
		
		Assert.assertEquals(response.statusCode(),200);	
		logger.info("----------------User info is displayed----------------------");
	}
	
	@Test(priority=2) 
	void test_getUser() {
		logger.info("----------------GetUser details ----------------------");
		Response response = UserEndPoints.viewUser(userPayload.getUsername().toString());
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(),200);	
		logger.info("----------------GetUser info displayed-------------------------");
	}
	
	@Test(priority=3)
	void test_putUser() {
		logger.info("----------------Update User details ----------------------");
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().emailAddress());
		
		Response response = UserEndPoints.updateUser(userPayload,userPayload.getUsername().toString());
		response.then().log().all().extract().response().asString();
			
		Assert.assertEquals(response.statusCode(),200);		
		logger.info("----------------Updatd User details ----------------------");
	}
	
	@Test(priority=4)
	void test_deleteUser() {
		logger.info("----------------Deleting User ----------------------");
		Response response = UserEndPoints.deleteUser(userPayload.getUsername().toString());
		response.then().log().all();
		
		Assert.assertEquals(response.statusCode(),200);	
		logger.info("----------------User Deleted ----------------------");
	}
}