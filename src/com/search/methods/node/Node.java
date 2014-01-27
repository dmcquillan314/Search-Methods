package com.search.methods.node;

import java.util.ArrayList;
import java.util.List;

public class Node {
	Integer nodesFromGoal = 0;
	Path inPath = null;
	List<Path> outPaths = new ArrayList<Path>();
	Boolean isGoal;
	String name;
	
	public Node( final String name, final Integer nodesFromGoal, final Boolean isGoal ) {
		this.name = name;
		this.nodesFromGoal = nodesFromGoal;
		this.isGoal = isGoal;
	}
	
	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("Name: " + name + "\n");
		stringBuilder.append("isGoal: " + isGoal);
		return stringBuilder.toString();
	}

	public Integer getNodesFromGoal() {
		return nodesFromGoal;
	}

	public Path getInPath() {
		return inPath;
	}

	public List<Path> getOutPaths() {
		return outPaths;
	}
	
	public Boolean isGoal() {
		return isGoal;
	}

	public String getName() {
		return name;
	}

	public void setNodesFromGoal(Integer nodesFromGoal) {
		this.nodesFromGoal = nodesFromGoal;
	}

	public void setInPath(Path inPath) {
		this.inPath = inPath;
	}

	public void setOutPaths(List<Path> outPaths) {
		this.outPaths = outPaths;
	}

	public void setIsGoal(Boolean isGoal) {
		this.isGoal = isGoal;
	}

	public void setName(String name) {
		this.name = name;
	}
}
