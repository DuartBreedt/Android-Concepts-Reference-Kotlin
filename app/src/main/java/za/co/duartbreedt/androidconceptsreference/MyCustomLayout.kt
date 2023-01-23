package za.co.duartbreedt.androidconceptsreference

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import androidx.annotation.AttrRes

class MyCustomLayout : LinearLayout {

    constructor(context: Context)
            : this(context, null)

    constructor(context: Context, attrs: AttributeSet?)
            : this(context, attrs, NO_ID)

    constructor(context: Context, attrs: AttributeSet?, @AttrRes defStyleAttr: Int)
            : super(context, attrs, defStyleAttr)

    fun getAppName(): String {
        return context.getString(R.string.app_name)
    }
}
