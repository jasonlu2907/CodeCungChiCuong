import java.util.Arrays;
import java.util.Scanner;

public class HelloCacBan {
    private static int getMajorityElement(int[] a, int left, int right) {
        if (left == right - 1) {
            return -1;
        } else if (left + 1 == right - 1) {
            return a[left];
        } else {
            Arrays.sort(a);
            int prev = a[left];
            int count = 1;
            ++left;

            while(left <= right - 1) {
                if (a[left] == prev) {
                    ++count;
                } else {
                    count = 1;
                    prev = a[left];
                }

                if (count > a.length / 2) {
                    return 1;
                }

                ++left;
            }

            return -1;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];

        for(int i = 0; i < n; ++i) {
            a[i] = scanner.nextInt();
        }

        if (getMajorityElement(a, 0, a.length) != -1) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }

    }
}
