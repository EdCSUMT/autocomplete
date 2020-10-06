///////////////////////
// By Eduard Shokur ///
// 09/25/2020 ////////
import java.util.Arrays;
import java.util.Comparator;

public class BinarySearchDeluxe {

    
    // Returns the index of the first key in a[] that equals the search key, or -1 if no such key.
    public static <Key> int firstIndexOf(Key[] a, Key key, Comparator<Key> comparator) {

        int firstRetInd = -1;
        int lo = 0;
        int hi = a.length-1;


        while (lo <= hi) {
            int mid = lo + (hi - lo)/2;


            // so if value of a[mid] is bigger than value of key, we need to search to the right of middle
            // therefore mid value is updated
            if (comparator.compare(a[mid], key) > 0) {
                hi = mid - 1;
            }
            // so if value of a[mid] is less than value of key, we need to search to the right of middle
            // accordinly, mid value is updated
            else if (comparator.compare(a[mid], key) < 0) {
                lo = mid + 1;
            }
            //otherwise, if a[mid] !< key and a[mid] >! key that means a[mid] == key
            //this means we found the first index of the key
            //we assign that index to the first return index
            // decrementing high ensures that we conduct search to the right of the one we just found
            else {

                    firstRetInd = mid;

                hi = mid - 1;
            }
        }
        return firstRetInd;
    }

    
    // Returns the index of the last key in a[] that equals the search key, or -1 if no such key.

    public static <Key> int lastIndexOf(Key[] a, Key key, Comparator<Key> comparator) {

        int lastRetInd = -1;
        int lo = 0;
        int hi = a.length-1;


        while (lo <= hi) {
            int mid = lo + (hi - lo)/2;

            // so if value of a[mid] is bigger than value of key, we need to search to the right of middle
            // therefore mid value is updated
            if (comparator.compare(a[mid], key) > 0) {
                hi = mid - 1;
            }
            // so if value of a[mid] is less than value of key, we need to search to the left of middle
            // accordinly, mid value is updated
            else if (comparator.compare(a[mid], key) < 0) {
                lo = mid + 1;
            }
            //otherwise, if a[mid] !< key and a[mid] >! key that means a[mid] == key
            //this means we found the first index of the key
            //we assign that index to the first return index
            // then by incrementing the lo we make that binary search from here on takes place to the left of where we just found key match
            else {

                    lastRetInd = mid;

                lo = mid + 1;
            }
        }
        return lastRetInd;

    }


    // unit testing (you should have some Unit Testing here to confirm that your methods work); for example...
    public static void main(String[] args) {
    
        Term[] terms = new Term[5];
        terms[0] = new Term("Trevor", 45);
        terms[1] = new Term("Kathy", 43);
        terms[2] = new Term("Ellie", 11);
        terms[3] = new Term("Allen", 9);
        terms[4] = new Term("Eva", 1);
        Arrays.sort(terms);

        Term searchme = new Term("J",0);
        int first = BinarySearchDeluxe.firstIndexOf(terms, searchme, Term.byPrefixOrder(2));
        int last = BinarySearchDeluxe.lastIndexOf(terms, searchme, Term.byPrefixOrder(2));
        StdOut.println("J: " + first + " to " + last);

        searchme = new Term("A",0);
        first = BinarySearchDeluxe.firstIndexOf(terms, searchme, Term.byPrefixOrder(2));
        last = BinarySearchDeluxe.lastIndexOf(terms, searchme, Term.byPrefixOrder(2));
        StdOut.println("A: " + first + " to " + last);
       
        searchme = new Term("E",0);
        first = BinarySearchDeluxe.firstIndexOf(terms, searchme, Term.byPrefixOrder(1));
        last = BinarySearchDeluxe.lastIndexOf(terms, searchme, Term.byPrefixOrder(1));
        StdOut.println("E: " + first + " to " + last);
        
        searchme = new Term("T",0);
        first = BinarySearchDeluxe.firstIndexOf(terms, searchme, Term.byPrefixOrder(1));
        last = BinarySearchDeluxe.lastIndexOf(terms, searchme, Term.byPrefixOrder(1));
        StdOut.println("T: " + first + " to " + last);        
    }
}

