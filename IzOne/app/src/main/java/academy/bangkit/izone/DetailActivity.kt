package academy.bangkit.izone

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetailActivity : AppCompatActivity() {

    companion object {
        const val KEY_MEMBER = "key_member"
    }
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val dataMember = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra(KEY_MEMBER, Members::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra(KEY_MEMBER)
        }
        dataMember?.let {member ->
            val nameTextView: TextView = findViewById(R.id.tv_detail_name)
            val positionTextView: TextView = findViewById(R.id.tv_detail_position)
            val descriptionTextView: TextView = findViewById(R.id.tv_detail_description)
            val imageView: ImageView = findViewById(R.id.img_detail_photo)
            val birthdayTextView: TextView = findViewById(R.id.tv_detail_birthday)
            val birthNameTextView: TextView = findViewById(R.id.tv_detail_birthname)

            val shareButton: Button = findViewById(R.id.action_share)

            nameTextView.text = member.name
            positionTextView.text = "Position: ${member.position}"
            descriptionTextView.text = member.description
            imageView.setImageResource(member.photos)
            birthdayTextView.text = "Birthday: ${member.birthday}"
            birthNameTextView.text = "Birth name: ${member.birthName}"

            shareButton.setOnClickListener {
                val shareText = "Pgn share ttg cwk canti ini, hehe, ${member.name}\n${member.description}"
                shareMemberInfo(shareText)
            }
        }

    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.back, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == R.id.back) {
            val intent = Intent(this, MainActivity::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
            }
            startActivity(intent)
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun shareMemberInfo(shareText: String) {
        val shareIntent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, shareText)
            type = "text/plain"
        }
        startActivity(Intent.createChooser(shareIntent, "Share via"))
    }
}