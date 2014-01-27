package com.search.methods.node;

public class Path {
	Integer weight;
	Node destNode;
	Node origNode;
	
	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public void setDestNode(Node destNode) {
		this.destNode = destNode;
	}

	public void setOrigNode(Node origNode) {
		this.origNode = origNode;
	}

	public Integer getWeight() {
		return weight;
	}

	public Node getDestNode() {
		return destNode;
	}

	public Node getOrigNode() {
		return origNode;
	}
}
