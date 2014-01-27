package com.search.methods.queue.comparators;

import java.util.Comparator;

import com.search.methods.node.Node;

public class HeuristicComparator implements Comparator<Node> {

	@Override
	public int compare(Node left, Node right) {
		return Integer.compare(getHeightOfNode(left), getHeightOfNode(right));
	}
	
	public int getHeightOfNode( final Node node ) {
		if( node.getInPath() == null ) {
			return 0;
		} else {
			Integer pathLength = node.getInPath().getWeight() + getHeightOfNode(node.getInPath().getOrigNode());
			//System.out.println(node.getName() + ": " + pathLength);
			return pathLength;
		}
	}
	
}

