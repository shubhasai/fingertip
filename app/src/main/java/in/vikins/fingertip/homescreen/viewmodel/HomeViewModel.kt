package `in`.vikins.fingertip.homescreen.viewmodel

import `in`.vikins.fingertip.homescreen.models.Recyclerlist
import `in`.vikins.fingertip.homescreen.network.RetroInstance
import `in`.vikins.fingertip.homescreen.network.RetroService
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel():ViewModel() {
    var recyclerlistdata:MutableLiveData<Recyclerlist>
    init {
        recyclerlistdata = MutableLiveData()
    }
    fun getRecyclerlistObserver():MutableLiveData<Recyclerlist>{
        return recyclerlistdata
    }
    fun makeapicall(){
        viewModelScope.launch (Dispatchers.IO){
            val retroinstance =RetroInstance.getRetroInstance().create(RetroService::class.java)
            val response = retroinstance.getDataFromApi("news")
            recyclerlistdata.postValue(response)
        }
    }
}