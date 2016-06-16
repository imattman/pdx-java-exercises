# Word Count

Write a program that that's composed of two (or more) classes, one with the responsibility of tracking word stats, and the other responsible for supplying the source of words.

Try to make the WordStats class flexible for easy reuse by accepting a general word source such as an `Iterator<String>`.

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


### Additional Reading

Some fun computing history can be found in the [article describing the word count solutions][1] provided by computing greats Donald Knuth and Doug McIlroy.

Knuth supplied a detailed and very intricate program that used a "clever, purpose-built data structure for keeping track of the words and frequency counts" and spanned several pages of Pascal code.

McIlroy responded with a simple 6-command shell pipeline, powerful and elegant in its simplicity:

```shell
tr -cs A-Za-z '\n' |
tr A-Z a-z |
sort |
uniq -c |
sort -rn |
sed ${1}q
```

:-)

[1]: http://www.leancrew.com/all-this/2011/12/more-shell-less-egg/

