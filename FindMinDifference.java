package dsa_practice_questions;
import java.util.*;
public class FindMinDifference {

    static long findMinDiff (ArrayList<Integer> a, int n, int m)
    {
        // your code here
        Collections.sort(a);
        // for(int j: a){
        //     System.out.print(j+ " ");
        // }
        // System.out.println();
        if(a.size() < m){
            return -1;
        }
        int min = Integer.MAX_VALUE;
        for(int i=0;i<=a.size()-m;i++){
            int min1 = a.get(i+m-1) - a.get(i);
            // System.out.println("i: " + i + " min1: " + min1);
            if(min1<= min){
                min = min1;
            }
        }
        return min;
    }
    public static void main(String[] args){

        ArrayList<Integer> list = new ArrayList<>();
        int[] arr = {17, 83, 59, 25, 38, 63, 25, 1, 37};
        for(int i:arr){
            list.add(i);
        }
        long minimum  = findMinDiff(list, list.size(), 9);
        System.out.println("Minimum: " + minimum);

    }
    
}
