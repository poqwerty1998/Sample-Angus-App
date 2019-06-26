package com.example.samplelogin.ui.mainmenu.work.tenantrequest.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel;
import com.example.samplelogin.data.TenantRequestRepository
import com.shopify.livedataktx.SingleLiveData

class TenantRequestViewModel() : ViewModel() {
    // TODO: Implement the ViewModel

    val _navigationLiveData = SingleLiveData<TenantNavigation>()
    val navigationLiveData : LiveData<TenantNavigation> = _navigationLiveData

    // use requestid for now since idk what your models look like for the request
    fun onRequestClicked(requestId : Int) {
        _navigationLiveData.postValue(TenantNavigation.Request(requestId))
    }


}

// extract this class whereever you want to
// basically, I use sealed classes for encapsulating navigation
sealed class TenantNavigation {
    data class Request(val requestId : Int) : TenantNavigation()
}