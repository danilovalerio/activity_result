package com.example.activityresult

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.AbsListView
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class ListaEstadosActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val listView = ListView(this)
        setContentView(listView)

        val listaEstados = resources.getStringArray(R.array.estados)

        val listaAdapter = ArrayAdapter(this,
            android.R.layout.simple_list_item_single_choice, listaEstados)

        listView.adapter = listaAdapter
        listView.choiceMode = AbsListView.CHOICE_MODE_SINGLE

        val state = intent.getStringExtra(EXTRA_STATE)

        if (state != null) {
            val position = listaEstados.indexOf(state)
            listView.setItemChecked(position, true)
        }

        listView.setOnItemClickListener { l, _, position, _ ->
            val result = l.getItemAtPosition(position) as String

            val it = Intent()
            it.putExtra(EXTRA_RESULT, result)

            setResult(Activity.RESULT_OK, it)
            finish()
        }
    }

    companion object{
        const val EXTRA_STATE = "estado"
        const val EXTRA_RESULT = "result"
    }
}
