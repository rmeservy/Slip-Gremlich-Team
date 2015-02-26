/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.slip.control;

import byui.cit260.slip.view.AttackMenuView;
/**
 *
 * @author Andrew
 */
public class FactorControl {
    
    public double calcAttackingPower (int energyLevel, int toolPower) {
        
        //Check if any input is 0
        if (energyLevel == 0 || toolPower == 0) {
            return 0;
        }
        
        //Check for the boundaries of the function
        if (energyLevel<0 || 10<energyLevel){
            return -1;
        }
        
        if (toolPower<0 || 8<toolPower){
            return -1;
        }
        
        //Check for an integer number.
        if (energyLevel%1 != 0 && toolPower%1 != 0) {
            return -1;
        }
        
        //Calculate attacking power and return value;
        else {
        int attackingPower = energyLevel + toolPower;
        return attackingPower;
                }

    }
    
}
