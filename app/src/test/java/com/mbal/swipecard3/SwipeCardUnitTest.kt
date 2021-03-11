package com.mbal.swipecard3

import android.view.View
import android.view.animation.LinearInterpolator
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.*
import androidx.recyclerview.widget.DefaultItemAnimator
import com.mbal.swipecard3.adaptors.ProfilesAdapter
import com.mbal.swipecard3.databinding.ActivityMainBinding
import com.mbal.swipecard3.model.CharacterList
import com.mbal.swipecard3.service.RickAndMortyApi
import com.mbal.swipecard3.service.RickAndMortyInterface
import com.mbal.swipecard3.viewmodel.CharacterListViewModel
import com.yuyakaido.android.cardstackview.CardStackLayoutManager
import com.yuyakaido.android.cardstackview.CardStackView
import com.yuyakaido.android.cardstackview.Direction
import com.yuyakaido.android.cardstackview.SwipeableMethod
import org.junit.Assert.assertEquals
import org.junit.Test
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import android.os.Bundle as OsBundle


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class SwipeCardUnitTest {
    @Test
    fun apiService_isGetCharacters() {
        var rickAndMortyInterface = RickAndMortyApi().getClient()!!.create(RickAndMortyInterface::class.java);
        rickAndMortyInterface.getCharacters("character?page=1").enqueue(object : Callback<CharacterList>{
            override fun onFailure(call: Call<CharacterList>, t: Throwable) {

            }

            override fun onResponse(call: Call<CharacterList>, response: Response<CharacterList>) {
                assertEquals(response.body()!!.results.size, 20)
            }

        })
    }

    @Test
    fun id_isSuitModel() {
        var rickAndMortyInterface = RickAndMortyApi().getClient()!!.create(RickAndMortyInterface::class.java);
        rickAndMortyInterface.getCharacters("character?page=1").enqueue(object : Callback<CharacterList>{
            override fun onFailure(call: Call<CharacterList>, t: Throwable) {

            }

            override fun onResponse(call: Call<CharacterList>, response: Response<CharacterList>) {
                assertEquals(response.body()!!.results[0].id, 1)
            }

        })
    }

    @Test
    fun name_isSuitModel() {
        var rickAndMortyInterface = RickAndMortyApi().getClient()!!.create(RickAndMortyInterface::class.java);
        rickAndMortyInterface.getCharacters("character?page=1").enqueue(object : Callback<CharacterList>{
            override fun onFailure(call: Call<CharacterList>, t: Throwable) {

            }

            override fun onResponse(call: Call<CharacterList>, response: Response<CharacterList>) {
                assertEquals(response.body()!!.results[0].name, "Rick Sanchez")
            }

        })
    }

    @Test
    fun status_isSuitModel() {
        var rickAndMortyInterface = RickAndMortyApi().getClient()!!.create(RickAndMortyInterface::class.java);
        rickAndMortyInterface.getCharacters("character?page=1").enqueue(object : Callback<CharacterList>{
            override fun onFailure(call: Call<CharacterList>, t: Throwable) {

            }

            override fun onResponse(call: Call<CharacterList>, response: Response<CharacterList>) {
                assertEquals(response.body()!!.results[0].status, "Alive")
            }

        })
    }

    @Test
    fun location_isSuitModel() {
        var rickAndMortyInterface = RickAndMortyApi().getClient()!!.create(RickAndMortyInterface::class.java);
        rickAndMortyInterface.getCharacters("character?page=1").enqueue(object : Callback<CharacterList>{
            override fun onFailure(call: Call<CharacterList>, t: Throwable) {

            }

            override fun onResponse(call: Call<CharacterList>, response: Response<CharacterList>) {
                assertEquals(response.body()!!.results[0].location.name, "Earth")
            }

        })
    }

    /*@Test
    fun card_isSwiped(){
        var binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var layoutManager: CardStackLayoutManager
        var charactersViewModel: CharacterListViewModel
        val profilesAdapter = ProfilesAdapter()
        var pageCounter =1

        layoutManager = CardStackLayoutManager(this, this).apply {
            setSwipeableMethod(SwipeableMethod.AutomaticAndManual)
            setOverlayInterpolator(LinearInterpolator())
        }
        charactersViewModel = ViewModelProvider(this).get(CharacterListViewModel::class.java)
        charactersViewModel.GetCharacterListViewModel(pageCounter)!!.observe(this, Observer {
            profilesAdapter.setCharacters(it)
        })

        binding.cardStackView.layoutManager=layoutManager
        binding.cardStackView.adapter=profilesAdapter
        binding.cardStackView.itemAnimator=DefaultItemAnimator()
        binding.cardStackView.swipe()
        binding.cardStackView.rewind()


    }



    override fun onCardDisappeared(view: View?, position: Int) {

    }

    override fun onCardDragging(direction: Direction?, ratio: Float) {

    }

    override fun onCardSwiped(direction: Direction?) {
        assertEquals(true, true)
    }

    override fun onCardCanceled() {

    }

    override fun onCardAppeared(view: View?, position: Int) {

    }

    override fun onCardRewound() {

    }*/
}

