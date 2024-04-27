package dp;

public class RegxMatching {


    private String [] allPatterns;

    public static void main(String[] args) {
        RegxMatching p = new RegxMatching();
        boolean output = p.isMatch("abceeeacc", "ab.*.acc");
        System.out.println(output);
    }

    public boolean isMatch(String s, String p) {

        allPatterns = p.split("\\*");
        if (allPatterns.length == 0) {
            return true;
        }
        return isMatch(s, 0);
    }


    public boolean isMatch(String s, int i) {

        if (i == allPatterns.length) {
            return s.length() == 0;
        }

        String pattern = allPatterns[i];

        String [] splitByDot = pattern.split("\\.");

        if (splitByDot.length == 0) {
            if (s.length() > pattern.length()+1)
                return isMatch(s.substring(pattern.length()+1), i+1);
            if (s.length() == pattern.length() && i == allPatterns.length-1) {
                return true;
            }
            return false;
        }

        int startIdxOfMatching = subPatternMatching(s, splitByDot);

        if (startIdxOfMatching != -1) {
            return isMatch(s.substring(startIdxOfMatching+ pattern.length()), i+1);
        } else {
            return false;
        }
    }

    private static int subPatternMatching(String tobeMatched, String[] splitByDot) {
        int previousIdx = tobeMatched.indexOf(splitByDot[0]);
        if (previousIdx == -1) {
            return -1;
        }

        if (splitByDot.length == 1) {
            return previousIdx;
        }

        if (previousIdx+splitByDot[0].length()+1 >= tobeMatched.length()) {
            return -1;
        }

        String news = tobeMatched.substring(previousIdx+splitByDot[0].length()+1);
        for (int j = 1; j < splitByDot.length; j++) {
            int index = news.indexOf(splitByDot[j]);
            if (index == -1) {
                return -1;
            }

            if (index != 0) {
                if (previousIdx+1 >= tobeMatched.length()) {
                    return -1;
                }
                return subPatternMatching(tobeMatched.substring(previousIdx+1), splitByDot);
            }

            if (j == splitByDot.length -1) {
                break;
            }

            if (index + splitByDot[j].length()+1 >= news.length()) {
                return -1;
            }
            news = news.substring(index + splitByDot[j].length()+1);
        }

        return previousIdx;
    }
}
