package za.co.duartbreedt.androidconceptsreference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

import za.co.duartbreedt.androidconceptsreference.databinding.ViewMyCustomLayoutBinding;

public class MyCustomLayout extends LinearLayout {

    private ViewMyCustomLayoutBinding binding;

    public MyCustomLayout(Context context) {
        this(context, null);
    }

    public MyCustomLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        LayoutInflater inflater = LayoutInflater.from(context);
        binding = ViewMyCustomLayoutBinding.inflate(inflater, this);

        setGravity(Gravity.CENTER);
        setOrientation(LinearLayout.VERTICAL);
    }

    public void setPrimaryText(String text) {
        binding.primaryText.setText(text);
    }

    public void setSecondaryText(String text) {
        binding.secondaryText.setText(text);
    }
}
