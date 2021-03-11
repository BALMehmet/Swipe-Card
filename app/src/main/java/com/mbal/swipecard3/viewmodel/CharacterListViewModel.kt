package com.mbal.swipecard3.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mbal.swipecard3.model.CharacterList
import com.mbal.swipecard3.repo.RickAndMortyApiRepo
import com.mbal.swipecard3.service.RickAndMortyApi
import com.mbal.swipecard3.service.RickAndMortyInterface

class CharacterListViewModel : ViewModel() {
    lateinit private var rickAndMortyInterface: RickAndMortyInterface
    private var characterList: MutableLiveData<CharacterList>? = null

    fun GetCharacterListViewModel(pageCounter:Int): MutableLiveData<CharacterList>? {
        //Created retrofit and set to model class
        rickAndMortyInterface = RickAndMortyApi().getClient()!!.create(RickAndMortyInterface::class.java);
        characterList =RickAndMortyApiRepo().GetCharacters(rickAndMortyInterface, pageCounter)//RickAndMortyApiRepo().GetCharacters(rickAndMortyInterface, pageCounter);
        return characterList
    }
}