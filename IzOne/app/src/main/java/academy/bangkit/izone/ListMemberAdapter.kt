package academy.bangkit.izone

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListMemberAdapter (private val listMember: ArrayList<Members>) : RecyclerView.Adapter<ListMemberAdapter.ListViewHolder>() {
    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_detail_photo)
        val tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        val tvPosition: TextView = itemView.findViewById(R.id.tv_item_position)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_members, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = listMember.size

    override fun onBindViewHolder(holder: ListViewHolder, i: Int) {
        val (name, position, _, photo, _, _) = listMember[i]
        holder.tvName.text = name
        holder.tvPosition.text = position
        holder.imgPhoto.setImageResource(photo)

        holder.itemView.setOnClickListener {
//            Toast.makeText(holder.itemView.context, "Kamu memilih " + listMember[holder.adapterPosition].name, Toast.LENGTH_SHORT).show()
            val intentDetail = Intent(holder.itemView.context, DetailActivity::class.java)
            intentDetail.putExtra("key_member", listMember[holder.adapterPosition])
            holder.itemView.context.startActivity(intentDetail)
        }
    }

}