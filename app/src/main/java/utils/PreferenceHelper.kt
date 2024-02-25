import android.content.Context

/**
 * A utility class for managing application preferences in Android apps,
 * simplifying the storage and retrieval of simple key-value pairs using Android's SharedPreferences.
 */
class PreferenceHelper {
    companion object {
        // Default name for the SharedPreferences file.
        private const val DEFAULT_PREF_NAME = "AppsPref"

        // Singleton instance of PreferencesClass.
        private lateinit var instance: PreferenceHelper

        /**
         * Returns the singleton instance of PreferencesClass, creating it if not already initialized.
         */
        fun getInstance(): PreferenceHelper {
            if (!::instance.isInitialized) {
                instance = PreferenceHelper()
            }
            return instance
        }
    }


    //region String Preference Functions

    /**
     * Retrieves a String preference value for the given key from the default SharedPreferences file.
     * If the key does not exist, returns an empty string.
     *
     * @param context The context used to access SharedPreferences.
     * @param key The name of the preference to retrieve.
     * @return The retrieved String value or an empty String if the key is not found.
     */
    fun getStringPreference(context: Context, key: String): String =
        getStringPreference(context, key, "", DEFAULT_PREF_NAME)

    /**
     * Retrieves a String preference value for the given key, with a specified default value, from the default SharedPreferences file.
     *
     * @param context The context used to access SharedPreferences.
     * @param key The name of the preference to retrieve.
     * @param defaultValue The default value to return if the preference is not found.
     * @return The retrieved String value or the specified default value if the key is not found.
     */
    fun getStringPreference(context: Context, key: String, defaultValue: String): String =
        getStringPreference(context, key, defaultValue, DEFAULT_PREF_NAME)

    /**
     * Retrieves a String preference value for the given key, with a specified default value, from a specified SharedPreferences file.
     *
     * @param context The context used to access SharedPreferences.
     * @param key The name of the preference to retrieve.
     * @param defaultValue The default value to return if the preference is not found.
     * @param fileName The name of the SharedPreferences file.
     * @return The retrieved String value or the specified default value if the key is not found.
     */
    fun getStringPreference(context: Context, key: String, defaultValue: String, fileName: String): String {
        val sharedPref = context.getSharedPreferences(fileName, Context.MODE_PRIVATE)
        return sharedPref.getString(key, defaultValue) ?: defaultValue
    }

    /**
     * Saves a String preference value under the given key in the specified SharedPreferences file.
     *
     * @param context The context used to access SharedPreferences.
     * @param key The name of the preference to save.
     * @param value The String value to save.
     * @param prefName The name of the SharedPreferences file (optional, defaults to DEFAULT_PREF_NAME).
     */
    fun setStringPreference(context: Context, key: String, value: String, prefName: String = DEFAULT_PREF_NAME) {
        val sharedPref = context.getSharedPreferences(prefName, Context.MODE_PRIVATE)
        with(sharedPref.edit()) {
            putString(key, value)
            apply()
        }
    }

    //endregion


    //region Int Preference Functions
    /**
     * Retrieves an Int preference value for the given key from the default SharedPreferences file.
     * If the key does not exist, returns 0 as the default value.
     *
     * @param context The context used to access SharedPreferences.
     * @param key The name of the preference to retrieve.
     * @return The retrieved Int value or 0 if the key is not found.
     */
    fun getIntPreference(context: Context, key: String): Int =
        getIntPreference(context, key, 0, DEFAULT_PREF_NAME)

    /**
     * Retrieves an Int preference value for the given key, with a specified default value, from the default SharedPreferences file.
     *
     * @param context The context used to access SharedPreferences.
     * @param key The name of the preference to retrieve.
     * @param defaultValue The default value to return if the preference is not found.
     * @return The retrieved Int value or the specified default value if the key is not found.
     */
    fun getIntPreference(context: Context, key: String, defaultValue: Int): Int =
        getIntPreference(context, key, defaultValue, DEFAULT_PREF_NAME)

    /**
     * Retrieves an Int preference value for the given key, with a specified default value, from a specified SharedPreferences file.
     * This allows for more granular control over which SharedPreferences file is used to store or retrieve the given preference.
     *
     * @param context The context used to access SharedPreferences.
     * @param key The name of the preference to retrieve.
     * @param defaultValue The default value to return if the preference is not found.
     * @param fileName The name of the SharedPreferences file from which to retrieve the preference.
     * @return The retrieved Int value or the specified default value if the key is not found.
     */
    fun getIntPreference(context: Context, key: String, defaultValue: Int, fileName: String): Int {
        val sharedPref = context.getSharedPreferences(fileName, Context.MODE_PRIVATE)
        return sharedPref.getInt(key, defaultValue)
    }


    fun setIntPreference(
            context: Context, key: String, value: Int, prefName: String = DEFAULT_PREF_NAME
                        ) {
        val sharedPref = context.getSharedPreferences(prefName, Context.MODE_PRIVATE)
        with(sharedPref.edit()) {
            putInt(key, value)
            apply()
        }
    }

    //endregion


    //region Boolean Preference Functions

    /**
     * Retrieves a Boolean preference value for the given key from the default SharedPreferences file.
     * If the key does not exist, returns false as the default value.
     *
     * @param context The context used to access SharedPreferences.
     * @param key The name of the preference to retrieve.
     * @return The retrieved Boolean value or false if the key is not found.
     */
    fun getBooleanPreference(context: Context, key: String): Boolean =
        getBooleanPreference(context, key, false, DEFAULT_PREF_NAME)

    /**
     * Retrieves a Boolean preference value for the given key, with a specified default value, from the default SharedPreferences file.
     *
     * @param context The context used to access SharedPreferences.
     * @param key The name of the preference to retrieve.
     * @param defaultValue The default value to return if the preference is not found.
     * @return The retrieved Boolean value or the specified default value if the key is not found.
     */
    fun getBooleanPreference(context: Context, key: String, defaultValue: Boolean): Boolean =
        getBooleanPreference(context, key, defaultValue, DEFAULT_PREF_NAME)

    /**
     * Retrieves a Boolean preference value for the given key, with a specified default value, from a specified SharedPreferences file.
     * This method provides flexibility to specify a custom SharedPreferences file name.
     *
     * @param context The context used to access SharedPreferences.
     * @param key The name of the preference to retrieve.
     * @param defaultValue The default value to return if the preference is not found.
     * @param fileName The name of the SharedPreferences file from which to retrieve the preference.
     * @return The retrieved Boolean value or the specified default value if the key is not found.
     */
    fun getBooleanPreference(context: Context, key: String, defaultValue: Boolean, fileName: String): Boolean {
        val sharedPref = context.getSharedPreferences(fileName, Context.MODE_PRIVATE)
        return sharedPref.getBoolean(key, defaultValue)
    }

    /**
     * Saves a Boolean preference value under the given key in the specified SharedPreferences file.
     *
     * @param context The context used to access SharedPreferences.
     * @param key The name of the preference to save.
     * @param value The Boolean value to save.
     * @param prefName The name of the SharedPreferences file (optional, defaults to DEFAULT_PREF_NAME).
     */
    fun setBooleanPreference(context: Context, key: String, value: Boolean, prefName: String = DEFAULT_PREF_NAME) {
        val sharedPref = context.getSharedPreferences(prefName, Context.MODE_PRIVATE)
        with(sharedPref.edit()) {
            putBoolean(key, value)
            apply()
        }
    }

//endregion


    //region Float Preference Functions

    /**
     * Retrieves a Float preference value for the given key from the default SharedPreferences file.
     * If the key does not exist, returns 0.0f as the default value.
     *
     * @param context The context used to access SharedPreferences.
     * @param key The name of the preference to retrieve.
     * @return The retrieved Float value or 0.0f if the key is not found.
     */
    fun getFloatPreference(context: Context, key: String): Float =
        getFloatPreference(context, key, 0.0f, DEFAULT_PREF_NAME)

    /**
     * Retrieves a Float preference value for the given key, with a specified default value, from the default SharedPreferences file.
     *
     * @param context The context used to access SharedPreferences.
     * @param key The name of the preference to retrieve.
     * @param defaultValue The default value to return if the preference is not found.
     * @return The retrieved Float value or the specified default value if the key is not found.
     */
    fun getFloatPreference(context: Context, key: String, defaultValue: Float): Float =
        getFloatPreference(context, key, defaultValue, DEFAULT_PREF_NAME)

    /**
     * Retrieves a Float preference value for the given key, with a specified default value, from a specified SharedPreferences file.
     * This method allows specifying a custom SharedPreferences file name, offering greater flexibility.
     *
     * @param context The context used to access SharedPreferences.
     * @param key The name of the preference to retrieve.
     * @param defaultValue The default value to return if the preference is not found.
     * @param fileName The name of the SharedPreferences file from which to retrieve the preference.
     * @return The retrieved Float value or the specified default value if the key is not found.
     */
    fun getFloatPreference(context: Context, key: String, defaultValue: Float, fileName: String): Float {
        val sharedPref = context.getSharedPreferences(fileName, Context.MODE_PRIVATE)
        return sharedPref.getFloat(key, defaultValue)
    }

    /**
     * Saves a Float preference value under the given key in the specified SharedPreferences file.
     *
     * @param context The context used to access SharedPreferences.
     * @param key The name of the preference to save.
     * @param value The Float value to save.
     * @param prefName The name of the SharedPreferences file (optional, defaults to DEFAULT_PREF_NAME).
     */
    fun setFloatPreference(context: Context, key: String, value: Float, prefName: String = DEFAULT_PREF_NAME) {
        val sharedPref = context.getSharedPreferences(prefName, Context.MODE_PRIVATE)
        with(sharedPref.edit()) {
            putFloat(key, value)
            apply()
        }
    }

//endregion


    //region  Utility Functions

    /**
     * Checks if the SharedPreferences contains a specific key.
     *
     * @param context The context used to access SharedPreferences.
     * @param key The preference key to check.
     * @param prefName The name of the SharedPreferences file (optional, defaults to DEFAULT_PREF_NAME).
     * @return True if the key exists, false otherwise.
     */
    fun containsKey(context: Context, key: String, prefName: String = DEFAULT_PREF_NAME): Boolean {
        val sharedPref = context.getSharedPreferences(prefName, Context.MODE_PRIVATE)
        return sharedPref.contains(key)
    }

    /**
     * Retrieves all key-value pairs from the specified SharedPreferences file.
     *
     * @param context The context used to access SharedPreferences.
     * @param prefName The name of the SharedPreferences file (optional, defaults to DEFAULT_PREF_NAME).
     * @return A map containing all key-value pairs.
     */
    fun getAllPreferences(context: Context, prefName: String = DEFAULT_PREF_NAME): Map<String, *> {
        val sharedPref = context.getSharedPreferences(prefName, Context.MODE_PRIVATE)
        return sharedPref.all
    }

    /**
     * Removes a specific preference entry from the SharedPreferences file.
     *
     * @param context The context used to access SharedPreferences.
     * @param key The preference key to remove.
     * @param prefName The name of the SharedPreferences file (optional, defaults to DEFAULT_PREF_NAME).
     */
    fun removePreference(context: Context, key: String, prefName: String = DEFAULT_PREF_NAME) {
        val sharedPref = context.getSharedPreferences(prefName, Context.MODE_PRIVATE)
        with(sharedPref.edit()) {
            remove(key)
            apply()
        }
    }

    /**
     * Clears all preferences from the specified SharedPreferences file.
     *
     * @param context The context used to access SharedPreferences.
     * @param prefName The name of the SharedPreferences file (optional, defaults to DEFAULT_PREF_NAME).
     */
    fun deleteAllSharedPreferences(context: Context, prefName: String = DEFAULT_PREF_NAME) {
        val sharedPref = context.getSharedPreferences(prefName, Context.MODE_PRIVATE)
        with(sharedPref.edit()) {
            clear()
            apply()
        }
    }

    //endregion

}