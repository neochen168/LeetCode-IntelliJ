package com.leetcode.src;

import java.util.*;


class Building {
    int left;
    int right;
    int height;

    public Building(int x, int y, int h) {
        left = x;
        right = y;
        height = h;
    }

    public static Comparator<Building> bldComparator = new Comparator<Building>(){
        public int compare(Building b1, Building b2) {
            if (b1.right > b2.right)
                return 1;
            else if (b1.right < b2.right)
                return -1;
            else
                return 0;
        }
    };

    public static Comparator<Building> ascComparator = new Comparator<Building>() {
        public int compare(Building b1, Building b2) {
            if(b1.left > b2.left) return 1;
            else if(b1.left < b2.left) return -1;
            else if(b1.height > b2.height) return 1;
            else if(b1.height < b2.height) return -1;
            else return 0;
        }

    };
}



public class SkyLineSolution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        ArrayList<Building> sortedStart = new ArrayList<Building>();
        ArrayList<Building> sortedEnd = new ArrayList<Building>();
        for (int i = 0; i < buildings.length; i++) {
            sortedStart.add(new Building(buildings[i][0], buildings[i][1], buildings[i][2]));
            sortedEnd.add(new Building(buildings[i][0], buildings[i][1], buildings[i][2]));
        }

        Collections.sort(sortedStart, Building.ascComparator);
        Collections.sort(sortedEnd, Building.bldComparator);

        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(new MaxHeapComparator());
        ArrayList<List<Integer>> ret = new ArrayList<List<Integer>>();
        for (int i = 0, j = 0; j < sortedEnd.size() || i < sortedStart.size();) {
            Building rightMost = sortedEnd.get(j);
            if(i < sortedStart.size() && sortedStart.get(i).left <= rightMost.right){
                Building current = sortedStart.get(i);
                maxHeap.add(current.height);
                i++;
                List<Integer> l = new ArrayList<Integer>();
                l.add(current.left);
                l.add(maxHeap.peek());
                ret.add(l);
            }else{
                if(!maxHeap.isEmpty()) {
                        maxHeap.remove(rightMost.height);
                        List<Integer> l = new ArrayList<Integer>();
                        l.add(rightMost.right);
                        l.add(maxHeap.isEmpty() ? 0 : maxHeap.peek());
                        ret.add(l);
                }else{
                    List<Integer> l = new ArrayList<Integer>();
                    l.add(rightMost.right);
                    l.add(0);
                    ret.add(l);
                }

                j++;
            }
        }

        Collections.sort(ret, new BuildingListComparator());
        for(int i = 1 ; i < ret.size(); i++){
            if(Integer.compare(ret.get(i).get(1), ret.get(i-1).get(1)) == 0){
                ret.remove(i);
                i--;
            }else if(ret.get(i).get(1) > ret.get(i-1).get(1) && Integer.compare(ret.get(i).get(0), ret.get(i-1).get(0)) == 0){
                ret.remove(i-1);
                i--;
            }else if(Integer.compare(ret.get(i).get(1), ret.get(i-1).get(1))< 0 && Integer.compare(ret.get(i).get(0), ret.get(i-1).get(0)) == 0){
                ret.remove(i-1);
                i--;
            }
        }

        return ret;
    }


    // This function is not bug free, still need to debug
    public List<List<Integer>> getSkyline2(int[][] buildings) {
        ArrayList<Building> sortedStart = new ArrayList<Building>();
        ArrayList<Building> sortedEnd = new ArrayList<Building>();
        for (int i = 0; i < buildings.length; i++) {
            sortedStart.add(new Building(buildings[i][0], buildings[i][1], buildings[i][2]));
            sortedEnd.add(new Building(buildings[i][0], buildings[i][1], buildings[i][2]));
        }

        Collections.sort(sortedStart, Building.ascComparator);
        Collections.sort(sortedEnd, Building.bldComparator);

        PriorityQueue<Building> maxHeap = new PriorityQueue<Building>(new BuildingMaxHeapComparator());
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        Building currentSky = new Building(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        for (int i = 0, j = 0; j < sortedEnd.size() || i < sortedStart.size();) {
            Building rightMost = sortedEnd.get(j);
            if(i < sortedStart.size() && sortedStart.get(i).left <= rightMost.right){
                Building current = sortedStart.get(i);
                maxHeap.add(current);
                i++;
                List<Integer> l = new ArrayList<Integer>();
                l.add(current.left);
                l.add(maxHeap.peek().height);
                ret.add(l);
            }else{
                if(!maxHeap.isEmpty()) {
                    if(maxHeap.peek().right >= currentSky.left && maxHeap.peek().right < currentSky.right){
                        maxHeap.remove();
                        j--;
                    }else {
                        Building pre = maxHeap.peek();
                        maxHeap.remove();
                        List<Integer> l = new ArrayList<Integer>();
                        l.add(rightMost.right);
                        l.add(maxHeap.isEmpty() ? 0 : maxHeap.peek().height);
                        ret.add(l);
                        currentSky.left = Math.min(pre.left, currentSky.left);
                        currentSky.right = Math.max(rightMost.right, currentSky.right);
                    }
                }else{
                    List<Integer> l = new ArrayList<Integer>();
                    l.add(rightMost.right);
                    l.add(0);
                    currentSky = new Building(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
                    ret.add(l);
                }

                j++;
            }
        }

        Collections.sort(ret, new BuildingListComparator());
        for(int i = 1 ; i < ret.size(); i++){
            if(Integer.compare(ret.get(i).get(1), ret.get(i-1).get(1)) == 0){
                ret.remove(i);
                i--;
            }else if(ret.get(i).get(1) > ret.get(i-1).get(1) && Integer.compare(ret.get(i).get(0), ret.get(i-1).get(0)) == 0){
                ret.remove(i-1);
                i--;
            }else if(Integer.compare(ret.get(i).get(1), ret.get(i-1).get(1))< 0 && Integer.compare(ret.get(i).get(0), ret.get(i-1).get(0)) == 0){
                ret.remove(i-1);
                i--;
            }
        }

        return ret;
    }
}

class MaxHeapComparator implements Comparator<Integer> {
    public int compare(Integer i1, Integer i2){
        return Integer.compare(i2, i1);
    }
}

class BuildingListComparator implements Comparator<List<Integer>> {
    public int compare(List<Integer> l1, List<Integer> l2) {
        if(l1.get(0) < l2.get(0)) return -1;
        else if(l1.get(0) > l2.get(0)) return 1;
        else return 0;
    }
}

class BuildingMaxHeapComparator implements Comparator<Building> {
    public int compare(Building b1, Building b2) {
        if (b1.height > b2.height)
            return -1;
        else if (b1.height < b2.height)
            return 1;
        else
            return 0;
    }
}