package com.mbal.swipecard3.adaptors

import android.util.Log.d
import android.util.Log.i
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mbal.swipecard3.model.Character
import com.mbal.swipecard3.model.CharacterList
import com.bumptech.glide.Glide
import com.mbal.swipecard3.databinding.ProfileCardStackBinding
import kotlinx.android.synthetic.main.profile_card_stack.view.*

class ProfilesAdapter : RecyclerView.Adapter<ProfilesAdapter.ProfileViewHolder>() {
    private var characters: CharacterList ?= null

    fun setCharacters (profiles: CharacterList) {
        this.characters =profiles
        //implemented to get live data from View Model
        notifyDataSetChanged()
        i("info", "Character list was assigned adapter")
    }

    class ProfileViewHolder(itemBinding: ProfileCardStackBinding) : RecyclerView.ViewHolder(itemBinding.root) {
        //Set view holder item
        fun setData (data: Character?){
            if (data != null) {
                //Glide used to dowload image from url
                Glide.with(itemView.rootView)
                        .load(data.image)
                        .into(itemView.item_image);
                //Set text view
                itemView.item_name?.text = data.name
                itemView.item_status?.text = data.status
                itemView.item_location?.text = data.location.name
                i("info", "Profile parameter was set to Item View")
            }
        }

    }

    override fun  onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileViewHolder {
        i("info", "Create View Holder")
        val itemBinding=ProfileCardStackBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ProfileViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: ProfileViewHolder, position: Int) {
        holder.setData(characters?.results?.get(position))
    }

    override fun getItemCount(): Int {
        //Return size of character list
        val size=this.characters?.results?.size
        return if (size != null) size else 0
    }
}
