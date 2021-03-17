package com.ramitsuri.forumhub.android.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.NO_POSITION
import com.ramitsuri.forumhub.android.R
import com.ramitsuri.forumhub.android.databinding.StoryItem2Binding
import com.ramitsuri.forumhub.android.util.Logger
import com.ramitsuri.forumhub.android.util.setIconStart
import com.ramitsuri.forumhub.shared.network.hn.HNStoryResponse

class StoryListAdapter : RecyclerView.Adapter<StoryListAdapter.ViewHolder>() {
    private val items: MutableList<HNStoryResponse> = mutableListOf()
    var onItemClick: ((HNStoryResponse) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemBinding =
            StoryItem2Binding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(itemBinding).apply {
            itemBinding.root.setOnClickListener {
                Logger.i("", "Clicked")
                val clickPosition = bindingAdapterPosition
                if (clickPosition != NO_POSITION) {
                    onItemClick?.let {
                        it(items[clickPosition])
                    }
                }
            }
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val value = items[position]
        holder.bind(value)
    }

    fun setItems(newItems: List<HNStoryResponse>) {
        val previousItemSize = newItems.size
        items.clear()
        items.addAll(newItems)
        notifyItemRangeChanged(previousItemSize, newItems.size)
    }

    override fun getItemCount() = items.size

    inner class ViewHolder(private val binding: StoryItem2Binding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: HNStoryResponse) {
            binding.apply {
                icon.setImageResource(R.drawable.ic_home)
                txtTitle.text = item.title
                txtHost.text = "(ycombinator.com)"
                txtDetail1.text = item.creationTime.toString()
                txtDetail1.setIconStart(R.drawable.ic_time)
                txtDetail2.text = item.author
                txtDetail2.setIconStart(R.drawable.ic_author)
                txtDetail3.text = item.score.toString()
                txtDetail3.setIconStart(R.drawable.ic_score)
                txtDetail4.text = item.children.size.toString()
                txtDetail4.setIconStart(R.drawable.ic_comments)
                btnBrowser.setOnClickListener {
                    Logger.i("", "Clicked browser button")
                }
            }
        }
    }
}