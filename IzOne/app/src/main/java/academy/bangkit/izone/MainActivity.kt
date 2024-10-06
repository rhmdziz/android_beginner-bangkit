package academy.bangkit.izone

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.text.util.Linkify
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {
    private lateinit var rvMembers: RecyclerView
    private val list = ArrayList<Members>()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textSource: TextView = findViewById(R.id.source)
        textSource.text = "Sumber: kprofiles.com/izone-members-profile"
        Linkify.addLinks(textSource, Linkify.WEB_URLS)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        rvMembers = findViewById(R.id.rv_members)
        rvMembers.setHasFixedSize(true)

        list.addAll(getListHeroes())
        showRecyclerList()


    }

    @SuppressLint("Recycle")
    private fun getListHeroes(): ArrayList<Members> {
        val dataName = resources.getStringArray(R.array.member_name)
        val dataPosition = resources.getStringArray(R.array.member_position)
        val dataDescription = resources.getStringArray(R.array.member_description)
        val dataPhoto = resources.obtainTypedArray(R.array.member_photo)
        val dataBirthday = resources.getStringArray(R.array.member_birthday)
        val dataBirthName = resources.getStringArray(R.array.member_birth_name)

        val listMember = ArrayList<Members>()

        for (i in dataName.indices) {
            val member = Members(dataName[i], dataPosition[i],  dataDescription[i], dataPhoto.getResourceId(i, -1), dataBirthday[i], dataBirthName[i])
            listMember.add(member)
        }
        return listMember
    }

    private fun showRecyclerList() {
//        rvMembers.layoutManager = LinearLayoutManager(this)
        rvMembers.layoutManager = GridLayoutManager(this, 2)
        val listMemberAdapter = ListMemberAdapter(list)
        rvMembers.adapter = listMemberAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == R.id.about_page) {
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}