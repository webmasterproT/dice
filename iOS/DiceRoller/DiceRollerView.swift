import UIKit

class DiceRollerView: UIView {
    
    let diceNumber: UITextField = {
        let textField = UITextField()
        textField.text = "1"
        textField.keyboardType = .numberPad
        textField.textAlignment = .center
        textField.backgroundColor = .white
        textField.layer.cornerRadius = 5
        return textField
    }()
    
    let diceType: UIPickerView = {
        let picker = UIPickerView()
        let diceTypes = ["d2", "d3", "d4", "d6", "d8", "d10", "d12", "d20", "d100"]
        picker.dataSource = diceTypes
        picker.selectRow(3, inComponent: 0, animated: false)
        return picker
    }()
    
    let modifier: UISegmentedControl = {
        let items = ["+", "-"]
        let segmentedControl = UISegmentedControl(items: items)
        segmentedControl.selectedSegmentIndex = 0
        return segmentedControl
    }()
    
    let rollButton: UIButton = {
        let button = UIButton()
        button.setTitle("Roll", for: .normal)
        button.backgroundColor = .darkGray
        button.layer.cornerRadius = 5
        return button
    }()
    
    override init(frame: CGRect) {
        super.init(frame: frame)
        setupViews()
    }
    
    required init?(coder: NSCoder) {
        fatalError("init(coder:) has not been implemented")
    }
    
    private func setupViews() {
        addSubview(diceNumber)
        addSubview(diceType)
        addSubview(modifier)
        addSubview(rollButton)
        
        // Add constraints here
    }
}