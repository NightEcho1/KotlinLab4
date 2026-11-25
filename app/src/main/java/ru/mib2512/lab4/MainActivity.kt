package ru.mib2512.lab4

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import ru.mib2512.lab4.databinding.ActivityMainBinding
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val openSecond = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            binding.textFromAct2.text = result.data?.getStringExtra("text").orEmpty()
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        savedInstanceState?.getString("reply")?.let { binding.textFromAct2.text = it }
        binding.btnCh1.setOnClickListener {
            openSecond.launch(Intent(this, Activity2::class.java).apply {
                putExtra("text", binding.plainText1.text.toString())
                putExtra("extra_text", binding.extraText.text.toString())
            })
        }
    }
    override fun onSaveInstanceState(outState: Bundle) {
        outState.putString("reply", binding.textFromAct2.text.toString())
        super.onSaveInstanceState(outState)
    }
}
