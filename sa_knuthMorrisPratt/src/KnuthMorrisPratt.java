public class KnuthMorrisPratt {
    private static KnuthMorrisPratt instance = new KnuthMorrisPratt();

    public Port port;

    private KnuthMorrisPratt() {
        port = new Port();
    }

    public static KnuthMorrisPratt getInstance() {
        return instance;
    }

    public class Port implements IStringMatching {

        public int search(String text, String pattern) {
            return searchString(text, pattern);
        }
    }

    private int searchString(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();

        int[] fail = computeFail(pattern);
        int i = 0;
        int j = 0;

        while (i < n) {
            if (pattern.charAt(j) == text.charAt(i)) {
                if (j == m - 1) {
                    return i - m + 1; // match
                }
                i++;
                j++;
            } else if (j > 0) {
                j = fail[j - 1];
            } else
                i++;
        }

        return -1;
    }

    private int[] computeFail(String pattern) {
        int[] fail = new int[pattern.length()];
        fail[0] = 0;
        int m = pattern.length();
        int j = 0;
        int i = 1;

        while (i < m) {
            if (pattern.charAt(j) == pattern.charAt(i)) {
                fail[i] = j + 1;
                i++;
                j++;
            } else if (j > 0) {
                j = fail[j - 1];
            } else {
                fail[i] = 0;
                i++;
            }
        }

        return fail;
    }
}