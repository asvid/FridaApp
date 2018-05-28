package asvid.github.io.fridaapp

import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var security: Security

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        security = Security(this, getPreferences(Context.MODE_PRIVATE))
        runEverySecond()
        initViews()
        showToast()
    }

    private fun initViews() {
        encryptedPassword.text = security.getPassword()
        password.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int,
                                           after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int,
                                       count: Int) {
                security.setPassword(s.toString())
            }
        })

        pinInput.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int,
                                           after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int,
                                       count: Int) {
                if (checkPin(s.toString())) {
                    pinResult.text = getString(R.string.correct_pin)
                } else {
                    pinResult.text = getString(R.string.wrong_pin)
                }
            }
        })
    }

    private fun runEverySecond() {
        val handler = Handler()
        val delay = 1000 //milliseconds

        handler.postDelayed(object : Runnable {
            override fun run() {
                sum(50, 30)
                handler.postDelayed(this, delay.toLong())
            }
        }, delay.toLong())
    }

    fun showToast() {
        runOnUiThread {
            Toast.makeText(this, R.string.toast_text, Toast.LENGTH_SHORT).show()
        }
    }

    fun getString() = "some string"

    fun checkPin(pin: String): Boolean {
        if (pin == "1234") {
            Log.d("PIN", "pin correct!")
            return true
        }
        return false
    }

    fun sum(x: Int, y: Int) {
        Log.d("Sum", (x + y).toString())
        Logger.log("debug log $x $y")
    }
}
