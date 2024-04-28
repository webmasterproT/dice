import UIKit

class DiceRollerCell: UITableViewCell {
    
    var diceRollerModel: DiceRollerModel!
    
    let diceNumberLabel: UILabel = {
        let label = UILabel()
        label.translatesAutoresizingMaskIntoConstraints = false
        return label
    }()
    
    let diceTypeLabel: UILabel = {
        let label = UILabel()
        label.translatesAutoresizingMaskIntoConstraints = false
        return label
    }()
    
    let modifierLabel: UILabel = {
        let label = UILabel()
        label.translatesAutoresizingMaskIntoConstraints = false
        return label
    }()
    
    override init(style: UITableViewCell.CellStyle, reuseIdentifier: String?) {
        super.init(style: style, reuseIdentifier: reuseIdentifier)
        
        addSubview(diceNumberLabel)
        addSubview(diceTypeLabel)
        addSubview(modifierLabel)
        
        setupConstraints()
    }
    
    required init?(coder: NSCoder) {
        fatalError("init(coder:) has not been implemented")
    }
    
    func setupConstraints() {
        diceNumberLabel.centerYAnchor.constraint(equalTo: centerYAnchor).isActive = true
        diceNumberLabel.leadingAnchor.constraint(equalTo: leadingAnchor, constant: 12).isActive = true
        
        diceTypeLabel.centerYAnchor.constraint(equalTo: centerYAnchor).isActive = true
        diceTypeLabel.leadingAnchor.constraint(equalTo: diceNumberLabel.trailingAnchor, constant: 12).isActive = true
        
        modifierLabel.centerYAnchor.constraint(equalTo: centerYAnchor).isActive = true
        modifierLabel.leadingAnchor.constraint(equalTo: diceTypeLabel.trailingAnchor, constant: 12).isActive = true
    }
    
    func configureCell(with model: DiceRollerModel) {
        self.diceRollerModel = model
        diceNumberLabel.text = "Number of dice: \(model.numberOfDice)"
        diceTypeLabel.text = "Type of dice: \(model.typeOfDice)"
        modifierLabel.text = "Modifier: \(model.modifier)"
    }
    
    func rollDice() -> Int {
        let rollResult = diceRollerModel.rollDice()
        return rollResult
    }
}