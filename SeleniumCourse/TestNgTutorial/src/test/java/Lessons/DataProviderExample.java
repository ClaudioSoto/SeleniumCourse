package Lessons;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderExample {
	
	@Test(dataProvider = "getData")
	public void test1(String user, String password) {
		System.out.println(user + " - " + password);
	}
	
	
	//this is a data provider
	@DataProvider
	public Object[][] getData(){
		
		Object[][] data = new Object[3][2];
		
		//first dataset
		data[0][0] = "first user";
		data[0][1] = "first password";
		
		//second dataset
		data[1][0] = "second user";
		data[1][1] = "second password";
		
		//third dataset
		data[2][0] = "third user";
		data[2][1] = "third password";
		
		return data;
	}

}
