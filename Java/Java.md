### Java
	- https://cupofjavasite.wordpress.com/2016/01/09/java-string-is-final-and-immutable-yet-its-contents-can-be-modified/
	- http://java67.blogspot.com/2016/01/how-to-use-foreach-method-in-java-8-examples.html
	- http://javaconceptoftheday.com/tricky-core-java-interview-coding-questions/
	- https://www.linkedin.com/groups/3983267/3983267-6101281510197837824

#### Marshalling and Unmarshalling
 	- http://www.jguru.com/faq/view.jsp?EID=560072


#### What are generics?
- They allow "a type or method to operate on objects of various types while providing compile-time type safety
- Generics are checked at compile-time for type-correctness. The generic type information is then removed in a process called type erasure.


#####Problems with Type-erasure
- Consequent to type erasure, type parameters cannot be determined at run-time.
- For eg. when an ArrayList is examined at runtime, there is no general way to determine whether, before type erasure, it was an ArrayList<Integer> or an ArrayList<Float>.

^
	For eg.,

	ArrayList<Integer> li = new ArrayList<Integer>();
	ArrayList<Float> lf = new ArrayList<Float>();
	if (li.getClass() == lf.getClass()) 
	{ 
		// evaluates to true
    	System.out.println("Equal");
	}

- Another effect of type erasure is that a generic class cannot extend the Throwable class in any way, directly or indirectly:

^
	public class GenericException<T> extends Exception

The reason why this is not supported is due to type erasure:

^
	try 
	{
    	throw new GenericException<Integer>();
	}
	catch(GenericsnericException<Integer> e)
	{
    	System.err.println("Integer");
	}
	catch(GenericException<String> e) 
	{
    	System.err.println("String");
	}	

Due to type erasure, the runtime will not know which catch block to execute, so this is prohibited by the compiler.

####What is thread-safe
- thread safe means that a method or class instance can be used by multiple threads at the same time without any problems occuring.
- Consider the following method:

^
	private int myInt = 0;
	public int AddOne()
	{
   	 	int tmp = myInt;
    	tmp = tmp + 1;
    	myInt = tmp;
    	return tmp;
	}

Now thread A and thread B both would like to execute AddOne(). but A starts first and reads the value of myInt (0) into tmp. Now for some reason the scheduler decides to halt thread A and defer execution to thread B. Thread B now also reads the value of myInt (still 0) into it's own variable tmp. Thread B finishes the entire method, so in the end myInt = 1. And 1 is returned. Now it's Thread A's turn again. Thread A continues. And adds 1 to tmp (tmp was 0 for thread A). And then saves this value in myInt. myInt is again 1.

So in this case the method AddOne was called two times, but because the method was not implemented in a thread safe way the value of myInt is not 2, as expected, but 1 because the second thread read the variable myInt before the first thread finished updating it.

- Creating thread safe methods is very hard in non trivial cases. And there are quite a few techniques. In Java you can mark a method as synchronized, this means that only one thread can execute that method at a given time. The other threads wait in line. This makes a method thread safe, but if there is a lot of work to be done in a method, then this wastes a lot of space. Another technique is to 'mark only a small part of a method as synchronized' by creating a lock or semaphore, and locking this small part (usually called the critical section). There are even some methods that are implemented as lockless thread safe, which means that they are built in such a way that multiple threads can race through them at the same time without ever causing problems, this can be the case when a method only executes one atomic call. Atomic calls are calls that can't be interrupted and can only be done by one thread at a time.

#### Difference between Join and Union
- UNION puts lines from queries after each other, while JOIN makes a cartesian product and subsets it -- completely different operations. Also since union is a set operation, there wouldn't be any duplicates records.Trivial example of UNION:

^
	mysql> SELECT 23 AS bah
	    -> UNION
	    -> SELECT 45 AS bah;
	+-----+
	| bah |
	+-----+
	|  23 | 
	|  45 | 
	+-----+
	2 rows in set (0.00 sec)

- similary trivial example of JOIN:

^
	mysql> SELECT * FROM 
	    -> (SELECT 23 AS bah) AS foo 
	    -> JOIN 
	    -> (SELECT 45 AS bah) AS bar
	    -> ON (33=33);
	+-----+-----+
	| bah | bah |
	+-----+-----+
	|  23 |  45 | 
	+-----+-----+
	1 row in set (0.01 sec)

#### Hibernate - http://www.tutorialspoint.com/hibernate/hibernate_interview_questions.htm
- Hibernate ORM (Hibernate in short) is an object-relational mapping framework for the Java language. It provides a framework for mapping an object-oriented domain model to a relational database. Hibernate solves object-relational impedance mismatch problems by replacing direct, persistent database accesses with high-level object handling functions.
- Hibernate's primary feature is mapping from Java classes to database tables; and mapping from Java data types to SQL data types.
- Hibernate also provides data query and retrieval facilities. It generates SQL calls and relieves the developer from manual handling and object conversion of the result set.	

- What are the key components/objects of hibernate?
Following are the key components/objects of Hibernate:

	* Configuration - Represents a configuration or properties file required by the Hibernate.

	* SessionFactory - Configures Hibernate for the application using the supplied configuration file and allows for a Session object to be instantiated.

	* Session - Used to get a physical connection with a database.

	* Transaction - Represents a unit of work with the database and most of the RDBMS supports transaction functionality.

	* Query - Uses SQL or Hibernate Query Language (HQL) string to retrieve data from the database and create objects.

	* Criteria - Used to create and execute, object oriented criteria queries to retrieve objects.

- The Configuration object provides two keys components:

	* Database Connection: This is handled through one or more configuration files supported by Hibernate. These files are hibernate.properties and hibernate.cfg.xml.

	* Class Mapping Setup : This component creates the connection between the Java classes and database tables.

- What is a configuration object in hibernate?
	* The Configuration object is the first Hibernate object you create in any Hibernate application and usually created only once during application initialization. It represents a configuration or properties file required by the Hibernate.

- What is a SessionFactory in hibernate?
	* Configuration object is used to create a SessionFactory object which inturn configures Hibernate for the application using the supplied configuration file and allows for a Session object to be instantiated. The SessionFactory is a thread safe object and used by all the threads of an application.

	* The SessionFactory is heavyweight object so usually it is created during application start up and kept for later use. You would need one SessionFactory object per database using a separate configuration file. So if you are using multiple databases then you would have to create multiple SessionFactory objects.

- What is Session in hibernate?
	* A Session is used to get a physical connection with a database. The Session object is lightweight and designed to be instantiated each time an interaction is needed with the database. Persistent objects are saved and retrieved through a Session object.

	* The session objects should not be kept open for a long time because they are not usually thread safe and they should be created and destroyed them as needed.

- Session.beginTransaction method begins a unit of work and returns the associated Transaction object.
- Session.createCriteria creates a new Criteria instance, for the given entity class, or a superclass of an entity class.
- Session.createQuery creates a new instance of Query for the given HQL query string.
- Session.createSQLQuery creates a new instance of SQLQuery for the given SQL query string.
- Session.delete removes a persistent instance from the datastore.
- Session.get returns the persistent instance of the given named entity with the given identifier, or null if there is no such persistent instance.
- Session.refresh re-reads the state of the given instance from the underlying database.
- Session.save saves the state of the given instance from the underlying database.
- Session.update updates the state of the given instance from the underlying database.
- Session.saveOrUpdate either saves(Object) or updates(Object) the given instance.

- What are persistent classes in hibernate?
	* Java classes whose objects or instances will be stored in database tables are called persistent classes in Hibernate.

- What are the best practices that hibernate recommends for persistent classes.
There are following main rules of persistent classes, however, none of these rules are hard requirements.

	* All Java classes that will be persisted need a default constructor.
	* All classes should contain an ID in order to allow easy identification of your objects within Hibernate and the database. This property maps to the primary key column of a database table.
	* All attributes that will be persisted should be declared private and have getXXX and setXXX methods defined in the JavaBean style.
	* A central feature of Hibernate, proxies, depends upon the persistent class being either non-final, or the implementation of an interface that declares all public methods.
	* All classes that do not extend or implement some specialized classes and interfaces required by the EJB framework.

- What are the three states of a persistent entity at a given point in time?
	Instances may exist in one of the following three states at a given point in time:
	1. transient: A new instance of a a persistent class which is not associated with a Session and has no representation in the database and no identifier value is considered transient by Hibernate.
	2. persistent: You can make a transient instance persistent by associating it with a Session. A persistent instance has a representation in the database, an identifier value and is associated with a Session.
	3. detached: Once we close the Hibernate Session, the persistent instance will become a detached instance.

- SessionFactory is a thread-safe and can be accessed by multiple threads simultaneously.
- Session is not thread-safe.

- What is lazy loading?
	* Lazy loading is a technique in which objects are loaded on demand basis. Since Hibernate 3, lazy loading is by default, enabled so that child objects are not loaded when parent is loaded.

- first level cache(mandatory, Session cache), second level cache(optional, configured on per-class and per collection basis, caching objects across session), query level cache

- What are concurrency strategies?
	* A concurrency strategy is a mediator which responsible for storing items of data in the cache and retrieving them from the cache. If you are going to enable a second-level cache, you will have to decide, for each persistent class and collection, which cache concurrency strategy to use.
		1. Transactional: Use this strategy for read-mostly data where it is critical to prevent stale data in concurrent transactions,in the rare case of an update.
		2. Read-write: Again use this strategy for read-mostly data where it is critical to prevent stale data in concurrent transactions,in the rare case of an update.
		3. Nonstrict-read-write: This strategy makes no guarantee of consistency between the cache and the database. Use this strategy if data hardly ever changes and a small likelihood of stale data is not of critical concern.
		4. Read-only: A concurrency strategy suitable for data which never changes. Use it for reference data only.

