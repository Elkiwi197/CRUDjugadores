package com.example.crudjugadores.ui.pantallaUpdate

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
import androidx.navigation.fragment.navArgs
import com.example.crudjugadores.databinding.FragmentUpdateBinding
import com.example.crudjugadores.domain.model.Jugador
import com.example.crudjugadores.ui.common.UiEvent
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FragmentUpdate : Fragment() {

    private var _binding: FragmentUpdateBinding? = null
    private val binding get() = _binding!!
    private val args: FragmentUpdateArgs by navArgs()
    private val viewModel: FragmentUpdateViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUpdateBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.handleEvent(FragmentUpdateEvento.GetJugador(args.idJugador))

        creareventos()
        observarState()
    }

    private fun creareventos() {
        with(binding) {
            botonAdd.setOnClickListener {
                viewModel.handleEvent(FragmentUpdateEvento.UpdateJugador(crearJugador()))
            }
            buttonDelete.setOnClickListener {
                viewModel.handleEvent(FragmentUpdateEvento.DeleteJugador(args.idJugador))
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

        return Jugador(args.idJugador, nombre, edad, equipo, posicion, valor)
    }

    @SuppressLint("SetTextI18n")
    private fun observarState() {
        viewModel.uiState.observe(viewLifecycleOwner) { state ->
            state?.let {
                state.event?.let { event ->
                    when (event) {
                        UiEvent.PopBackStack -> findNavController().navigateUp()
                        is UiEvent.ShowSnackbar -> Toast.makeText(
                            requireContext(),
                            event.message,
                            Toast.LENGTH_SHORT
                        ).show()

                    }
                }

                binding.editTextNombre.setText(state.jugadorUpdate.nombre)
                binding.editTextEquipo.setText(state.jugadorUpdate.equipo)
                binding.seekBarEdad.progress = state.jugadorUpdate.edad
                binding.textViewEdad.text = "Edad: " + state.jugadorUpdate.edad
                binding.editTextPosicion.setText(state.jugadorUpdate.posicion)
                binding.editTextValor.setText(state.jugadorUpdate.valor.toString())

            }
        }
    }


}