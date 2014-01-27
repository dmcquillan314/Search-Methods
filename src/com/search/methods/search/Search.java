package com.search.methods.search;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.search.methods.node.Node;
import com.search.methods.node.Path;
import com.search.methods.queue.QueueFunction;

public class Search {
	public static Node search( final Node problem, final QueueFunction queueFunction ) {
		
		if( problem == null ) {
			throw new IllegalArgumentException( "problem must not be null" );
		}
		
		if( queueFunction == null ) {
			throw new IllegalArgumentException("queue function must not be null");
		}
		
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(problem);
		Node node = null;
		
		System.out.println("--------------------------");
		System.out.println("n\tq");
		
		while( ! queue.isEmpty() ) {
			StringBuilder stringBuilder = new StringBuilder();
			
			Iterator<Node> it = queue.iterator();
			stringBuilder.append("(");
			while( it.hasNext() ) {
				Node nodeIt = it.next();
				stringBuilder.append(nodeIt.getName());
				if( it.hasNext() ) {
					stringBuilder.append(",");
				}
			}
			stringBuilder.append(")");
			System.out.println((node == null ? "-" : node.getName()) + "\t" + stringBuilder.toString());
			
			node = queue.remove();
			
			if( node.isGoal() ) {
				return node;
			}
			
			queue = queueFunction.sort(queue, expand( node ) );
		}
		
		System.out.println("--------------------------");

		return null;
		
	}
	
	public static List<Node> expand( final Node node ) {
		
		final List<Path> paths = node.getOutPaths();
		List<Node> nodes = new ArrayList<Node>();
		
		for(Path path : paths ) {
			nodes.add(path.getDestNode() );
		}
		
		return nodes;
	}

}
