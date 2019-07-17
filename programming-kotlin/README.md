Following along with Programming Kotlin by Stephen Samuel and Stefan Bocutiu   

The Kotlin and Android book was a bit hard to follow since I am kind of new to both Kotlin AND Android.  

See https://github.com/PacktPublishing/Programming-Kotlin when lost.   

The file other.gradle can be used to specify a main class at the command line:
```shell
gradle --build-file other.gradle build --warning-mode all
gradle run --build-file other.gradle  -PmainClass=com.programming.kotlin.chapter03.ThirdKt
```

```text
src/main/kotlin/com/programming/kotlin/chapter02/Second.kt:164:fun main( args: Array< String > ) {
src/main/kotlin/com/programming/kotlin/chapter01/Program.kt:3:    fun main( args: Array< String > ) {
src/main/kotlin/com/programming/kotlin/chapter03/Third.kt:31:fun main( args: Array< String > ) {
```
