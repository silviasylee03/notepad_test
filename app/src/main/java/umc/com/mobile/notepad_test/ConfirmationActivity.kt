package umc.com.mobile.notepad_test

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import umc.com.mobile.notepad_test.databinding.ActivityConfirmationBinding

class ConfirmationActivity : AppCompatActivity() {
    private lateinit var binding: ActivityConfirmationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityConfirmationBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val memoTextView = binding.textViewMemo
        val memo = intent.getStringExtra("memo")
        memoTextView.text = memo
    }
}