package com.example.myapplication

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.screen_transition_button)
        button.setOnClickListener {

            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)

        }

        val webViewButton = findViewById<Button>(R.id.web_view_button)
        webViewButton.setOnClickListener {

            val intent = Intent(this, WebViewActivity::class.java)
            startActivity(intent)

        }

        val dialogButton = findViewById<Button>(R.id.dialog_button)
        dialogButton.setOnClickListener {
            AlertDialog.Builder(this).setTitle("ダイアログのタイトルをいれう")
                .setPositiveButton("OK", { dialog, which ->
                    //OKの時の処理
                    val intent = Intent(this, WebViewActivity::class.java)
                    startActivity(intent)

                }).setNegativeButton("No", { dialog, which ->
                    //NOの時の処理
                    finish()
                }).show()
        }

        val externalBrowserButton = findViewById<Button>(R.id.external_browser_button)
        externalBrowserButton.setOnClickListener {

        val urlstr ="https://toy.bandai.co.jp/series/tamagotchi/chara/"

                // 外部ブラウザ起動
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(urlstr))
               startActivity(intent)
        }
    }
}