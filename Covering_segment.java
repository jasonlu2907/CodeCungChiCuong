
//Task. Given a set of 𝑛 segments {[𝑎0, 𝑏0], [𝑎1, 𝑏1], . . . , [𝑎𝑛−1, 𝑏𝑛−1]} with integer coordinates on a line, find
//the minimum number 𝑚 of points such that each segment contains at least one point. That is, find a
//set of integers 𝑋 of the minimum size such that for any segment [𝑎𝑖, 𝑏𝑖] there is a point 𝑥 ∈ 𝑋 such that 𝑎𝑖 ≤ 𝑥 ≤ 𝑏𝑖.
//Input Format. The first line of the input contains the number 𝑛 of segments. Each of the following 𝑛 lines
//contains two integers 𝑎𝑖 and 𝑏𝑖 (separated by a space) defining the coordinates of endpoints of the 𝑖-th
//segment.
//  Constraints. 1 ≤ 𝑛 ≤ 100; 0 ≤ 𝑎𝑖 ≤ 𝑏𝑖 ≤ 10^9 for all 0 ≤ 𝑖 < 𝑛.
//        Output Format. Output the minimum number 𝑚 of points on the first line and the integer coordinates
// of 𝑚 points (separated by spaces) on the second line. You can output the points in any order. If there
// are many such sets of points, you can output any set. (It is not difficult to see that there always exist
// a set of points of the minimum size such that all the coordinates of the points are integers.)

/* 3                  4
1 3                   4 7
2 5                   1 3
3 6                   2 5
-> 1                  5 6
   3               -> 2
                      3 6
* */

import java.util.*;
public class Covering_Segment {
    public static void  main(String []args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Segment[] segm = new Segment[n]; // Array kiểu Segment
        for(int i = 0; i < n; i++) {
            int s = scanner.nextInt();
            int e = scanner.nextInt();
            segm[i] = new Segment(s, e);
            
        }
        int[] points = optimal_points(segm);
        System.out.println(points.length + "\n");
        for(Segment i : segm) {
            System.out.println(i.start + i.end);
        }
    }
       
    private static int[] optimal_points(Segment[] s) {
        // Sort the Segment according to the end points
    	for (int i = 0; i < s.length - 1; i++) {
    		for (int j = i + 1; j < s.length; j++) {
    			if (s[i].getEnd() > s[j].getEnd()) {
    				Segment temp = s[i];
    				s[i] = s[j];
    				s[j] = temp;
    			}
    		}
    	}
    	System.out.println("Segment Sort");
    	for (Segment temp : s) {
    		System.out.println(temp);
    	}
    	System.out.println("=============");
    	
        // Create array to store end points
        int[] points = new int[1];
        int point = s[0].end; // Set the point to the least end point i.e the first end point
        points[0] = point;
        for(int i = 1; i < s.length; i++) {
            if(point < s[i].start || point > s[i].end) {
                // Update and push the point to array points
                point = s[i].end;
                points = addElement(points, point);
            }
        }
        return points;
    }
    static int[] addElement(int[] a, int e) {
        a  = Arrays.copyOf(a, a.length + 1);
        a[a.length - 1] = e;
        return a;
    }
    static class Segment {
        int start, end; // public, private, protected, default

        public Segment(int s, int e) {
            this.start = s;
            this.end = e;
        }
        
        public int getStart() {
        	return this.start;
        }
        
        public int getEnd() {
        	return this.end;
        }
        
        @Override
        public String toString() {
        	return this.start + " " + this.end;
        }
    }
}
