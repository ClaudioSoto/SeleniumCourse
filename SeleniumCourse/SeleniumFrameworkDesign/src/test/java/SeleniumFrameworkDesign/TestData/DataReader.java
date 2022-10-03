package SeleniumFrameworkDesign.TestData;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataReader {
	
	public List<HashMap<String, String>> getJsonDataToHashMap() throws IOException {
		//get jason file into a string
		String jsonContet = FileUtils.readFileToString(new File (System.getProperty("user.dir") + "\\src\\test\\java\\SeleniumFrameworkDesign\\TestData\\IncorrectLoginTestData.json"),
				StandardCharsets.UTF_8);
	
		//get hashmap with the json
		ObjectMapper mapper = new ObjectMapper();
		
		//json to hashmap list
		List<HashMap<String,String>> data = mapper.readValue(jsonContet, new TypeReference<List<HashMap<String,String>>>(){});
		
		return data;
	}

}
