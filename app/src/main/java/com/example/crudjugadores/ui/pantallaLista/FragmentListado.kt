package com.example.crudjugadores.ui.pantallaLista

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.crudjugadores.databinding.FragmentListadoBinding
import com.example.crudjugadores.domain.model.Jugador
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class FragmentListado : Fragment() {

    private var _binding: FragmentListadoBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: JugadorAdapter
    private val viewModel: FragmentListadoViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListadoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        configureRecyclerView()
        observarState()
        eventos()

        viewModel.handleEvent(FragmentListadoEvent.GetJugadores)
    }

    private fun observarState() {
        viewModel.uiState.observe(viewLifecycleOwner) { state ->
            adapter.submitList(state.jugadores)
        }
    }

    private fun configureRecyclerView() {
        adapter = JugadorAdapter(
            actions = object : JugadorAdapter.JugadorActions {
                override fun onItemClick(jugador: Jugador) {
                    val action = FragmentListadoDirections.actionFragmentListadoToFragmentUpdate(jugador.id)
                    findNavController().navigate(action)
                }

                override fun onItemDeleted(jugador: Jugador) {
                    viewModel.handleEvent(FragmentListadoEvent.GetJugadores)
                }
            }
        )

        binding.listaJugadores.layoutManager = LinearLayoutManager(requireContext())
        binding.listaJugadores.adapter = adapter

    }


    private fun eventos() {
        binding.botonNavegarDetalle.setOnClickListener {
            val action = FragmentListadoDirections.actionFragmentListadoToFragmentAnadir()
            findNavController().navigate(action)
        }
    }
}