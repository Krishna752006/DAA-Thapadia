import java.util.*;

// class b {
//     public static void main(String[] args) {
//         String s = "YazaAay";
//         System.out.println(longestHarmonious(s));
//     }

//     static String longestHarmonious(String s) {
//         int n = s.length();
//         String res = "";

//         for (int i = 0; i < n; i++) {
//             int[] lower = new int[26];
//             int[] upper = new int[26];
//             for (int j = i; j < n; j++) {
//                 char c = s.charAt(j);
//                 if (Character.isLowerCase(c)) lower[c - 'a']++;
//                 else if (Character.isUpperCase(c)) upper[c - 'A']++;

//                 if (isHarmonious(lower, upper) && (j - i + 1) > res.length()) {
//                     res = s.substring(i, j + 1);
//                 }
//             }
//         }
//         return res;
//     }

//     static boolean isHarmonious(int[] lower, int[] upper) {
//         for (int k = 0; k < 26; k++) {
//             if ((lower[k] > 0 && upper[k] == 0) || (upper[k] > 0 && lower[k] == 0))
//                 return false;
//         }
//         return true;
//     }
// }

public class b {
    public static void main(String[] args) {
        String s = "YazaAay";
        System.out.println(longestHarmonious(s));
    }

    public static String longestHarmonious(String s) {
        return helper(s);
    }

    private static String helper(String s) {
        if (s.length() <= 1) return "";

        // Collect lowercase and uppercase sets
        java.util.Set<Character> lower = new java.util.HashSet<>();
        java.util.Set<Character> upper = new java.util.HashSet<>();

        for (char c : s.toCharArray()) {
            if (Character.isLowerCase(c)) lower.add(c);
            else if (Character.isUpperCase(c)) upper.add(Character.toLowerCase(c));
        }

        // Find bad characters (appear in only one case)
        java.util.Set<Character> bad = new java.util.HashSet<>(lower);
        for (char c : upper) {
            if (bad.contains(c)) bad.remove(c);
            else bad.add(c);
        }

        // If no bad characters, it's harmonious
        if (bad.isEmpty()) return s;

        // Divide by bad characters
        String best = "";
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            if (bad.contains(Character.toLowerCase(s.charAt(i)))) {
                if (start < i) {
                    String candidate = helper(s.substring(start, i));
                    if (candidate.length() > best.length()) best = candidate;
                }
                start = i + 1;
            }
        }

        // Process last part
        if (start < s.length()) {
            String candidate = helper(s.substring(start));
            if (candidate.length() > best.length()) best = candidate;
        }

        return best;
    }
}
