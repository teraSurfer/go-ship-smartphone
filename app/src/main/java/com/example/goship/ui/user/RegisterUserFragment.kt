package com.example.goship.ui.user

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation

import com.example.goship.R
import com.example.goship.databinding.FragmentLoginBinding
import com.example.goship.databinding.FragmentRegisterUserBinding
import com.example.goship.network.AddCustomerAPI
import com.example.goship.network.AddVendorAPI
import com.example.goship.network.UpdateLeastPriceAPI
import okhttp3.MediaType
import okhttp3.RequestBody
import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterUserFragment : Fragment() {

    companion object {
        fun newInstance() = RegisterUserFragment()
    }

    private lateinit var registerUserViewModel: RegisterUserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        activity?.findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)?.visibility  = View.INVISIBLE
        val binding = DataBindingUtil.inflate<FragmentRegisterUserBinding>(inflater, R.layout.fragment_register_user,container,false)

        registerUserViewModel = ViewModelProviders.of(this).get(RegisterUserViewModel::class.java)

        binding.registerButton.setOnClickListener { view: View ->
            val first_name = binding.firstNameTextId.text.toString()
            val last_name = binding.lastNameTextId.text.toString()
            val email = binding.emailTextId.text.toString()
            val mobile = binding.mobileNumberTextId.text.toString()
            val password = binding.passwordTextId.text.toString()
            if(validateInputs(binding)) {
                var isCustomer = false
                if (binding.registerAsCustomerRadioButton.isChecked) {
                    isCustomer = true
                }
                register(
                    firstname = first_name,
                    lastname = last_name,
                    email = email,
                    mobile = mobile,
                    password = password,
                    isCustomer = isCustomer
                )
            }
        }
        return binding.root
    }

    private fun validateInputs(binding: FragmentRegisterUserBinding) : Boolean{
        var valid = true
        val first_name = binding.firstNameTextId.text.toString()
        val last_name = binding.lastNameTextId.text.toString()
        val email = binding.emailTextId.text.toString()
        val mobile = binding.mobileNumberTextId.text.toString()
        val password = binding.passwordTextId.text.toString()
        val confirm_password = binding.confirmPasswordTextId.text.toString()

        if(first_name.isEmpty()){
            binding.firstNameTextId.setError("Please enter valid First Name")
            valid = false
        }
        if(last_name.toString().isEmpty()){
            binding.lastNameTextId.setError("Please enter valid Last Name")
            valid = false
        }
        if(email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            binding.emailTextId.setError("Please enter valid Email")
            valid = false
        }
        if(mobile.isEmpty() || !Patterns.PHONE.matcher(mobile).matches()){
            binding.mobileNumberTextId.setError("Please enter valid Mobile number")
            valid = false
        }
        if(password.isEmpty() || password.length < 6){
            binding.passwordTextId.setError("Password length should be at least 6 character")
            valid = false
        }
        if(confirm_password.isEmpty() || confirm_password.length < 6){
            binding.confirmPasswordTextId.setError("Password length should be at least 6 character")
            valid = false
        }else{
            if(!confirm_password.equals(password)){
                binding.confirmPasswordTextId.setError("Password and Confirm Password should match.")
                valid = false
            }
        }

        return valid
    }

    private fun register(firstname: String, lastname: String, email: String, mobile: String, password: String, isCustomer: Boolean) {

        val json = JSONObject()
        if(isCustomer){
            json.put("u_email", email)
            json.put("first_name", firstname)
            json.put("last_name", lastname)
        }else{
            json.put("v_email", email)
            json.put("name", firstname+lastname)
            json.put("mobile", mobile)
        }

        val requestBody: RequestBody = RequestBody.create(MediaType.parse("application/json"), json.toString())
        AddCustomerAPI.retrofitService.post(
            requestBody).enqueue(
            object : Callback<ResponseBody> {
                override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                    val toast = Toast.makeText(context,
                        context!!.getText(R.string.error_failed_to_register).toString() + t.message, Toast.LENGTH_LONG)
                    toast.show()
                }

                override fun onResponse(
                    call: Call<ResponseBody>,
                    response: Response<ResponseBody>
                ) {
                    if(response.code() == 200){
                        val toast = Toast.makeText(context,
                            context!!.getText(R.string.success_user_register), Toast.LENGTH_SHORT
                        )
                        toast.show()
                    }
                    else{
                        val toast = Toast.makeText(context,
                            context!!.getText(R.string.error_failed_to_register).toString(), Toast.LENGTH_LONG)
                        toast.show()
                    }

                }
            }
        )
    }
}
