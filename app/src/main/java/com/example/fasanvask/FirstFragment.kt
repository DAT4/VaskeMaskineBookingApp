package com.example.fasanvask

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import com.example.fasanvask.databinding.FragmentFirstBinding
import com.example.fasanvask.viewmodels.BookingRepository
import com.example.fasanvask.viewmodels.BookingViewModel
import com.example.fasanvask.viewmodels.BookingViewModelProviderFactory
import com.example.fasanvask.api.Resource
import com.example.fasanvask.models.User
import kotlinx.coroutines.flow.collect

class FirstFragment : Fragment() {
    private lateinit var _binding: FragmentFirstBinding
    private val binding get() = _binding
    private val viewModel by lazy { createViewModel() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        observeToken()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        makeLoginButton()
    }

    private fun observeToken() {
        lifecycleScope.launchWhenCreated {
            viewModel.token.collect { uiState ->
                when (uiState) {
                    is Resource.Success -> navigate()
                    is Resource.Error -> showMessage("${uiState.message}...")
                    is Resource.Loading -> showMessage("Loading...")
                    is Resource.Nil -> showMessage("Not loaded..")
                }
            }
        }
    }

    private fun showMessage(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }

    private fun makeLoginButton() {
        binding.apply {
            login.setOnClickListener {
                viewModel.login(User("${room.text}", "${password.text}"))
            }
        }
    }

    private fun navigate() {
        Navigation.findNavController(binding.root).navigate(R.id.navigateToInsideFragment)
    }

    private fun createViewModel(): BookingViewModel {
        val repository = BookingRepository()
        val factory = BookingViewModelProviderFactory(repository)
        return ViewModelProvider(this, factory)
            .get(BookingViewModel::class.java)
    }

}