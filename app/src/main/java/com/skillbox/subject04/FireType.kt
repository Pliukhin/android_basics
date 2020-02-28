package com.skillbox.subject04

sealed class FireType (
    val ammoAmount: Int
) {
   object SingleShot: FireType(ammoAmount = 1)
   object BurstShot: FireType(ammoAmount = 4)
}
