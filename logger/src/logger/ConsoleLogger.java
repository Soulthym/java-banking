package _logger;

public class ConsoleLogger implements Logger {

	@Override
	public void info(String category, String message) {
		//Si la categorie du logger est "output" alors on écrit dans la console
		if (category == "OUTPUT") {
			System.out.println(message);
		}
	}

	@Override
	public void error(String category, String message) {
		//Cf methode info
		if (category == "OUTPUT") {
			System.out.println("Error : " + message);
		}
	}
}
