///////////////////////
// By Eduard Shokur ///
// 09/25/2020 ////////
import java.util.Arrays;
public class Autocomplete {
    Term [] termsArray;
    int firstIndex;
    int lastIndex;
    // Initializes the data structure from the given array of terms.
    public Autocomplete(Term[] terms) {
        //sorts the array passed in
        termsArray = new Term[terms.length];

        Arrays.sort(termsArray);

    }

    // Returns all terms that start with the given prefix, in descending order of weight.
    public Term[] allMatches(String prefix) {
        // we copy the array from the indexes that are found to have equivalent prefixes that we found using numberOfMatches()
        Term [] allMatchesArray = Arrays.copyOfRange(termsArray, firstIndex, lastIndex);
        //allMatches array is then sorted and then returned in order
        Arrays.sort(allMatchesArray, Term.byReverseWeightOrder());
        return allMatchesArray;
    }

    // Returns the number of terms that start with the given prefix.
    public int numberOfMatches(String prefix) {
        Term prefixTerm = new Term(prefix, 0);
        firstIndex = BinarySearchDeluxe.firstIndexOf(termsArray, prefixTerm, Term.byPrefixOrder(prefix.length()));
        lastIndex = BinarySearchDeluxe.lastIndexOf(termsArray, prefixTerm, Term.byPrefixOrder(prefix.length()));
        return firstIndex - lastIndex;
    }
    

    // A sample client for unit testing
    public static void main(String[] args) {

        // read in the terms from a file
        String filename = args[0];
        In in = new In(filename);
        int N = in.readInt();
        Term[] terms = new Term[N];
        int i;
        for (i = 0; i < N; i++) {
            long weight = in.readLong();           // read the next weight
            in.readChar();                         // scan past the tab
            String query = in.readLine();          // read the next query
            terms[i] = new Term(query, weight);    // construct the term
        }
        
        // read in queries from standard input and print out the top k matching terms
        int k = Integer.parseInt(args[1]);
        Autocomplete autocomplete = new Autocomplete(terms);
        while (StdIn.hasNextLine()) {
            String prefix = StdIn.readLine();
            Term[] results = autocomplete.allMatches(prefix);
            for ( i = 0; i < Math.min(k, results.length); i++)
                StdOut.println(results[i]);
        }
    }
}