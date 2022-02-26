package com.ursinasanderink.selfpromoapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*
import com.google.android.material.textfield.TextInputEditText
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_preview.setOnClickListener {
            onPreviewClicked()
        }

        val spinnerValues: Array<String> = arrayOf("Android Developer", "Android Engineer")
        val spinnerAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item,spinnerValues)
        spinner_job_title.adapter = spinnerAdapter

    }

    private fun onPreviewClicked() {
        val message = Message(
            edit_text_contact_name.text.toString(),
            edit_text_contact_number.text.toString(),
            edit_text_my_display_name.text.toString(),
            check_box_junior.isChecked,
            spinner_job_title.selectedItem?.toString(),
            check_box_immediate_start.isChecked,
            edit_text_start_date.text.toString()
        )

        // In Kotlin, the word New is not needed to make a new object
        // referring to happens with :: in Kotlin
       val previewActivityIntent = Intent(this, PreviewActivity::class.java)
        previewActivityIntent.putExtra("Message", message)
        startActivity(previewActivityIntent)
    }
}