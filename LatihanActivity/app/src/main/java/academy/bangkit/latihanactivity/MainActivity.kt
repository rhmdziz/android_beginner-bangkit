package academy.bangkit.latihanactivity

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var edtPanjang: EditText
    private lateinit var edtLebar: EditText
    private lateinit var edtTinggi: EditText
    private lateinit var btnHitung: Button
    private lateinit var tvHasil: TextView

    companion object {
        private const val STATE_RESULT = "state_result"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        edtPanjang = findViewById(R.id.edt_length)
        edtLebar = findViewById(R.id.edt_width)
        edtTinggi = findViewById(R.id.edt_height)
        btnHitung = findViewById(R.id.btn_calculate)
        tvHasil = findViewById(R.id.tv_result)

        btnHitung.setOnClickListener(this)

        if (savedInstanceState != null) {
            val result = savedInstanceState.getString(STATE_RESULT)
            tvHasil.text = result ?: ""
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(STATE_RESULT, tvHasil.text.toString())
    }

    override fun onClick(view: View?) {
        if (view?.id == R.id.btn_calculate) {

            val inputLength = edtPanjang.text.toString().trim()
            val inputWidth = edtLebar.text.toString().trim()
            val inputHeight = edtTinggi.text.toString().trim()

            var isEmptyFields = false
            if (inputLength.isEmpty()) {
                isEmptyFields = true
                edtPanjang.error = "Field ini tidak boleh kosong"
            }
            if (inputWidth.isEmpty()) {
                isEmptyFields = true
                edtLebar.error = "Field ini tidak boleh kosong"
            }
            if (inputHeight.isEmpty()) {
                isEmptyFields = true
                edtTinggi.error = "Field ini tidak boleh kosong"
            }
            if (!isEmptyFields) {
                try {
                    val volume =
                        inputLength.toDouble() * inputWidth.toDouble() * inputHeight.toDouble()
                    tvHasil.text = volume.toString()
                } catch (e: NumberFormatException) {
                    e.printStackTrace()
                }
            }

        }
    }
}