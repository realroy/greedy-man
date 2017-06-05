package com.example.oldroy.greedyman

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.oldroy.greedyman.adapters.AppointmentAdapter
import com.example.oldroy.greedyman.models.Appointment


class DashboardFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.fragment_dashboard, container, false)
        val recycler_invitation = view.findViewById(R.id.recycler_invitation) as RecyclerView
        recycler_invitation.setHasFixedSize(true)
        val layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        recycler_invitation.layoutManager = layoutManager
        val appointmentList = ArrayList<Appointment>()
        val a1 = Appointment()
        a1.name = "a1"
        val a2 = Appointment()
        a2.name = "a2"
        appointmentList.add(a1)
        appointmentList.add(a2)
        val appointmentAdapter = AppointmentAdapter(appointmentList, context)
        recycler_invitation.adapter = appointmentAdapter
        return view
    }

}// Required empty public constructor
