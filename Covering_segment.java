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
