package com.mbal.swipecard3.service

import com.mbal.swipecard3.model.CharacterList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Url

interface RickAndMortyInterface
{
    @GET
    abstract fun getCharacters(@Url url: String): Call<CharacterList>
}