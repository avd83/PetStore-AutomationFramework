package api.endpoints;

public class Routes {

	public static String baseUrl = "https://petstore.swagger.io/v2";
	
	public static String postUrl = baseUrl + "/user";
	public static String getUrl = baseUrl + "/user/{username}";
	public static String putUrl= baseUrl + "/user/{username}";
	public static String deleteUrl = baseUrl + "/user/{username}";
	

	public static String postStoreUrl = baseUrl + "/store/order";
	public static String getStoreOrderUrl = baseUrl + "/store/order/{id}";
	public static String getStoreInventoryUrl = baseUrl + "/store/inventory";
	public static String deleteStoreOrderUrl = baseUrl + "/store/order/{id}";

}