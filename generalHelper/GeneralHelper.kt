package utils

import android.Manifest.permission.ACCESS_NETWORK_STATE
import android.app.Activity
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.annotation.RequiresPermission

object GeneralHelper {
    /**
     * Toggles the visibility of a [View] between visible and gone.
     *
     * If the view is visible ([View.VISIBLE]), it will be set to gone ([View.GONE]).
     * Otherwise, it will be set to visible.
     *
     * @param view The [View] to toggle visibility on.
     */
    fun toggleVisibilityOf(view: View) {
        view.visibility = if (view.visibility == View.VISIBLE) View.GONE else View.VISIBLE
    }

    /**
     * Toggles the visibility of a [View] and executes a callback function after.
     *
     * @param view The [View] to toggle visibility on.
     * @param callback The function to execute after toggling visibility.
     */
    fun toggleVisibilityWithCallback(view: View, callback: () -> Unit) {
        view.visibility = if (view.visibility == View.VISIBLE) View.GONE else View.VISIBLE
        callback()
    }

    /**
     * Copies the given non-null text to the clipboard.
     *
     * @param context The context in which the clipboard operation should be performed.
     * @param text The non-null text to be copied to the clipboard. It can be an empty string.
     */
    fun copyTextToClipboard(context: Context, text: String) {
        val clipboardManager = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        val clipData = ClipData.newPlainText("label", text)
        clipboardManager.setPrimaryClip(clipData)
    }

    /**
     * Copies the given non-null text to the clipboard and invokes the callback after the clipboard operation is completed.
     *
     * @param context The context in which the clipboard operation should be performed.
     * @param text The non-null text to be copied to the clipboard. It can be an empty string.
     * @param callback The callback to be invoked after the clipboard operation is completed.
     */
    fun copyTextToClipboardWithCallback(context: Context, text: String, callback: () -> Unit) {
        val clipboardManager = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        val clipData = ClipData.newPlainText("label", text)
        clipboardManager.setPrimaryClip(clipData)
        callback()
    }

    /**
     * Determines if there is an active internet connection.
     *
     * Note: Requires the ACCESS_NETWORK_STATE permission in your AndroidManifest.xml:
     * `<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />`
     *
     * @param context Context to access the ConnectivityManager.
     * @return true if an internet connection is available, false otherwise.
     */
    @RequiresPermission(allOf = [ACCESS_NETWORK_STATE])
    fun isInternetAvailable(context: Context): Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork = connectivityManager.activeNetwork ?: return false
        val capabilities = connectivityManager.getNetworkCapabilities(activeNetwork) ?: return false
        return capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) ||
                capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) ||
                capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET)
    }

    /**
     * Generates a one-time password (OTP) with given specifications.
     *
     * @param passwordLength The length of the generated password. Defaults to 8 characters.
     * @param shuffleCharacters Flag to determine if the character set should be shuffled. Defaults to true.
     * @param random An instance of SecureRandom for cryptographic strength randomness. Defaults to a new instance.
     * @param includeLowercase Flag to include lowercase letters in the character set. Defaults to true.
     * @param includeUppercase Flag to include uppercase letters in the character set. Defaults to true.
     * @param includeDigits Flag to include digits in the character set. Defaults to true.
     * @param includeSpecialChars Flag to include special characters in the character set. Defaults to true.
     * @param exemptChars A list of characters to exclude from the password. Defaults to an empty list.
     * @return A string representing the generated one-time password.
     */
    fun generateRandomPassword(
            passwordLength: Int = 8,
            shuffleCharacters: Boolean = true,
            random: SecureRandom = SecureRandom(),
            exemptChars: List<Char> = emptyList(),
            includeLowercase: Boolean = true,
            includeUppercase: Boolean = true,
            includeDigits: Boolean = true,
            includeSpecialChars: Boolean = true
                               ): String {
        // Define character categories
        val lowercaseLetters = "abcdefghijklmnopqrstuvwxyz"
        val uppercaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
        val digits = "0123456789"
        val specialChars = "!@%$%&^?|~'\"#+=\\*/.,:;[]()-_<>"

        // Build the character set based on the flags provided
        val characterSet = StringBuilder().apply {
            if (includeLowercase) append(lowercaseLetters)
            if (includeUppercase) append(uppercaseLetters)
            if (includeDigits) append(digits)
            if (includeSpecialChars) append(specialChars)
        }.toString().toCharArray().toMutableList()

        // Shuffle the character set if required
        if (shuffleCharacters) {
            characterSet.shuffle(random)
        }

        // Remove exempt characters
        characterSet.removeAll(exemptChars)

        // Generate the password
        return (1..passwordLength)
            .map { characterSet[random.nextInt(characterSet.size)] }
            .joinToString("")
    }

    /**
     * Executes a given action on the main (UI) thread.
     *
     * This function is typically used when you need to update the UI
     * from a background thread, as only the main thread can make changes to the UI.
     * It uses the `ContextHandler.handler` to post the action to the main thread's message queue.
     *
     * @param action A lambda function that contains the code to be executed on the main thread.
     *               This is passed as a parameter and will be run on the UI thread.
     */
    fun runOnUiThread(action: () -> Unit) {
        ContextHandler.handler.post {
            action()
        }
    }


}