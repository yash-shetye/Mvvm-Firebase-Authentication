package v.abhijeet.mvvmhotel.ui.auth


import android.os.Bundle

import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider


import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein

import v.abhijeet.mvvmhotel.R
import v.abhijeet.mvvmhotel.data.firebase.FirebaseSource
import v.abhijeet.mvvmhotel.data.repositories.UserRepository

import v.abhijeet.mvvmhotel.databinding.ActivitySignupBinding


class SignupActivity : AppCompatActivity(), AuthListener, KodeinAware {

    override val kodein by kodein()
  //  private val factory : AuthViewModelFactory by instance()

    private lateinit var viewModel: AuthViewModel
    lateinit var binding : ActivitySignupBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
      //  setContentView(R.layout.activity_signup)

        val viewModelFactory = AuthViewModelFactory( UserRepository(FirebaseSource()))
         binding= DataBindingUtil.setContentView(this, R.layout.activity_signup)
      //  viewModel = ViewModelProviders.of(this, factory).get(AuthViewModel::class.java)

        viewModel = ViewModelProvider(this, viewModelFactory).get(AuthViewModel::class.java)
        binding.viewmodel = viewModel

        viewModel.authListener = this
    }

    override fun onStarted() {

        /*Intent(this, HomeActivity::class.java).also {
            it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(it)
        }*/
    }

    override fun onSuccess() {

        //startHomeActivity()
        Toast.makeText(this, "Sigun up sucessfull", Toast.LENGTH_SHORT).show()
    }

    override fun onFailure(message: String) {

        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
