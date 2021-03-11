package com.mbal.swipecard3.repo

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.mbal.swipecard3.model.CharacterList
import com.mbal.swipecard3.service.RickAndMortyInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RickAndMortyApiRepo() {
    fun GetCharacters(serviceInterface:RickAndMortyInterface, pageCounter:Int): MutableLiveData<CharacterList> {
        var apiResponse = MutableLiveData <CharacterList>()
        var url="character?page=" + pageCounter.toString()

        //Call service interface with url parameter. Url paarameter used for pagination
        serviceInterface.getCharacters(url).enqueue(object : Callback<CharacterList>{
            override fun onFailure(call: Call<CharacterList>, t: Throwable) {
                Log.d("Error", "Server connection issue: ${t.message}")
            }

            override fun onResponse(call: Call<CharacterList>, response: Response<CharacterList>) {
                if (response.isSuccessful) {
                    apiResponse.postValue(response.body())
                } else {
                    Log.d("Error", "onResponse: connection issue ")
                }
                Log.i("info", "Repo get data successfully ")
            }
        })
        return apiResponse
    }
}