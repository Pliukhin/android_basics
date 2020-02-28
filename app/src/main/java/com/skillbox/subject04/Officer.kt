package com.skillbox.subject04

class Officer(

    maxHealth: Int = 150,
    evasion: Int = 15,
    accuracy: Int = 10,
    weapon: AbstractWeapon = AbstractWeapon.Weapons.shotgun

): AbstractWarrior(maxHealth, evasion, accuracy, weapon)
