package com.skillbox.subject04

import com.skillbox.subject04.AbstractWeapon.Weapons.gun

class Soldier(

    maxHealth: Int = 100,
    evasion: Int = 20,
    accuracy: Int = 5,
    weapon: AbstractWeapon = gun

): AbstractWarrior(maxHealth,  evasion, accuracy, weapon)







