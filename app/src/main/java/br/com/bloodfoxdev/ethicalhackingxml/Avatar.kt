package br.com.bloodfoxdev.ethicalhackingxml


import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import org.w3c.dom.Text

private const val TAG = "LogMessage"

class Avatar : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.avatar_page)

        val sharedPreference =
            getSharedPreferences("PREFERENCE_NAME", Context.MODE_PRIVATE)
        var editor = sharedPreference.edit()
        editor.clear()
        editor.commit()

        var username = intent?.extras?.getString("username").orEmpty()
        var whatsApp = intent?.extras?.getString("whatsApp").orEmpty()
        var instagram = intent?.extras?.getString("instagram").orEmpty()

        var usernameView: TextView = this.findViewById(R.id.yourUsername)
        var whatsAppView: TextView = this.findViewById(R.id.yourWhatsApp)
        var instagramView: TextView = this.findViewById(R.id.yourInstagram)


        usernameView.text = username
        whatsAppView.text = whatsApp
        instagramView.text = instagram

    }

    override fun onStart() {
        super.onStart()

        val getSharedPre = getSharedPreferences("PREFERENCE_NAME", Context.MODE_PRIVATE)
        var getSelect = getSharedPre.getBoolean("selected", false)

        var btnChooseAvatar = findViewById<Button>(R.id.btnChoose)
        var btnToResume = findViewById<Button>(R.id.btnToResume)

        btnChooseAvatar.setOnClickListener {
            val intent = Intent(this, ChooseAvatar::class.java)
            startActivity(intent)
        }

        if (getSelect !== false) {
            btnToResume.setOnClickListener {
                val intent = Intent(this, LectureSummary::class.java)
                startActivity(intent)
            }

        } else {
            Toast.makeText(this, "Choose your Avatar Icon", Toast.LENGTH_LONG).show()
        }
    }

    override fun onResume() {
        super.onResume()
        val getSharedPre = getSharedPreferences("PREFERENCE_NAME", Context.MODE_PRIVATE)
        val ImageAvatar: ImageView = findViewById(R.id.Avatar)

        var getShared = getSharedPre.getString("imageAvatar", "selected.toString()")
        Log.i(TAG, getShared.toString())

        when (getShared) {
            "Ghost" -> {
                ImageAvatar.visibility = View.VISIBLE
                ImageAvatar.setImageResource(R.drawable.ghost_avatar_ofside)
            }
            "Frank" -> {
                ImageAvatar.visibility = View.VISIBLE
                ImageAvatar.setImageResource(R.drawable.frank_ofside)
            }
            "Dead" -> {
                ImageAvatar.visibility = View.VISIBLE
                ImageAvatar.setImageResource(R.drawable.dead_ofside)
            }
            "Vamp" -> {
                ImageAvatar.visibility = View.VISIBLE
                ImageAvatar.setImageResource(R.drawable.vamp_ofside)
            }
            "Whitch" -> {
                ImageAvatar.visibility = View.VISIBLE
                ImageAvatar.setImageResource(R.drawable.whitch_ofisde)
            }
        }
    }
}