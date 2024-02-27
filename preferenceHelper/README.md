# PreferencesClass Usage Guide

`PreferencesClass` is a utility class designed for Android applications to simplify the management of application preferences using Android's `SharedPreferences`.
It provides an easy and efficient way to **store**, **retrieve**, **remove**, and **check various data types** such as `String`, `Int`, `Boolean`, and `Float`.
This class is ideal for handling user settings and application configurations with minimal boilerplate code.

## Features

- **Easy Storage and Retrieval**: Seamlessly store and retrieve String, Int, Boolean, and Float data types.
- **Flexible Preference Management**: Offers functionality to remove specific preferences or check for the existence of preference keys.
- **Comprehensive Access**: Facilitates retrieval of all stored preferences and supports deletion of all preferences within a specified preference file.

## Setup
To use `PreferencesClass` in your Android project, simply copy the provided class into your project's source directory.
Ensure that your application has access to Android's Context as it is required for accessing SharedPreferences.

## Usage Examples

## Saving into Preferences
Save a `String` preference:

```kotlin
PreferencesClass.getInstance().setStringPreference(context, "user_name", "John Doe")
```

Save an `Int` preference:
```kotlin
PreferencesClass.getInstance().setIntPreference(context, "user_age", 30)
```
## Saving Preferences in a Different Preference File

Save a `Boolean` preference in a custom preference file:
```kotlin
PreferencesClass.getInstance().setBooleanPreference(context, "isPremiumUser", true, "app_info")
```
Save an `Int` preference in a custom preference file:
```kotlin
PreferencesClass.getInstance().setIntPreference(context, "user_age", 30, "user_info")
```

## Retrieving Preferences
Retrieve a `String` preference:

```kotlin
val userName = PreferencesClass.getInstance().getStringPreference(context, "user_name")
```
Retrieve an `Int` preference:
```kotlin
val userAge = PreferencesClass.getInstance().getIntPreference(context, "user_age")
```

## Retrieving Preferences with **default value**
Retrieve a `String` preference:

```kotlin
val userName = PreferencesClass.getInstance().getStringPreference(context, "user_name","defaultValue")
```
Retrieve an `Int` preference:
```kotlin
//50 is default value
val userAge = PreferencesClass.getInstance().getIntPreference(context, "user_age",50)
```

## Retrieving Preferences with different file
Retrieve a `String` preference:

```kotlin
val userName = PreferencesClass.getInstance().getStringPreference(context, "user_name","defaultvalue","newFile")
```
Retrieve an `Int` preference:
```kotlin
//50 is default value
val userAge = PreferencesClass.getInstance().getIntPreference(context, "user_age",50,"newFile")
```

## Checking for a Key's Existence
Check if a preference key exists:
```kotlin
val exists = PreferencesClass.getInstance().containsKey(context, "user_name")
```

## Deleting Preferences
Remove a specific preference:
```kotlin
PreferencesClass.getInstance().removePreference(context, "user_name")
```

## Delete all preferences within a specified file:
```kotlin
PreferencesClass.getInstance().deleteAllSharedPreferences(context)
```
## Retrieving All Preferences

The `getAllPreferences` function provides an easy way to retrieve all key-value pairs stored in a specific SharedPreferences file.
This can be particularly useful for debugging purposes or when you need to display all user preferences.

```kotlin
val allPrefs = PreferencesClass.getInstance().getAllPreferences(context)
for ((key, value) in allPrefs) {
    Log.d("Preferences", "Key: $key, Value: $value")
}

```

## Retrieving All Preferences With Custom File

The `getAllPreferences` function provides an easy way to retrieve all key-value pairs stored in a specific SharedPreferences file.
This can be particularly useful for debugging purposes or when you need to display all user preferences.

```kotlin
val allPrefs = PreferencesClass.getInstance().getAllPreferences(context, "CustomPrefName")
for ((key, value) in allPrefs) {
    Log.d("Preferences", "Key: $key, Value: $value")
}
```

## Understanding `.commit()` vs `.apply()`

When you're modifying the `PreferencesClass` to suit your specific needs, it's crucial to understand the difference between using `.commit()` and `.apply()` methods for saving SharedPreferences.

### `.commit()`:
- Saves the changes to the SharedPreferences **synchronously**, blocking the main thread until the save operation is completed.
- Returns a boolean value indicating the success or failure of the save operation.
- Should be used when you need to ensure the data is persisted immediately and if the result of the operation must be checked.
- Note: Using `.commit()` for large sets of data or frequent operations can lead to performance issues or ANR (Application Not Responding) dialogs due to its synchronous nature.

### `.apply()`:
- Saves the changes to the SharedPreferences **asynchronously**, without blocking the main thread.
- Does not return any value; it assumes the operation succeeds.
- Changes made with `.apply()` are written to memory immediately and flushed to disk on a separate thread.
- Recommended for most use cases where immediate persistence is not critical and when the operation's success does not need to be verified.

### Usage Considerations:
- **Use `.apply()`** for non-critical, frequent updates to shared preferences where the timing of the save is not crucial.
- **Opt for `.commit()`** when it's essential to know the outcome of the save operation or when immediate persistence is necessary (e.g., before the process is terminated).

By understanding these differences, you can modify the `PreferencesClass` to better suit your application's needs, choosing the appropriate method for saving preferences based on your specific requirements.


This guide assumes context refers to an instance of Context (e.g., an Activity or Application context). Adjust your implementation accordingly to ensure proper context management.
