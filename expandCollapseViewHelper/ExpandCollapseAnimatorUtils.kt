package utils
import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ValueAnimator
import android.view.View
import android.view.ViewGroup

object ExpandCollapseAnimatorUtils {

    private const val DEFAULT_DURATION = 300L // Default animation duration set to 300 milliseconds.

    /**
     * Expands a view from a height of 0 to its measured height.
     *
     * @param v The view to expand.
     * @param duration The duration of the animation in milliseconds. Defaults to 300ms.
     */
    fun expandView(v: View, duration: Long = DEFAULT_DURATION) {
        // Measure the view to determine its target height.
        v.measure(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        val targetHeight = v.measuredHeight

        // Initially make the view invisible. It will be made visible right when the animation starts.
        v.visibility = View.INVISIBLE

        // Create and configure a ValueAnimator to animate from 0 to the target height.
        ValueAnimator.ofInt(0, targetHeight).apply {
            addUpdateListener { animation ->
                // Update the view's height for each frame of the animation.
                val layoutParams = v.layoutParams
                layoutParams.height = animation.animatedValue as Int
                v.layoutParams = layoutParams
            }
            addListener(object : AnimatorListenerAdapter() {
                override fun onAnimationStart(animation: Animator) {
                    // Make the view visible when the animation actually starts.
                    v.visibility = View.VISIBLE
                }
            })
            this.duration = duration // Set the animation duration.
            start() // Start the animation.
        }
    }

    /**
     * Collapses a view from its current height to 0, effectively hiding it.
     *
     * @param v The view to collapse.
     * @param duration The duration of the animation in milliseconds. Defaults to 300ms.
     */
    fun collapseView(v: View, duration: Long = DEFAULT_DURATION) {
        // Get the initial height of the view for the animation.
        val initialHeight = v.measuredHeight

        // Create and configure a ValueAnimator to animate from the current height to 0.
        ValueAnimator.ofInt(initialHeight, 0).apply {
            addUpdateListener { animation ->
                // Update the view's height for each frame of the animation.
                val layoutParams = v.layoutParams
                layoutParams.height = animation.animatedValue as Int
                v.layoutParams = layoutParams
            }
            addListener(object : AnimatorListenerAdapter() {
                override fun onAnimationEnd(animation: Animator) {
                    // Hide the view once the animation is complete.
                    v.visibility = View.GONE
                }
            })
            this.duration = duration // Set the animation duration.
            start() // Start the animation.
        }
    }
}
