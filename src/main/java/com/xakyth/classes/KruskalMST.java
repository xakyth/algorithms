package com.xakyth.classes;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

import org.jgrapht.alg.util.UnionFind;

import com.xakyth.util.Edge;

public class KruskalMST {
    
    public static int search(ArrayList<ArrayList<Edge>> graph) {
        int totalCost = 0;
        class CustEdge {
            int v1;
            int v2;
            int cost;
            CustEdge(int v1, int v2, int cost) {
                this.v1 = v1;
                this.v2 = v2;
                this.cost = cost;
            }
        }
        ArrayList<CustEdge> sortedEdges = new ArrayList<>();
        for (int i = 0; i < graph.size(); i++) {
            ArrayList<Edge> incident = graph.get(i);
            for (int j = 0; j < incident.size(); j++) {
                Edge e = incident.get(j);
                sortedEdges.add(new CustEdge(i, e.vertex, e.weight));
            }
        }
        sortedEdges.sort(new Comparator<CustEdge>() {
            public int compare(CustEdge o1, CustEdge o2) {
                return Integer.compare(o1.cost, o2.cost);
            };
        });
        int n = graph.size();
        int mstEdgesCnt = 0;
        HashSet<Integer> tempSet = new HashSet<>(n);
        for (int i = 0; i < n; i++) {
            tempSet.add(i);
        }

        UnionFind<Integer> unionFind = new UnionFind<>(tempSet);
        for (int i = 0; i < sortedEdges.size(); i++) {
            CustEdge e = sortedEdges.get(i);
            if (unionFind.find(e.v1) != unionFind.find(e.v2)) {
                totalCost += e.cost;
                unionFind.union(e.v1, e.v2);
                mstEdgesCnt++;
                if (mstEdgesCnt == n - 1)
                    break;
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
