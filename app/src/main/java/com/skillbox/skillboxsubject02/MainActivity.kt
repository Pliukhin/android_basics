package com.skillbox.skillboxsubject02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val textView = findViewById<TextView>(R.id.build_info)
        textView.text = """
            Flavor = ${BuildConfig.FLAVOR}
            BuildType = ${BuildConfig.BUILD_TYPE}
            VersionCode = ${BuildConfig.VERSION_CODE}
            VersionName = ${BuildConfig.VERSION_NAME}
            applicationId = ${BuildConfig.APPLICATION_ID}
        """.trimIndent()
    }

}
