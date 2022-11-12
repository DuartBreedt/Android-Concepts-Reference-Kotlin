package za.co.duartbreedt.androidconceptsreference.pusheen

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import za.co.duartbreedt.androidconceptsreference.databinding.ViewItemPusheenBinding

class PusheenAdapter(
    private val data: List<String>
) : RecyclerView.Adapter<PusheenViewHolder>() {

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PusheenViewHolder {

        val inflater = LayoutInflater.from(parent.context)

        val binding: ViewItemPusheenBinding = ViewItemPusheenBinding.inflate(inflater)

        return PusheenViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PusheenViewHolder, position: Int) {

        val title = data[position]

        holder.setPusheen(title)
    }
}
