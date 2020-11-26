package com.android.submissionsatu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import de.hdodenhof.circleimageview.CircleImageView
import kotlinx.android.synthetic.main.activity_detail_developers.*

class DetailDevelopersActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_DEVELOPER = "extra_developer"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_developers)

        val developer = intent.getParcelableExtra(EXTRA_DEVELOPER) as Developers

        img_photo_detail.setImageResource(developer.avatar)
        txt_name_detail.text = developer.name.toString()
        txt_username_detail.text = "@${developer.username.toString()}"
        txt_repository_detail.text = developer.repository.toString()
        txt_followers_detail.text = developer.followers.toString()
        txt_following_detail.text = developer.following.toString()
        txt_location_detail.text = developer.location.toString()
        txt_company_detail.text = developer.company.toString()
    }
}