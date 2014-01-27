package com.search.methods.queue.comparators;

import java.util.Comparator;

import com.search.methods.node.Node;

public class GreedyComparator implements Comparator<Node> {

	@Override
	public int compare(Node left, Node right) {
		int result = Integer.compare(left.getNodesFromGoal(), right.getNodesFromGoal());
		if( result == 0 ) {
			return left.getName().compareTo(right.getName());
		}
		return result;
	}
	
}
