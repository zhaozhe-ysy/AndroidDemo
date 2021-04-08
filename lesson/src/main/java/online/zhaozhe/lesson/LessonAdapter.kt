package online.zhaozhe.lesson
import online.zhaozhe.lesson.entity.Lesson

import android.view.LayoutInflater
import android.view.View

import android.view.ViewGroup
import online.zhaozhe.core.BaseViewHolder

import androidx.recyclerview.widget.RecyclerView


class LessonAdapter : RecyclerView.Adapter<LessonAdapter.LessonViewHolder>() {
    private var list: List<Lesson> = ArrayList()
    fun updateAndNotify(list: List<Lesson>) {
        this.list = list
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LessonViewHolder {
        return LessonViewHolder.onCreate(parent)
    }

    override fun onBindViewHolder(holder: LessonViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    /**
     * 静态内部类
     */
    class LessonViewHolder internal constructor(itemView: View) : BaseViewHolder(itemView) {
        fun onBind(lesson: Lesson) {
            var date = lesson.getDate()
            if (date == null) {
                date = "日期待定"
            }
            setText(R.id.tv_date, date)
            setText(R.id.tv_content, lesson.getContent())
            val state = lesson.getState()
            if (state != null) {
                setText(R.id.tv_state, state.stateName())
                var colorRes: Int = R.color.playback
                when (state) {
                    Lesson.State.PLAYBACK -> {

                        // 即使在 {} 中也是需要 break 的。
                        colorRes = R.color.playback
                    }
                    Lesson.State.LIVE -> colorRes = R.color.live
                    Lesson.State.WAIT -> colorRes = R.color.wait
                }
                val backgroundColor = itemView.context.getColor(colorRes)
                getView<View>(R.id.tv_state)!!.setBackgroundColor(backgroundColor)
            }
        }

        companion object {
            fun onCreate(parent: ViewGroup): LessonViewHolder {
                return LessonViewHolder(
                    LayoutInflater
                        .from(parent.context)
                        .inflate(R.layout.item_lesson, parent, false)
                )
            }
        }
    }
}