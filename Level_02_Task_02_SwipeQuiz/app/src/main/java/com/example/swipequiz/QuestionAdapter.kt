package com.example.swipequiz

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.item_question.view.*

class QuestionAdapter(private val questions: List<Question>): RecyclerView.Adapter<QuestionAdapter.ViewHolder>(){

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(question: Question){
            var questionAnswer:Boolean
            //Bind the question to the recyclerview
            itemView.tvQuestions.text = question.questionText
            itemView.setOnClickListener{
                questionAnswer = question.value == 4
                Snackbar.make(itemView, "Question: " + question.questionText + ": Answer is " + questionAnswer, Snackbar.LENGTH_SHORT).show()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_question, parent,false)
        )
    }

    override fun getItemCount(): Int {
        return questions.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(questions[position])
    }
}