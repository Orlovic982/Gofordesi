package com.orlandus.gofordesicompose

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.orlandus.gofordesicompose.ui.models.Tab
import com.orlandus.gofordesicompose.ui.models.Tabs
import com.orlandus.gofordesicompose.ui.repository.Repository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel : ViewModel() {

    private val repository = Repository()
    private val _isloading = MutableStateFlow(true)
    val isloading = _isloading.asStateFlow()
    val tabs=MutableLiveData<List<Tab>>()


    init {
        Log.d("Milan","Pokrenuli smo")
        viewModelScope.launch {
            val list = repository.getBottomTabs()
            if (list.isSuccessful) {
                tabs.value= list.body()?.tabs
            }else{

                Log.d("Milan","\n"+"Error code:"+list.code())
            }


            _isloading.value = false

        }
    }
}