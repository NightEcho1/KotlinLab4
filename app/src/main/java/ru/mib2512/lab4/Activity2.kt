package ru.mib2512.lab4

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.mib2512.lab4.databinding.Activity2Binding
class Activity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = Activity2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.textFromMain.text = intent.getStringExtra("text").orEmpty()
        binding.extraFromMain.text = intent.getStringExtra("extra_text").orEmpty()
        binding.btnCh2.setOnClickListener {
            setResult(Activity.RESULT_OK, Intent().putExtra("text", binding.plainText2.text.toString()))
            finish()
        }
        binding.exit.setOnClickListener { finish() }
    }
}
