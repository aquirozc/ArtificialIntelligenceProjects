package mx.uaemex.fi.ico.linc28.aquirozc.forwardchaining;

import java.util.ArrayList;
import java.util.Arrays;

public class App {
    
	public static void main(String[] args) {
		
		ForwardChaining solver = new ForwardChaining(Rules.values());
		
		System.out.println(solver.checkIfGoalIsMeet("H2", new ArrayList<String>(Arrays.asList("H7","H8"))));
		
	}
	
}
