package v.abhijeet.mvvmhotel.ui.home

import android.view.View
import androidx.lifecycle.ViewModel

import v.abhijeet.mvvmhotel.data.repositories.UserRepository
import v.abhijeet.mvvmhotel.utils.startLoginActivity

class HomeViewModel(
    private val repository: UserRepository
) : ViewModel() {

    val user by lazy {
        repository.currentUser()
    }
    
    fun logout(view: View){
        repository.logout()
        view.context.startLoginActivity()
    }
}