package com.smkcoding.myapp

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_edit_profil.*

class EditProfilActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profil)

        val intentData = intent.extras
        val userName = intentData?.getString("nama")

        edtProfilName.setText(userName)
        btnSaveEdit.setOnClickListener { saveData() }
    }

    private fun saveData() {
        val editName = edtProfilName.text.toString()
        if (!editName.isEmpty()) {
            val result = Intent()
            result.putExtra("nama", editName)
            setResult(Activity.RESULT_OK, result)
        } else {
            setResult(Activity.RESULT_CANCELED)
        }

        finish()
    }
}
