package com.search.methods.queue.comparators;

import com.search.methods.node.Node;

public class AStarComparator extends HeuristicComparator {

	@Override
	public int compare(Node left, Node right) {
		int result = Integer.compare(getHeightOfNode(left) + left.getNodesFromGoal(), getHeightOfNode(right) + right.getNodesFromGoal());
		if( result == 0 ) {
			return left.getName().compareTo(right.getName());
		}
		return result;
	}
}
