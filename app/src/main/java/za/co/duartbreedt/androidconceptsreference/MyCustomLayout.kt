package za.co.duartbreedt.androidconceptsreference

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.util.TypedValue
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
            : this(context, attrs, R.attr.myCustomLayout)

    constructor(context: Context, attrs: AttributeSet?, @AttrRes defStyleAttr: Int)
            : super(context, attrs, defStyleAttr) {

        val inflater = LayoutInflater.from(context)

        binding = ViewMyCustomLayoutBinding.inflate(inflater, this)

        setAttributes(attrs, defStyleAttr)

        gravity = Gravity.CENTER
        orientation = VERTICAL
    }

    private fun setAttributes(attrs: AttributeSet?, defStyleAttr: Int) {
        val attributes: TypedArray = context.theme.obtainStyledAttributes(attrs, R.styleable.MyCustomLayout, defStyleAttr, 0)

        // Primary text
        setPrimaryText(attributes.getString(R.styleable.MyCustomLayout_android_text))

        val primaryTextSizePx = attributes.getDimension(R.styleable.MyCustomLayout_android_textSize, 0f)
        binding.textPrimary.setTextSize(TypedValue.COMPLEX_UNIT_PX, primaryTextSizePx)

        binding.textPrimary.setTextColor(attributes.getColorStateList(R.styleable.MyCustomLayout_android_textColor))

        // Secondary text
        setSecondaryText(attributes.getString(R.styleable.MyCustomLayout_secondaryText))

        val secondaryTextSizePx = attributes.getDimension(R.styleable.MyCustomLayout_secondaryTextSize, 0f)
        binding.textSecondary.setTextSize(TypedValue.COMPLEX_UNIT_PX, secondaryTextSizePx)

        binding.textSecondary.setTextColor(attributes.getColorStateList(R.styleable.MyCustomLayout_secondaryTextColor))

        attributes.recycle()
    }

    fun setPrimaryText(text: String?) {
        binding.textPrimary.text = text
    }

    fun setSecondaryText(text: String?) {
        binding.textSecondary.text = text
    }
}
