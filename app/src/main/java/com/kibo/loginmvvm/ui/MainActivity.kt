package com.kibo.loginmvvm.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.kibo.loginmvvm.R
import com.kibo.loginmvvm.databinding.ActivityMainBinding
import com.kibo.loginmvvm.model.LoginResult
import com.kibo.loginmvvm.viewmodel.LoginViewModel
import retrofit2.Callback

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private  lateinit var  binding: ActivityMainBinding
    private  lateinit var loginViewModel:LoginViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        loginViewModel = LoginViewModel()
        binding.btnLogin.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
       var email = binding.edtEmail.text.toString()
        var pass = binding.edtEmail.text.toString()
       loginViewModel.login(email,pass)
    }

    private  fun observeLogin(email:String, password:String)
    {
        loginViewModel.login(email,password).observe(this, Observer {
            if(it!=null)
            {
                Toast.makeText(this,"login succsess",Toast.LENGTH_SHORT).show()
            }
            else
            {
                Toast.makeText(this,"erros",Toast.LENGTH_LONG).show()
            }
        })
    }
}