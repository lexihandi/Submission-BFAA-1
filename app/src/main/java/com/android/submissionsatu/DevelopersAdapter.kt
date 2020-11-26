package com.android.submissionsatu

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import de.hdodenhof.circleimageview.CircleImageView
import kotlinx.android.synthetic.main.activity_detail_developers.*
import java.nio.file.Files.size

class DevelopersAdapter internal constructor(private val context: Context) : BaseAdapter() {
    internal var developers = arrayListOf<Developers>()

    override fun getCount(): Int = developers.size

    override fun getItem(i: Int): Any = developers[i]

    override fun getItemId(i: Int): Long = i.toLong()

    override fun getView(position: Int, view: View?, viewGroup: ViewGroup): View? {
        var itemView = view
        if (itemView == null) {
            itemView =
                LayoutInflater.from(context).inflate(R.layout.item_developers, viewGroup, false)
        }
        val viewHolder = ViewHolder(itemView as View)
        val developers = getItem(position) as Developers
        viewHolder.bind(developers)
        return itemView
    }

    private inner class ViewHolder internal constructor(view: View) {
        private val txtUserName: TextView = view.findViewById(R.id.txt_username)
        private val txtName: TextView = view.findViewById(R.id.txt_name)
        private val txtCompany: TextView = view.findViewById(R.id.txt_company)
        private val imgPhoto: CircleImageView = view.findViewById(R.id.img_photo)
        private val txtLocation: TextView = view.findViewById(R.id.txt_location)
        internal fun bind(developers: Developers) {
            txtUserName.text = "@${developers.username.toString()}"
            txtName.text = developers.name
            txtCompany.text = developers.company
            txtLocation.text = developers.location
            imgPhoto.setImageResource(developers.avatar)
        }
    }
}