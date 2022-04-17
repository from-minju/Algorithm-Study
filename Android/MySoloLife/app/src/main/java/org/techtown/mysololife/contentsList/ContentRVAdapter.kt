package com.bokchi.mysolelife.contentsList

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bokchi.mysolelife.R
import com.bumptech.glide.Glide
import org.techtown.mysololife.R
//아이템 레이아웃과 데이터를 실제로 연결하는 역할을 수행
class ContentRVAdapter(val context : Context, val items : ArrayList<ContentModel>) : RecyclerView.Adapter<ContentRVAdapter.Viewholder>() {

    interface ItemClick {
        fun onClick(view : View, position: Int)
    }
    var itemClick : ItemClick? = null


    //전체 아이템들을 가져와 하나씩 넣어줌(하나의 레이이웃을 만들어줌)
    //viewHolder객체를 생성 후 리턴
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContentRVAdapter.Viewholder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.content_rv_item, parent, false)
        return Viewholder(v)
    }

    //viewHolder가 재활용 될 때 사용되는 메소드
    override fun onBindViewHolder(holder: ContentRVAdapter.Viewholder, position: Int) {

        if(itemClick != null) {
            holder.itemView.setOnClickListener { v->
                itemClick?.onClick(v, position)
            }
        }
        holder.bindItems(items[position])
    }

    //아이템 개수가 몇개인지
   override fun getItemCount(): Int {
        return items.size
    }

    //아이템에 있는 내용물들을 넣을 수 있게
    //아이템 뷰를 저장하는 클래스
    inner class Viewholder(itemView : View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(item : ContentModel) {

            val contentTitle = itemView.findViewById<TextView>(R.id.textArea)
            val imageViewArea = itemView.findViewById<ImageView>(R.id.imageArea)

            contentTitle.text = item.title

            Glide.with(context)
                .load(item.imageUrl)
                .into(imageViewArea)

        }

    }


}