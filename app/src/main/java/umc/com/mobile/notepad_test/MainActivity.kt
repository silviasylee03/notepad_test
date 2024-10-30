package umc.com.mobile.notepad_test

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import umc.com.mobile.notepad_test.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var editText: EditText
    private var savedMemo: String? = null  // 메모 내용을 저장할 전역 변수

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        editText = binding.editTextMemo
        val buttonNext = binding.buttonNext

        buttonNext.setOnClickListener {
            val intent = Intent(this, ConfirmationActivity::class.java)
            intent.putExtra("memo", editText.text.toString())
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        savedMemo?.let {
            editText.setText(it)
        }
    }

    override fun onPause() {
        super.onPause()
        savedMemo = editText.text.toString()
    }

    override fun onRestart() {
        super.onRestart()
        AlertDialog.Builder(this).apply {
            setTitle("Continue Editing")
            setMessage("Do you want to continue editing?")
            setPositiveButton("Yes") { _, _ -> }
            setNegativeButton("No") { _, _ ->
                savedMemo = null
                editText.setText("")
            }
            show()
        }
    }
}