package com.example.goship.ui.vendor.price

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI

import com.example.goship.R
import com.example.goship.databinding.FragmentUpdateLeastPriceBinding
import com.example.goship.network.UpdateLeastPriceAPI
import com.example.goship.ui.user.LoginViewModel
import okhttp3.MediaType
import okhttp3.RequestBody
import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UpdateLeastPriceFragment : Fragment() {

    private lateinit var updateLeastPriceViewModel: UpdateLeastPriceViewModel

    companion object {
        fun newInstance() = UpdateLeastPriceFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentUpdateLeastPriceBinding>(inflater, R.layout.fragment_update_least_price,container,false)

        var source = UpdateLeastPriceFragmentArgs.fromBundle(arguments!!).sourcedivision
        var destination = UpdateLeastPriceFragmentArgs.fromBundle(arguments!!).destinationdivision

        updateLeastPriceViewModel = ViewModelProviders.of(this).get(UpdateLeastPriceViewModel::class.java)
        val loginViewModel : LoginViewModel by activityViewModels()

        binding.textView4.text = source
        binding.textView5.text = destination
        updateLeastPriceViewModel.leastprice.observe(viewLifecycleOwner, Observer { price ->
            binding.textView7.text = price.toString()
        })

        binding.minusButton.setOnClickListener { _: View ->
            updateLeastPriceViewModel.decreasePrice()
        }

        binding.plusButton.setOnClickListener { _: View ->
            updateLeastPriceViewModel.increasePrice()
        }

        binding.button2.setOnClickListener { view: View ->
            if(updateLeastPriceViewModel.leastprice.value == updateLeastPriceViewModel.initialprice.value){
                val toast = Toast.makeText(context, context!!.getText(R.string.warning_price_should_be_less), Toast.LENGTH_SHORT
                )
                toast.show()
            }
            else{
                updateLeastPrice(source, destination, updateLeastPriceViewModel.leastprice.value.toString(), loginViewModel.email.value.toString())
            }
        }
        updateLeastPriceViewModel.getLeastPrice(source, destination)

        setHasOptionsMenu(true)
        return binding.root
    }

    private fun updateLeastPrice(source: String, destination: String, price: String, v_email: String) {

        val json = JSONObject()
        json.put("sourcedivision", source)
        json.put("destinationdivision", destination)
        json.put("price", price)
        json.put("v_email", v_email)

        val requestBody: RequestBody = RequestBody.create(MediaType.parse("application/json"), json.toString())
        UpdateLeastPriceAPI.retrofitService.post(
            requestBody).enqueue(
            object : Callback<ResponseBody> {
                override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                    val toast = Toast.makeText(context,
                        context!!.getText(R.string.error_failed_price_update).toString() + t.message, Toast.LENGTH_LONG)
                    toast.show()
                }

                override fun onResponse(
                    call: Call<ResponseBody>,
                    response: Response<ResponseBody>
                ) {
                    if(response.code() == 200){
                        val toast = Toast.makeText(context,
                            context!!.getText(R.string.info_successful_price_update), Toast.LENGTH_SHORT
                        )
                        toast.show()
                    }
                    else{
                        val toast = Toast.makeText(context,
                            context!!.getText(R.string.error_failed_price_update).toString(), Toast.LENGTH_LONG)
                        toast.show()
                    }

                }
            }
        )
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        updateLeastPriceViewModel = ViewModelProviders.of(this).get(UpdateLeastPriceViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, Navigation.findNavController(view!!))
                ||super.onOptionsItemSelected(item)
    }

}
