package com.bongonets.readalong

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.util.Log
import com.bongonets.readalong.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity(),TextToSpeech.OnInitListener {

    private var tts: TextToSpeech? = null
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_ReadAlong)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnRead!!.isEnabled = false;
        tts = TextToSpeech(this, this)

        binding.btnRead!!.setOnClickListener { speakOut() }
        binding.btnQuit!!.setOnClickListener { this.finish() }
    }

    override fun onInit(status: Int) {

        if (status == TextToSpeech.SUCCESS) {
            // set US English as language for tts
            val result = tts!!.setLanguage(Locale.US)

            if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Log.e("TTS","The Language specified is not supported!")
            } else {
                binding.btnRead!!.isEnabled = true
            }

        } else {
            Log.e("TTS", "Initilization Failed!")
        }

    }

    private fun speakOut() {
        tts!!.speak(binding.txtPhrase.text.toString(), TextToSpeech.QUEUE_FLUSH, null,"")
    }

    public override fun onDestroy() {
        // Shutdown TTS
        if (tts != null) {
            tts!!.stop()
            tts!!.shutdown()
        }
        super.onDestroy()
    }

}