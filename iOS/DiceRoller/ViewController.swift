import UIKit

class ViewController: UIViewController {

    var diceRoller: DiceRollerController!
    var logScreen: DiceRollerLogController!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        setupDiceRoller()
        setupLogScreen()
    }
    
    func setupDiceRoller() {
        diceRoller = DiceRollerController()
        diceRoller.view.frame = self.view.bounds
        self.view.addSubview(diceRoller.view)
        self.addChild(diceRoller)
        diceRoller.didMove(toParent: self)
    }
    
    func setupLogScreen() {
        logScreen = DiceRollerLogController()
        logScreen.view.frame = self.view.bounds
        self.view.addSubview(logScreen.view)
        self.addChild(logScreen)
        logScreen.didMove(toParent: self)
        logScreen.view.isHidden = true
    }
    
    @objc func swipeGesture(gesture: UISwipeGestureRecognizer) {
        if gesture.direction == .left {
            logScreen.view.isHidden = false
            diceRoller.view.isHidden = true
        } else if gesture.direction == .right {
            logScreen.view.isHidden = true
            diceRoller.view.isHidden = false
        }
    }
    
    override func viewWillAppear(_ animated: Bool) {
        super.viewWillAppear(animated)
        let swipeLeft = UISwipeGestureRecognizer(target: self, action: #selector(swipeGesture))
        swipeLeft.direction = .left
        self.view.addGestureRecognizer(swipeLeft)
        
        let swipeRight = UISwipeGestureRecognizer(target: self, action: #selector(swipeGesture))
        swipeRight.direction = .right
        self.view.addGestureRecognizer(swipeRight)
    }
}