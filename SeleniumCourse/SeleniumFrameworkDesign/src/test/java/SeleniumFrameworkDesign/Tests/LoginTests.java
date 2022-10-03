package SeleniumFrameworkDesign.Tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import SeleniumFrameworkDesign.TestComponents.BaseTest;

public class LoginTests extends BaseTest{


	@Test(dataProvider = "getCorrectData")
	public void verifyCorrectLogin(String user, String password) {
		loginObj.loginApplication(user, password);
		Assert.assertTrue(loginObj.getLoginLogo());

	}

	@Test(dataProvider = "getIncorrectData")
	public void verifyIncorrectLoginMessage(String user, String password) {
		loginObj.loginApplication(user, password);
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
	@DataProvider
	public Object[][] getCorrectData(){
		return new Object[][] {{"claudio.soto.ayala@gmail.com","Legostarwars10."},{"claudio.soto.ayala@gmail.com","Legostarwars10."}
		,{"claudio.soto.ayala@gmail.com","Legostarwars10."}};
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
	@DataProvider
	public Object[][] getIncorrectData(){
		return new Object[][] {{"not.a.valid@gmail.com","Legostarwars10."},{"claudio.soto.ayala@gmail.com","NotavalidPassword."}
		,{"not.a.valid@gmail.com","NotavalidPassword."}};
	}

}
