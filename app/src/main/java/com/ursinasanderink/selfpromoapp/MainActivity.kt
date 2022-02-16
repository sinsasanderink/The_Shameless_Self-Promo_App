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
       val contactName = edit_text_contact_name.text.toString()
       val contactNumber = edit_text_contact_number.text.toString()
       val myDisplayName = edit_text_my_display_name.text.toString()
       val includeJunior = check_box_junior.isChecked
       val jobTitle = spinner_job_title.selectedItem?.toString()
        val immediateStart = check_box_immediate_start.isChecked
        val startDate = edit_text_start_date.text.toString()

        // In Kotlin, the word New is not needed to make a new object
        // referring to happens with :: in Kotlin
       val previewActivityIntent = Intent(this, PreviewActivity::class.java)
        // If you want any extra data use the putExtra method:
        previewActivityIntent.putExtra("Contact Name", contactName)
        previewActivityIntent.putExtra("Contact Number", contactNumber)
        previewActivityIntent.putExtra("My Display Name", myDisplayName)
        previewActivityIntent.putExtra("Include Junior", includeJunior)
        previewActivityIntent.putExtra("Job Title", jobTitle)
        previewActivityIntent.putExtra("Immediate Start", immediateStart)
        previewActivityIntent.putExtra("Start Date", startDate)
        startActivity(previewActivityIntent)

    }
}