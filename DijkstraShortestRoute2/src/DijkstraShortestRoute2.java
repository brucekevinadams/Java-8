import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Scanner;

public class DijkstraShortestRoute2 {

	private static class Node implements Comparable<Node> {
		final int id;
		int distance = Integer.MAX_VALUE;
		final Map<Node, Integer> linkedNodes = new HashMap<>();

		private Node(int id) {
			this.id = id;
		}

		/**
		 * Links the input node to this node by adding it to linkedNodes list.
		 */
		private void addLinkedNode(Node node, Integer distance) {
			linkedNodes.put(node, distance);
		}

		@Override
		public int compareTo(Node o) {
			return this.distance - o.distance;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + id;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Node other = (Node) obj;
			if (id != other.id)
				return false;
			return true;
		}
	}

	/**
	 * Updates distances of nodes in input array with the distance from input source
	 * node.
	 */
	private static void updateNodeDistances(Node[] graphNodes, int source) {
		// Create priority queue instance and add all the graphNodes to priority queue.
		// Since compareTo of nodes
		// is based on distance, it will order graph nodes in increasing order of
		// distances
		final PriorityQueue<Node> pQ = new PriorityQueue<>();
		pQ.addAll(Arrays.asList(graphNodes));

		// Since distance of sourceNode from sourceNode is 0, we will need to update the
		// distance of sourceNode to 0
		// as initially distance of all nodes are set to max integer value.
		final Node sourceNode = graphNodes[source];
		// Since Java implementation of priority queue doesn't allow mechanism to update
		// the priority once it is added.
		// Moreover it becomes unstable if attributes used in compareTo are changed
		// after addition.
		// In order to work this, we remove sourceNode, update distance and then
		// re-insert it.
		pQ.remove(sourceNode); // This requires id based equals implementation in Node structure
		sourceNode.distance = 0;
		pQ.add(sourceNode);

		while (!pQ.isEmpty()) {
			final Node node = pQ.poll();
			// For each of linkedNodes of this node
			for (Entry<Node, Integer> linkedNodeEntry : node.linkedNodes.entrySet()) {
				final Node linkedNode = linkedNodeEntry.getKey();
				final int linkedNodeEdgeWeight = linkedNodeEntry.getValue();

				// calculated distance of linked node from source node will be addition of
				// distance of this node from
				// source and weight of edge between this node and linked node
				int targetDistance = node.distance + linkedNodeEdgeWeight;
				if (!(node.distance == Integer.MAX_VALUE) && targetDistance < linkedNode.distance) {
					// If target calculated distance is less than linkedNode's current distance, we
					// need to update this
					// linked node's priority so we do same ritual of removing, updating and
					// re-inserting!
					pQ.remove(linkedNode);
					linkedNode.distance = targetDistance;
					pQ.offer(linkedNode);
				}
			}
		}

	}

	public static void main(String[] args) {
		final Scanner in = new Scanner(System.in);

		int T = in.nextInt();
		// For each test case
		while (T-- > 0) {
			final int N = in.nextInt();
			final int M = in.nextInt();

			final Node[] graphNodes = new Node[N];
			for (int j = 0; j < M; j++) {
				// Subtract 1 out of first node id to fit this into our graph elements as array
				// index starts with 0
				final int x = in.nextInt() - 1;
				// If node is present in array, fetch it, otherwise create a new instance of
				// Node and put in array
				Node xNode = graphNodes[x];
				if (xNode == null) {
					xNode = new Node(x);
					graphNodes[x] = xNode;
				}

				// Subtract 1 out of second node id to fit this into our graph elements as array
				// index starts with 0
				final int y = in.nextInt() - 1;
				// If node is present in array, fetch it, otherwise create a new instance of
				// Node and put in array
				Node yNode = graphNodes[y];
				if (yNode == null) {
					yNode = new Node(y);
					graphNodes[y] = yNode;
				}

				final int r = in.nextInt();
				// Since there could be multiple edges between two nodes, we will just keep the
				// smallest one
				if (xNode.linkedNodes.get(yNode) == null || xNode.linkedNodes.get(yNode) > r) {
					// Since graph is undirected, we set both nodes into each other's linked nodes
					// to have a bi-directional mapping
					xNode.addLinkedNode(yNode, r);
					yNode.addLinkedNode(xNode, r);
				}
			}

			// Subtract 1 out of start node id to fit this into our graph elements as array
			// index starts with 0
			final int S = in.nextInt() - 1;
			updateNodeDistances(graphNodes, S);
			for (Node node : graphNodes) {
				if (node.distance != 0) {
					System.out.print((node.distance == Integer.MAX_VALUE ? -1 : node.distance) + " ");
				}
			}
			System.out.println();

		}

		in.close();
	}
}

