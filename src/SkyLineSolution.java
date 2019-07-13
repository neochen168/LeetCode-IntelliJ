import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

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
}

class BuildingComparator implements Comparator<Building> {
    public int compare(Building b1, Building b2) {
        if (b1.height > b2.height)
            return -1;
        else if (b1.height < b2.height)
            return 1;
        else
            return 0;
    }
}

class ListComparator implements Comparator<List<Integer>> {
    public int compare(List<Integer> l1, List<Integer> l2) {
        if(l1.get(0) < l2.get(0)) return -1;
        else if(l1.get(0) > l2.get(0)) return 1;
        else return 0;
    }
}

public class SkyLineSolution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        ArrayList<Building> sortedStart = new ArrayList<Building>();
        ArrayList<Building> sortedEnd = new ArrayList<Building>();
        for (int i = 0; i < buildings.length; i++) {
            sortedStart.add(new Building(buildings[i][0], buildings[i][1], buildings[i][2]));
            sortedEnd.add(new Building(buildings[i][0], buildings[i][1], buildings[i][2]));
        }

        sortedStart.add(new Building(Integer.MAX_VALUE, Integer.MIN_VALUE, 0));
        Collections.sort(sortedEnd, Building.bldComparator);


        PriorityQueue<Building> maxHeap = new PriorityQueue<Building>(new BuildingComparator());
        List<List<Integer>> ret = new ArrayList<List<Integer>>();

        for (int i = 0, j = 0; j < sortedEnd.size() && i < sortedStart.size();) {
            Building next = sortedStart.get(i);
            Building rightMost = sortedEnd.get(j);
            if(next.left <= rightMost.right && next.left != Integer.MAX_VALUE){
                maxHeap.add(next);
                i++;
                //System.out.println(String.format("The push ! %d, %d %d", next.left, next.right, next.height));
            }else{
                Building latestSky = new Building(Integer.MAX_VALUE, Integer.MIN_VALUE,0);
                while(rightMost.right <= next.left && !maxHeap.isEmpty()){
                    List<Integer> l = new ArrayList<Integer>();
                    Building top = maxHeap.peek();
                    System.out.println(String.format("The Top ! %d, %d %d", top.left, top.right, top.height));
                    System.out.println(String.format("The rightMost ! %d, %d %d", rightMost.left, rightMost.right, rightMost.height));
                    if(top.right <= rightMost.right && top.right > latestSky.right){
                                if(top.left < latestSky.left)
                                    l.add(top.left);
                                else
                                    l.add(latestSky.right);
                                l.add(top.height);
                                ret.add(l);
                                latestSky.left = latestSky.left < top.left ? latestSky.left : top.left;
                                latestSky.right = latestSky.right > top.right ? latestSky.right : top.right;
                                maxHeap.remove();
                                if(!maxHeap.isEmpty()
                                        && (
                                                maxHeap.peek().left < latestSky.right
                                                        && maxHeap.peek().left >= latestSky.left
                                )) maxHeap.peek().left = latestSky.right;

                    }else if(top.left < latestSky.left && top.right <= latestSky.right) {
                        l.add(top.left);
                        l.add(top.height);
                        ret.add(l);
                        latestSky.left = top.left;
                        maxHeap.remove();
                    }else if(top.left >= latestSky.left && top.right <= latestSky.right){
                        maxHeap.remove();
                    }
                    else if(top.right > rightMost.right){
                        rightMost = sortedEnd.get(++j);
                    }

                }

                // add the 0 block
                if(maxHeap.isEmpty()){
                    if(next.left > latestSky.right || latestSky.right == Integer.MAX_VALUE){
                        List<Integer> l = new ArrayList<Integer>();
                        l.add(latestSky.right);
                        l.add(0);
                        ret.add(l);
                    }
                }
                while(j < sortedEnd.size() && sortedEnd.get(j).right < next.left){
                    j++;
                }
                maxHeap.add(next);
                if(next.left == Integer.MAX_VALUE) break;
            }
        }


        Collections.sort(ret, new ListComparator());
        for(int i = 1 ; i < ret.size(); i++){
            if(ret.get(i).get(1) == ret.get(i-1).get(1)){
                ret.remove(i);
                i--;
            }
        }

        for(int i = 0; i < ret.size(); i++){
            System.out.println(String.format("left %d, height %d", ret.get(i).get(0), ret.get(i).get(1)));
        }
        return ret;
    }
}