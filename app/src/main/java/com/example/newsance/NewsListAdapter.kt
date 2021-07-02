 package com.example.newsance

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

 class NewsListAdapter( private val listner :NewsItemClicled): RecyclerView.Adapter<NewsViewHolder>()
{
    private val items: ArrayList<News> = ArrayList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
           val view = LayoutInflater.from(parent.context).inflate(R.layout.item_news, parent, false)
        val viewHolder = NewsViewHolder(view)
        view.setOnClickListener{
                listner.onItemClicked(items[viewHolder.adapterPosition])
        }
            return viewHolder
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
       val currentItems = items[position]
        holder.titleView.text = currentItems.title
        holder.author.text=currentItems.author
        Glide.with(holder.itemView.context).load(currentItems.imageUrl).into(holder.image)
    }

    override fun getItemCount(): Int {
        return items.size
    }
    fun updateNews(updatedNews: ArrayList<News>) {
        items.clear()
        items.addAll(updatedNews)
        notifyDataSetChanged()
    }
}
    class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
              val titleView : TextView = itemView.findViewById(R.id.title)
        val image: ImageView = itemView.findViewById(R.id.image)
        val author : TextView = itemView.findViewById(R.id.author)
    }
interface NewsItemClicled
{
    fun  onItemClicked(item : News)
}