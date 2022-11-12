package za.co.duartbreedt.androidconceptsreference

import android.content.Context
import android.util.AttributeSet
import android.view.Gravity
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.annotation.AttrRes
import za.co.duartbreedt.androidconceptsreference.databinding.ViewMyCustomLayoutBinding

class MyCustomLayout : LinearLayout {

    private val binding: ViewMyCustomLayoutBinding

    constructor(context: Context)
            : this(context, null)

    constructor(context: Context, attrs: AttributeSet?)
            : this(context, attrs, NO_ID)

    constructor(context: Context, attrs: AttributeSet?, @AttrRes defStyleAttr: Int)
            : super(context, attrs, defStyleAttr) {

        val inflater = LayoutInflater.from(context)

        binding = ViewMyCustomLayoutBinding.inflate(inflater, this)

        gravity = Gravity.CENTER
        orientation = VERTICAL
    }

    fun setPrimaryText(text: String?) {
        binding.textPrimary.text = text
    }

    fun setSecondaryText(text: String?) {
        binding.textSecondary.text = text
    }
}
