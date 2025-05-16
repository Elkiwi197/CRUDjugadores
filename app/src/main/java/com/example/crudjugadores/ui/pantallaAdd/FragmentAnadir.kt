package com.example.crudjugadores.ui.pantallaAdd

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.crudjugadores.databinding.FragmentAnadirBinding
import com.example.crudjugadores.domain.model.Jugador
import com.example.crudjugadores.ui.common.UiEvent
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class FragmentAnadir : Fragment() {

    private var _binding: FragmentAnadirBinding? = null
    private val binding get() = _binding!!
    private val viewModel: FragmentAnadirViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAnadirBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        crearEventos()
        observarState()
    }

    private fun observarState() {
        viewModel.uiState.observe(viewLifecycleOwner) { state ->
            state.event?.let { event ->
                when (event) {
                    UiEvent.PopBackStack -> findNavController().navigateUp()
                    is UiEvent.ShowSnackbar -> Toast.makeText(
                        requireContext(),
                        event.message,
                        Toast.LENGTH_SHORT
                    )
                        .show()
                }
            }

        }
    }

    private fun crearEventos() {
        with(binding) {
            botonAdd.setOnClickListener {
                viewModel.handleEvent(FragmentAnadirEvento.AnadirJugador(crearJugador()))
            }
            seekBarEdad.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
                @SuppressLint("SetTextI18n")
                override fun onProgressChanged(
                    seekBar: SeekBar?,
                    progress: Int,
                    fromUser: Boolean
                ) {
                    textViewEdad.text = "Edad: $progress"
                }

                override fun onStartTrackingTouch(p0: SeekBar?) {
                    //No necesario
                }
                override fun onStopTrackingTouch(p0: SeekBar?) {
                    //No necesario
                }
            })
        }
    }

    private fun crearJugador(): Jugador {
        val nombre = binding.editTextNombre.text.toString()
        val equipo = binding.editTextEquipo.text.toString()
        val edad: Int = binding.seekBarEdad.progress
        val posicion = binding.editTextPosicion.text.toString()
        val valor: Int = binding.editTextValor.text.toString().toInt()

        return Jugador(1, nombre, edad, equipo, posicion, valor)
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}