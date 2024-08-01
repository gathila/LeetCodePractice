package dp;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    public static void main(String[] args) {
        Permutations permutations = new Permutations();
        List<String> results = new ArrayList<>();
        permutations.permute("abc", "", results);

        for (String pair : results) {
            System.out.println(pair);
        }
    }

    public void permute(String original, String newstr, List<String> results) {
        for (int i=0; i<original.length(); i++) {
            String s = newstr + original.charAt(i);
            String newOriginal = original.length() > 1 ? original.substring(0, i) + original.substring(i + 1) : "";
            permute(newOriginal, s, results);
        }

        if (original.isEmpty()) {
            results.add(newstr);
        }
    }
}
