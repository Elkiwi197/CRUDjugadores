package com.example.crudjugadores.ui.pantallaLista

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.crudjugadores.databinding.JugadorViewBinding
import com.example.crudjugadores.domain.model.Jugador


class JugadorViewholder(itemView: View, val actions: JugadorAdapter.JugadorActions) :
    RecyclerView.ViewHolder(itemView) {

    private val binding = JugadorViewBinding.bind(itemView)

    fun bind(item: Jugador) {
        with(binding) {
            textViewNombre.text = item.nombre
            textViewEdad.text = item.edad.toString()
            textViewEquipo.text = item.equipo
            textViewPosicion.text = item.posicion
            textViewValor.text = item.valor.toString()

            itemView.setOnLongClickListener {
                true
            }
            itemView.setOnClickListener {
                actions.onItemClick(item)
            }
        }
    }
}