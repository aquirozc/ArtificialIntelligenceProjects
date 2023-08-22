package mx.uaemex.fi.ico.linc28.aquirozc.forwardchaining;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class ForwardChaining {
	
	private boolean[] HAS_RULE_BEEN_MEET;
	private Rules[] RULES_AS_ARRAY;
	
	public ForwardChaining(Rules[] rulesArray) {
		RULES_AS_ARRAY = rulesArray;		
	}
	
	public boolean checkIfGoalIsMeet(String goal, List<String>kb) {
		
		HAS_RULE_BEEN_MEET = new boolean[RULES_AS_ARRAY.length];
		int index = 1;
		
		while (index <= kb.size()) {
			List<String> l = kb.subList(0, index);
			
			kb.addAll(IntStream.range(0, RULES_AS_ARRAY.length)
				.filter(i -> !HAS_RULE_BEEN_MEET[i] && Arrays.stream(RULES_AS_ARRAY[i].req).allMatch(l::contains))
				.peek(this::markAsMeeted)
				.mapToObj(i -> RULES_AS_ARRAY[i].res)
				.filter(s -> !kb.contains(s))
				.distinct()
				.toList());
			
			index++;
		}
		
		return goal.equals(kb.get(kb.size()-1));
		
	}
	
	private void markAsMeeted(int ruleID) {
		HAS_RULE_BEEN_MEET[ruleID] = true;
	}

}
