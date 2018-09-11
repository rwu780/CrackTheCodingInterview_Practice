# Interview Questions

###13.1

In terms of inheritance, keeping constructor private is that current class do not want to get extended, except its own or its parents inner class

### 13.2

Yes

### 13.3
final apply to 
- method, cannot be overridden
- variables, cannot change
- class, cannot be extend

finally apply to 
- try/catch block

finalize
- used in garbage collection

### 13.4
Generics
- runtime
- prevent you from using primitive types
- cannot be used for static methods and variables


### 13.5
HashMap
- Unsorted, Unordered

LinkedHashMap
- Ordered, not sorted

TreeMap
- Ordered and sorted

### 13.6
Reflection can be very useful in some cases.

1. it can help you observe or manipulate the runtime behavior of applications
2. It can help you debug or test programs, as you have direct access to methods, constructors, and fields
3. You can call methods by name when you don't know the method in advnace.

### 13.7

```
int sum = 0;

for( Country c: countries){
	if(c.getContinent().equals(continent)){
		sum += c.getPopulation();
	}
}

return sum

```

### 13.8

```

List<Integer> getRandomSubset(List<Integer> list){
	List<Integer> returnList = new ArrayList<Integer>();
	Random random = new Random();
	
	for(int a: list){
		if(random.nextBoolean()){
			returnList.add(a);
		}
	}
	
	return returnList;
}