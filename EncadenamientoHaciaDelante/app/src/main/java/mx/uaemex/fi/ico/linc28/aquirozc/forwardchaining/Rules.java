package mx.uaemex.fi.ico.linc28.aquirozc.forwardchaining;

public enum Rules {
	
	R1("H4", new String[] {"H8","H6","H5"}),
	R2("H9", new String[] {"H6","H3"}),
	R3("H9", new String[] {"H7","H4"}),
	R4("H1", new String[] {"H8"}),
	R5("H5", new String[] {"H6"}),
	R6("H2", new String[] {"H1","H9"}),
	R7("H6", new String[] {"H7"}),
	R8("H9", new String[] {"H1","H7"}),
	R9("H6", new String[] {"H1","H8"});
	
	
	final String[] req;
	final String res;
	
	private Rules(String res, String[] req) {
		this.res = res;
		this.req = req;
	}

}
