import java.util.*;

class classplus {
	class vertex {
		int val;
		int time;

		vertex(int val, int time) {
			this.val = val;
			this.time = time;
		}
	}

	Map<Integer, Set<vertex>> adjList;
	Map<Integer, Map<Integer, Integer>> demonTime;
	Map<Integer, int[]> demonArray;
	int min;

	classplus() {
		adjList = new HashMap<>(); // Adjecency List
		demonTime = new HashMap<>(); // contains all time-stamp with its index position in demonArray for each node
		demonArray = new HashMap<>(); // contains all time-stamp in form of sorted array
		min = Integer.MAX_VALUE; // minimum value to reach destination planet
	}

	public int getVaccine(int dest) {
		// dfs(1,dest,0,new int[dest+1]);
		modifiedDijkstra(1, dest);

		if (min != Integer.MAX_VALUE)
			return min;
		else
			return -1;
	}

	// time complexity -> number of edges * log(number of nodes), space complexity
	// -> number of nodes
	void modifiedDijkstra(int src, int dest) {

		int dist[] = new int[dest + 1];
		for (int i = 2; i <= dest; i++)
			dist[i] = Integer.MAX_VALUE;

		PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> Integer.compare(dist[x], dist[y]));

		pq.add(1);

		while (!pq.isEmpty()) {
			int u = pq.poll();
			if (!adjList.containsKey(u))
				continue;
			for (vertex v : adjList.get(u)) {

				if (dist[v.val] > dist[u] + v.time) {
					int dTime = 0;
					if (demonTime.get(v.val).containsKey(dist[u] + v.time)) {
						dTime = getTime(demonTime.get(v.val).get(dist[u] + v.time), demonArray.get(v.val));
					}
					dist[v.val] = dist[u] + v.time + dTime;
					pq.add(v.val);
				}
			}

		}
		min = dist[dest];

	}

	// time complexity-> O(1), space complexity-> O(1)
	private int getTime(int idx, int[] arr) {

		if (idx < arr.length - 1) {
			return arr[idx + 1] - arr[idx];
		} else
			return 0;
	}

}

public class Main {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		classplus cp = new classplus();
		int n = sc.nextInt();
		int m = sc.nextInt();
		for (int i = 0; i < m; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			int t = sc.nextInt();

			cp.adjList.putIfAbsent(u, new HashSet<>());
			cp.adjList.get(u).add(cp.new vertex(v, t));

		}

		for (int i = 0; i < m; i++) {
			int k = sc.nextInt();
			int j = 0;
			cp.demonTime.put(i + 1, new HashMap<>());
			cp.demonArray.put(i + 1, new int[k]);
			while (k-- > 0) {
				int tStamp = sc.nextInt();
				cp.demonTime.get(i + 1).put(tStamp, j);
				cp.demonArray.get(i + 1)[j] = tStamp;
				j++;
			}
		}

		System.out.println(cp.getVaccine(n));
		sc.close();

	}

}


