package com.search.methods.queue;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.search.methods.node.Node;

public class GreedyQueueFunction implements QueueFunction {

	@Override
	public Queue<Node> sort(Queue<Node> queue, List<Node> nodes) {
		Queue<Node> toReturn = new LinkedList<Node>();
		
		nodes.addAll( queue );
		Collections.sort(nodes, new GreedyComparator() );
		
		toReturn.addAll(nodes);
		return toReturn;
	}
	
	private class GreedyComparator implements Comparator<Node> {

		@Override
		public int compare(Node left, Node right) {
			return Integer.compare(left.getNodesFromGoal(), right.getNodesFromGoal());
		}
		
	}
}
