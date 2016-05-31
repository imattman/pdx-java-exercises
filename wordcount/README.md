# Word Count

Write a program that that's composed of two (or more) classes, one with the responsibility of tracking word stats, and the other responsible for supplying the source of words.

Try to make the WordStats class flexible for easy reuse by accepting a general word source such as Iterator<String>.

There could be different implementations of string source: from files, from text fetched from a URL, etc., so long as the contract is fulfilled of producing an Iterator<String>.

Create a 3rd class that provides the main() and glues the other two together, giving a clean separation of responsibilities.

The end result should print out the counts of unique words in descending order by count.

_example:_
```shell
$ java -cp . MyAwesomeWordCounter  foobar-text-file.txt

101  foo
99  bar
99  baz
24  yadda
```

