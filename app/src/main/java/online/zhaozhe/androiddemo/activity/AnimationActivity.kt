package online.zhaozhe.androiddemo.activity

import android.animation.*
import android.graphics.Point
import android.graphics.PointF
import android.os.Bundle
import android.os.PersistableBundle
import android.view.animation.AccelerateDecelerateInterpolator
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_animation.*
import online.zhaozhe.androiddemo.R
import online.zhaozhe.androiddemo.widget.ProvinceEvaluator
import online.zhaozhe.core.utils.dp

class AnimationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animation)
        
//        val animator = ObjectAnimator.ofFloat(circle_view,"radius",150.dp).apply {
//            startDelay = 1000
//        }.start()


//        val topFlipAnimator = ObjectAnimator.ofFloat(camera_view,"topFlip",-60f).apply {
//            startDelay = 200
//            duration = 1000
//        }
//
//        val bottomFlipAnimator = ObjectAnimator.ofFloat(camera_view,"bottomFlip",60f).apply {
//            startDelay = 1000
//            duration = 1000
//        }
//
//        val flipRoatationAnimator = ObjectAnimator.ofFloat(camera_view,"flipRotation",270f).apply {
//            startDelay = 200
//            duration = 1000
//        }
//
//        val animatorSet = AnimatorSet().apply {
//            playSequentially(bottomFlipAnimator,flipRoatationAnimator,topFlipAnimator)
//        }.start()


//        val bottomFlipHolder = PropertyValuesHolder.ofFloat("bottomFlip",60f)
//        val flipRoatationHolder = PropertyValuesHolder.ofFloat("flipRotation",270f)
//        val topFlipHolder = PropertyValuesHolder.ofFloat("topFlip",-60f)
//        val holderAnimator = ObjectAnimator.ofPropertyValuesHolder(camera_view,bottomFlipHolder,flipRoatationHolder,topFlipHolder)
//        holderAnimator.startDelay = 1000
//        holderAnimator.duration = 2000
//        holderAnimator.start()

//        val length = 200.dp
//        val keyFrame1 = Keyframe.ofFloat(0f,0f)
//        val keyFrame2 = Keyframe.ofFloat(0.2f,0.4f * length)
//        val keyFrame3 = Keyframe.ofFloat(0.8f,0.6f * length)
//        val keyFrame4 = Keyframe.ofFloat(1f,1f * length)
//        val keyFrameHolder = PropertyValuesHolder.ofKeyframe("translationX",keyFrame1,keyFrame2,keyFrame3,keyFrame4)
//        val animator = ObjectAnimator.ofPropertyValuesHolder(camera_view,keyFrameHolder)
//        animator.startDelay = 1000
//        animator.duration = 3000
//        animator.start()

        val animator = ObjectAnimator.ofObject(point_view,"point",PointEvaluator(),PointF(100.dp,200.dp))
        animator.startDelay = 1000
        animator.duration = 2000
        animator.start()

//        val animator = ObjectAnimator.ofObject(province_view,"province", ProvinceEvaluator(),"澳门特别行政区")
//        animator.startDelay = 1000
//        animator.duration = 10000
//        animator.start()

    }

    class PointEvaluator : TypeEvaluator<PointF> {

        override fun evaluate(fraction: Float, startValue: PointF, endValue: PointF): PointF {
            val startX = startValue.x
            val endX = endValue.x
            val currentX = startX + (endX - startX) * fraction

            val startY = startValue.y
            val endY = endValue.y
            val currentY = startY + (endY - startY) * fraction
            return PointF(currentX,currentY)
        }

    }
}