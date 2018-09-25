# Note

## Overloading VS Overriding

<b>Overloading</b>

Overloading is a term used to describe when two methods have the same name but differ in the type of number of arguments

<b>Overriding</b>

Overriding, occurs when a method shares the same name and function signature as another method in its super class.

## Collection Framework
Java's collection framework is incredibly useful.

### ArrayList
A dynamically resizing array, which grows as you insert elements.

```
ArrayList<String> myArr = new ArrayList<String>();
myArr.add("One");
myArr.add("Two");

System.out.println(Arrays.toString(myArr.toArray()))
```

### Vector
A vector is very similar to an ArrayList, except that it is synchronized.

```
Vector<String> vector = new Vector<String>();

```

### LinkedList
Java's built-in LinkedList class.

```

LinkedList<String> myLinkedList = new LinkedList<String>();

```

### HashMap
Java's built-in hashmap

```
HashMap<String, String> map = new HashMap<String, String>();

```