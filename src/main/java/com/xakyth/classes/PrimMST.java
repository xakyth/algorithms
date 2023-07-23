package com.xakyth.classes;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

import com.xakyth.util.Edge;

public class PrimMST {
    public static int f(String filename) throws Exception {
        return search(initGraph(filename));
    }

    public static int search(ArrayList<ArrayList<Edge>> graph) {
        int totalCost = 0;
        if (graph.isEmpty()) 
            return 0;
        boolean[] explored = new boolean[graph.size()];
        explored[0] = true;
        PriorityQueue<Edge> pq = new PriorityQueue<>(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return Integer.compare(o1.weight, o2.weight);
            }
        });

        for (Edge e : graph.get(0)) {
            pq.offer(e);
        }
        while (!pq.isEmpty()) {
            Edge e = pq.poll();
            if (explored[e.vertex])
                continue;
            explored[e.vertex] = true;
            totalCost += e.weight;
            ArrayList<Edge> neighbours = graph.get(e.vertex);
            for (Edge neighbour : neighbours) {
                pq.offer(neighbour);
            }
        }
        return totalCost;
    }

    public static ArrayList<ArrayList<Edge>> initGraph(String filename) throws IOException {
        ArrayList<ArrayList<Edge>> result = new ArrayList<>();

        String filepath = System.getProperty("user.dir");
        String sep = System.getProperty("file.separator");
        filepath += sep + "src" + sep + "test" + sep + filename;
        List<String> lines = Files.readAllLines(Paths.get(filepath), Charset.forName("utf-8"));
        int n = Integer.parseInt(lines.get(0).split(" ")[0]);
        int m = Integer.parseInt(lines.get(0).split(" ")[1]);
        
        //initializing empty graph with n vertices
        for (int i = 0; i < n; i++) {
            result.add(new ArrayList<>());
        }

        for (int i = 1; i < lines.size(); i++) {
            String[] temp = lines.get(i).split(" ");
            int v1 = Integer.parseInt(temp[0])-1;
            int v2 = Integer.parseInt(temp[1])-1;
            int cost = Integer.parseInt(temp[2]);
            result.get(v1).add(new Edge(v2, cost));
            result.get(v2).add(new Edge(v1, cost));
        }
        
        return result;
    }
}
