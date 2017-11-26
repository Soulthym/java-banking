package logger;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileLogger implements Logger {

	public String getDate() {
		//Creation d'une nouvelle instance date
		Date today = new Date();
		//Formattage de la date au format : jour/mois/annee , heure:minutes:secondes
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy , HH:mm:ss");
		//Passage de la date en type String
		String date = format.format(today);
		return date;
	}

	public void fileWriter(String category, String message, String lvl)throws WritingException {
		//Creation d'un fichier et donner son chemin
			final String chemin = "./Log.txt";
			final File fichier = new File(chemin);
		//Creation d'un writer
		try {
			if (!(fichier.exists())) {
				fichier.createNewFile();
			}
			final FileWriter writer = new FileWriter(fichier, true);
			try {
				//recuperer la date --> ecrire
				final String date = getDate();
				writer.write("< "+date+" > ");
				//recuperer lvl(info, error) --> ecrire
				writer.write("< "+lvl+" > ");
				//recuperer category(input, output, program) --> ecrire
				writer.write("< "+category+" > ");
				//recuperer message --> ecrire
				writer.write(message);
				// \n
				writer.write("\n");
				} finally {
					//fermeture fichier
					writer.close();
				}
			} catch (Exception e) {
				throw new WritingException("Creation du fichier impossible");
			}

	}

	@Override
	public void info(String category, String message) throws WritingException {
		fileWriter(category.toUpperCase(), message, "INFO");
	}

	@Override
	public void error(String category, String message) throws WritingException {
		fileWriter(category.toUpperCase(), message, "ERROR");
	}

}
