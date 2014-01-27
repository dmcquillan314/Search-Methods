import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.search.methods.node.Node;
import com.search.methods.node.Path;
import com.search.methods.queue.AStarQueueFunction;
import com.search.methods.queue.BredthFirstQueueFunction;
import com.search.methods.queue.DepthFirstQueueFunction;
import com.search.methods.queue.GreedyQueueFunction;
import com.search.methods.queue.HeuristicQueueFunction;
import com.search.methods.search.Search;

public class Main {

	private final static String LINE_REGEX = "([A-Z]):([0-9]+):([A-Z])\\s*=\\s*\\[(.*)\\]";
	private final static String PATH_REGEX = "([A-Z]):(\\d+),?";
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {

		//File file = new File("testOtherTree.txt");
		//File file = new File("Testtree.txt");
		File file = new File("Testtree.txt");
		Map<String,String> pathMappings = new HashMap<String,String>();
		List<Node> nodes = new ArrayList<Node>();
		
		try {
			Scanner scanner = new Scanner(file);
			
			while(scanner.hasNext()) {
				final String line = scanner.next();
				
				Pattern pattern = Pattern.compile(LINE_REGEX, Pattern.CASE_INSENSITIVE);
				Matcher matcher = pattern.matcher(line);
				
				if( matcher.matches() ) {
					final String nodeName = matcher.group(1);
					final Integer nodesFromGoal = Integer.parseInt(matcher.group(2));
					final String goalString = matcher.group(3);
					final Boolean isGoal = goalString.equalsIgnoreCase("G");
					
					final String mappings = matcher.group(4);
					pathMappings.put(nodeName, mappings);
					
					Node node = new Node(nodeName, nodesFromGoal, isGoal);
					nodes.add(node);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		generatePathMappings( nodes, pathMappings );
		
		Node rootNode = getRootNode(nodes);
		
		System.out.println("Depth First Search");
		Node depthFirstResult = Search.search(rootNode, new DepthFirstQueueFunction());
		System.out.println( depthFirstResult );
		System.out.println("Breadth First Search");
		Node breadthFirstResult = Search.search(rootNode, new BredthFirstQueueFunction());
		System.out.println( breadthFirstResult );
		System.out.println("Greedy Search [h(n)]");
		Node greedyResult = Search.search(rootNode, new GreedyQueueFunction());
		System.out.println( greedyResult );
		System.out.println("Heuristic Search [g(n)]");
		Node heuristicResult = Search.search(rootNode, new HeuristicQueueFunction());
		System.out.println( heuristicResult );
		System.out.println("A*/A Search [f(n)]");
		Node aStarResult = Search.search(rootNode, new AStarQueueFunction());
		System.out.println( aStarResult );
	}

	private static void generatePathMappings(List<Node> nodes, Map<String, String> pathMappings) {
				
		for( final String key : pathMappings.keySet() ) {
			final Node node = getNodeForName( nodes, key );
			final String mappings = pathMappings.get(key);
			
			Pattern pattern = Pattern.compile(PATH_REGEX, Pattern.CASE_INSENSITIVE);
			Matcher matcher = pattern.matcher(mappings);
			
			while (matcher.find()) {
				Path path = new Path();
				final Node destNode = getNodeForName( nodes, matcher.group(1) );
				final Integer weight = Integer.parseInt( matcher.group(2) );
				path.setOrigNode(node);
				path.setDestNode(destNode);
				path.setWeight(weight);
				
				destNode.setInPath(path);
				node.getOutPaths().add(path);
			}		
		}
	}
	
	private static Node getRootNode( final List<Node> nodes ) {
		for( final Node node : nodes ) {
			if( node.getInPath() == null ) {
				return node;
			}
		}
		
		return null;
	}
	
	private static Node getNodeForName( final List<Node> nodes, final String name ) {
		for( final Node node : nodes ) {
			if( node.getName().equals( name ) ) {
				return node;
			}
		}
		
		return null;
	}

}
