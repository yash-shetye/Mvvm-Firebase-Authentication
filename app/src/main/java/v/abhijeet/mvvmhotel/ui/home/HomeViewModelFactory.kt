package v.abhijeet.mvvmhotel.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

import v.abhijeet.mvvmhotel.data.repositories.UserRepository

@Suppress("UNCHECKED_CAST")
class HomeViewModelFactory(
    private val repository: UserRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return HomeViewModel(repository) as T
    }

}