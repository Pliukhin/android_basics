package com.skillbox.subject04

class Rocketeer(

    maxHealth: Int = 250,
    evasion: Int = 5,
    accuracy: Int = 20,
    weapon: AbstractWeapon = AbstractWeapon.Weapons.rocketLauncher

): AbstractWarrior(maxHealth, evasion, accuracy, weapon)

