package com.skillbox.subject04

interface Warrior {

    val isKilled: Boolean
    val evasion: Int
    val currentHealth: Int

    fun attack(warrior: Warrior): Int
    fun getDamage(damage: Int): Int
}