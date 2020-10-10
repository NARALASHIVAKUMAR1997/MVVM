package com.example.roomwithexoplayer.ui.main.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeDataViewModel :ViewModel() {

    private val homeImageLiveData = MutableLiveData<List<String>>()

    fun setDataToLiveData() : MutableLiveData<List<String>>{
        val arrayList = ArrayList<String>()
        arrayList.add("https://cdn.pixabay.com/photo/2018/07/11/21/51/toast-3532016_1280.jpg")
        arrayList.add("https://cdn.pixabay.com/photo/2014/10/23/18/05/burger-500054_1280.jpg")
        arrayList.add("https://cdn.pixabay.com/photo/2018/03/31/19/29/schnitzel-3279045_1280.jpg")
        arrayList.add("https://cdn.pixabay.com/photo/2016/10/25/13/29/smoked-salmon-salad-1768890_1280.jpg")
        arrayList.add("https://cdn.pixabay.com/photo/2017/05/01/05/18/pastry-2274750_1280.jpg")
        arrayList.add("https://cdn.pixabay.com/photo/2018/07/10/21/23/pancake-3529653_1280.jpg")
        arrayList.add("https://cdn.pixabay.com/photo/2018/06/18/16/05/indian-food-3482749_1280.jpg")
        arrayList.add("https://cdn.pixabay.com/photo/2014/08/07/21/07/souffle-412785_1280.jpg")
        arrayList.add("https://cdn.pixabay.com/photo/2018/04/09/18/26/asparagus-3304997_1280.jpg")
        homeImageLiveData.value = arrayList

        return homeImageLiveData
    }








}