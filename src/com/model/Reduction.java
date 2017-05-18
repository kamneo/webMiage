package com.model;
import java.util.HashMap;

public class Reduction {
	private HashMap<String, Float> reducs;
	
	public Reduction(HashMap<String, Float> reductions){
		this.setTarif(reductions);
	}

	private void setTarif(HashMap<String, Float> reductions2) {
		this.reducs = reductions2;
	}

	public HashMap<String, Float> getTarif(){
		return reducs;
	}
	
}
