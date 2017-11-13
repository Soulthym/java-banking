package _logger;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileLogger implements Logger {
	
	public String getDate() {
		//Création d'une nouvelle instance date
		Date today = new Date();
		//Formattage de la date au format : jour/mois/année , heure:minutes:secondes
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy , HH:mm:ss");
		//Passage de la date en type String
		String date = format.format(today);
		return date;
	}
	
	public void fileWriter(String category, String message, String lvl) {
		//trouver le chemin du fichier
			//private final String chemin = "../Logger.txt"; ?
		//recuperer la date --> ecrire
			//private String date = getDate(); ?
		//recuperer category(input, output, program) --> ecrire
		//recuperer lvl(info, error) --> ecrire
		//recuperer message --> ecrire
		// \n
		//fermeture fichier
	}
	
	@Override
	public void info(String category, String message) {
		fileWriter(category.toUpperCase(), message, "INFO");		
	}

	@Override
	public void error(String category, String message) {
		fileWriter(category.toUpperCase(), message, "ERROR");		
	}

}
