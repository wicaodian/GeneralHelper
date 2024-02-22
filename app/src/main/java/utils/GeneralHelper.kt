package utils

import android.content.Context
import android.view.View
import android.widget.Toast

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
     * Displays a toast message.
     *
     * @param context The context in which the toast should be displayed.
     * @param message The message to be displayed in the toast.
     * @param duration The duration for which the toast should be displayed. Defaults to [Toast.LENGTH_SHORT].
     */
    fun showToast(context: Context, message: String, duration: Int = Toast.LENGTH_SHORT) {
        Toast.makeText(context, message, duration).show()
    }
}