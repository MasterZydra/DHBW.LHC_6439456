import com.sun.jdi.NativeMethodException;

public class Native {
    private static Native instance = new Native();

    public Port port;

    private Native() {
        port = new Port();
    }

    public static Native getInstance() {
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
        int j;

        for (int i = 0; i <= (n - m); i++) {
            j = 0;
            while ((j < m) && (text.charAt(i + j) == pattern.charAt(j))) {
                j++;
            }
            if (j == m) return i;
        }

        return -1;
    }
}