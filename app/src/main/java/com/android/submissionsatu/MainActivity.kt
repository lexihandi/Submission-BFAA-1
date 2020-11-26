package com.android.submissionsatu

import android.content.Intent
import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: DevelopersAdapter
    private lateinit var dataUserName: Array<String>
    private lateinit var dataName: Array<String>
    private lateinit var dataLocation: Array<String>
    private lateinit var dataRepository: Array<String>
    private lateinit var dataCompany: Array<String>
    private lateinit var dataFollowers: Array<String>
    private lateinit var dataFollowing: Array<String>
    private lateinit var dataPhoto: TypedArray

    private var developers = arrayListOf<Developers>()

    private var exitTime: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView: ListView = findViewById(R.id.lv_list)
        adapter = DevelopersAdapter(this)
        listView.adapter = adapter

        prepare()
        addItem()

        listView.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->

            val moveDevelopers = Developers(
                developers[position].username,
                developers[position].name,
                developers[position].location,
                developers[position].repository,
                developers[position].company,
                developers[position].followers,
                developers[position].following,
                developers[position].avatar,
            )
            val moveIntentToDetail = Intent(this@MainActivity, DetailDevelopersActivity::class.java)
            moveIntentToDetail.putExtra(DetailDevelopersActivity.EXTRA_DEVELOPER, moveDevelopers)
            startActivity(moveIntentToDetail)
        }
    }

    private fun prepare() {
        dataUserName = resources.getStringArray(R.array.username)
        dataName = resources.getStringArray(R.array.data_name)
        dataLocation = resources.getStringArray(R.array.data_location)
        dataRepository = resources.getStringArray(R.array.repository)
        dataCompany = resources.getStringArray(R.array.company)
        dataFollowers = resources.getStringArray(R.array.followers)
        dataFollowing = resources.getStringArray(R.array.following)
        dataPhoto = resources.obtainTypedArray(R.array.avatar)
    }

    private fun addItem() {
        for (position in dataName.indices) {
            val developer = Developers(
                dataUserName[position],
                dataName[position],
                dataLocation[position],
                dataRepository[position],
                dataCompany[position],
                dataFollowers[position],
                dataFollowing[position],
                dataPhoto.getResourceId(position, -1),
            )
            developers.add(developer)
        }
        adapter.developers = developers
    }

    override fun onBackPressed() {
        if (System.currentTimeMillis() - exitTime > 2000) {
            Toast.makeText(this, "Press again to exit", Toast.LENGTH_SHORT).show()
            exitTime = System.currentTimeMillis()
        } else {
            finish()
        }
    }
}