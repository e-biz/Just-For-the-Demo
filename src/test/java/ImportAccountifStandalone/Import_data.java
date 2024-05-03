package ImportAccountifStandalone;
import java.util.List;
import java.util.Map;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import com.DriverFactory.DriverFactory;
import com.StoringLocalValues.ScenarioContext;
import com.pages.*;


public class Import_data {
	private ImportData importFiles =new ImportData(DriverFactory.getDriver()); 
	private MenuNavBar MainMenu = new MenuNavBar(DriverFactory.getDriver());
	
	public String AppName;
	
	@Then("open the import data page")
	public void open_the_import_data_page() throws InterruptedException {
		  String AppName = ScenarioContext.get("AppName");
		if(AppName.equals("Standalone")) {
		
		MainMenu.ImportDataMenu();
		Thread.sleep(2000);
		String FileDirectory = "C:\\eRequisition_Latest_Script";
        ScenarioContext.put("FileDirectory", FileDirectory);
        
		}
		else {
			  
			System.out.println("App Name is:"+AppName);
		}	
		
	;
	}
	@Then("click on import data button and Submit Account file and Verify the Results and Error and successful popup msg")
	public void click_on_import_data_button_and_submit_Account_file_and_verify_the_results_and_error_and_successful_popup_msg(DataTable dataTable) throws InterruptedException {
		String AppName = ScenarioContext.get("AppName");
		if(AppName.equals("Standalone")) {
		List<Map<String, String>> listdata = dataTable.asMaps(String.class, String.class);
	    for (Map<String, String> mapdata : listdata) {
	    	
	    	String fileDirectorykey = ScenarioContext.get("FileDirectory");
	    	String GetDirectory=mapdata.get("DirectoryURLofImportAmount");
	    	String directoryURL =fileDirectorykey+GetDirectory;  
	    	int successfullyLineItemsResults = Integer.parseInt(mapdata.get("SuccessfullyLineItemsResults"));
	    	int hardSleepForFileUpload = Integer.parseInt(mapdata.get("HardSleepforFileUpload"));
	    	int hardSleepAfterSubmitButtonClick = Integer.parseInt(mapdata.get("HardSleepAfterSubmitButtonClick"));
	    	
	    	importFiles.ImportAccounts(directoryURL, successfullyLineItemsResults,
	    		    hardSleepForFileUpload, hardSleepAfterSubmitButtonClick);
	    	}
	    	
	    }
		else {
    		
    		System.out.println("App Name is:"+AppName);
    	}
		
	}

	@Then("click on import data button and Submit Class file and Verify the Results and Error and successful popup msg")
	public void click_on_import_data_button_and_submit_class_file_and_verify_the_results_and_error_and_successful_popup_msg(DataTable dataTable) throws InterruptedException {
		String AppName = ScenarioContext.get("AppName");
		if(AppName.equals("Standalone")) {
		List<Map<String, String>> listdata = dataTable.asMaps(String.class, String.class);
	    for (Map<String, String> mapdata : listdata) {
	    	
	    	String fileDirectorykey = ScenarioContext.get("FileDirectory");
	    	String GetDirectory=mapdata.get("DirectoryURLofImportClass");
	    	String directoryURL =fileDirectorykey+GetDirectory; 
	    	int successfullyLineItemsResults = Integer.parseInt(mapdata.get("SuccessfullyLineItemsResults"));
	    	int hardSleepForFileUpload = Integer.parseInt(mapdata.get("HardSleepforFileUpload"));
	    	int hardSleepAfterSubmitButtonClick = Integer.parseInt(mapdata.get("HardSleepAfterSubmitButtonClick"));
	    	
	    	importFiles.ImportClass(directoryURL, successfullyLineItemsResults,
	    		    hardSleepForFileUpload, hardSleepAfterSubmitButtonClick);
	    
	    	
	    	
	    	}
	    }
		else {
  		 
  		System.out.println("App Name is:"+AppName);}
	}

	@Then("click on import data button and Submit Terms file and Verify the Results and Error and successful popup msg")
	public void click_on_import_data_button_and_submit_terms_file_and_verify_the_results_and_error_and_successful_popup_msg(DataTable dataTable) throws InterruptedException {
		String AppName = ScenarioContext.get("AppName");
		if(AppName.equals("Standalone")) {
		List<Map<String, String>> listdata = dataTable.asMaps(String.class, String.class);
	    for (Map<String, String> mapdata : listdata) {
	    	
	    	String fileDirectorykey = ScenarioContext.get("FileDirectory");
	    	String GetDirectory=mapdata.get("DirectoryURLofImportTerms");
	    	String directoryURL =fileDirectorykey+GetDirectory;  
	    	int successfullyLineItemsResults = Integer.parseInt(mapdata.get("SuccessfullyLineItemsResults"));
	    	int hardSleepForFileUpload = Integer.parseInt(mapdata.get("HardSleepforFileUpload"));
	    	int hardSleepAfterSubmitButtonClick = Integer.parseInt(mapdata.get("HardSleepAfterSubmitButtonClick"));
	    	
	    	importFiles.ImportTerms(directoryURL, successfullyLineItemsResults,
	    		    hardSleepForFileUpload, hardSleepAfterSubmitButtonClick);
	    	}
	    	
	    }
		else {
    		
    		System.out.println("App Name is:"+AppName);
    	}
		
	}

	


}




