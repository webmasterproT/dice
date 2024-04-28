import Foundation

class DiceRollerModel {
    var numberOfDice: Int
    var typeOfDice: String
    var modifier: String

    init() {
        self.numberOfDice = 1
        self.typeOfDice = "d6"
        self.modifier = "+"
    }

    func setNumberOfDice(number: Int) {
        if number >= 1 && number <= 99 {
            self.numberOfDice = number
        }
    }

    func setTypeOfDice(type: String) {
        let diceTypes = ["d2", "d3", "d4", "d6", "d8", "d10", "d12", "d20", "d100"]
        if diceTypes.contains(type) {
            self.typeOfDice = type
        }
    }

    func setModifier(modifier: String) {
        if modifier == "+" || modifier == "-" {
            self.modifier = modifier
        }
    }
}