package org.techtown.mysololife.contentsList

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import org.techtown.mysololife.R

import com.bumptech.glide.Glide
import org.techtown.mysololife.utils.FBAuth
import org.techtown.mysololife.utils.FBRef

//아이템 레이아웃과 데이터를 실제로 연결하는 역할을 수행
class ContentRVAdapter(val context : Context, val items : ArrayList<ContentModel>, val keyList : ArrayList<String>)
    : RecyclerView.Adapter<ContentRVAdapter.Viewholder>() {

//    //recycler view item 클릭
//    interface ItemClick {
//        fun onClick(view : View, position: Int)
//    }
//    var itemClick : ItemClick? = null


    //전체 아이템들을 가져와 하나씩 넣어줌(하나의 레이이웃을 만들어줌)
    //viewHolder객체를 생성 후 리턴
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContentRVAdapter.Viewholder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.content_rv_item, parent, false)
        return Viewholder(v)
    }

    //viewHolder가 재활용 될 때 사용되는 메소드
    override fun onBindViewHolder(holder: ContentRVAdapter.Viewholder, position: Int) {

//        //item 클릭하면 화면이동할 수 있도록
//       if(itemClick != null) {
//            holder.itemView.setOnClickListener{ v->
//                itemClick?.onClick(v, position)
//            }
//        }
        holder.bindItems(items[position], keyList[position]) //Viewholder의 bindItems랑 매개변수 맞춰줘야함
    }

    //아이템 개수가 몇개인지
    override fun getItemCount(): Int {
        return items.size
    }


    //아이템에 있는 내용물들을 넣을 수 있게
    //아이템 뷰를 저장하는 클래스
    inner class Viewholder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        fun bindItems(item : ContentModel, key : String) {

            itemView.setOnClickListener{
                Toast.makeText(context, item.title, Toast.LENGTH_LONG).show()
                val intent = Intent(context, ContentShowActivity::class.java)
                intent.putExtra("url", item.webUrl)
                itemView.context.startActivity(intent)
            }

            val contentTitle = itemView.findViewById<TextView>(R.id.textArea) //여기서의 itemView는 content_rv_item
            val imageViewArea = itemView.findViewById<ImageView>(R.id.imageArea)
            val bookmarkArea = itemView.findViewById<ImageView>(R.id.bookmarkArea)

            bookmarkArea.setOnClickListener{
                Log.d("ContentRVAdapter", FBAuth.getUid())
                Toast.makeText(context, key, Toast.LENGTH_LONG).show()

                FBRef.bookmarkRef.child(FBAuth.getUid()).child(key).setValue("Good")
            }

            contentTitle.text = item.title

            //context : 맥락을 가져
            Glide.with(context)
                .load(item.imageUrl)
                .into(imageViewArea)


        }
    }

}