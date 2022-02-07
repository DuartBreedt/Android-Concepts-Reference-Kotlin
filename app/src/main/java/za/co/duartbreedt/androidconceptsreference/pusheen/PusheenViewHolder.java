package za.co.duartbreedt.androidconceptsreference.pusheen;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import za.co.duartbreedt.androidconceptsreference.databinding.ViewItemPusheenBinding;

public class PusheenViewHolder extends RecyclerView.ViewHolder {

    private final ViewItemPusheenBinding binding;

    public PusheenViewHolder(@NonNull ViewItemPusheenBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void setPusheen(String pusheen) {
        binding.textPrimary.setText(pusheen);
    }
}
