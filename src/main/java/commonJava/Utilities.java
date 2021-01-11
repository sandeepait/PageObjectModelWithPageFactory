package commonJava;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.json.JSONObject;
import org.json.JSONTokener;

public class Utilities {
	private static Utilities utilitiesInstance;

	private Utilities() {
		
	}
	
	public static Utilities getInstance() {
		if(utilitiesInstance==null) {
			utilitiesInstance= new Utilities();
		}
		return utilitiesInstance;
	}
	
	public JSONObject readJsonResources (String filename) {
		File datalistFile = new File(System.getProperty("user.dir")+File.separator+"src"+File.separator+"test"+File.separator+"resources"+File.separator+filename);
		FileInputStream fis=null;
		try {
			fis = new FileInputStream(datalistFile);
		} catch (FileNotFoundException e) {
			System.out.println("DataList.json file not found");
			e.printStackTrace();
		}
		JSONTokener tokener = new JSONTokener(fis);
		JSONObject resourceJsonObject = new JSONObject(tokener);
		return resourceJsonObject;
	}
	
	public String getBrowser() {
		JSONObject runnerObject=readJsonResources("runner.json");
		String browser = runnerObject.getString("runner").split(",")[0];
		System.out.println("browser mentioned in runner.json -->"+browser);
		return browser;
		
	}
	
	public String getEnvironment() {
		JSONObject runnerObject=readJsonResources("runner.json");
		String environment = runnerObject.getString("runner").split(",")[1];
		System.out.println("Environment mentioned in runner.json -->"+environment);
		return environment;
		
	}
}
