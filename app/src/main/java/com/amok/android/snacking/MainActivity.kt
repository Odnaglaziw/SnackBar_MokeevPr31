package com.amok.android.snacking

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val common : Button = findViewById(R.id.common)
        val uncommon : Button = findViewById(R.id.uncommon)
        val with_btn : Button = findViewById(R.id.with_btn)

        common.setOnClickListener{
            Snackbar.make(it,"Кнопка",Snackbar.LENGTH_LONG).show()
        }
        uncommon.setOnClickListener {
            uncommon.animate().scaleX(1.2f).scaleY(1.2f).setDuration(200).withEndAction {
                uncommon.animate().scaleX(1f).scaleY(1f).setDuration(200).start()
            }.start()

            val snackbar = Snackbar.make(it, "Uncommon кнопка с кастомизацией!", Snackbar.LENGTH_LONG)
            snackbar.view.setBackgroundColor(ContextCompat.getColor(this, R.color.purple_200))
            snackbar.show()
        }
        with_btn.setOnClickListener{
            val snackbar = Snackbar.make(it, "Сообщение с кнопкой", Snackbar.LENGTH_LONG)
            snackbar.setAction("Выбрать"){
                Snackbar.make(it,"Вы выбрали",Snackbar.LENGTH_LONG).show()
            }
            snackbar.show()
        }
    }
}