package api.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.github.javafaker.Faker;
import org.testng.annotations.Test;
import api.endpoints.UserEndPoints;
import api.payload.User;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class TestUserExcelDriven {
	
	public Logger logger;
	
	@Test(priority=1,dataProvider="Data",dataProviderClass=DataProviders.class)
	void testPostUser(String userId,String userName,String fName,String lName,String userEmail,String pwd,String phone) {
		
		logger = LogManager.getLogger(this.getClass());
		logger.info("----------------Create User by DataDriven-- ----------------------");
		User userPayload = new User();
		
		userPayload.setId(Integer.parseInt(userId));
		userPayload.setFirstName(fName);
		userPayload.setLastName(lName);
		userPayload.setUsername(userName);
		userPayload.setPassword(pwd);
		userPayload.setEmail(userEmail);
		userPayload.setPhone(phone);
		
		Response response = UserEndPoints.createUser(userPayload);
		Assert.assertEquals(response.statusCode(),200);	
		logger.info("----------------User Created by DataDriven-- ----------------------");
		
	}
	
	@Test(priority=2,dataProvider="UserNames",dataProviderClass=DataProviders.class)
	void testDeleteUser(String userName) {
		
		logger.info("----------------Delete User by DataDriven-- ----------------------");
		Response response = UserEndPoints.deleteUser(userName);
		Assert.assertEquals(response.statusCode(),200);	
		logger.info("----------------User Deleted  by DataDriven-- ----------------------");
	}
}
