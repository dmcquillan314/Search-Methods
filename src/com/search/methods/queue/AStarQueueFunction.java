package com.search.methods.queue;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.search.methods.node.Node;
import com.search.methods.queue.comparators.AStarComparator;

public class AStarQueueFunction implements QueueFunction {

	@Override
	public Queue<Node> sort(Queue<Node> queue, List<Node> nodes) {
		Queue<Node> toReturn = new LinkedList<Node>();
		
		nodes.addAll( queue );
		Collections.sort(nodes, new AStarComparator() );
		
		toReturn.addAll(nodes);
		return toReturn;
	}

}
