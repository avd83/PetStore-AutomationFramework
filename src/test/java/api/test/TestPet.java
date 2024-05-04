package api.test;

import static io.restassured.RestAssured.*;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.PetEndPoints;
import api.endpoints.Routes;
import api.endpoints.UserEndPoints;
import api.payload.Pet;
import api.payload.PetCategory;
import io.restassured.response.Response;

public class TestPet {
	
	Pet petPayload ;
	Faker faker ;
	public Logger logger;	
	
	@BeforeClass
	void setUp() {	
		
		petPayload = new Pet();
		faker = new Faker();
		
		petPayload.setId(faker.idNumber().hashCode());
		PetCategory pc = new PetCategory();
		pc.setId(0);
		pc.setName(faker.name().name());		
		petPayload.setCategory(pc);		
		petPayload.setName(faker.animal().name());
		String [] PhotoUrls ={"aereg"};
		petPayload.setPhotoUrls(PhotoUrls);
		//Array [] tags ={0,"string"};
		//petPayload.setTags(tags);		
		petPayload.setStatus("avialable");
				
		logger = LogManager.getLogger(this.getClass());
	}
	
	@Test(priority=1)
	void test_postPet() throws IOException {
		logger.info("----------------Adding Pet----------------------");
		Response response = PetEndPoints.addPet(petPayload);
		response.then().log().all().assertThat().extract().response().toString();
		Assert.assertEquals(response.statusCode(),200);	
		logger.info("----------------Pet info is displayed----------------------");
	}
	
	@Test(priority=2) 
	void test_getPet() throws IOException {
		logger.info("----------------Get Pet details ----------------------");
		Response response = PetEndPoints.getPet(petPayload.getId());
		response.then().log().all().assertThat().extract().response().toString();
		Assert.assertEquals(response.getStatusCode(),200);	
		logger.info("----------------Get Pet info displayed-------------------------");
	}
	
	@Test(priority=3)
	void test_putPet() throws IOException {
		logger.info("----------------Update Pet details ----------------------");
		petPayload.setName(faker.name().name());
		String [] PhotoUrls ={"lkutg"};
		petPayload.setPhotoUrls(PhotoUrls);
		petPayload.setStatus("not avialable");
		
		Response response = PetEndPoints.updatePet(petPayload,petPayload.getId());
		response.then().log().all().assertThat().extract().response();			
		//Assert.assertEquals(response.getStatusCode(),200);		
		logger.info("----------------Updated Pet details ----------------------");
	}
	
	@Test(priority=4)
	void test_deletePet() throws IOException {
		logger.info("----------------Deleting Pet ----------------------");
		Response response = PetEndPoints.deletePet(petPayload.getId());
		response.then().log().all().extract().response().asString();
		
		Assert.assertEquals(response.statusCode(),200);	
		logger.info("----------------Pet Deleted ----------------------");
	}
}
