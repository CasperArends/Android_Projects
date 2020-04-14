package com.example.rockpaperscissors

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.score.view.*

class RockPaperScissorAdapter (private val rps: List<RockPaperScissor>) : RecyclerView.Adapter<RockPaperScissorAdapter.ViewHolder>()
{

    override fun getItemCount(): Int {
        return rps.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(rps[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.score, parent, false)
        )
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(rps: RockPaperScissor) {
            itemView.tvWinner.text = rps.winner
            itemView.tvDate.text = rps.date

            when (rps.computerChoice) {
                1 -> itemView.ivComputerTurn.setImageResource(R.drawable.paper)
                2 -> itemView.ivComputerTurn.setImageResource(R.drawable.rock)
                3 -> itemView.ivComputerTurn.setImageResource(R.drawable.scissors)
            }
            when (rps.playerChoice) {
                1 -> itemView.ivPlayerTurn.setImageResource(R.drawable.paper)
                2 -> itemView.ivPlayerTurn.setImageResource(R.drawable.rock)
                3 -> itemView.ivPlayerTurn.setImageResource(R.drawable.scissors)
            }
        }
    }
}
