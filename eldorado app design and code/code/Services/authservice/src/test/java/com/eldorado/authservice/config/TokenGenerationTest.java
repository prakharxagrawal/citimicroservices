//package com.eldorado.authservice.config;
//
//import static io.restassured.RestAssured.given;
//import static org.junit.Assert.assertNotNull;
//
//import org.json.JSONException;
//import org.json.JSONObject;
//import org.junit.Ignore;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Value;
//
//import com.eldorado.authservice.constants.AuthServiceConstants;
//
//import io.restassured.response.Response;
//
//class TokenGenerationTest {
//
//	/*
//	 * Initializing constanst related to Oauth token generation
//	 */
//
//	public static String USER_NAME = "doug@123.com";
//	public static String PASSWORD = "doug";
//	
//	
//	
//
//	/*
//	 * Method to get Access Token from Authorization Server
//	 */
//
//	public String getAccessToken() throws JSONException {
//
//		Response response = given().auth().preemptive()
//				.basic(AuthServiceConstants.CLIENT_ID, AuthServiceConstants.CLIENT_PASSWORD)
//				.contentType("application/x-www-form-urlencoded").log().all().formParam("grant_type", "password")
//				.formParam("username", USER_NAME).formParam("password", PASSWORD).when()
//				.post(AuthServiceConstants.BASE_URI + "/oauth/token");
//
//		JSONObject jsonObject = new JSONObject(response.getBody().asString());
//		String accessToken = jsonObject.get("access_token").toString();
//		return accessToken;
//	}
//
//	/*
//	 * Testing for token generation
//	 */
//
//	@Test
//	@Ignore
//	void testOAuthTokenGenerationCode() throws JSONException {
//		String accessToken = getAccessToken();
//		assertNotNull(accessToken);
//
//	}
//
//}
