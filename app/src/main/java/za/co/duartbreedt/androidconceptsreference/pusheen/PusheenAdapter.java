package za.co.duartbreedt.androidconceptsreference.pusheen;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import za.co.duartbreedt.androidconceptsreference.databinding.ViewItemPusheenBinding;

public class PusheenAdapter extends RecyclerView.Adapter<PusheenViewHolder> {

    private final List<String> data;

    public PusheenAdapter(List<String> data) {
        this.data = data;
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @NonNull
    @Override
    public PusheenViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ViewItemPusheenBinding binding = ViewItemPusheenBinding.inflate(inflater);
        return new PusheenViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull PusheenViewHolder holder, int position) {
        String title = data.get(position);
        holder.setPusheen(title);
    }
}
