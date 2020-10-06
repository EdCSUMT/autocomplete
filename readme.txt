/******************************************************************************
 *  Name: Eduard Shokur
 *
 *  Hours to complete assignment (optional): Many hours
 *
 ******************************************************************************/

Programming Assignment 2: Autocomplete


/******************************************************************************
 *  Describe how your firstIndexOf() method in BinarySearchDeluxe.java
 *  finds the first index of a key that equals the search key.
 *****************************************************************************/
1. I initialize a variable firstIndex to -1 so that by default, the key is not found.
2. Then use a binary search just as was discussed in 5-2, but instead returning mid as soon as it is found,
everytime I find the key, I assign the index where key was found to the above mention variable. 
3. Next, I pretend that I didn't find the key and by making hi = mid - 1, I pretend that the place where mid was
just found has too large of a value so binary search goes to the left of the just found key location.
4. If the key is found again, I repeat steps 2 & 3. Otherwise, I go to the right of the place where I actually
was not able to find the key--low = mid + 1 . 
5. I keep repeating steps 2-4 until eventually low>high and loop terminates. Upon termination, whatever the value of the 
firstIndex was, gets returned.
This is a pretty clever design, I think, because it is almost EXACTLY like a standard, textbook code for a binary search with
just 3 extra lines. 

/******************************************************************************
 *  What is the order of growth of the number of compares (in the
 *  worst case) that each of the operations in the Autocomplete
 *  data type make, as a function of the number of terms n and the
 *  number of matching terms m?  (Big-Oh notation)
 *
 *  Recall that with order-of-growth notation, you should discard
 *  leading coefficients and lower-order terms, e.g., m^2 + m log n.
 *****************************************************************************/

constructor:
---------------------------------------------------------------------------
Linear time to initilize an array of Term objects + nlgn time to sort it. 
So,  nlgn+n or Big-Oh(nlgn) or Linearithmic
---------------------------------------------------------------------------
allMatches():
---------------------------------------------------------------------------
All matches asks numberOfMatches() to do 2 binary searches for it (one for firstIndex and one
binary search for lastIndex). Allmatches also initializes a string that keeps a copy of all items
that are between the inices that it receives from numberOfMatches--m. Finally, allMatches() sorts an array
that contains only matching items. 

So, 2lgn + m(initialize an array to return) + mlgm (sort the array). 
We have lgn+mlgm+m --> Big-Oh(lgn) or logarithmic.
--------------------------------------------------------------------------------
numberOfMatches():
--------------------------------------------------------------------------------
It is fair to say that this function does not have runtime on its own. In otherwords 
it only does any work if it is asked by allMatches() to do somework and it can be made
a private function without any changes to design. 
When it is asked to do some work, as described above, it only does 2 binary searches +
some constant operations for a total runtime of:
2lgn --> Big-Oh(lgn)--logarithmic.



/******************************************************************************
 *  Known bugs / limitations.
 *****************************************************************************/
I am not aware of any bugs or limitations. I spent a whole day to ensure that. 

/******************************************************************************
 *  Describe whatever help (if any) that you received.
 *  Don't include readings or lectures, but do include
 *  any help from people (including course staff, lab TAs,
 *  classmates, and friends) and attribute them by name.
 *
 *  Also include any resources (including the web) that you may
 *  may have used in creating your design.
 *****************************************************************************/
I have argued extensively with Adam Viray about different ways to prove worse case runtimes
for different scenarios of binary search. While I didn't take any ideas from him--conversation was
too general, arguing it out helped me cement my understanding on ways to approach the problem. 
I also used https://stackoverflow.com/questions/50290996/what-is-the-worst-case-for-binary-search for reference and 
some article for binary search trees as I dabbled with that.
I discussed briefly with John if implementing PriorityQue would is an overkill--thank goodness
I didn't go that route.
I got some helpful tips from Trent when I was stuck like: making a smaller test file and
test on it first to fix big bugs before moving on to test bigger things, also we discussed
command line arguements and what they do.
Finally, when I kept getting tab is missing, Kayla suggested I check to make sure I implemented 
my return string. 
That is all the help that I can remember.

/******************************************************************************
 *  Describe any serious problems you encountered.
 *****************************************************************************/
When I first opened this project I started freaking out and couldn't even get simple
things accomplished like initializing a memeber variable. Hehehe.
I also had a hard time understanding how Term V and Term W and comparator works and why
we were able to use Term.byPrefixorderFunction without actually calling it. I almost 
figured it out myself, but I kept doubting it so I had to ask for help on these.

/******************************************************************************
 *  List any other comments here. Feel free to provide any feedback
 *  on how much you learned from doing the assignment, and whether
 *  you enjoyed doing it.
 *****************************************************************************/
I liked the assignment very much, especially, the GUI. I did find it challenging
but mostly because I overthought and over freaked out. I also like how the requirements
were clearly and explicidly spelled out.
