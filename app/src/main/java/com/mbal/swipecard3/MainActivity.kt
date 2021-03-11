package com.mbal.swipecard3

import android.os.Bundle
import android.util.Log.d
import android.util.Log.i
import android.view.View
import android.view.animation.LinearInterpolator
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DefaultItemAnimator
import com.mbal.swipecard3.adaptors.ProfilesAdapter
import com.mbal.swipecard3.databinding.ActivityMainBinding
import com.mbal.swipecard3.viewmodel.CharacterListViewModel
import com.yuyakaido.android.cardstackview.CardStackLayoutManager
import com.yuyakaido.android.cardstackview.CardStackListener
import com.yuyakaido.android.cardstackview.Direction
import com.yuyakaido.android.cardstackview.SwipeableMethod

class MainActivity : AppCompatActivity(), CardStackListener {
    private lateinit var binding: ActivityMainBinding
    private val profilesAdapter = ProfilesAdapter()
    private lateinit var layoutManager: CardStackLayoutManager
    private lateinit var charactersViewModel: CharacterListViewModel
    //pageCounter created for pagination
    private var pageCounter: Int =1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Set layout manager
        layoutManager = CardStackLayoutManager(this, this).apply {
            setSwipeableMethod(SwipeableMethod.AutomaticAndManual)
            setOverlayInterpolator(LinearInterpolator())
        }
        //Calls View Model, get data and set first page
        charactersViewModel = ViewModelProvider(this).get(CharacterListViewModel::class.java)
        charactersViewModel.GetCharacterListViewModel(pageCounter)!!.observe(this, Observer {
            profilesAdapter.setCharacters(it)
        })
        binding.cardStackView.layoutManager = layoutManager
        binding.cardStackView.adapter = profilesAdapter
        binding.cardStackView.itemAnimator.apply {
            if (this is DefaultItemAnimator) {
                supportsChangeAnimations = false
            }
        }
    }


    override fun onCardDisappeared(view: View?, position: Int) {

    }

    override fun onCardDragging(direction: Direction?, ratio: Float) {

    }

    override fun onCardSwiped(direction: Direction?) {
        i("info:", "Current Page: ${this.layoutManager.topPosition}, Last Page:  ${profilesAdapter.itemCount}")
        //This condition checks item position and decides to get next page
        if(this.layoutManager.topPosition == profilesAdapter.itemCount){
            pageCounter = pageCounter +1
            charactersViewModel.GetCharacterListViewModel(pageCounter)!!.observe(this, Observer {
                profilesAdapter.setCharacters(it)
            })
            i("info", "Get Next Page")
        }
    }

    override fun onCardCanceled() {

    }

    override fun onCardAppeared(view: View?, position: Int) {
        val tv=view!!.findViewById<TextView>(R.id.item_name)
        i("info","Item Position: " + position + ", item name: " + tv.text)
    }

    override fun onCardRewound() {

    }


}

