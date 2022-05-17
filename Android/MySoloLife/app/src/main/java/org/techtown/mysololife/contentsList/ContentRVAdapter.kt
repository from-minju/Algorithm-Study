package org.techtown.mysololife.contentsList

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.techtown.mysololife.R

import com.bumptech.glide.Glide

//아이템 레이아웃과 데이터를 실제로 연결하는 역할을 수행
class ContentRVAdapter(val context : Context, val items : ArrayList<ContentModel>) : RecyclerView.Adapter<ContentRVAdapter.Viewholder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContentRVAdapter.Viewholder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.content_rv_item, parent, false)
        return Viewholder(v)
    }

    override fun onBindViewHolder(holder: ContentRVAdapter.Viewholder, position: Int) {
        holder.bindItems(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class Viewholder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        fun bindItems(item : ContentModel) {

            val contentTitle = itemView.findViewById<TextView>(R.id.textArea) //여기서의 itemView는 content_rv_item
            val imageViewArea = itemView.findViewById<ImageView>(R.id.imageArea)

            contentTitle.text = item.title

            //context : 맥락을 가져
            Glide.with(context)
                .load(item.imageUrl)
                .into(imageViewArea)


        }
    }

//    //recycler view item 클릭
//    interface ItemClick {
//        fun onClick(view : View, position: Int)
//    }
//    var itemClick : ItemClick? = null
//
//옴
//    //전체 아이템들을 가져와 하나씩 넣어줌(하나의 레이이웃을 만들어줌)
//    //viewHolder객체를 생성 후 리턴
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContentRVAdapter.Viewholder {
//        val v = LayoutInflater.from(parent.context).inflate(R.layout.content_rv_item, parent, false)
//        return Viewholder(v)
//    }
//
//    //viewHolder가 재활용 될 때 사용되는 메소드
//    override fun onBindViewHolder(holder: ContentRVAdapter.Viewholder, position: Int) {
//
//        if(itemClick != null) {
//            holder.itemView.setOnClickListener { v->
//                itemClick?.onClick(v, position)
//            }
//        }
//        holder.bindItems(items[position])
//    }
//
//    //아이템 개수가 몇개인지
//   override fun getItemCount(): Int {
//        return items.size
//    }
//
//    //아이템에 있는 내용물들을 넣을 수 있게
//    //아이템 뷰를 저장하는 클래스
//    inner class Viewholder(itemView : View) : RecyclerView.ViewHolder(itemView) {
//
//        fun bindItems(item : ContentModel) {
//
//            val contentTitle = itemView.findViewById<TextView>(R.id.textArea) //여기서의 itemView는 content_rv_item
//            val imageViewArea = itemView.findViewById<ImageView>(R.id.imageArea)
//
//            contentTitle.text = item.title
//
//            Glide.with(context)
//                .load(item.imageUrl)
//                .into(imageViewArea)
//
//        }
//
//    }


}