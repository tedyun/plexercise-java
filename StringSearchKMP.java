/**
 * The implementation of Knuth-Morris-Pratt algorithm for sub-string search.
 */
public class StringSearchKMP {
    // Radix
    private static final int R = 65535;
    String searchKey;
    int[][] searchMap;

    /**
     * Constructor 
     */
    public StringSearchKMP (String searchKey) {
        this.searchKey = searchKey;
        buildSearchMap(searchKey);
    }

    /**
     * Building the automaton in an array
     */
    private void buildSearchMap (String searchKey) {
        int N = searchKey.length();
        searchMap = new int[N][R];
        int stateExceptFirst = 0;
        for (int i = 0; i < N; i++) {
            // i is the state, i.e. the length of the suffix that matched so far
            int curChar = searchKey.charAt(i);
            for (int j = 0; j < R; j++) {
                if (j == curChar) {
                    searchMap[i][curChar] = i + 1;
                } else {
                    searchMap[i][j] = searchMap[stateExceptFirst][j];
                }
            }
            if (i > 0) {
                stateExceptFirst = searchMap[stateExceptFirst][curChar];
            }
        }
    }

    /**
     * The search method
     */
    public int search (String content) {
        int curPos = 0;
        int i;
        for (i = 0; i < content.length(); i++) {
            curPos = searchMap[curPos][content.charAt(i)];
            if (curPos == searchKey.length()) {
                break;
            }
        }
        if (curPos == searchKey.length()) {
            return i - searchKey.length() + 1;
        }
        return -1;
    }

    /**
     * Main method for testing
     */
    public static void main (String[] args) {
        StringSearchKMP searchTest = new StringSearchKMP("jdkl");
        int ind = searchTest.search("alk;sdjfl;kasjdfkl;asjdklfkwerjgjdsajkfads");
        System.out.println(ind);
    }
}
