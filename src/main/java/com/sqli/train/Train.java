package com.sqli.train;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Train {
	private   String structure;
	private List<WagonStrategy> wagonStrategies=new ArrayList<>();

	public Train(String structure) {

		this.structure=structure;

	}

	private void buildStructure(){
		String[] structureDetached = structure.split("");

		for(int counter=0;counter<structureDetached.length;counter++){
			if(structureDetached[counter].equals("H")) this.wagonStrategies.add(new Head(counter));
			if (structureDetached[counter].equals("P")) this.wagonStrategies.add(new Passeneger());
			if (structureDetached[counter].equals("R"))  this.wagonStrategies.add(new Restaurant());
			if(structureDetached[counter].equals("C")) this.wagonStrategies.add(new Cargo(true));
			if (structureDetached[counter].equals("F")) this.wagonStrategies.add(new Cargo(false));
		}

		/*Arrays.stream(structureDetached).map(wagon->{
			if(wagon.equals("H")) this.wagonStrategies.add(new Head());
			if (wagon.equals("P")) this.wagonStrategies.add(new Passeneger());
			this.wagonStrategies.add(new Restaurant());
			return null;
		});*/
	}

	public String print(){
		buildStructure();
		return this.wagonStrategies.stream()
				.map(wagon->wagon.getRepresentation())
				.collect(Collectors.joining("::"));
	}

	public void detachEnd(){
		String[] structureDetached = structure.split("");
		this.structure="";
		for (int i=0;i<structureDetached.length-1;i++){
			this.structure+=structureDetached[i];
		}
		this.wagonStrategies.clear();
/*
		this.structure=structure.replace(structureDetached[structureDetached.length-1],"");
*/
	}

	public void detachHead(){
		String[] structureDetached = structure.split("");
		this.structure=structure.replaceFirst(structureDetached[0],"");
		this.wagonStrategies.clear();

	}

	public boolean fill(){
		String oldStructure=this.structure;
		this.structure=structure.replaceFirst("C","F");
		this.wagonStrategies.clear();
		return oldStructure.equals(this.structure)?false:true;
	}
}
