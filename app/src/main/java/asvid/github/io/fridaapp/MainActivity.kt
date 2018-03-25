package asvid.github.io.fridaapp

import android.accounts.AccountManager.KEY_PASSWORD
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.Toast
import com.moldedbits.r2d2.R2d2
import kotlinx.android.synthetic.main.activity_main.encryptedPassword
import kotlinx.android.synthetic.main.activity_main.password

class MainActivity : AppCompatActivity() {

  private lateinit var r2d2: R2d2
  private lateinit var preferences: SharedPreferences

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    preferences = getPreferences(Context.MODE_PRIVATE)
    r2d2 = R2d2(this)
    runEverySecond()
    initViews()
  }

  private fun initViews() {
    encryptedPassword.text = getPassword()
    password.addTextChangedListener(object : TextWatcher {
      override fun afterTextChanged(s: Editable?) {

      }

      override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
      }

      override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        setPassword(s.toString())
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
      Toast.makeText(this, "showing Toast!!! yay wow", Toast.LENGTH_SHORT).show()
    }
  }

  fun getString() = "some string"

  fun checkPin(pin: Int) {
    if (pin == 1234) {
      showToast()
    }
  }

  fun sum(x: Int, y: Int) {
    Log.d("Sum", (x + y).toString())
  }

  fun setPassword(password: String) {
    var password = password
    val encrypted = r2d2.encryptData(password)
    if (encrypted != null && !encrypted!!.equals("", ignoreCase = true)) {
      password = encrypted
    }
    val editor = preferences.edit()
    editor.putString(KEY_PASSWORD, password)
    editor.apply()

    encryptedPassword.text = password
  }

  fun getPassword(): String {
    var password = preferences.getString(KEY_PASSWORD, null)
    val decrypted = r2d2.decryptData(password)
    if (decrypted != null && !decrypted!!.equals("", ignoreCase = true)) {
      password = decrypted
    }
    return password
  }
}
