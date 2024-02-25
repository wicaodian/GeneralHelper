package utils

import android.content.Context
import android.widget.Toast

object ToastHelper {
    private var currentToast: Toast? = null

    /**
     * Displays a short-duration toast message.
     *
     * @param context The context for showing the toast.
     * @param message The message to display.
     */
    fun shortToast(context: Context, message: String) {
        disposeCurrentToast()
        makeToastAndShow(context, message, Toast.LENGTH_SHORT)
    }

    /**
     * Displays a long-duration toast message.
     *
     * @param context The context for showing the toast.
     * @param message The message to display.
     */
    fun longToast(context: Context, message: String) {
        disposeCurrentToast()
        makeToastAndShow(context, message, Toast.LENGTH_LONG)
    }

    /**
     * Displays a toast message with a custom duration.
     *
     * @param context The context for showing the toast.
     * @param message The message to display.
     * @param duration The duration for the toast display.
     */
    fun customToastTime(context: Context, message: String, duration: Int) {
        disposeCurrentToast()
        makeToastAndShow(context, message, duration)
    }

    /**
     * Creates and shows a toast message.
     *
     * @param context The context for showing the toast.
     * @param message The message to display.
     * @param duration The duration for the toast display.
     */
    private fun makeToastAndShow(context: Context, message: String, duration: Int) {
        currentToast = Toast.makeText(context, message, duration).apply { show() }
    }

    /**
     * Cancels any current toast message being displayed and resets the reference.
     */
    private fun disposeCurrentToast() {
        currentToast?.cancel()
        currentToast = null
    }
}