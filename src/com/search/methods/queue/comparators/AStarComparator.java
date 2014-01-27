package com.search.methods.queue.comparators;

import com.search.methods.node.Node;

public class AStarComparator extends HeuristicComparator {

	@Override
	public int compare(Node left, Node right) {
		int result = Integer.compare(getHeightOfNode(left) + getParentNodeDistanceSum(left), getHeightOfNode(right) + getParentNodeDistanceSum(right));
		if( result == 0 ) {
			return left.getName().compareTo(right.getName());
		}
		return result;
	}
	
	public int getParentNodeDistanceSum(final Node node ) {
		if( node.getInPath() == null ) {
			return 0;
		} else {
			return node.getNodesFromGoal() + getParentNodeDistanceSum( node.getInPath().getOrigNode() );
		}
	}
}
