package com.example.sampleangusapp

import android.app.Application
import com.example.sampleangusapp.data.AppDatabase
import com.example.sampleangusapp.data.network.*
import com.example.sampleangusapp.data.repository.AppRepository
import com.example.sampleangusapp.data.repository.AppRepositoryImpl
import com.example.sampleangusapp.ui.mainmenu.work.tenantrequest.detail.TenantRequestDetailViewModelFactory
import com.example.sampleangusapp.ui.mainmenu.work.tenantrequest.list.TenantRequestViewModelFactory
import com.jakewharton.threetenabp.AndroidThreeTen
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.*

class SampleApplication : Application(), KodeinAware {
    override val kodein = Kodein.lazy {
        import(androidXModule(this@SampleApplication))

        bind() from singleton { AppDatabase(instance()) }
        bind() from singleton { instance<AppDatabase>().workOrderDao() }
        bind<ConnectivityInterceptor>() with singleton { ConnectivityInterceptorImpl(instance())}
        bind() from singleton { AngusApiService(instance()) }
        bind<AppNetworkDataSource>() with singleton { AppNetworkDataSourceImpl(instance())}
        bind<AppRepository>() with singleton { AppRepositoryImpl(instance(), instance()) }
        bind() from provider { TenantRequestViewModelFactory(instance()) }
        bind() from factory { workOrderId: Int -> TenantRequestDetailViewModelFactory(workOrderId, instance()) }

    }

    override fun onCreate() {
        super.onCreate()
        AndroidThreeTen.init(this)
    }
}