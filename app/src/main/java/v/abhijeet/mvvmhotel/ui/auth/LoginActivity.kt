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
import v.abhijeet.mvvmhotel.databinding.ActivityLoginBinding
import v.abhijeet.mvvmhotel.utils.startHomeActivity


class LoginActivity : AppCompatActivity(), AuthListener, KodeinAware {

    override val kodein by kodein()




 private lateinit var viewModel : AuthViewModel
    lateinit var binding : ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val viewModelFactory = AuthViewModelFactory(UserRepository(FirebaseSource()))

         binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
       viewModel = ViewModelProvider(this,viewModelFactory).get(AuthViewModel::class.java)
      //  viewModel = ViewModelProviders(this, factory).get(AuthViewModel::class.java)
        binding.viewmodel = viewModel

        viewModel.authListener = this
    }
    override fun onStart() {
        super.onStart()
        viewModel.user?.let {
            startHomeActivity()
        }
    }

    override fun onStarted() {

        Toast.makeText(this, "hello", Toast.LENGTH_SHORT).show()
    }

    override fun onSuccess() {

        Toast.makeText(this, "Login sucessfull", Toast.LENGTH_SHORT).show()
        startHomeActivity()
    }

    override fun onFailure(message: String) {

        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }


}
