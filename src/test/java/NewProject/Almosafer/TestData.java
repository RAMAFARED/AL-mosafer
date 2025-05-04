package NewProject.Almosafer;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class TestData {
	
	
	String ExpectedLanguage = "en";
	
	String ExpectedSar = "SAR";
	String ExpectedNumber = "+966554400000";
	String ExpectedActionTab = "active";
	//String expectedText = "Hotels";
	
	
	String tomorrow = LocalDate.now().plusDays(1).format(DateTimeFormatter.ofPattern("dd"));
	String aftertoday = LocalDate.now().plusDays(2).format(DateTimeFormatter.ofPattern("dd"));
	
	//String[] LANGUAGES = {"en", "ar"};

	
	 String[] OPTION_1 = {"1 Room, 2 Adults, 0 Children","1 Room, 1 Adult, 0 Children"};
   
	 String[] englishCities = {"Dubai", "Jeddah", "Riyadh"};
}


