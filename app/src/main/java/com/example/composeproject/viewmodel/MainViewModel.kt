package com.example.composeproject.viewmodel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.composeproject.util.Utility
import java.util.*
import java.util.concurrent.ThreadLocalRandom
import kotlin.concurrent.fixedRateTimer
import kotlin.time.Duration
import kotlin.time.ExperimentalTime

@ExperimentalTime
class MainViewModel : ViewModel() {

    private var time: Duration = Duration.ZERO

    private lateinit var timer: Timer

    var person by mutableStateOf("Person")
    var Squad by mutableStateOf("Squad")
    var hours by mutableStateOf("00")
    var isPlaying by mutableStateOf(false)
    var isSucceeded by mutableStateOf(false)
    var countNumber by mutableStateOf(0)

    fun start() {
        timer = fixedRateTimer(initialDelay = 0, period = 150L) {
            if(countNumber>5)
            {
                this@MainViewModel.countNumber = 0

            }
            time = time.plus(Duration.seconds(1))
            updateTimeStates()
        }
        isPlaying = true
    }

    private fun updateTimeStates() {
        time.toComponents { hours, minutes, seconds, _ ->
            if (!isPlaying) {
                this@MainViewModel.person = getMember()
                this@MainViewModel.Squad = getSquadName()
                if (Squad.equals(Utility.teamMap[person])) {
                    Log.e(Squad,person+"success")
                    this@MainViewModel.isSucceeded = true

                }
            } else {
                if (seconds == 30) {
                    countNumber = countNumber.plus(1)
                    this@MainViewModel.countNumber = countNumber
                    this@MainViewModel.person = getMember()
                    this@MainViewModel.Squad = getSquadName()
                    Utility.buildTeamMap()
                    if (Squad.equals(Utility.teamMap[person])) {
                        Log.e(Squad,person+"success")
                        this@MainViewModel.isSucceeded = true

                    } else {
                        stop()
                    }

                } else {
                    this@MainViewModel.countNumber = countNumber
                    this@MainViewModel.person = getMember()
                    this@MainViewModel.Squad = getSquadName()
                }

            }

        }
    }

    private fun getSquadName(): String {
        return Utility.squadList.get(ThreadLocalRandom.current().nextInt(0, 7) + 0)
    }

    private fun getMember(): String {
        return Utility.membersList.get(ThreadLocalRandom.current().nextInt(0, 19) + 0)
    }

    private fun Int.pad(): String {
        return this.toString().padStart(2, '0')
    }

    fun pause() {
        timer.cancel()
        isPlaying = false
    }

    fun stop() {
        pause()

        time = Duration.ZERO
        updateTimeStates()
    }
}