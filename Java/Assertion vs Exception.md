### Assertion vs Exception

- Assertions should be used to check something that should never happen, while an exception should be used to check something that might happen. 
- For example, a function might divide by 0, so an exception should be used, but an assertion could be used to check that the harddrive suddenly disapears. An assertion would stop the program from running, but an exception would let the program continue running.

- Out of my mind (list may be incomplete, and is too long to fit in a comment), I would say:
	- use exceptions when checking parameters passed to public or protected methods and constructors
 	- use exceptions to address problems that might occur	
	- use assertions when checking pre-conditions, post-conditions and invariants of private/internal code
	- use assertions to provide feedback to yourself or your developer team
	- use assertions when checking for things that are very unlikely to happen otherwise it means that there is a serious ﬂaw in your application
	- use assertions to state things that you (supposedly) know to be true

- In other words, exceptions address the robustness of your application while assertions address its correctness.

- Assertions are designed to be cheap to write, you can use them almost everywhere and I'm using this rule of thumb: the more an assertion statement looks stupid, the more valuable it is and the more information it embeds. When debugging a program that does not behave the right way, you will surely check the more obvious failure possibilities based on your experience. Then you will check for problems that just cannot happen: this is exactly when assertions help a lot and save time.

#### ClassNotFoundException vs NoClassDefFoundError
- http://javaconceptoftheday.com/classnotfoundexception-vs-noclassdeffounderror-in-java/