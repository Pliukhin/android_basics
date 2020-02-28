package com.skillbox.subject04

class MachineGunner(
    maxHealth: Int = 200,
    evasion: Int = 10,
    accuracy: Int = 15,
    weapon: AbstractWeapon = AbstractWeapon.Weapons.machineGun

): AbstractWarrior(maxHealth, evasion, accuracy, weapon)

