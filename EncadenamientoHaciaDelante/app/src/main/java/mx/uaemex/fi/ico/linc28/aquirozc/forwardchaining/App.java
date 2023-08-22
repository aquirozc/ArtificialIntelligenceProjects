package mx.uaemex.fi.ico.linc28.aquirozc.forwardchaining;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class App {
	
	private static List<String> baseDeConocimientos = new ArrayList<String>();
	private static Rules[] rulesAsArray = Rules.values();
	private static Scanner scanner = new Scanner(System.in);
	private static String objetivo = "";
    
	public static void main(String[] args) {
		
		System.out.println("\nUniversidad Autónoma del Estado de México\n"
				+ "Ingenería en computación\n"
				+ "LINC28 Inteligencia Artificial\n");
		System.out.println("Encademaniento hacia adelante (Totem Hokum)\n");
		
		System.out.print("Por favor seleccione el objetivo(1-9): ");
		objetivo = "H" + scanner.nextLine();
		
		System.out.println("\nReglas disponibles: ");
		
		for (int i = 0; i < rulesAsArray.length;i++) {
			System.out.print("[R" + (i+1) +"] Si");
			for (int j = 0; j < rulesAsArray[i].req.length;j++) {
				System.out.print(((j == 0) ? " " : ((j < rulesAsArray[i].req.length - 1) ? ", " : " y ")) +  rulesAsArray[i].req[j]);
			}
			System.out.print(" entonces " + rulesAsArray[i].res + "\n");
		}
		
		System.out.print("\nPor favor escriba los elementos a introducir en la base de conocimientos separados por un espacio: ");
		baseDeConocimientos = new ArrayList<String>(Stream.of(scanner.nextLine().split(" ")).map(s -> "H" +  s).toList());
		
		new ForwardChaining(rulesAsArray).checkIfGoalIsMeet(objetivo, baseDeConocimientos);
		System.out.println("\n"+baseDeConocimientos);
		
	}
	
}
