
# String Helper Class

This class provides a collection of utility functions that can be used in various projects for string manipulation, validation, and more.
Below is a brief overview of each function and its usage.


## Usage
To use these functions, simply copy the Kotlin file into your project and call the functions with the necessary parameters.

## Functions

### capitalizeFirstLetterOfEachSentence
Capitalizes the first letter of each sentence in a string.
```kotlin
val result = capitalizeFirstLetterOfEachSentence("hello world. this is kotlin.")
println(result) // "Hello world. This is kotlin."

```
### reverseString
Reverses the given string.
```kotlin
val reversed = reverseString("Hello Kotlin")
println(reversed) // "nitolK olleH"

```
### countWords
Counts the number of words in a string.
```kotlin
val wordCount = countWords("Hello Kotlin World")
println(wordCount) // 3

```
### replaceSubstring
Replaces all occurrences of a substring with a new string, case-insensitively.
```kotlin
val replacedString = replaceSubstring("Hello Kotlin", "Kotlin", "Java")
println(replacedString) // "Hello Java"

```
### removeSubstring
Removes all occurrences of a specific substring, case-insensitively.
```kotlin
val stringWithoutSubstring = removeSubstring("Hello Kotlin", "Kotlin")
println(stringWithoutSubstring) // "Hello "

```
### removeExtraSpaces
Removes extra spaces from a string, leaving only single spaces between words.
```kotlin
val noExtraSpaces = removeExtraSpaces("Hello    Kotlin   ")
println(noExtraSpaces) // "Hello Kotlin"

```
### isEmailValid
Validates an email address.
```kotlin
val isValidEmail = isEmailValid("example@example.com")
println(isValidEmail) // true

```
### noNumbers
Checks if a string contains no numbers.
```kotlin
val containsNoNumbers = noNumbers("HelloKotlin")
println(containsNoNumbers) // true

```
### encodeToBase64
Encodes a string to Base64.
```kotlin
val base64Encoded = encodeToBase64("Hello Kotlin")
println(base64Encoded) // Encoded string

```
### decodeFromBase64
Decodes a Base64 encoded string.
```kotlin
val base64Decoded = decodeFromBase64("SGVsbG8gS290bGlu") // Assuming "SGVsbG8gS290bGlu" is the base64 encoded form of "Hello Kotlin"
println(base64Decoded) // "Hello Kotlin"

```
### generateRandomString
Generates a random string of a specified length.
```kotlin
val randomString = generateRandomString(10)
println(randomString) // Random string of length 10

```
### maskString
Masks a string, leaving only the last few characters visible.
```kotlin
val masked = maskString("HelloKotlin", 4)
println(masked) // "*****otlin"

val maskedString = maskString("123456789", visibleCount = 4, maskChar = '#')
println(maskedString) // Output: #####6789

val creditCard = "1234567890123456"
val maskedCreditCard = maskString(creditCard, visibleCount = 4)
println(maskedCreditCard) // Output: ************3456

val email = "user@example.com"
val maskedEmail = email.substringBefore('@').let { localPart ->
    maskString(localPart, visibleCount = 1) + email.substringAfter('@')
}
println(maskedEmail) // Output could be something like: "****@example.com", depending on the length of the local part.


```
### splitStringToList
Splits a string into a list by a delimiter.
```kotlin
val list = splitStringToList("Hello, Kotlin, World", ",")
println(list) // ["Hello", "Kotlin", "World"]

```
### joinListToString
Joins a list of strings into a single string with a specified delimiter.
```kotlin
val joinedString = joinListToString(listOf("Hello", "Kotlin", "World"), "-")
println(joinedString) // "Hello-Kotlin-World"

```
### onlyNumbers
Checks if a string contains only numbers.
```kotlin
val isOnlyNumbers = onlyNumbers("12345")
println(isOnlyNumbers) // true

```
### allUpperCase
Checks if all characters in a string are uppercase.
```kotlin
val isAllUpperCase = allUpperCase("HELLO")
println(isAllUpperCase) // true

```
### allLowerCase
Checks if all characters in a string are lowercase.
```kotlin
val isAllLowerCase = allLowerCase("hello")
println(isAllLowerCase) // true

```
### atLeastOneLowerCase
Checks if there is at least one lowercase letter in a string.
```kotlin
val hasLowerCase = atLeastOneLowerCase("HelloKotlin")
println(hasLowerCase) // true

```
### atLeastOneUpperCase
Checks if there is at least one uppercase letter in a string.
```kotlin
val hasUpperCase = atLeastOneUpperCase("helloKotlin")
println(hasUpperCase) // true

```
### atLeastOneNumber
Checks if there is at least one number in a string.
```kotlin
val hasNumber = atLeastOneNumber("HelloKotlin1")
println(hasNumber) // true

```
### startsWithNonNumber
Checks if a string starts with a non-umeric character.
```kotlin
val startsNonNumber = startsWithNonNumber("Hello123")
println(startsNonNumber) // true

```
### noSpecialCharacter
Checks if a string contains no special characters.
```kotlin
val noSpecial = noSpecialCharacter("HelloKotlin123")
println(noSpecial) // true

```
### atLeastOneSpecialCharacter
Checks if a string contains at least one special character.
```kotlin
val hasSpecialCharacter = atLeastOneSpecialCharacter("Hello*Kotlin")
println(hasSpecialCharacter) // true

```
