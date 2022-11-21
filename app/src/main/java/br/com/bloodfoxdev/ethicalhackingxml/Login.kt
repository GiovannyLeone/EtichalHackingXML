package br.com.bloodfoxdev.ethicalhackingxml

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


private const val TAG = "LogMessageLogin"

class Login : AppCompatActivity()  {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.login_page)

            val sharedPreference =
                getSharedPreferences("PREFERENCE_NAME", Context.MODE_PRIVATE)
            var editor = sharedPreference.edit()

            editor.clear()
            editor.commit()
        }

        override fun onStart() {
            super.onStart()

            var btnNext = findViewById<Button>(R.id.btnnext)

            btnNext.setOnClickListener {
                var username = findViewById<EditText>(R.id.personName).text.toString()

                var whatsApp = findViewById<EditText>(R.id.wpp).text.toString()

                var instagram = findViewById<EditText>(R.id.insta).text.toString()

                if (username.length !== 0 && whatsApp.length !== 0 && instagram.length !== 0) {
                    val intent = Intent(this, Avatar::class.java)
                    intent.putExtra("username", username);
                    intent.putExtra("whatsApp", whatsApp);
                    intent.putExtra("instagram", instagram);
                    startActivity(intent)
                } else {
                    Toast.makeText(this, "Fill in the fields", Toast.LENGTH_LONG).show()
                }
            }
        }


}