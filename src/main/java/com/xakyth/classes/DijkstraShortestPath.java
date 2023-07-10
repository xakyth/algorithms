package com.xakyth.classes;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;

import com.xakyth.util.Pair;

public class DijkstraShortestPath {
    
    public static HashMap<Integer, ArrayList<Pair<Integer, Long>>> initGraphFromFile(String filename) throws Exception {
        HashMap<Integer, ArrayList<Pair<Integer, Long>>> result = new HashMap<>();

        String filepath = System.getProperty("user.dir");
        String sep = System.getProperty("file.separator");
        filepath += sep + "src" + sep + "test" + sep + filename;
        
        List<String> lines = Files.readAllLines(Paths.get(filepath), Charset.forName("utf-8"));
        for (String line : lines) {
            Integer vertex = Integer.parseInt(line.substring(0, line.indexOf("\t")));
            ArrayList<Pair<Integer, Long>> incident = new ArrayList<>();
            String[] edges = line.substring(line.indexOf("\t")+1).split("\\s");
            for (String edge : edges) {
                String[] temp = edge.trim().split(",");
                Integer w = Integer.parseInt(temp[0]);
                Long len = Long.parseLong(temp[1]);
                incident.add(new Pair<>(w, len));
            }
            result.put(vertex, incident);
        }   

        return result;
    }

    public static String search(HashMap<Integer, ArrayList<Pair<Integer, Long>>> graph, int s) {
        HashSet<Integer> processed = new HashSet<>();
        processed.add(s);
        
        HashMap<Integer, Long> distMap = new HashMap<>();
        distMap.put(s, 0L);
        for (Integer v : graph.keySet()) {
            if (v == s) 
                continue;
            distMap.put(v, Long.MAX_VALUE);
        }
        PriorityQueue<Pair<Integer, Long>> heap = new PriorityQueue<>(new Comparator<Pair<Integer, Long>>() {
            public int compare(Pair<Integer, Long> p1, Pair<Integer, Long> p2) { 
                return Integer.compare(p1.getKey(), p2.getKey());
            };
        });

        heap.offer(new Pair<>(s, 0L));
        while (!heap.isEmpty()) {
            Pair<Integer, Long> v = heap.poll();
            ArrayList<Pair<Integer, Long>> incident = graph.get(v.getKey());
            if (incident == null)
                continue;
            Long curDist = v.getValue();
            if (curDist > distMap.get(v.getKey())) 
                continue;

            for (Pair<Integer, Long> w : incident) {
                Long newDist = curDist + w.getValue();
                if (newDist < distMap.get(w.getKey())) {
                    distMap.put(w.getKey(), newDist);
                    heap.offer(new Pair<>(w.getKey(), newDist));
                }
            }
        }

        return String.format("%d,%d,%d,%d,%d,%d,%d,%d,%d,%d", distMap.get(7), distMap.get(37), distMap.get(59), distMap.get(82), distMap.get(99),
         distMap.get(115), distMap.get(133), distMap.get(165), distMap.get(188), distMap.get(197));
    }
}
