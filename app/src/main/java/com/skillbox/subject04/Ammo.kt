package com.skillbox.subject04
import kotlin.random.Random

enum class Ammo(
    val damage: Int,
    val criticalHitChance: Int,
    val criticalHitCoeff: Int
) {
    ORDINARY(damage = 10, criticalHitChance = 3, criticalHitCoeff = 2),
    ARMORPIERSING(damage = 15, criticalHitChance = 2, criticalHitCoeff = 3),
    EXPLOSIVE(damage = 20, criticalHitChance = 1, criticalHitCoeff = 4)
}

fun currentDamageCounter(ammo: Ammo): Int {
    return if (ammo.criticalHitChance == Random.nextInt(0, 5)) {
        ammo.damage * ammo.criticalHitCoeff
    } else {
        ammo.damage
    }
}
