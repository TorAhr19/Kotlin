package com.example.ex2calculatrice

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    // Déclaration des variables nécessaires
    private lateinit var button0: Button
    private lateinit var button1: Button
    private lateinit var button2: Button
    private lateinit var button3: Button
    private lateinit var button4: Button
    private lateinit var button5: Button
    private lateinit var button6: Button
    private lateinit var button7: Button
    private lateinit var button8: Button
    private lateinit var button9: Button
    private lateinit var buttonPlus: Button
    private lateinit var buttonMoins: Button
    private lateinit var buttonDiv: Button
    private lateinit var buttonMul: Button
    private lateinit var buttonC: Button
    private lateinit var buttonEgal: Button
    private lateinit var buttonPoint: Button
    private lateinit var editecran: EditText

    private var nombre1 = 0.0 // pour mémoriser le 1er nombre de l'opération
    private var operateur = "" // pour mémoriser l'opérateur
    private var changenombre = false // pour indiquer si on passe au nombre2 à l'affichage
    private var nombre2 = 0.0 // pour mémoriser le 2ème nombre de l'opération

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Affectation des éléments d'interface graphique aux variables
        button0 = findViewById(R.id.button0)
        button1 = findViewById(R.id.button1)
        button2 = findViewById(R.id.button2)
        button3 = findViewById(R.id.button3)
        button4 = findViewById(R.id.button4)
        button5 = findViewById(R.id.button5)
        button6 = findViewById(R.id.button6)
        button7 = findViewById(R.id.button7)
        button8 = findViewById(R.id.button8)
        button9 = findViewById(R.id.button9)
        buttonPoint = findViewById(R.id.buttonPoint)
        buttonPlus = findViewById(R.id.buttonPlus)
        buttonMoins = findViewById(R.id.buttonMoins)
        buttonDiv = findViewById(R.id.buttonDivision)
        buttonMul = findViewById(R.id.buttonMultiplier)
        buttonC = findViewById(R.id.buttonC)
        buttonEgal = findViewById(R.id.buttonEgal)
        editecran = findViewById(R.id.EditText01)

        // Mise en place d'un écouteur d'événement à tous les boutons
        buttonPlus.setOnClickListener { plusClick() }
        buttonMoins.setOnClickListener { moinsClick() }
        buttonDiv.setOnClickListener { divClick() }
        buttonMul.setOnClickListener { mulClick() }
        buttonC.setOnClickListener { resetClick() }
        buttonEgal.setOnClickListener { egalClick() }
        buttonPoint.setOnClickListener { chiffreClick(".") }
        button0.setOnClickListener { chiffreClick("0") }
        button1.setOnClickListener { chiffreClick("1") }
        button2.setOnClickListener { chiffreClick("2") }
        button3.setOnClickListener { chiffreClick("3") }
        button4.setOnClickListener { chiffreClick("4") }
        button5.setOnClickListener { chiffreClick("5") }
        button6.setOnClickListener { chiffreClick("6") }
        button7.setOnClickListener { chiffreClick("7") }
        button8.setOnClickListener { chiffreClick("8") }
        button9.setOnClickListener { chiffreClick("9") }
    }

    // Méthode exécutée lors du clic sur un bouton chiffre
    private fun chiffreClick(str: String) {
        if (changenombre) {
            // Début d'affichage du nombre2
            editecran.setText(str)
            changenombre = false
        } else {
            // Complément de l'affichage du nombre1 ou nombre2
            editecran.setText(editecran.text.toString() + str)
        }
    }

    // Méthode exécutée lors du clic sur le bouton +
    private fun plusClick() {
        nombre1 = editecran.text.toString().toDouble()
        operateur = "+"
        changenombre = true
    }

    // Méthode exécutée lors du clic sur le bouton -
    private fun moinsClick() {
        nombre1 = editecran.text.toString().toDouble()
        operateur = "-"
        changenombre = true
    }

    // Méthode exécutée lors du clic sur le bouton *
    private fun mulClick() {
        nombre1 = editecran.text.toString().toDouble()
        operateur = "*"
        changenombre = true
    }

    // Méthode exécutée lors du clic sur le bouton /
    private fun divClick() {
        nombre1 = editecran.text.toString().toDouble()
        operateur = "/"
        changenombre = true
    }

    // Méthode exécutée lors du clic sur le bouton =
    private fun egalClick() {
        calcul()
        changenombre = true
        operateur = ""
    }

    // Méthode exécutée lors du clic sur le bouton C
    private fun resetClick() {
        changenombre = true
        nombre1 = 0.0
        operateur = ""
        editecran.setText("")
    }

    // Méthode qui effectue l'opération demandée par l'utilisateur entre nombre1 et nombre2
    private fun calcul() {
        var result = 0.0
        nombre2 = editecran.text.toString().toDouble()
        when (operateur) {
            "+" -> result = nombre1 + nombre2
            "-" -> result = nombre1 - nombre2
            "*" -> result = nombre1 * nombre2
            "/" -> if (nombre2 != 0.0) result = nombre1 / nombre2
        }
        editecran.setText(result.toString())
    }
}
