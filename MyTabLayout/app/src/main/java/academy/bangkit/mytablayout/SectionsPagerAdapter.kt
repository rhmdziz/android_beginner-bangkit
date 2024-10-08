package academy.bangkit.mytablayout

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter


//FragmentStateAdapter merupakan base adapter yang digunakan untuk mengatur data pada ViewPager2. Dengan extends ke abstract class ini, Anda diminta untuk mengimplementasikan 2 fungsi utama yaitu, createFragment dan getItemCount. Selain itu, di sini juga terdapat constructor yang diperlukan yaitu AppCompatActivity karena kita menggunakan Activity. Apabila Anda menerapkannya di Fragment, gunakanFragmentActivity.
//Perlu diketahui juga, sebenarnya Anda dapat menggunakan RecyclerView.Adapter sebagai adapter. Hal ini karena pada dasarnya ViewPager2 dibuat menggunakan RecyclerView. Jadi, Anda pun bisa menggunakannya. Menarik ya!
class SectionsPagerAdapter(activity: AppCompatActivity) : FragmentStateAdapter(activity) {

//  Fungsi getItemCount digunakan untuk menentukan jumlah tab yang ingin ditampilkan. Pada kode di atas, Anda mencoba untuk menampilkan dua tab. Pastikan bahwa jumlah yang ditampilkan sesuai dengan Fragment yang didefinisikan oleh fungsi createFragment
//    override fun getItemCount(): Int {
//        return 2
//    }


//  Fungsi createFragment digunakan untuk menampilkan fragment sesuai dengan posisi tab-nya. Misalnya kode di atas untuk posisi 0 (tab pertama) menampilkan HomeFragment dan di posisi 1 (tab kedua) menampilkan ProfileFragment. Cukup mudah kan?
//    override fun createFragment(position: Int): Fragment {
//        var fragment: Fragment? = null
//        when (position) {
//            0 -> fragment = HomeFragment()
//            1 -> fragment = ProfileFragment()
//        }
//        return fragment as Fragment
//    }


    override fun createFragment(position: Int): Fragment {
        val fragment = HomeFragment()
        fragment.arguments = Bundle().apply {
            putInt(HomeFragment.ARG_SECTION_NUMBER, position + 1)
            putString(HomeFragment.ARG_NAME, appName)
        }
        return fragment
    }

    override fun getItemCount(): Int {
        return 3
    }

//  mengirim data dari activity ke fragment
    var appName: String = ""



}