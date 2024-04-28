import UIKit

class DiceRollerLogController: UIViewController {
    
    var diceRollerLogView: DiceRollerLogView!
    var diceRollerLogModel: DiceRollerLogModel!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        diceRollerLogView = DiceRollerLogView(frame: self.view.frame)
        self.view.addSubview(diceRollerLogView)
        
        diceRollerLogModel = DiceRollerLogModel()
        
        updateLogScreen()
    }
    
    func addRollToLog(roll: String) {
        diceRollerLogModel.rolls.append(roll)
        updateLogScreen()
    }
    
    private func updateLogScreen() {
        diceRollerLogView.logScreen.text = diceRollerLogModel.rolls.joined(separator: "\n")
    }
}