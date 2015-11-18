# TimberBug
Example of "Unexpected failure during lint analysis..." bug

To replicate:

```
./gradlew :app:lint
```

Output:

```
Unexpected failure during lint analysis of Foo.java (this is a bug in lint or one of the libraries it depends on)
EcjParser.equalsCompound(EcjParser.java:2351)->EcjParser$EcjResolvedClass.isSubclassOf(EcjParser.java:1381)->WrongTimberUsageDetector.isSubclassOf(WrongTimberUsageDetector.java:329)->WrongTimberUsageDetector.checkThrowablePosition(WrongTimberUsageDetector.java:448)
```

The offending [code](https://github.com/mattlogan/TimberBug/blob/master/app/src/main/java/me/mattlogan/timberbug/Foo.java#L8):

```
public class Foo<T> {

    public void logBar(T bar) {
        Timber.d("bar: %s", bar);
    }
}
```
