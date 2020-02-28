package com.skillbox.subject04
import kotlin.random.Random

class Team (warriorsAmount: Int = readLine()!!.toInt()) {

   var warriorsList: ArrayList<Warrior> = arrayListOf()

    init {
        createTeam(warriorsAmount)
    }

    private fun createTeam(warriorsAmount: Int): ArrayList<Warrior> {
        val range = 0 until warriorsAmount
        for (warriors in range) {
            when {
                Random.nextInt(0,10) == 4 -> warriorsList.add(Soldier())
                Random.nextInt(0,5) == 1 -> warriorsList.add(Officer())
                Random.nextInt(0,3) == 2 -> warriorsList.add(MachineGunner())
                else -> warriorsList.add(Rocketeer())
            }
        }
        return warriorsList
    }


}


