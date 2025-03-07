package d1_algorithm.dynamicPrograming;
/*

 求解最短路径问题
求出初始点到所有顶点的最短距离
 f(to) = min(f(to),f(from)+from.weight)

*/
public class BellmanFord {
    private static class Edge {
        int from;
        int to;
        int weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {
        Edge[] edges = {
                new Edge(1, 2, 3),
                new Edge(2, 4, 5),
                new Edge(3, 4, 2),
                new Edge(1, 3, 4)
        };
        int[] dp = new int[edges.length + 1];
        dp[1] = 0;
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < edges.length - 1; i++) {
            for (Edge edge : edges) {
                if (dp[edge.from] != Integer.MAX_VALUE) {
                    dp[edge.to] = Integer.min(dp[edge.to], dp[edge.from] + edge.weight);
                }
            }
        }
        for (int i : dp) {
            System.out.print(i + " ");
        }

    }
}
