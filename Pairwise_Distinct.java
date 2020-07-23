//Task. The goal of this problem is to represent a given positive integer 𝑛 as a sum of as many pairwise
//    distinct positive integers as possible. That is, to find the maximum 𝑘 such that 𝑛 can be written as
//     𝑎1 + 𝑎2 + · · · + 𝑎𝑘 where 𝑎1, . . . , 𝑎𝑘 are positive integers and 𝑎𝑖 ̸= 𝑎𝑗 for all 1 ≤ 𝑖 < 𝑗 ≤ 𝑘.
// Input Format. The input consists of a single integer 𝑛.
//   Constraints. 1 ≤ 𝑛 ≤ 10^9
// Output Format. In the first line, output the maximum number 𝑘 such that 𝑛 can be represented as a sum
//of 𝑘 pairwise distinct positive integers. In the second line, output 𝑘 pairwise distinct positive integers
//that sum up to 𝑛 (if there are many such representations, output any of them).

/* 6             8
*  3             3
* 1 2 3          1 2 5*/

import java.util.*;

public class Pairwise_Distinct {
    public static List<Integer> optimal_number(int x) {
        List<Integer> arr = new ArrayList<>();
        for(int k = x, l = 1; k > 0; l++) {
            if(k <= 2 * l) {
                arr.add(k);
                k -= k;
            } else {
                arr.add(l);
                k -= l;
            }
        }

        return arr;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        List<Integer> result = optimal_number(n);
        System.out.println(result.size());
        for(int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i) + " ");
        }
    }
}
