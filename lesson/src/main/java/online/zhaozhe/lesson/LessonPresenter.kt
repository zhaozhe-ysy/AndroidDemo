package online.zhaozhe.lesson

import online.zhaozhe.lesson.entity.Lesson

import androidx.annotation.NonNull
import androidx.appcompat.app.AppCompatActivity

import online.zhaozhe.core.http.EntityCallback

import com.google.gson.reflect.TypeToken
import online.zhaozhe.core.http.HttpClient
import online.zhaozhe.core.utils.Utils
import java.lang.reflect.Type


class LessonPresenter(val activity: LessonActivity) {
    companion object{
        private const val LESSON_PATH = "lessons"
    }


    private var lessons: List<Lesson> = ArrayList()

    private val type: Type = object : TypeToken<List<Lesson?>?>() {}.type

    fun fetchData() {
        HttpClient.INSTANCE.get(LESSON_PATH, type, object : EntityCallback<List<Lesson>> {
            override fun onSuccess(lessons: List<Lesson>) {
                this@LessonPresenter.lessons = lessons
                activity!!.runOnUiThread { activity.showResult(lessons) }
            }

            override fun onFailure(message: String?) {
                activity!!.runOnUiThread { Utils.toast(message) }
            }
        })
    }

    fun showPlayback() {
        val playbackLessons: MutableList<Lesson> = ArrayList()
        for (lesson in lessons) {
            if (lesson.getState() === Lesson.State.PLAYBACK) {
                playbackLessons.add(lesson)
            }
        }
        activity.showResult(playbackLessons)
    }
}