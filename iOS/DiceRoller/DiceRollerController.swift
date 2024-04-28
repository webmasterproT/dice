import UIKit

class DiceRollerController: UIViewController {

    var diceRollerModel: DiceRollerModel!
    var diceRollerView: DiceRollerView!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        diceRollerModel = DiceRollerModel()
        diceRollerView = DiceRollerView()
        
        diceRollerView.diceNumber.addTarget(self, action: #selector(updateDiceNumber), for: .editingChanged)
        diceRollerView.diceType.addTarget(self, action: #selector(updateDiceType), for: .valueChanged)
        diceRollerView.modifier.addTarget(self, action: #selector(updateModifier), for: .valueChanged)
    }
    
    @objc func updateDiceNumber(_ textField: UITextField) {
        if let number = Int(textField.text ?? "1") {
            diceRollerModel.numberOfDice = number
        }
    }
    
    @objc func updateDiceType(_ picker: UIPickerView) {
        let selectedType = picker.selectedRow(inComponent: 0)
        diceRollerModel.typeOfDice = DiceType(rawValue: selectedType) ?? .d6
    }
    
    @objc func updateModifier(_ picker: UIPickerView) {
        let selectedModifier = picker.selectedRow(inComponent: 0)
        diceRollerModel.modifier = Modifier(rawValue: selectedModifier) ?? .plus
    }
    
    func rollDice() {
        let result = diceRollerModel.rollDice()
        diceRollerView.updateResult(result: result)
    }
}