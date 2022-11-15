package upt.solmovi.voicerecognizera

import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.RecognitionListener
import android.speech.RecognizerIntent
import android.speech.SpeechRecognizer
import androidx.core.app.ActivityCompat
import upt.solmovi.voicerecognizera.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

  private lateinit var binding:ActivityMainBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityMainBinding.inflate(layoutInflater)
    val view = binding.root
    setContentView(view)

    ActivityCompat.requestPermissions(this,
      arrayOf(android.Manifest.permission.RECORD_AUDIO)
      , PackageManager.PERMISSION_GRANTED)


    var intentRecognizer = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH)
    intentRecognizer.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
    RecognizerIntent.LANGUAGE_MODEL_FREE_FORM)
    var speechRecognizer = SpeechRecognizer.createSpeechRecognizer(applicationContext)
    speechRecognizer.setRecognitionListener(
      object:RecognitionListener{
        override fun onReadyForSpeech(params: Bundle?) {
          TODO("Not yet implemented")

        }

        override fun onBeginningOfSpeech() {
          TODO("Not yet implemented")
        }

        override fun onRmsChanged(rmsdB: Float) {
          TODO("Not yet implemented")
        }

        override fun onBufferReceived(buffer: ByteArray?) {
          TODO("Not yet implemented")
        }

        override fun onEndOfSpeech() {
          TODO("Not yet implemented")
        }

        override fun onError(error: Int) {
          TODO("Not yet implemented")
        }

        override fun onResults(results: Bundle?) {
          var matches:ArrayList<String>
          = results?.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION) as ArrayList<String>
          var string = ""
          if(!matches.isNullOrEmpty()){
            string = matches.get(0)
            binding.txtMessage.text = string
          }
        }

        override fun onPartialResults(partialResults: Bundle?) {
          TODO("Not yet implemented")
        }

        override fun onEvent(eventType: Int, params: Bundle?) {
          TODO("Not yet implemented")
        }

      }
    )

    binding.btnStart.setOnClickListener {
      speechRecognizer.startListening(intentRecognizer)
    }
    binding.btnStop.setOnClickListener {
      speechRecognizer.stopListening()
    }
  }
}