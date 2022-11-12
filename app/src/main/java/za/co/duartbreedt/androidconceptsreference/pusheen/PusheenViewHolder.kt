package za.co.duartbreedt.androidconceptsreference.pusheen

import androidx.recyclerview.widget.RecyclerView
import za.co.duartbreedt.androidconceptsreference.databinding.ViewItemPusheenBinding

class PusheenViewHolder(
    private val binding: ViewItemPusheenBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun setPusheen(pusheen: String?) {
        binding.textPrimary.text = pusheen
    }
}
