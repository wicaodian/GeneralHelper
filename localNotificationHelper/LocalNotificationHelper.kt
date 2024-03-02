package utils

import android.app.Activity
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.BitmapFactory
import android.graphics.Color
import android.media.RingtoneManager
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat

class LocalNotificationHelper(private val context: Context) {

    // Companion object to hold static and constant fields
    companion object {
        // Request code for post notification permission request, used in Android 12 (API level 31) and above
        const val POST_NOTIFICATIONS_REQUEST_CODE = 101
    }

    /**
     * Creates a notification channel, which is required for notifications on Android 8.0 (API level 26) and above.
     * @param channelId A unique String identifier for the notification channel.
     * @param channelName The user-visible name of the channel, displayed in the system settings.
     * @param channelDescription The user-visible description of the channel.
     */
    fun createNotificationChannel(channelId: String, channelName: String, channelDescription: String) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(channelId, channelName, NotificationManager.IMPORTANCE_HIGH).apply {
                description = channelDescription
            }
            val notificationManager: NotificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }

    /**
     * Sends a notification to the user.
     * @param channelId The ID of the notification channel to use.
     * @param notificationId A unique integer ID for the notification.
     * @param title The title for the notification.
     * @param content The content text for the notification.
     * @param iconResId The resource ID for the notification icon.
     * @param destinationActivity The activity to open when the notification is tapped.
     */
    fun sendNotification(
            channelId: String,
            notificationId: Int,
            title: String,
            content: String,
            iconResId: Int,
            destinationActivity: Class<out Activity>
                        ) {
        val notificationManager: NotificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        val intent = Intent(context, destinationActivity)
        val pendingIntent = PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE)

        val notificationBuilder = NotificationCompat.Builder(context, channelId).apply {
            setSmallIcon(iconResId)
            setLargeIcon(BitmapFactory.decodeResource(context.resources, iconResId))
            setContentTitle(title)
            setContentText(content)
            setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION))
            setContentIntent(pendingIntent)
            setAutoCancel(true)
        }

        notificationManager.notify(notificationId, notificationBuilder.build())
    }

    /**
     * Checks if the application has notification posting permission.
     * This check is relevant for Android 13 (API level 33, Tiramisu) and above.
     * @return Boolean indicating whether the permission is granted.
     */
    fun hasNotificationPermission(): Boolean {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            checkNotificationPermission()
        } else {
            true
        }
    }

    /**
     * Helper method to check for POST_NOTIFICATIONS permission.
     * @return Boolean indicating whether the permission is granted.
     */
    private fun checkNotificationPermission(): Boolean {
        return ContextCompat.checkSelfPermission(context, android.Manifest.permission.POST_NOTIFICATIONS) == PackageManager.PERMISSION_GRANTED
    }

    /**
     * Requests the POST_NOTIFICATIONS permission from the user.
     * This is required for Android 13 (API level 33, Tiramisu) and above.
     */
    fun requestNotificationPermission() {
        if (context is Activity && Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            context.requestPermissions(arrayOf(android.Manifest.permission.POST_NOTIFICATIONS), POST_NOTIFICATIONS_REQUEST_CODE)
        }
    }

}