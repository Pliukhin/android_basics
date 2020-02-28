package com.skillbox.subject04

sealed class BattleState() {

  class CurrentStatus(private val team: Team) :
          BattleState(){
      val health: Int

      get(){
          var tempHealth = 0
          team.warriorsList.forEach{
              tempHealth += it.currentHealth}
              return tempHealth
          }
      }


    object FirstTeamWin: BattleState(){
        fun printWinner(){
            println("Победила первая команда")
        }
    }
    object SecondTeamWin: BattleState(){
        fun printWinner(){
            println("Победила вторая команда")
        }

    }

    object Draw : BattleState(){
        fun printWinner(){
            println("Ничья")
        }
    }

}







