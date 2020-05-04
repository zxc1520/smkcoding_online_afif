package com.smkcoding.myapp

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_profil.*

class ProfilActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profil)

        ambilData()
        btnEditName.setOnClickListener { navigasiKeEditProfil() }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK) {
                val result = data?.getStringExtra("nama")
                txtName.text = result
            } else {
                Toast.makeText(this, "Edit Failed", Toast.LENGTH_SHORT).show()
            }
        }
        super.onActivityResult(requestCode, resultCode, data)
    }

    companion object {
       val REQUEST_CODE = 100
    }

    private fun ambilData() {
        val bundle = intent.extras

        val nama = bundle?.getString("nama")
        val gender = bundle?.getString("gender")
        val email = bundle?.getString("email")
        val telp = bundle?.getString("telp")
        val alamat = bundle?.getString("alamat")

        txtName.text = nama
        tv_jk.text = gender
        tv_email.text = email
        tv_telp.text = telp
        tv_alamat.text = alamat

    }

    private fun navigasiKeEditProfil() {
        val intent = Intent(this, EditProfilActivity::class.java)

        val userName = txtName.text.toString()
        intent.putExtra("nama", userName)

        startActivityForResult(intent, REQUEST_CODE)
    }

}
