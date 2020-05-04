package com.example.goship.ui.user

import android.os.Bundle
import android.util.Patterns
import android.view.*
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import com.example.goship.R
import com.example.goship.databinding.FragmentLoginBinding
import com.example.goship.network.LoginAPI
import okhttp3.MediaType
import okhttp3.RequestBody
import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


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
            if(validateInputs(binding)){
                val email = binding.emailTextId.text.toString()
                val password = binding.passwordTextId.text.toString()
                loginViewModel.email.value = email

                login(email = email, password = password, isCustomer = binding.loginAsCustomerRadioButton.isChecked, binding = binding, view = view)
            }
        }

        binding.newUserRegisterButton.setOnClickListener { view: View ->
            Navigation.findNavController(view).navigate(
                LoginFragmentDirections.actionLoginFragmentToRegisterUserFragment()
            )
        }
        return binding.root
    }

    private fun validateInputs(binding: FragmentLoginBinding) : Boolean{
        var valid = true
        val email = binding.emailTextId.text.toString()
        val password = binding.passwordTextId.text.toString()

        if(email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            binding.emailTextId.setError("Please enter valid Email")
            valid = false
        }

        if(password.isEmpty()){
            binding.passwordTextId.setError("Please enter Password")
            valid = false
        }
        return valid
    }

    private fun login(email: String, password: String, isCustomer: Boolean, binding: FragmentLoginBinding, view : View)  {
        val json = JSONObject()
        if(isCustomer){
            json.put("customer", true)
        }else{
            json.put("customer", false)
        }
        json.put("email", email)
        json.put("password", password)

        val requestBody: RequestBody = RequestBody.create(MediaType.parse("application/json"), json.toString())
        LoginAPI.retrofitService.post(
            requestBody).enqueue(
            object : Callback<ResponseBody> {
                override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                    val toast = Toast.makeText(context,
                        context!!.getText(R.string.error_authentication_failed).toString() + t.message, Toast.LENGTH_LONG)
                    toast.show()
                }

                override fun onResponse(
                    call: Call<ResponseBody>,
                    response: Response<ResponseBody>
                ) {
                    if(response.code() == 200){
                        val toast = Toast.makeText(context,
                            context!!.getText(R.string.success_authentication), Toast.LENGTH_SHORT
                        )

                        toast.show()
                        if (binding.loginAsCustomerRadioButton.isChecked){
                            Navigation.findNavController(view).navigate(
                                LoginFragmentDirections.actionLoginFragmentToNavCustomerEstimate())
                            loginViewModel.isCustomer.value = true

                        }else {
                            loginViewModel.isCustomer.value = false
                            Navigation.findNavController(view).navigate(
                                LoginFragmentDirections.actionLoginFragmentToNavVendorEstimate()
                            )
                        }
                    }
                    else{
                        val toast = Toast.makeText(context,
                            context!!.getText(R.string.error_authentication_failed).toString(), Toast.LENGTH_LONG)
                        toast.show()
                    }

                }
            }
        )
    }
}