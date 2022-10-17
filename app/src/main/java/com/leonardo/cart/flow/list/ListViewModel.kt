package com.leonardo.cart.flow.list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ListViewModel(
    private val repository: ListRepository
) : ViewModel() {

    val listLiveData: MutableLiveData<ListStates> by lazy {
        MutableLiveData()
    }

    val textoLiveData: MutableLiveData<String> by lazy {
        MutableLiveData()
    }

    fun onButtonClick() {
        textoLiveData.value = "Oi"
    }

    fun fetchList() {
        val items = repository.getItems()
        onListReceived(items)
    }

    private fun onListReceived(items: List<ListItem>) {
        if (items.isEmpty()) {
            listLiveData.value = ListStates.EmptyList
        } else {
            listLiveData.value = ListStates.FilledList(items)
        }
    }

    sealed class ListStates {
        object EmptyList : ListStates()
        data class FilledList(val items: List<ListItem>) : ListStates()
    }

}

class ListRepository {

    fun getItems(): List<ListItem> {
        return listOf<ListItem>(
            ListItem("Arroz", 3, false),
            ListItem("Batata", 30, false),
            ListItem("Macarrão", 5, false)
        )
    }

}