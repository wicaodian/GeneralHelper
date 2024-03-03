# ExpandCollapseAnimatorUtils

A Kotlin utility class for animating the expansion and collapse of `View` elements in Android.
This utility provides a smooth animation effect for showing or hiding content in your app, enhancing the user experience.

## Setup

To use `ExpandCollapseAnimatorUtils` in your project, follow these steps:

1. **Copy the Class**: Copy the `ExpandCollapseAnimatorUtils.kt` file into your project's `util` package or any other relevant package within your app.

2. **Ensure Compatibility**: This class is compatible with all Android versions that support property animations (Android 3.1, API level 12 and up). Make sure your `minSdkVersion` is set accordingly.

## Usage

The `ExpandCollapseAnimatorUtils` object provides two main functions:

- `expandView(view: View, duration: Long = DEFAULT_DURATION)`: Expands the view from a height of 0 to its measured height.
- `collapseView(view: View, duration: Long = DEFAULT_DURATION)`: Collapses the view from its current height to 0, effectively hiding it.

### Expanding a View

To expand a view, simply call the `expandView` method with the view you wish to animate:

```kotlin
ExpandCollapseAnimatorUtils.expandView(myView)

// You can also specify the duration of the animation in milliseconds:
ExpandCollapseAnimatorUtils.expandView(myView, 500) // Expand over half a second
```

### Collapsing a View
To collapse a view, use the `collapseView` method:
```kotlin
ExpandCollapseAnimatorUtils.collapseView(myView)

// You can also specify the duration of the animation in milliseconds:
ExpandCollapseAnimatorUtils.collapseView(myView, 500) // Collapse over half a second
```
