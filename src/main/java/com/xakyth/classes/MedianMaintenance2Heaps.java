package com.xakyth.classes;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

public class MedianMaintenance2Heaps {
    private PriorityQueue<Integer> leftHeap;
    private PriorityQueue<Integer> rightHeap;
    
    public MedianMaintenance2Heaps() {
        this.leftHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o2, o1);
            }
        });
        this.rightHeap = new PriorityQueue<>();
    }

    public MedianMaintenance2Heaps(Collection<Integer> collection) {
        int colSize = collection.size();
        Iterator<Integer> iterator = collection.iterator();
        this.leftHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o2, o1);
            }
        });
        this.rightHeap = new PriorityQueue<>();
        for (int i = 0; i < colSize; i++) {
            if (i < colSize / 2) {
                leftHeap.add(iterator.next());
            } else {
                rightHeap.add(iterator.next());
            }
        }
    }

    public void add(Integer i) {
        if (leftHeap.size() == 0 && rightHeap.size() == 0) {
            leftHeap.offer(i);
        }
        if (leftHeap.peek() != null && leftHeap.peek() >= i) {
            leftHeap.offer(i);
        } else {
            rightHeap.offer(i);
        }
        int diff = leftHeap.size() - rightHeap.size();
        if (diff > 1) {
            Integer temp = leftHeap.poll();
            rightHeap.offer(temp);
        } else if (diff < -1) {
            Integer temp = rightHeap.poll();
            leftHeap.offer(temp);
        }
    }

    public Integer getMedian() {
        int diff = leftHeap.size() - rightHeap.size();
        if (diff == 0) {
            return leftHeap.peek();
        } else if (diff == 1) {
            return leftHeap.peek();
        } else if (diff == -1) {
            return rightHeap.peek();
        }
        return null;
    }
    
    

}
