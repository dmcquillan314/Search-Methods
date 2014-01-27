package com.search.methods.queue;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.search.methods.node.Node;
import com.search.methods.queue.comparators.GreedyComparator;

public class GreedyQueueFunction implements QueueFunction {

	@Override
	public Queue<Node> sort(Queue<Node> queue, List<Node> nodes) {
		Queue<Node> toReturn = new LinkedList<Node>();
		
		nodes.addAll( queue );
		
		Collections.sort(nodes, new GreedyComparator() );
		
		for( Node node : nodes ) {
			toReturn.add(node);
		}
		return toReturn;
	}
	
}
