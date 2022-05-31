package com.bongonets.palindrome

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bongonets.palindrome.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_Palindrome)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnCheck.setOnClickListener {
            val errors = "Please fill the input above!"
            if (binding.txtInput.text.toString().isEmpty()){
                binding.txtDisplay.text = errors
            }else {
                val theText = binding.txtInput.text.toString().lowercase()
                val y = "The input ${binding.txtInput.text} is \nPalindrome"
                val n = "The input ${binding.txtInput.text} is \nNOT Palindrome"

                if (theText == reverse(theText)){
                    binding.txtDisplay.text = y
                } else{
                    binding.txtDisplay.text = n
                }
            }
        }

        binding.btnClear.setOnClickListener { clearText() }
        binding.btnQuit.setOnClickListener { finish() }
    }

    private fun reverse(str: String): String{
        var reverse = ""
        for (i in str.length - 1 downTo 0){
            reverse += str[i]
        }
        return reverse
    }

    private fun clearText(){
        binding.txtDisplay.text = ""
        binding.txtInput.text.clear()
    }
}