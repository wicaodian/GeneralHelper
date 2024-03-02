# LocalNotificationHelper Class Usage Guide

This `LocalNotificationHelper` simplifies handling notifications across various Android versions,
particularly focusing on creating notification channels, sending notifications, and managing notification permissions effectively.
Below is a guide on how to integrate and use this utility in your Android project.

## Setup
Ensure you have the necessary permissions declared in your `AndroidManifest.xml`
```xml
<uses-permission android:name="android.permission.POST_NOTIFICATIONS" />
```
```kotlin
val helper = LocalNotificationHelper(this)
```

## Usage
### Creating a Notification Channel
Notification channels are essential for Android 8.0 (API level 26) and above.
Create a notification channel before sending notifications:

```kotlin
val channelId = "your_channel_id"
val channelName = "Your Channel Name"
val channelDescription = "Your channel description"

// Call this method in your application's initialization phase, typically in onCreate() of your MainActivity or Application class.
helper.createNotificationChannel(channelId, channelName, channelDescription)
```

### General Notification Channel
```kotlin
helper.createNotificationChannel("general_notifications", "General Notifications", "All general app notifications.")
```

### Alerts Only Notification Channel
```kotlin
helper.createNotificationChannel("alerts", "Alerts", "Important alerts and warnings.")
```

### Chat Notification Channel
```kotlin
helper.createNotificationChannel("messages", "Messages", "Chat messages and conversation alerts.")
```

## Send Notifications

```kotlin
helper.sendNotification(
    channelId = "general_notifications",
    notificationId = 1,
    title = "Welcome",
    content = "Hello, welcome to our app!",
    iconResId = R.drawable.ic_notification,
    destinationActivity = MainActivity::class.java
)

```
## Managing Notification Permissions
For Android 13 and above, check and request notification permissions as needed:

```kotlin
if (!helper.hasNotificationPermission()) {
    // Request permission within an Activity context
    helper.requestNotificationPermission(activity)
}
```

## Conclusion
The Notification Helper class abstracts the complexities of Android's notification system, making it easier to work with notifications across different Android versions.
By following this guide, you can efficiently integrate notification functionality into your Android application.
