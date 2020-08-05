package com.io.tazarapp.ui.fragments.partners

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.io.tazarapp.R
import com.io.tazarapp.model.Makala


class PartnersAdapter(private val function: (Makala) -> Unit) :
    RecyclerView.Adapter<PartnersAdapter.MainItemViewHolder>() {
    private var category: List<Makala> = mutableListOf()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view: View = inflater.inflate(R.layout.item_main_items, parent, false)
        return MainItemViewHolder(
            view,
            function
        )
    }


    fun update(list: ArrayList<Makala>) {
        this.category = list
        notifyDataSetChanged()

    }

    override fun getItemCount(): Int {
        return category.size
    }

    override fun onBindViewHolder(holder: MainItemViewHolder, position: Int) {
        holder.bind(category[position])
    }


    class MainItemViewHolder(itemView: View, val function: (Makala) -> Unit) :
        RecyclerView.ViewHolder(itemView) {

        var title: TextView = itemView.findViewById(R.id.title_items)
        var desc: TextView = itemView.findViewById(R.id.desc_items)
        var image: ImageView = itemView.findViewById(R.id.image_items)
        var bntMore: ConstraintLayout = itemView.findViewById(R.id.const_part)


        fun bind(item: Makala) {

            if (item.icon.isNullOrEmpty()) {
                when (item.id) {
                    1 -> Glide.with(itemView).load(R.drawable.ic_icon_video).into(image)
                    2 -> Glide.with(itemView).load(R.drawable.ic_icon_news).into(image)
                    3 -> Glide.with(itemView).load(R.drawable.ic_icon_image).into(image)
                    4 -> Glide.with(itemView).load(R.drawable.ic_icon_audio).into(image)
                    5 -> Glide.with(itemView).load(R.drawable.ic_icon_books).into(image)
                    8 -> Glide.with(itemView).load(R.drawable.ic_icon_ramadan).into(image)
                    10 -> Glide.with(itemView).load(R.drawable.ic_icon_shop).into(image)
                    11 -> Glide.with(itemView).load(R.drawable.ic_icon_charity).into(image)
                    12 -> Glide.with(itemView).load(R.drawable.ic_icon_prayer).into(image)
                    13 -> Glide.with(itemView).load(R.drawable.ic_icon_qauaran).into(image)
                    14 -> Glide.with(itemView).load(R.drawable.ic_icon_arab_language).into(image)
                    15 -> Glide.with(itemView).load(R.drawable.ic_icon_question).into(image)
                }
            } else {
                Glide.with(itemView).load(item.icon).into(image)
            }

            title.text = item.title
            desc.text = item.category

            bntMore.setOnClickListener {
                function(item)
            }
        }
    }
}