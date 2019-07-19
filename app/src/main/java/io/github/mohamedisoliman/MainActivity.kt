package io.github.mohamedisoliman

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.TransitionManager
import androidx.constraintlayout.widget.ConstraintSet
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var toggle = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val scene = ConstraintSet()
        scene.clone(root)
        val scene1 = ConstraintSet()
        scene1.clone(this, R.layout.activity_main_poster_expanded)
        poster.setOnClickListener {
            val transition = if (toggle) scene else scene1
            TransitionManager.beginDelayedTransition(root)
            transition.applyTo(root)
            toggle = !toggle
        }
    }
}
