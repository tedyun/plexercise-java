public class AB {

    public static String createString(int N, int K) {
        // TODO: argument validation for N and K
        // start with "BB...BAA...A" where the number of A's is n/2
        int half = N / 2;
        String str = "";
        for (int i = 0; i < half; i++) {
            str += "B";
        }
        for (int i = 0; i < N - half; i++) {
            str += "A";
        }
        for (int i = 0; i < K; i++) {
            try {
                str = switchFirstBAtoAB(str);
            } catch (Exception e) {
                str = "";
                break;
            }
        }
        return str;
    }

    public static String switchFirstBAtoAB(String str) throws Exception {
        int len = str.length();
        int pos = -1;
        String newStr = "";
        for (int i = 0; i < len - 1; i++) {
            if (str.substring(i, i + 2).equals("BA")) {
                pos = i;
                break;
            }
        }
        if (pos > -1) {
            newStr = str.substring(0, pos) + "AB" + str.substring(pos + 2);
        } else {
            throw new Exception("Unable to find BA.");
        }
        return newStr;
    }
    
    /*
    public static int computeAB(String str) {
        int count = 0;
        int len = str.length();
        for (int i = 0; i < len - 1; i++) {
            if (str.charAt(i) == 'A') {
                for (int j = i + 1; j < len; j++) {
                    if (str.charAt(j) == 'B') {
                        count++;
                    }
                }
            }
        }
        return count;
    }
    */
    
    public static void main(String[] args) {
        // Run "java AB 5 3"
        if (args.length != 2) {
            args = new String[] {"5", "3"};
        }
        System.out.println(createString(Integer.parseInt(args[0]), Integer.parseInt(args[1])));
    }
}