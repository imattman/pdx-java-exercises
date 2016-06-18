# Word Count Solution

To build and run:

```shell
# from directory 'wordcount-solution'

$ gradle clean installDist

# all build artifacts are under 'build/' 
# with gradle-generated script under 'build/install/.../bin/...'
# script makes things easier by setting java class path and passing along args

$ build/install/wordcount-solution/bin/wordcount-solution  src/test/resources/poe-raven.txt
```


