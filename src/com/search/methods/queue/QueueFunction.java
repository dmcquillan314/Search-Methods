package com.search.methods.queue;

import java.util.List;
import java.util.Queue;

import com.search.methods.node.Node;

public interface QueueFunction {
	public Queue<Node> sort(Queue<Node> queue, List<Node> nodes );
}
