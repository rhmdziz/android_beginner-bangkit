package academy.bangkit.myflexiblefragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

class HomeFragment : Fragment(), View.OnClickListener {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//      Inflate the layout for this fragment
//      mengubah layout xml ke dalam bentuk objek viewgroup atau widget
//      Sama seperti setContentView
        return inflater.inflate(R.layout.fragment_home, container, false)
//      resource : Int                      : Layout yang ingin diubah
//      root : ViewGroup?              : Root dari Layout Activity
//      attachToRoot: Boolean     :  Apakah kita akan menempelkan layout kita ke dalam root dari parent layout yang ada. Jika ya, maka akan ditempelkan ke dalam parent layout yang ada. Jika tidak, maka hanya akan menghasilkan nilai balik dalam bentu objek view saja.
//      Kita memilih false pada attachToRoot karena pada kode ini kita ingin menambahkan event onClick pada button-nya. Maka kita membutuhkan nilai balik berupa view.
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        Perlu view. untuk mengakses id
        val btnCategory: Button = view.findViewById(R.id.btn_category)
        btnCategory.setOnClickListener(this)
    }
    override fun onClick(v: View) {
        val categoryFragment = CategoryFragment()
//      activity menggunakan support
//      fragment menggunakan parent
        val fragmentManager = parentFragmentManager
        fragmentManager.beginTransaction().apply {
            replace(R.id.frame_container, categoryFragment, CategoryFragment::class.java.simpleName)
            addToBackStack(null) // ketika di back maka kembali ke fragment sblmnya
            commit()
        }
    }


}