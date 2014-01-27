package com.search.methods.queue.comparators;

import java.util.Comparator;

import com.search.methods.node.Node;

public class GreedyComparator implements Comparator<Node> {

	@Override
	public int compare(Node left, Node right) {
		return Integer.compare(left.getNodesFromGoal(), right.getNodesFromGoal());
	}
	
}
