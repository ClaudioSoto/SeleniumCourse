package SeleniumFrameworkDesign.Tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import SeleniumFrameworkDesign.TestComponents.BaseTest;
import SeleniumFrameworkDesign.TestComponents.RetryFailed;

public class LoginTests extends BaseTest{


	@Test(dataProvider = "getCorrectData", retryAnalyzer = RetryFailed.class)
	public void verifyCorrectLogin(HashMap<String,String> input) {
		loginObj.loginApplication(input.get("user"), input.get("password"));
		Assert.assertTrue(loginObj.getLoginLogo());

	}

	@Test(dataProvider = "getIncorrectData" , retryAnalyzer = RetryFailed.class)
	public void verifyIncorrectLoginMessage(HashMap<String,String> input) {
		loginObj.loginApplication(input.get("user"), input.get("password"));
		Assert.assertEquals(loginObj.getLoginErrorMessage(), "Incorrect email or password.");
	}


	//using regular format
	/*
	@DataProvider
	public Object[][] getCorrectData(){

		Object[][] data = new Object[3][2];

		//correct password and user
		data[0][0] = "claudio.soto.ayala@gmail.com";
		data[0][1] = "Legostarwars10.";

		//correct password and user
		data[1][0] = "claudio.soto.ayala@gmail.com";
		data[1][1] = "Legostarwars10.";

		//correct password and user
		data[2][0] = "claudio.soto.ayala@gmail.com";
		data[2][1] = "Legostarwars10.";

		return data;
	}
	 */

	//using json  format
	/*
	@DataProvider
	public Object[][] getCorrectData(){
		return new Object[][] {{"claudio.soto.ayala@gmail.com","Legostarwars10."},{"claudio.soto.ayala@gmail.com","Legostarwars10."}
		,{"claudio.soto.ayala@gmail.com","Legostarwars10."}};
	}
	 */

	//using json  format and hashmap 
	@DataProvider
	public Object[][] getCorrectData(){
		//dataset 1
		HashMap<String,String> ds1 = new HashMap<String,String>();
		ds1.put("user", "claudio.soto.ayala@gmail.com");
		ds1.put("password", "Legostarwars10.");

		//dataset 2
		HashMap<String,String> ds2 = new HashMap<String,String>();
		ds2.put("user", "claudio.soto.ayala@gmail.com");
		ds2.put("password", "Legostarwars10.");


		return new Object[][] {{ds1},{ds2}};
	}

	//using regular format
	/*
	@DataProvider
	public Object[][] getIncorrectData(){

		Object[][] data = new Object[3][2];

		//correct password and user
		data[0][0] = "not.a.valid@gmail.com";
		data[0][1] = "Legostarwars10.";

		//correct password and user
		data[1][0] = "claudio.soto.ayala@gmail.com";
		data[1][1] = "NotavalidPassword.";

		//correct password and user
		data[2][0] = "not.a.valid@gmail.com";
		data[2][1] = "NotavalidPassword.";

		return data;
	}
	 */

	//using json format
	/*
	@DataProvider
	public Object[][] getIncorrectData(){
		return new Object[][] {{"not.a.valid@gmail.com","Legostarwars10."},{"claudio.soto.ayala@gmail.com","NotavalidPassword."}
		,{"not.a.valid@gmail.com","NotavalidPassword."}};
	}
	*/
	
	//usign jason format by usign external data file
	@DataProvider
	public Object[][] getIncorrectData() throws IOException{
		List <HashMap<String,String>> data = getJsonDataToHashMap(System.getProperty("user.dir") + "\\src\\test\\java\\SeleniumFrameworkDesign\\TestData\\IncorrectLoginTestData.json");
		return new Object[][] {{data.get(0)},{data.get(1)}};
	}

}
