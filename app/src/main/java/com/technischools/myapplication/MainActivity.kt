package com.technischools.myapplication

import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val washProgramInput = findViewById<EditText>(R.id.wash_program_input)
        val washProgramResult = findViewById<TextView>(R.id.wash_program_result)
        val confirmWashProgramButton = findViewById<MaterialButton>(R.id.confirm_wash_program_button)
        val vacuumToggleButton = findViewById<MaterialButton>(R.id.vacuum_toggle_button)
        val vacuumState = findViewById<TextView>(R.id.vacuum_state)

        confirmWashProgramButton.setOnClickListener {
            val programNumber = washProgramInput.text.toString().toIntOrNull()
            if (programNumber != null && programNumber in 1..12) {
                washProgramResult.text = getString(R.string.wash_program_number, programNumber)
            } else {
                Toast.makeText(this, R.string.invalid_wash_program, Toast.LENGTH_SHORT).show()
            }
        }

        var vacuumIsOn = false
        vacuumToggleButton.setOnClickListener {
            vacuumIsOn = !vacuumIsOn
            if (vacuumIsOn) {
                vacuumToggleButton.setText(R.string.turn_off)
                vacuumState.setText(R.string.vacuum_on)
            } else {
                vacuumToggleButton.setText(R.string.turn_on)
                vacuumState.setText(R.string.vacuum_off)
            }
        }
    }
}
