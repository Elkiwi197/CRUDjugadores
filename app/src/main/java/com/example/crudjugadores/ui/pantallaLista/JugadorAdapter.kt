package com.example.crudjugadores.ui.pantallaLista

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.crudjugadores.R
import com.example.crudjugadores.domain.model.Jugador

class JugadorAdapter(
    val actions: JugadorActions
): ListAdapter<Jugador, JugadorViewholder>(DiffCallback()){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JugadorViewholder {
        return JugadorViewholder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.jugador_view, parent, false),
            actions,
        )
    }

    override fun onBindViewHolder(holder: JugadorViewholder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    class DiffCallback : DiffUtil.ItemCallback<Jugador>() {
        override fun areItemsTheSame(oldItem: Jugador, newItem: Jugador): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Jugador, newItem: Jugador): Boolean {
            return oldItem == newItem
        }
    }
    interface JugadorActions {
        fun onItemClick(jugador: Jugador)
        fun onItemDeleted(jugador: Jugador)
    }
}