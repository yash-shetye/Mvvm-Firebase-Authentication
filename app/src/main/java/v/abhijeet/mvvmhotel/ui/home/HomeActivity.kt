package v.abhijeet.mvvmhotel.ui.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider


import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein

import v.abhijeet.mvvmhotel.R
import v.abhijeet.mvvmhotel.data.firebase.FirebaseSource
import v.abhijeet.mvvmhotel.data.repositories.UserRepository
import v.abhijeet.mvvmhotel.databinding.ActivityHomeBinding



class HomeActivity : AppCompatActivity(), KodeinAware {

    override val kodein by kodein()


    private lateinit var viewModel: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val binding: ActivityHomeBinding = DataBindingUtil.setContentView(this, R.layout.activity_home)
       // viewModel = ViewModelProviders.of(this, factory).get(HomeViewModel::class.java)
        val viewModelFactory = HomeViewModelFactory(UserRepository(FirebaseSource()))
        viewModel = ViewModelProvider(this, viewModelFactory).get(HomeViewModel::class.java)
        binding.viewmodel = viewModel

    }

}
