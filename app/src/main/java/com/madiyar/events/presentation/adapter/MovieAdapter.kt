package com.madiyar.events.presentation.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.madiyar.data.utils.Constant.POSTER_BASEURL
import com.madiyar.domain.models.MovieListResponse
import com.madiyar.events.R
import com.madiyar.events.databinding.ItemRowBinding

class MovieAdapter : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {
    private lateinit var binding: ItemRowBinding
    private lateinit var context:Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieAdapter.ViewHolder {
        var inflater = LayoutInflater.from(parent.context)
        binding=ItemRowBinding.inflate(inflater,parent,false)
        context=parent.context
        return ViewHolder()
    }

    override fun onBindViewHolder(holder: MovieAdapter.ViewHolder, position: Int) {
        holder.binding(differ.currentList[position])
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    inner class ViewHolder : RecyclerView.ViewHolder(binding.root){
        fun  binding(item: MovieListResponse.Result){
            binding.apply {
                tvMovieName.text=item.title
                tvRate.text=item.voteAvarage.toString()
                val moviePosterURL=POSTER_BASEURL+item.posterPath
                imgMovie.load(moviePosterURL){
                    crossfade(true)
                    placeholder(R.drawable.poster_placeholder)
                    scale(coil.size.Scale.FILL)
                }
                tvLang.text=item.originalLanguage
                tvMovieDateReleased.text=item.releaseDate
            }
        }
    }

    private val differCallback= object :  DiffUtil.ItemCallback<MovieListResponse.Result>(){
        override fun areItemsTheSame(
            oldItem: MovieListResponse.Result,
            newItem: MovieListResponse.Result
        ): Boolean {
            return oldItem.id==newItem.id
        }

        override fun areContentsTheSame(
            oldItem: MovieListResponse.Result,
            newItem: MovieListResponse.Result
        ): Boolean {
            return oldItem==newItem
        }
    }

    var differ= AsyncListDiffer(this,differCallback)

}