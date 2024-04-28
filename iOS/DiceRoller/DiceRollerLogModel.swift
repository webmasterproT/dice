import Foundation

class DiceRollerLogModel {
    var rolls: [String] = []
    
    func addRollToLog(roll: String) {
        rolls.append(roll)
    }
    
    func getRolls() -> [String] {
        return rolls
    }
    
    func clearLog() {
        rolls.removeAll()
    }
}