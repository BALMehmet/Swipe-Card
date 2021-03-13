package com.mbal.swipecard3

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.mbal.swipecard3.adaptors.ProfilesAdapter
import com.mbal.swipecard3.databinding.ActivityMainBinding
import com.mbal.swipecard3.databinding.ProfileCardStackBinding
import com.mbal.swipecard3.model.CharacterList
import com.mbal.swipecard3.service.RickAndMortyApi
import com.mbal.swipecard3.service.RickAndMortyInterface
import com.mbal.swipecard3.viewmodel.CharacterListViewModel
import org.junit.Assert.assertEquals
import org.junit.Test
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException


//Unit Test..
class SwipeCardUnitTest{

    @Test
    fun apiService_isGetCharacters() {
        var rickAndMortyInterface = RickAndMortyApi().getClient()!!.create(RickAndMortyInterface::class.java);
        var apiResponse:CharacterList
        try {
            apiResponse=rickAndMortyInterface.getCharacters("character?page=1").execute().body()!!
            assertEquals(20, apiResponse.results.size)
        }

        catch (e: IOException) {
            e.printStackTrace();
        }
    }

    @Test
    fun id_isSuitModel() {
        fun apiService_isGetCharacters() {
            var rickAndMortyInterface = RickAndMortyApi().getClient()!!.create(RickAndMortyInterface::class.java);
            var apiResponse:CharacterList
            try {
                apiResponse=rickAndMortyInterface.getCharacters("character?page=1").execute().body()!!
                assertEquals(1, apiResponse.results[0].id)
            }

            catch (e: IOException) {
                e.printStackTrace();
            }
        }
    }

    @Test
    fun name_isSuitModel() {
        var rickAndMortyInterface = RickAndMortyApi().getClient()!!.create(RickAndMortyInterface::class.java);
        var apiResponse:CharacterList
        try {
            apiResponse=rickAndMortyInterface.getCharacters("character?page=1").execute().body()!!
            assertEquals("Rick Sanchez", apiResponse.results[0].name)
        }

        catch (e: IOException) {
            e.printStackTrace();
        }
    }

    @Test
    fun status_isSuitModel() {
        var rickAndMortyInterface = RickAndMortyApi().getClient()!!.create(RickAndMortyInterface::class.java);
        var apiResponse:CharacterList
        try {
            apiResponse=rickAndMortyInterface.getCharacters("character?page=1").execute().body()!!
            assertEquals("Alive", apiResponse.results[0].status)
        }

        catch (e: IOException) {
            e.printStackTrace();
        }
    }

    @Test
    fun location_isSuitModel() {
        var rickAndMortyInterface = RickAndMortyApi().getClient()!!.create(RickAndMortyInterface::class.java);
        var apiResponse:CharacterList
        try {
            apiResponse=rickAndMortyInterface.getCharacters("character?page=1").execute().body()!!
            assertEquals("Earth (Replacement Dimension)", apiResponse.results[0].location.name)
            print(apiResponse.results[0].location.name)
        }

        catch (e: IOException) {
            e.printStackTrace();
        }
    }
}

