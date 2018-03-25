package asvid.github.io.fridaapp

import android.accounts.AccountManager
import android.content.Context
import android.content.SharedPreferences
import com.moldedbits.r2d2.R2d2

class Security(context: Context, private val preferences: SharedPreferences) {

  private var r2d2: R2d2 = R2d2(context)

  fun setPassword(password: String) {
    var password = password
    val encrypted = r2d2.encryptData(password)
    if (encrypted != null && !encrypted.equals("", ignoreCase = true)) {
      password = encrypted
    }
    val editor = preferences.edit()
    editor.putString(AccountManager.KEY_PASSWORD, password)
    editor.apply()
  }

  fun getPassword(): String {
    var password = preferences.getString(AccountManager.KEY_PASSWORD, null)
    val decrypted = r2d2.decryptData(password)
    if (decrypted != null && !decrypted.equals("", ignoreCase = true)) {
      password = decrypted
    }
    return password
  }
}