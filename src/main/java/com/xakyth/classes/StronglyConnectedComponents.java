package com.xakyth.classes;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class StronglyConnectedComponents {

    public static String computeSCC(String inputFile) throws Exception {
        String filepath = System.getProperty("user.dir");
        String sep = System.getProperty("file.separator");
        filepath += sep + "src" + sep + "test" + sep + inputFile;
        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
        HashMap<Integer, ArrayList<Integer>> graphReversed = new HashMap<>();
        
        List<String> lines = Files.readAllLines(Paths.get(filepath), Charset.forName("utf-8"));
        for (String line : lines) {
            String[] temp = line.trim().split(" ");
            int u = Integer.parseInt(temp[0]);
            int w = Integer.parseInt(temp[1]);
            ArrayList<Integer> incident = graph.get(u);
            ArrayList<Integer> incidentReversed = graphReversed.get(w);
            if (incident == null) {
                incident = new ArrayList<>();
            }
            if (incidentReversed == null) {
                incidentReversed = new ArrayList<>();
            }
            incident.add(w);
            incidentReversed.add(u);
            graph.put(u, incident);
            graphReversed.put(w, incidentReversed);
        }

        ArrayList<Integer> sorted = topoSort(graphReversed);
        HashSet<Integer> visited = new HashSet<>();
        ArrayList<ArrayList<Integer>> scc = new ArrayList<>();
        for (int i = sorted.size()-1; i >= 0; i--) {
            if (!visited.contains(sorted.get(i))) {
                ArrayList<Integer> curSCC = new ArrayList<>();
                dfs(sorted.get(i), graph, visited, curSCC);
                scc.add(curSCC);
            }
        }
        for (int i = 0; i < scc.size(); i++) {
            System.out.println(String.format("%d : %s", i+1, scc.get(i).toString()));
        }
        scc.sort(new Comparator<ArrayList<Integer>>() {
            public int compare(ArrayList<Integer> al1, ArrayList<Integer> al2) {
                return al1.size() < al2.size() ? 1 : -1;
            };
        });

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            if (i >= scc.size()) {
                result.append("0,");
            } else {
                result.append(scc.get(i).size() + ",");
            }
        }

        return result.substring(0, result.length()-1);
    }   

    public static ArrayList<Integer> topoSort(HashMap<Integer, ArrayList<Integer>> graph) {
        HashSet<Integer> visited = new HashSet<>();
        ArrayList<Integer> sorted = new ArrayList<>();
        for (Integer v : graph.keySet()) {
            if (visited.contains(v))
                continue;
            dfsTopo(v, graph, visited, sorted);
        }
        return sorted;
    }

    public static void dfsTopo(int vertex, HashMap<Integer, ArrayList<Integer>> graph, HashSet<Integer> visited, ArrayList<Integer> sorted) {
        visited.add(vertex);
        ArrayList<Integer> incident = graph.get(vertex);
        if (incident != null) {
            for (Integer w : incident) {
                if (visited.contains(w))
                    continue;
                dfsTopo(w, graph, visited, sorted);
            }
        }
        sorted.add(vertex);
    }

    public static void dfs(int vertex, HashMap<Integer, ArrayList<Integer>> graph, HashSet<Integer> visited, ArrayList<Integer> scc) {
        visited.add(vertex);
        scc.add(vertex);
        ArrayList<Integer> incident = graph.get(vertex);
        if (incident != null) {
            for (Integer w : incident) {
                if (visited.contains(w))
                    continue;
                dfs(w, graph, visited, scc);
            }
        }
    }
}
