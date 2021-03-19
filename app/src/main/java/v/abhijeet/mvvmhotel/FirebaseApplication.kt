package v.abhijeet.mvvmhotel

import android.app.Application
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton
import v.abhijeet.mvvmhotel.data.firebase.FirebaseSource
import v.abhijeet.mvvmhotel.data.repositories.UserRepository
import v.abhijeet.mvvmhotel.ui.auth.AuthViewModelFactory
import v.abhijeet.mvvmhotel.ui.home.HomeViewModelFactory


class FirebaseApplication : Application(), KodeinAware {

    override val kodein = Kodein.lazy {
        import(androidXModule(this@FirebaseApplication))

        bind() from singleton { FirebaseSource() }
        bind() from singleton { UserRepository(instance()) }
        bind() from provider { AuthViewModelFactory(instance()) }
        bind() from provider { HomeViewModelFactory(instance()) }

    }
}