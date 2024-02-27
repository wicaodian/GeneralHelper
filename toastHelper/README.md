# ToastHelper Usage Guide

`ToastHelper` is a class that provides a set of functions to display toast messages in an Android application. The class is designed
to simplify the process of displaying toast messages.

## Setup
To use `ToastHelper` in your Android project, simply copy the provided class into your project's source directory.
Ensure that your application has access to Android's Context as it is required for accessing SharedPreferences.


### showToast
```kotlin
// Display a short toast message
GeneralHelper().showToast(context, "Hello, world!")

// Display a long toast message
GeneralHelper().showToast(context, "This is a longer message", Toast.LENGTH_LONG)

// Display a custom duration toast message (e.g., 3 seconds)
val customDuration = 3000 // milliseconds
GeneralHelper().showToast(context, "Custom duration toast", customDuration)
```
