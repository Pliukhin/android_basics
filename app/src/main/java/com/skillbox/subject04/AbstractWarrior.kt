
package com.skillbox.subject04

import kotlin.random.Random

abstract class AbstractWarrior(

    maxHealth: Int,
    override val evasion: Int,
    private val accuracy: Int,
    private val weapon: AbstractWeapon

): Warrior {

    override var currentHealth = maxHealth
    override var isKilled: Boolean = false

    override fun attack(warrior: Warrior): Int{
        var damage = 0
        if(currentHealth == 0){
            return damage //мертвый не может атаковать
        }
        if(weapon.currentAmmoList.isEmpty()){
          weapon.reload()
        } else if (Random.nextInt(0, warrior.evasion) < Random.nextInt(0, accuracy)){
            val ammoForShot = weapon.getAmmoForShot()
            for (ammo in ammoForShot) {
                damage += currentDamageCounter(ammo)
            }
            return damage
        }
        return damage
    }

    override fun getDamage(damage: Int): Int {
        if (currentHealth <= damage) {
            currentHealth = 0
            isKilled = true
        } else {
            currentHealth -= damage
            return currentHealth
        }
        return currentHealth
    }
}


