package com.search.methods.queue;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.search.methods.node.Node;

public class DepthFirstQueueFunction implements QueueFunction {

	@Override
	public Queue<Node> sort(Queue<Node> queue, List<Node> nodes) {
		Queue<Node> toReturn = new LinkedList<Node>();
		toReturn.addAll(nodes);
		toReturn.addAll(queue);
		return toReturn;
	}
	
}
