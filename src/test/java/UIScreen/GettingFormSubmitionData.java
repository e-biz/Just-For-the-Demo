package UIScreen;

import javax.swing.SwingUtilities;

import WindowScreenRunner.TRXApplication;
import io.cucumber.java.en.*;

public class GettingFormSubmitionData {
	
	private TRXApplication trxApplication;
	
	@Given("Open the UI Screen")
	public void Open_the_UI_Screen() {
		trxApplication = new TRXApplication();
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                trxApplication.display();
            }
        });
	}
	
	@When("Screen is Open Check user is submiting the Valid Data")
	public void ValidatetheData() {
		trxApplication.submitForm();
	}
	
	@Then("Check if user correctly Input the Data Closed the Form and Start running the Scripts")
	public void GetingtheDataAndClosedtheUIScreen() {
		// Wait for the form to be submitted before proceeding
        while (!trxApplication.isFormSubmitted()) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        trxApplication.closeWindow();
	}
}
