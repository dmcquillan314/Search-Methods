package com.search.methods.queue.comparators;

import com.search.methods.node.Node;

public class AStarComparator extends HeuristicComparator {

	@Override
	public int compare(Node left, Node right) {
		return Integer.compare(getHeightOfNode(left) + left.getNodesFromGoal(), getHeightOfNode(right) + right.getNodesFromGoal());
	}
}
