package asvid.github.io.fridaapp

import android.util.Log

object Logger {

  val showLogs = BuildConfig.DEBUG

  fun log(text: String) {
    if (showLogs)
      Log.d("LOOGGER", text)
  }

}