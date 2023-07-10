package com.xakyth.classes;

import java.util.Collection;
import java.util.Iterator;
import java.util.TreeSet;

public class MedianMaintenanceBST {
    private TreeSet<Integer> tree;

    public MedianMaintenanceBST() {
        this.tree = new TreeSet<>();
    }

    public MedianMaintenanceBST(Collection<Integer> collection) {
        this.tree = new TreeSet<>(collection);
    }

    public void add(Integer i) {
        tree.add(i);
    }

    public Integer getMedian() {
        Iterator<Integer> treeIterator = tree.iterator();
        int median = 0;
        for (int i = 0; i < (tree.size() + 1) / 2; i++) {
            median = treeIterator.next();
        }
        return median;
    }

}
