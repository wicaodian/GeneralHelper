# General Helper Class & more

I've developed a General Helper class for my Android projects, which has significantly streamlined my development process. To keep myself active on GitHub and share the convenience this class offers, I've embarked on a new challenge: to commit new functions to the General Helper class daily. This way, I hope to share the tools and shortcuts that have made my development journey smoother with the wider developer community.

## Usage
Copy this class into your Android project

Since GeneralHelper is defined as an object class, you can directly invoke its functions using the class name.

## List of functions available

### toggleVisibilityOf
```kotlin

// Assuming `myView` is a View object in your layout
GeneralHelper().toggleVisibilityOf(myView)

```
### toggleVisibilityWithCallback
```kotlin
// Assuming `myView` is a View object in your layout
GeneralHelper(). toggleVisibilityWithCallback(myView) {
    Log.d("VisibilityToggle", "Visibility change completed")
}
```

### copyTextToClipboard
```kotlin
// Usage without callback
val textToCopy = "This is the text to copy to clipboard"
GeneralHelper().copyTextToClipboard(context, textToCopy)
```

### copyTextToClipboardWithCallback
```kotlin
// Usage with callback
val textToCopy = "This is the text to copy to clipboard"
GeneralHelper().copyTextToClipboard(context, textToCopy) {
// Callback lambda: Perform actions after the clipboard operation is completed
// For example, show a toast message indicating that the text has been copied 
    GeneralHelper().showToast(context, "Text copied to clipboard")
}
```

### isInternetAvailable
```kotlin
if (GeneralHelper().isInternetAvailable(this)) {
    // Internet is available
    GeneralHelper().showToast(this, "Internet is available")
} else {
    // Internet is not available
    GeneralHelper().showToast(this, "Internet is not available")
}
```