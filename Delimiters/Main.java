import java.util.*;
import java.util.stream.Stream;

/* Unit 7 Practice FRQ, implemented in Java 17. @author T. De Laguna 2024 */
public class Main {
    public static void main(String[] args) {
        Delimiters d = new Delimiters("(", ")");
        final String input = "((Shall) I compare thee to a summer's (day)? (goof here->)";
        String[] tokens = tokenize(input);
        System.out.println("Tokens are: " + Arrays.toString(tokens));
        List<String> parsed = d.getDelimitersList(tokens);
        System.out.println("Is it balanced? " + d.isBalanced(parsed));

            String sonnet = "(Shall I (compare) thee?";
            Delimiters d2 = new Delimiters("(", ")");
            Stream.of(sonnet, sonnet + ")").map(Main::tokenize).forEach(d2::isBalanced);
    }
    /* Tokenize a string into words and special characters, using regex capture */
    private static String[] tokenize(String s) {
        final String specialChar = "[^\\p{Alnum}]";// any non-alphanumeric character
        final String capture = "(?<=" + specialChar + ")|(?=" + specialChar + ")";
        return s.split(capture);
    }
}
// records added in Java 17, no need for constructors/getters
record Delimiters(String openDel, String closeDel) {
    public List<String> getDelimitersList(String[] tokens) {
        return Arrays.stream(tokens).filter(this::isToken).toList();
    }

    private boolean isToken(String s) {
        return List.of(openDel, closeDel).contains(s);
    }

    /**
     * @return true if delimiter tokens are matching
     * Uses running tally of unmatched open delimiters
     */
    public boolean isBalanced(List<String> delimiters) {
        long openCount = 0;
        for (String token : delimiters) {
            if (token.equals(openDel))
                openCount++;
            else if (token.equals(closeDel))
                openCount--;
            if (openCount < 0)
                return false;
        }
        return openCount == 0;
    }
    /* Overloaded to handle tokens directly. */
    public boolean isBalanced(String[] tokens) {
        System.out.println("Checking for balance: \n" + Arrays.toString(tokens));
        return isBalanced(getDelimitersList(tokens));
    }
}
