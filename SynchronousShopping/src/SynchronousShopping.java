import java.util.*;

public class SynchronousShopping {
    static class Node {
        int label, time, status;

        public Node(int label, int time, int status) {
            this.label = label;
            this.time = time;
            this.status = status;
        }
    }

    private static int minTime(int n, int k, int[] sale, List<List<Node>> graph) {
        int[][] time = new int[1 << k][n];
        for (int[] t : time) Arrays.fill(t, Integer.MAX_VALUE);
        PriorityQueue<Node> minHeap = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node n1, Node n2) {
                return n1.time - n2.time;
            }
        });
        minHeap.offer(new Node(0, 0, sale[0]));
        time[sale[0]][0] = 0;
        List<Node> candidates = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            Node cur = minHeap.poll();
            if (cur.label == n - 1) candidates.add(cur);
            for (Node node : graph.get(cur.label)) {
                int newStatus = (cur.status | sale[node.label]);
                if (cur.time + node.time < time[newStatus][node.label]) {
                    time[newStatus][node.label] = cur.time + node.time;
                    minHeap.offer(new Node(node.label, cur.time + node.time, newStatus));
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < candidates.size(); i++) {
            Node cur = candidates.get(i);
            for (int j = i; j < candidates.size(); j++) {
                Node another = candidates.get(j);
                if ((cur.status | another.status) == (1 << k) - 1) {
                    min = Math.min(min, Math.max(cur.time, another.time));
                }
            }
        }
        return min;
    }

    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        String nmk = SCANNER.nextLine();
        String[] nmkVals = nmk.split(" ");
        int n = Integer.valueOf(nmkVals[0]), m = Integer.valueOf(nmkVals[1]), k = Integer.valueOf(nmkVals[2]);

        int[] sale = new int[n];
        for (int i = 0; i < n; i++) {
            String items = SCANNER.nextLine();
            String[] types = items.split(" ");
            for (int j = 1; j < types.length; j++) {
                sale[i] |= (1 << (Integer.valueOf(types[j]) - 1));
            }
        }

        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        for (int i = 0; i < m; i++) {
            String edge = SCANNER.nextLine();
            String[] detail = edge.split(" ");
            int n1 = Integer.valueOf(detail[0]) - 1, n2 = Integer.valueOf(detail[1]) - 1, t = Integer.valueOf(detail[2]);
            graph.get(n1).add(new Node(n2, t, 0));
            graph.get(n2).add(new Node(n1, t, 0));
        }

        System.out.print(minTime(n, k, sale, graph));
    }
}