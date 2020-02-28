package com.skillbox.subject04

class Battle {

    private val teamOne = Team()
    private val teamTwo = Team(teamOne.warriorsList.size)


    var teamOneCurrentHealth = BattleState.CurrentStatus(teamOne).health
    var teamTwoCurrentHealth = BattleState.CurrentStatus(teamTwo).health

    private fun teamAttack(warrior1: Warrior, warrior2: Warrior): Int {
        return warrior1.attack(warrior2)
    }

    fun fight() {
        while (teamTwoCurrentHealth > 0 || teamOneCurrentHealth > 0) {

            val range = 0 until teamOne.warriorsList.size

            for (warriors in range) {

                teamOneCurrentHealth -= teamAttack(teamTwo.warriorsList[warriors],
                    teamOne.warriorsList[warriors])
                teamTwoCurrentHealth -= teamAttack(teamOne.warriorsList[0],
                    teamTwo.warriorsList[warriors])

            }

            teamOne.warriorsList.shuffle()
            teamTwo.warriorsList.shuffle()

            if (teamTwoCurrentHealth < teamAttack(teamOne.warriorsList[0],
                    teamTwo.warriorsList[0])) {
                teamTwoCurrentHealth = 0
            }

            if (teamOneCurrentHealth < teamAttack(teamTwo.warriorsList[0],
                    teamOne.warriorsList[0])) {
                teamOneCurrentHealth = 0
            }


            println("First team health: $teamOneCurrentHealth  " +
                    "Second team health $teamTwoCurrentHealth")


            if (teamTwoCurrentHealth <= 0 && teamOneCurrentHealth > 0) {
                BattleState.FirstTeamWin.printWinner()
                break
            }

            if (teamOneCurrentHealth <= 0 && teamTwoCurrentHealth > 0) {
                BattleState.SecondTeamWin.printWinner()
                break
            }

            if (teamOneCurrentHealth == 0 && teamTwoCurrentHealth == 0){
                BattleState.Draw.printWinner()
                break
            }
        }
    }
}

