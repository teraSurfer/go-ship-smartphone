package com.example.goship.ui.user

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.goship.R
import com.example.goship.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {

    companion object {
        fun newInstance() = LoginFragment()
    }

    private val loginViewModel: LoginViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        activity?.findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)?.visibility  = View.INVISIBLE

        val binding = DataBindingUtil.inflate<FragmentLoginBinding>(inflater, R.layout.fragment_login,container,false)

        binding.loginButton.setOnClickListener { view: View ->
            loginViewModel.email.value = binding.emailTextId.text.toString()
            if (binding.loginAsCustomerRadioButton.isChecked){
                loginViewModel.isCustomer.value = true

                Navigation.findNavController(view).navigate(
                    LoginFragmentDirections.actionLoginFragmentToNavCustomerEstimate()
                )
            }else {
                loginViewModel.isCustomer.value = false
                Navigation.findNavController(view).navigate(
                    LoginFragmentDirections.actionLoginFragmentToNavVendorEstimate()
                )
            }
        }

        binding.newUserRegisterButton.setOnClickListener { view: View ->
            Navigation.findNavController(view).navigate(
                LoginFragmentDirections.actionLoginFragmentToRegisterUserFragment()
            )
        }
        return binding.root
    }
}
