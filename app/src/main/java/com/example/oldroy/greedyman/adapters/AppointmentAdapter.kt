package com.example.oldroy.greedyman.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import com.example.oldroy.greedyman.R
import com.example.oldroy.greedyman.models.Appointment
import kotlinx.android.synthetic.main.card_appointment.view.*

class AppointmentAdapter(val appointmentList: ArrayList<Appointment>, val context: Context) : RecyclerView.Adapter<AppointmentAdapter.ViewHolder>() {

    class ViewHolder(itemView: View?, context: android.content.Context) : RecyclerView.ViewHolder(itemView) {
        @android.annotation.SuppressLint("SetTextI18n")
        fun bindData(appointment: Appointment) {
            itemView.text_name.text = appointment.name
            itemView.text_interval.text = "${appointment.date} ${appointment.startAt} - ${appointment.endAt}"
            itemView.text_location.text = appointment.location
            itemView.text_participant.text = appointment.participants.toString()
        }
    }

    override fun onBindViewHolder(viewHolder: ViewHolder?, position: Int) = viewHolder!!.bindData(appointmentList[position])

    override fun onCreateViewHolder(viewGroup: android.view.ViewGroup?, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.card_appointment, viewGroup, false)
        return ViewHolder(view, context)
    }

    override fun getItemCount(): Int = appointmentList.size

}