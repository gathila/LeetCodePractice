package dailychallange;

import java.util.*;

public class FindCity {

    public record Tuple(int city, int distance) {
    }

    public int findTheCity(int n, int[][] edges, Set<Tuple> set) {

        Map<Integer, Integer> vertices = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            vertices.put(edges[i][0], Integer.MAX_VALUE);
            vertices.put(edges[i][1], Integer.MAX_VALUE);
        }

        vertices.put(edges[0][0], 0);

        return 0;
    }

    int shortestPathTo(int start, int vertex, int[][] edges, Map<Integer, Integer> distanceToVertex) {

        if (start == vertex) {
            return 0;
        }

        Integer calcMinDistance = distanceToVertex.get(vertex);
        if (calcMinDistance!=null) {
            return calcMinDistance;
        }

        int minDistance = Integer.MAX_VALUE;
        for (int i=0; i<edges.length; i++) {
            if (vertex == edges[i][0] || vertex == edges[i][1]) {
                //adjecent
                int neighbor = edges[i][0] == vertex? edges[i][1] : edges[i][0];

                int distance = shortestPathTo(start, neighbor, edges, distanceToVertex) + edges[i][2];
                if (distance < minDistance) {
                    minDistance = distance;
                }
            }
        }

        distanceToVertex.put(vertex, minDistance);

        return minDistance;
    }



}
