///////////////////////
// By Eduard Shokur ///
// 09/25/2020 ////////

import java.util.Arrays;
import java.util.Comparator;

public class Term implements Comparable<Term> {
    // creates variables to be initialized
    Term termPassedIn;
    private long termWeight;
    private String queryString;
    // Initializes a term with the given query string and weight.
    public Term(String query, long weight) {
        //how to assign the value of the string to something
        termWeight = weight;
        queryString = query;
        // we initialize the term to be an object with certain weight and certain String Object
        termPassedIn = new Term(queryString, termWeight);
    }

    public static Comparator<Term> byReverseWeightOrder() {
        /////////////////what's this?? why doesn't work without this method
        return new Comparator<Term>() {
            public int compare(Term v, Term w) {
               int retInt;
               if (v.termWeight < w.termWeight) {
                   retInt = -1;
               }
               else if (v.termWeight > w.termWeight) {
                   retInt = 1;
               }
               else {
                   retInt = 0;
               }
               return retInt;
            }

        };
    }

    // Compares the two terms in lexicographic order but using only the first r characters of each query.
    public static Comparator<Term> byPrefixOrder(int r) {
        return new Comparator<Term>() {
            public int compare(Term v, Term w) {
                // this error checking prevents r from giving index out of bounds exception;
                // so if at least one of the strings is less than r in length
                // we check up to the last char of shortest string
                if((v.queryString.length() < r) || (w.queryString.length() < r)) {

                }


              return 0;
            }
        };
    }

    // Compares the two terms in lexicographic order by query.
    public int compareTo(Term that) {
        return 0; //FIXME
    }

    // Returns a string representation of this term in the following format:
    // the weight, followed by a tab, followed by the query.
    public String toString() {
        return null; //FIXME
    }

    // unit testing (you should have some Unit Testing here to confirm that your methods work); for example...
    public static void main(String[] args) {
        Term[] terms = new Term[5];
        ///////////////string objects not initialized
        terms[0] = new Term("Trevor", 45);
        terms[1] = new Term("Kathy", 43);
        terms[2] = new Term("Ellie", 11);
        terms[3] = new Term("Allen", 9);
        terms[4] = new Term("Eva", 1);
        int papa;
        Arrays.sort(terms);
        for (Term t : terms) {
            StdOut.println(t);
        }
        
        StdOut.println("");
        Arrays.sort(terms, Term.byReverseWeightOrder());
        for (Term t : terms) {
            StdOut.println(t);
        }
        
        StdOut.println("");
        Arrays.sort(terms, Term.byPrefixOrder(1));
        for (Term t : terms) {
            StdOut.println(t);
        }        
    }

    long getTermWeight() {
        return termWeight;
    }

    void setTermWeight(long termWeight) {
        this.termWeight = termWeight;
    }

    public Term getTermPassedIn() {
        return termPassedIn;
    }

    public void setTermPassedIn(Term termPassedIn) {
        this.termPassedIn = termPassedIn;
    }
}