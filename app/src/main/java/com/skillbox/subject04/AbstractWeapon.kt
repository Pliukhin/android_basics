package com.skillbox.subject04

abstract class AbstractWeapon(
    val maxAmmoAmount: Int,
    val fireType: FireType
) {
    val currentAmmoList = mutableListOf<Ammo>()
    var isMagazineEmpty = currentAmmoList.isEmpty()

    abstract fun createAmmo(): Ammo

    fun reload(): List<Ammo> {
        return if (isMagazineEmpty) {
            while (currentAmmoList.size < maxAmmoAmount) {
                currentAmmoList.add(createAmmo())
            }
            isMagazineEmpty = false
            currentAmmoList
        } else {
            currentAmmoList
        }
    }

    fun getAmmoForShot(): List<Ammo> {
        val ammoForShot = mutableListOf<Ammo>()
        val range = 0 until fireType.ammoAmount
        if(currentAmmoList.size > fireType.ammoAmount) {
            for (ammo in range) {
                ammoForShot.add(createAmmo())
                currentAmmoList.removeAt(currentAmmoList.size - 1)
            }
        } else {
            ammoForShot.addAll(currentAmmoList)
            currentAmmoList.clear()
            isMagazineEmpty = true
        }
        return ammoForShot
    }

    object Weapons {
        val gun = object : AbstractWeapon(
            maxAmmoAmount = 10,
            fireType = FireType.SingleShot) {
            override fun createAmmo(): Ammo {
                return Ammo.ORDINARY
            }
        }
        val machineGun =
            object : AbstractWeapon(
                maxAmmoAmount = 10,
                fireType = FireType.BurstShot) {
                override fun createAmmo(): Ammo {
                    return Ammo.ORDINARY
                }
            }
        val shotgun = object : AbstractWeapon(
            maxAmmoAmount = 8,
            fireType = FireType.SingleShot){
            override fun createAmmo(): Ammo {
                return Ammo.ARMORPIERSING
            }
        }
        val rocketLauncher = object : AbstractWeapon(
            maxAmmoAmount = 5,
            fireType = FireType.SingleShot) {
                override fun createAmmo(): Ammo {
                    return Ammo.EXPLOSIVE
                }
            }
    }
}

