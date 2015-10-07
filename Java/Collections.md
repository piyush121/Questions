#### HashMap Implementation
	- http://javahungry.blogspot.com/2013/08/hashing-how-hash-map-works-in-java-or.html
	- put (key,value) will return
		1.  null , if key is unique and added to the map
		2.  Old Value of the key , if key is duplicate
	- An instance of HashMap has two parameters that affect its performance: initial capacity and load factor. 
	- The hashmap implementation provides constant time performance for (get and put) basic operations i.e the complexity of get() and put() is O(1)

#### LinkedHashMap
	- http://stackoverflow.com/questions/19738977/how-is-the-internal-implementation-of-linkedhashmap-different-from-hashmap-imple
	- http://geekrai.blogspot.com/2013/06/linkedhashmap-implementation-in-java.html
	- http://javarticles.com/2012/06/linkedhashmap.html
	- additional doubly-linked list to maintain the insertion order. 
	
#### HashSet Implementation
	- http://javahungry.blogspot.com/2013/08/how-sets-are-implemented-internally-in.html

#### Treemap Implementation
	- http://javahungry.blogspot.com/2014/06/how-treemap-works-ten-treemap-java-interview-questions.html
	- Red Black Tree is used Internally
	- Red Black tree has the following properties :
		1. As the name of the algorithm suggests ,color of every node in the tree is either red or black.
		2. Root node must be Black in color.
		3. Red node can not have a red color neighbor node.
		4. All paths from root node to the null should consist the same number of black nodes 

#### ArrayList vs Vector
	- http://javahungry.blogspot.com/2013/12/difference-between-arraylist-and-vector-in-java-collection-interview-question.html

#### Time complexity
	- http://www.javaexperience.com/time-complexity-of-collection-classes/

#### Fail Fast vs Fail Safe Iterators
	- http://javahungry.blogspot.com/2014/04/fail-fast-iterator-vs-fail-safe-iterator-difference-with-example-in-java.html

#### For loop vs For each loop
	- http://stackoverflow.com/questions/256859/is-there-a-performance-difference-between-a-for-loop-and-a-for-each-loop
	- https://aliteralmind.wordpress.com/2014/03/22/for_foreach/
	- http://www.mkyong.com/java/while-loop-for-loop-and-iterator-performance-test-java/