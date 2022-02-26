package com.ursinasanderink.selfpromoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_preview.*

class PreviewActivity : AppCompatActivity() {

    private lateinit var message : Message // lateinit is like a promise that we initialise it later
    private lateinit var messagePreviewText: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preview)
        // With "as Message" we tell Android what kind of class it is and convert it (this is called "casting")
        // Type Casting = Taking an object of one Type and transforming it into another Type
        // If we write the wrong data type (for example boolean instead Message) our app will crash and we'll get a class cast exception
        displayMessage()
        setupButton()
    }

    private fun displayMessage() {
        message = intent.getSerializableExtra("Message") as Message
        messagePreviewText = """
                Hi ${message.contactName}, 
                
                My name is ${message.myDisplayName} and I am ${message.getFullJobDescription()}.
                
                I have a portfolio of apps to demonstrate my technical skills that I can show on request.
                
                I am able to start a new position ${message.getAvaibility()}.
                
                Please get in touch if you have any suitable roles for me.
                
                Thanks and best regards.
            """.trimIndent()  // this code deletes the spaces in front of every line.
        text_view_message.text = messagePreviewText
    }

    private fun setupButton() {
        button_send_message.setOnClickListener {
            // Send Message Intent
        }

    }


}