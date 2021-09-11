package `in`.vikins.fingertip.homescreen

import `in`.vikins.fingertip.R
import `in`.vikins.fingertip.homescreen.models.News
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class HomeRecyclerAdapter(val context: Context,val listener:newsItemClicked) :RecyclerView.Adapter<HomeRecyclerAdapter.MyViewHolder>(){
        var News = ArrayList<News>()
        fun setupdateDada(News:ArrayList<News>){
            this.News = News
            notifyDataSetChanged()
        }
        class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
            val title:TextView = itemView.findViewById(R.id.txtTitle)
            val url:TextView = itemView.findViewById(R.id.txtUrl)
            val date:TextView = itemView.findViewById(R.id.txtdate)
            val author:TextView = itemView.findViewById(R.id.txtauthor)
            val img:ImageView = itemView.findViewById(R.id.imgviewnews)
            fun bind(item:News){
                title.text = item.title
                url.text = item.url
                date.text = item.publishedAt
                author.text = item.author
                Picasso.get()
                    .load(item.urlToImage)
                    .into(img)
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.news_singleview,parent,false)
            val viewHolder =  MyViewHolder(view)
            view.setOnClickListener{
                listener.onitemClicked(News[viewHolder.adapterPosition])
            }
            return viewHolder
        }

        override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
            holder.bind(News[position])
        }

        override fun getItemCount(): Int {
            return News.size
        }

    }
interface newsItemClicked{
    fun onitemClicked(itemlist: News){

    }
}
