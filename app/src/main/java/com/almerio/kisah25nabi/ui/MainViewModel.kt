package com.almerio.kisah25nabi.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.almerio.kisah25nabi.data.KisahResponse
import com.yoenas.kisah25nabi.data.network.ApiClient
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class MainViewModel : ViewModel() {

     var isLoading = MutableLiveData<Boolean>()
     var isError = MutableLiveData<Throwable>()
     var kisahResponse = MutableLiveData<List<KisahResponse>>()

    fun getData(responseHandler : (List<KisahResponse>) -> Unit, errorHandler : (Throwable) -> Unit) {
        ApiClient.getApiService().getKisahNabi()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                responseHandler(it)
            }, {
                errorHandler(it)
            })
    }

    fun getKisahNabi() {
        getData({
            isLoading.value = true
            kisahResponse.value = it
        }, {
            isLoading.value = false
            isError.value = it
        })
    }
}