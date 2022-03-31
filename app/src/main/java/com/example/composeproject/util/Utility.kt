package com.example.composeproject.util

import java.util.concurrent.TimeUnit

object Utility {
    //time to countdown - 1hr - 60secs
    const val TIME_COUNTDOWN: Long = 60000L
    private const val TIME_FORMAT = "%02d:%02d"


    //convert time to milli seconds
    fun Long.formatTime(): String = String.format(
        TIME_FORMAT,
        TimeUnit.MILLISECONDS.toMinutes(this),
        TimeUnit.MILLISECONDS.toSeconds(this) % 60
    )

     val squadList = listOf(
        "Nucleus", "Sigma", "Qubit", "Electrons", "Momentum", "Photon", "Quantum",
        "Delta"
    )

     val membersList = listOf(
        "Omar", "Prashant", "Sanchit", "Sanjeev", "Ankit", "Abhishek", "Faheem",
        "Ankit Raj", "Sakshi Pruthi", "Aditya Mathur", "Moghira", "Abhilash",
        "Gauri Advani", "Gunjit", "Nitin Bhatia",
        "Vaibhav", "Vatsal", "Yogesh", "Ricky", "Tushar"
    )

     val teamMap = HashMap<String, String>()
    fun buildTeamMap(){
        teamMap.apply {
            this["Omar"] = "Sigma"
            this["Prashant"] = "Nucleus"
            this["Sanchit"] = "Qubit"
            this["Sanjeev"] = "Electrons"
            this["Ankit"] = "Sigma"
            this["Abhishek"] = "Photon"
            this["Faheem"] = "Photon"
            this["Ankit Raj"] = "Momentum"
            this["Sakshi Pruthi"] = "Qubit"
            this["Aditya Mathur"] = "Nucleus"
            this["Moghira"] = "Momentum"
            this["Abhilash"] = "Delta"
            this["Gauri Advani"] = "Quantum"
            this["Gunjit"] = "Nucleus"
            this["Nitin Bhatia"] = "Nucleus"
            this["Vaibhav"] = "Sigma"
            this["Yogesh"] = "Qubit"
            this["Ricky"] = "Nucleus"
            this["Tushar"] = "Sigma"
        }
    }
}