package academy.bangkit.myflexiblefragment

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentManager = supportFragmentManager
        val homeFragment = HomeFragment()
        val fragment = fragmentManager.findFragmentByTag(HomeFragment::class.java.simpleName)

        if (fragment !is HomeFragment) {
            Log.d("MyFlexibleFragment", "Fragment Name :" + HomeFragment::class.java.simpleName)
            fragmentManager
                .beginTransaction() // memulai proses perubahan.
                .add(R.id.frame_container, homeFragment, HomeFragment::class.java.simpleName) // menambahkan objek fragment ke dalam layout container.
                .commit() // mengeksekusi untuk melakukan pemasangan objek secara asynchronous untuk ditampilkan ke antar muka pengguna (user interface).
        }

    }
}