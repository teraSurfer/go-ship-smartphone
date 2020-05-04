package com.example.goship.ui.customer

import android.app.DatePickerDialog
import android.icu.util.Calendar
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.core.view.get
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI

import com.example.goship.R
import com.example.goship.databinding.FragmentPlaceOrderBinding
import com.example.goship.dataproperty.EstimateProperty
import com.example.goship.dataproperty.OrderSuccessProperty
import com.example.goship.network.EstimateAPI
import com.example.goship.network.PlaceOrderAPI
import com.example.goship.ui.user.LoginViewModel
import okhttp3.MediaType
import okhttp3.RequestBody
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PlaceOrderFragment : Fragment() {

    companion object {
        fun newInstance() = PlaceOrderFragment()
    }

    private lateinit var viewModel: PlaceOrderViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = DataBindingUtil.inflate<FragmentPlaceOrderBinding>(inflater, R.layout.fragment_place_order,container,false)
        viewModel = ViewModelProviders.of(this).get(PlaceOrderViewModel::class.java)

        viewModel.source  = PlaceOrderFragmentArgs.fromBundle(arguments!!).source
        viewModel.destination  = PlaceOrderFragmentArgs.fromBundle(arguments!!).destination
        viewModel.weight = PlaceOrderFragmentArgs.fromBundle(arguments!!).weight

        binding.source.text = viewModel.source
        binding.destination.text = viewModel.destination
        binding.wightValue.text = viewModel.weight.toString()


        viewModel.price.observe(viewLifecycleOwner, Observer {
            binding.priceValue.text = "$"+viewModel.price.value

        })


        //reference : https://stackoverflow.com/questions/45842167/how-to-use-datepickerdialog-in-kotlin

        binding.pickupDay.setOnFocusChangeListener { view, hasFocus ->
            if(hasFocus) {
                val calender = Calendar.getInstance()
                val year = calender.get(Calendar.YEAR)
                val month = calender.get(Calendar.MONTH)
                val day = calender.get(Calendar.DAY_OF_MONTH)

                activity?.let {
                    DatePickerDialog(
                        it,
                        DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                            var date_string =
                                (monthOfYear+1).toString() + "/" + dayOfMonth.toString() + "/" + year
                            viewModel.pickup_date = date_string
                            binding.pickupDay.setText(date_string)
                        },
                        year,
                        month,
                        day
                    )
                }?.show()
            }
        }

        binding.placeOrder.setOnClickListener { view: View ->
            if(binding.sourceAddress.text.toString().trim()=="" || binding.destinationAddress.text.toString().trim()==""
                ||binding.sourceMobile.text.toString().trim()=="" || binding.destinationMobile.text.toString().trim()==""||
                binding.pickupDay.text.toString().trim()==""){

            }else{
                viewModel.source_address = binding.sourceAddress.text.toString()
                viewModel.destination_address = binding.destinationAddress.text.toString()
                viewModel.source_mobile = binding.sourceMobile.text.toString()
                viewModel.destination_mobile = binding.destinationMobile.text.toString()
                viewModel.pickup_date = binding.pickupDay.text.toString()

                placeOrder()
            }
        }
        setHasOptionsMenu(true)
        return binding.root
    }



    private fun  placeOrder() {
        val loginViewModel : LoginViewModel by activityViewModels()

        val json = JSONObject()
        json.put("origin", viewModel.source.toInt())
        json.put("destination", viewModel.destination.toInt())
        json.put("u_email", loginViewModel.email.value.toString())
        json.put("o_address", viewModel.source_address)
        json.put("d_address", viewModel.destination_address)
        json.put("weight", viewModel.weight)
        json.put("o_mobile", viewModel.source_mobile.toLong())
        json.put("d_mobile", viewModel.destination_mobile.toLong())
        json.put("p_date", viewModel.pickup_date)

        val requestBody: RequestBody = RequestBody.create(MediaType.parse("application/json"), json.toString())
        PlaceOrderAPI.retrofitService.post(
            requestBody).enqueue(
            object : Callback<OrderSuccessProperty> {
                override fun onFailure(call: Call<OrderSuccessProperty>, t: Throwable) {
                    val toast = Toast.makeText(context,
                        "Order place Failed: " + t.message, Toast.LENGTH_LONG)
                    toast.show()
                }

                override fun onResponse(
                    call: Call<OrderSuccessProperty>,
                    response: Response<OrderSuccessProperty>
                ) {
                    if(response.code() == 200){


                        var action = response.body()?.let {
                            PlaceOrderFragmentDirections.actionNavPlaceOrderToNavOrderSuccess(
                                id = response.body()!!.id,
                                price = response.body()!!.price,
                                vEmail = response.body()!!.v_email,
                                vName = response.body()!!.v_name,
                                vMobile = response.body()!!.v_mobile,
                                weight = viewModel.weight
                            )
                        }
                        if (action != null) {
                            view?.findNavController()?.navigate(action)
                        }
                    }
                    else{
                        val toast = Toast.makeText(context,
                            "Order place Failed: " + response.body(), Toast.LENGTH_LONG)
                        toast.show()
                    }

                }
            }
        )
    }

    private fun getEstimate(){
        viewModel = ViewModelProviders.of(this).get(PlaceOrderViewModel::class.java)

        EstimateAPI.retrofitService.getProperties(source = viewModel.source, destination = viewModel.destination, weight = viewModel.weight).enqueue(
            object : Callback<EstimateProperty> {
                override fun onFailure(call: Call<EstimateProperty>, t: Throwable) {
                    viewModel.price.value = ""
                    val toast = Toast.makeText(context,
                        "Estimate Price Failed: " + t.message, Toast.LENGTH_LONG)
                    toast.show()
                }

                override fun onResponse(
                    call: Call<EstimateProperty>,
                    response: Response<EstimateProperty>
                ) {
                    if(response.code() == 200) {
                        viewModel.price.value = response.body()?.price.toString()
                    }else{
                        val toast = Toast.makeText(context,
                            "Estimate Price Failed: " + response.body(), Toast.LENGTH_LONG)
                        toast.show()
                    }
                }
            }
        )
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(PlaceOrderViewModel::class.java)
        getEstimate()
        // TODO: Use the ViewModel
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, Navigation.findNavController(view!!))
                ||super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu, menuInflater: MenuInflater) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //menuInflater.inflate(R.menu.main, menu)
        menu[0].setVisible(true)
    }

}




