package v.abhijeet.mvvmhotel.ui.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

import v.abhijeet.mvvmhotel.data.repositories.UserRepository

@Suppress("UNCHECKED_CAST")
class AuthViewModelFactory(private val repository: UserRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return AuthViewModel(repository) as T
    }

}