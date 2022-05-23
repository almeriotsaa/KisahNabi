package com.almerio.kisah25nabi.ui

import androidx.lifecycle.ViewModel
import com.almerio.kisah25nabi.data.KisahResponse
import com.yoenas.kisah25nabi.data.network.ApiClient
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class MainViewModel : ViewModel() {

    fun getData(responseHandler : (List<KisahResponse>) -> Unit, errorHandler : (Throwable) -> Unit) {
        ApiClient.getApiService().getKisahNabi()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                responseHandler(it)
            }, {

            }
            )
    }
}