package com.example.oldroy.greedyman.models

import java.util.*

class Appointment {

    companion object {
        val STATUS_INVITATION = "invitation"
        val STATUS_DONE = "done"
        val STATUS_NOT_DONE = "not done"
    }

    var name = ""
    var startAt = ""
    var endAt = ""
    var date = Date()
    var location = ""
    var participants = ArrayList<String>()
    var priority = 0
    var status = Appointment.STATUS_NOT_DONE

}
