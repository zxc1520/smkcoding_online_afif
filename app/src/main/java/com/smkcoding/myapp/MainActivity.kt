package com.smkcoding.myapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var inputName : String = ""
    private var inputEmail : String = ""
    private var telpInput : String = ""
    private var inputAlamat : String = ""
    private var inputGender : String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setDataSpinner()

        //tes komentar
        btnSave.setOnClickListener { validate() }

    }

    private fun setDataSpinner() {
        val adapter = ArrayAdapter.createFromResource(this, R.array.jk, android.R.layout.simple_spinner_item)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerGender.adapter = adapter
    }

    private fun goToProfil() {
        val intent = Intent(this, ProfilActivity::class.java)

        val bundle = Bundle()
        bundle.putString("nama", inputName)
        bundle.putString("gender", inputGender)
        bundle.putString("email", inputEmail)
        bundle.putString("telp", telpInput)
        bundle.putString("alamat", inputAlamat)

        intent.putExtras(bundle)

        startActivity(intent)
    }

    private fun validate() {

        inputName = nama.text.toString()
        inputEmail = email.text.toString()
        telpInput = telp.text.toString()
        inputAlamat = addres.text.toString()
        inputGender = spinnerGender.selectedItem.toString()

        when {
            inputName.isEmpty() -> nama.error = "Nama harus diisi"
            inputGender.equals(
                "Pilih jenis kelamin",
                ignoreCase = true
            ) -> showToast("Jenis kelamin harus dipilih")
            inputEmail.isEmpty() -> email.error = "Email harus diisi"
            telpInput.isEmpty() -> telp.error = "Telepon harus diisi"
            inputAlamat.isEmpty() -> addres.error = "Alamat harus diisi"

            else -> {
                showToast("Navigasi halaman profil")
                goToProfil()
            }

        }

    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
