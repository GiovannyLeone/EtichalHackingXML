package br.com.bloodfoxdev.ethicalhackingxml

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

private const val TAG = "LogMessageChooseAvatar"

class ChooseAvatar : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.choose_avatar_page)

        val sharedPreference =
            getSharedPreferences("PREFERENCE_NAME", Context.MODE_PRIVATE)
        var editor = sharedPreference.edit()
        editor.clear()
        editor.commit()

        val ImageAvatar: ImageView = findViewById(R.id.imageAvatar)
        val avatars = resources.getStringArray(R.array.avatar_array)
        val spinner: Spinner = findViewById(R.id.spinner)
        val btnChoose: Button = findViewById(R.id.btnChoose)

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter.createFromResource(
            this,
            R.array.avatar_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            spinner.adapter = adapter
        }

        spinner.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View, position: Int, id: Long,
            ) {
                open class AvatarSelected {
                    private var avatarSelected = avatars[position]

                    fun setAvatarImage(): Any {
                        val selected = when (avatarSelected) {
                            "Ghost" -> {
                                ImageAvatar.setImageResource(R.drawable.ghost_avatar_front)
                                editor.putString("imageAvatar", "Ghost")
                                editor.putBoolean("selected", true)
                                editor.commit()
                            }
                            "Frank" -> {
                                ImageAvatar.setImageResource(R.drawable.frank_front)
                                editor.putString("imageAvatar", "Frank")
                                editor.putBoolean("selected", true)
                                editor.commit()
                            }
                            "Dead" -> {
                                ImageAvatar.setImageResource(R.drawable.dead_front)
                                editor.putString("imageAvatar", "Dead")
                                editor.putBoolean("selected", true)
                                editor.commit()
                            }
                            "Vamp" -> {
                                ImageAvatar.setImageResource(R.drawable.vamp_front)
                                editor.putString("imageAvatar", "Vamp")
                                editor.putBoolean("selected", true)
                                editor.commit()
                            }
                            "Whitch" -> {
                                ImageAvatar.setImageResource(R.drawable.whitch_front)
                                editor.putString("imageAvatar", "Whitch")
                                editor.putBoolean("selected", true)
                                editor.commit()
                            }
                            else -> {
                                "default"
                                editor.putBoolean("selected", false)

                            }
                        }
                        var value: Any = selected
                        Log.i(TAG, avatarSelected.toString())

                        btnChoose.setOnClickListener {
                            finish()
                        }
                        return value
                    }

                    fun getAvatarImage(): String? {
                        return avatarSelected
                    }
                }
                AvatarSelected().setAvatarImage()
                Log.i(TAG, AvatarSelected().getAvatarImage().toString())
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // write code to perform some action
            }
        }

    }
}