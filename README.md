Extended String Builder
=======================
[![Build Status](https://travis-ci.org/JPDSousa/ExtendedStringBuilder.svg?branch=master)](https://travis-ci.org/JPDSousa/ExtendedStringBuilder)
[![codecov](https://codecov.io/gh/JPDSousa/ExtendedStringBuilder/branch/master/graph/badge.svg)](https://codecov.io/gh/JPDSousa/ExtendedStringBuilder)
[![](https://jitpack.io/v/JPDSousa/ExtendedStringBuilder.svg)](https://jitpack.io/#JPDSousa/ExtendedStringBuilder)

Extended String Builder is a simple utility library that extends the common [StringBuilder](https://docs.oracle.com/javase/7/docs/api/java/lang/StringBuilder.html) from java's native library.

The Extended String Builder wraps the classic StringBuilder, adding additional utility methods that make this object much more useful to programmers.

How To Use?
---------------

Simply call `StringBuilder.create()` to create a default (extended) string builder. From there just use the available methods to build your strings!

Conditional concatenation
-------------------------

ExtendedStringBuilder provides an additional feature of conditional concatenation, through `StringBuilder.appendIf()`. This allows code simplification:

Without ExtendedStringBuilder:
```java
if(condition) {
  builder.append(chunck);
}
```
With ExtendedStringBuilder:
```java
extBuilder.appendIf(condition, chunck);
```

Additionally, you can call `StringBuilder.appendIf(condition)` to access a `ConditionalStringBuilder`, where you can perform more elaborate operations. When you're done with the conditional operations call `StringBuilder.endIf()` to return to the main StringBuilder:

```java
extBuilder.appendIf(a == 4)
          .append("variable a equals 4")
          .breakLine()
          .endIf()
          .append("Done!");
```
