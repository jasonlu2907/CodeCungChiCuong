import java.util.*;

public class FindPalindrom {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String n = scanner.next();

        if(Palindrom(n)) {
            System.out.println(n + " la Palindrom");
        }
        else {
            System.out.println(n + " khong phai la Palindrom");
        }
    }

    private static boolean Palindrom(String m) {
        int i = 0, j = m.length() - 1;

        while(i < j) {
            char s1 = m.charAt(i);
            char s2 = m.charAt(j);
            if(s1 != s2) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
