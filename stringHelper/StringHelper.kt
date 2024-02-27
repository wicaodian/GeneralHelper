
object StringHelper{

    fun capitalizeFirstLetterOfEachSentence(input: String): String {
        return input.split('.').joinToString(".") { sentence ->
            sentence.trimStart().replaceFirstChar { if (it.isLowerCase()) it.titlecase() else it.toString() }
        }.trim()
    }

    fun reverseString(input: String): String {
        return input.reversed()
    }

    fun countWords(input: String): Int {
        if (input.isEmpty()) return 0
        return input.trim().split("\\s+".toRegex()).size
    }
    fun replaceSubstring(input: String, old: String, new: String): String {
        return input.replace(old, new, ignoreCase = true)
    }
    fun removeSubstring(input: String, substring: String): String {
        return input.replace(substring, "", ignoreCase = true)
    }

    fun removeExtraSpaces(input: String): String {
        return input.trim().replace("\\s+".toRegex(), " ")
    }
    fun isEmailValid(email: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
    fun noNumbers(input: String): Boolean {
        return !input.matches(Regex(".*\\d.*"))
    }
    fun encodeToBase64(input: String): String {
        return Base64.getEncoder().encodeToString(input.toByteArray())
    }
    fun decodeFromBase64(input: String): String {
        return String(Base64.getDecoder().decode(input))
    }
    fun generateRandomString(length: Int): String {
        val allowedChars = ('A'..'Z') + ('a'..'z') + ('0'..'9')
        return (1..length)
            .map { allowedChars.random() }
            .joinToString("")
    }
    fun maskString(input: String, visibleCount: Int = 4, maskChar: Char = '*'): String {
        return if (input.length <= visibleCount) input
        else maskChar.toString().repeat(input.length - visibleCount) + input.takeLast(visibleCount)
    }
    fun splitStringToList(input: String, delimiter: String = ","): List<String> {
        return input.split(delimiter).map { it.trim() }
    }
    fun joinListToString(input: List<String>, delimiter: String = ","): String {
        return input.joinToString(delimiter)
    }
    fun onlyNumbers(input: String): Boolean {
        return input.matches(Regex("\\d+"))
    }

    fun allUpperCase(input: String): Boolean {
        return input == input.uppercase()
    }

    fun allLowerCase(input: String): Boolean {
        return input == input.lowercase()
    }

    fun atLeastOneLowerCase(input: String): Boolean {
        return input.matches(Regex(".*[a-z].*"))
    }

    fun atLeastOneUpperCase(input: String): Boolean {
        return input.matches(Regex(".*[A-Z].*"))
    }

    fun atLeastOneNumber(input: String): Boolean {
        return input.matches(Regex(".*\\d.*"))
    }

    fun startsWithNonNumber(input: String): Boolean {
        if (input.isEmpty()) return true
        return !Character.isDigit(input[0])
    }

    fun noSpecialCharacter(input: String): Boolean {
        return input.matches(Regex("[A-Za-z0-9]*"))
    }

    fun atLeastOneSpecialCharacter(input: String): Boolean {
        return !input.matches(Regex("[A-Za-z0-9]*"))
    }
}