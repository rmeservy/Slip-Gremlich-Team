/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.slip.view;

import byui.cit260.slip.control.FactorControl;
import byui.cit260.slip.control.GameControl;
import byui.cit260.slip.model.Actor;
import byui.cit260.slip.model.Location;
import byui.cit260.slip.model.Map;
import slip.Slip;

/**
 *
 * @author Richard
 */
public class GameMenuView extends View {

    public GameMenuView() {
        super("\n"
                + "\n -------------------------------"
                + "\n *****   Game Menu  *******"
                + "\n--------------------------------"
                + "\nM - Display Map"
                + "\nV - View Mountain"
                + "\nA - View Characters"
                + "\nQ - Resume Game"
                + "\nR - Save Game"
                + "\n"
                + "\nT  - Inventory Menu"
                + "\nW  - Move Menu"
                + "\n"
                + "\nY - Attack Menu"
                + "\nI - Health Menu"
                + "\n"
                + "\nH - Average health of ALL characters"
                + "\n"
                + "\nQ - Quit to Previous Menu"
                + "\n--------------------------------");
    }

    public GameMenuView(String promptMessage) {
        super(promptMessage);
    }

    @Override
    public boolean doAction(Object obj) {
        char selection = ((String) obj).toLowerCase().charAt(0);
        switch (selection) {
            case 'm': //display map
                this.displayMap();
                break;
            case 'v': //display map
                this.viewMountain();
                break;
            case 'a'://view actors
                this.viewActors();
                break;
            case 't'://view inventory menu
                this.seeInventory();
                break;
            case 'r': // save game
                this.saveGame();
                break;
            case 'y'://view sled
                this.viewAttackMenu();
                break;
            case 'w': // Player Menu
                this.seeMove();
                break;
            case 'i': // Player Menu
                this.seeHealthMenu();
                break;
            case 'q': //return to main menu
                return true;
            case 'h'://view average health of all players.
                this.viewAverageHealth();
                break;
            default:
                ErrorView.display(this.getClass().getName(),
                        "\n*** Invalid Selection *** Please Try again");
                return false;
        }
        return false;
    }

    private void viewActors() {

        // Get a list of the actors in the game.
        Actor[] ActorList = GameControl.getSortedActorList();

        //this.console.println(sortedActorList);
        this.console.println("\nList of Characters");
        this.console.println("Name" + "\t"
                + "Description of " + "\t");

        //for each character in the Game
        for (Actor actor : ActorList) {

            //Display the description, of each of the actors
            this.console.println(actor.name() + "\t    "
                    + actor.getDescription());

            }
    }

    private Location[][] displayMap() {
        Map map = Slip.getCurrentGame().getMap();
        Location[][] locations = map.getLocations();
        this.console.println("Slip Map of Mt. McKinley");
        this.console.println("\n     1 ,  2 ,  3 ,  4 ,  5 ,  6 ,  7 ,  8 ,  9 ,  10");
        this.console.println("****************************************************");

        for (int i = 0; i < map.getNoOfRows(); i++) {
            this.console.print(i + " | ");
            for (int j = 0; j < map.getNoOfColumns(); j++) {
                Location location = locations[i][j];
                String symbol = location.getScene().getMapSymbol();
                if (location.isVisited()) {
                    this.console.print(symbol + "|");
                } else {
                    this.console.print("??" + "|");
                }

            }

            this.console.println("\n****************************************************");
        }

        return locations;
    }

    private void viewAverageHealth() {
        this.console.println("The average health of all players is " + FactorControl.calculateAverageHealth());
    }

    private void seeInventory() {
        InventoryMenuView inventoryMenu = new InventoryMenuView();
        inventoryMenu.display();
    }

    private void viewAttackMenu() {
        AttackMenuView attackMenu = new AttackMenuView();
        attackMenu.display();
    }

    private void seeMove() {
        MoveView moveView = new MoveView();
        moveView.display();
    }

    private void seeHealthMenu() {
        HealthView healthMenu = new HealthView();
        healthMenu.display();
    }

    private void viewMountain() {
        MountainView mountainView = new MountainView();
        mountainView.display();
    }

    private void saveGame() {
        this.console.println("\n\nEnter the file path for where the game is to be saved");
        String filepath = this.getInput();

        try {
            //save the game to the specified file
            GameControl.saveGame(Slip.getCurrentGame(), filepath);
        } catch (Exception ex) {
            ErrorView.display("GameMenuView", ex.getMessage());
        }
    }

}
