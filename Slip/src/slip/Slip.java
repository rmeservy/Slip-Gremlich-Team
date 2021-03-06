/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slip;

import byui.cit260.slip.model.Game;
import byui.cit260.slip.model.Player;
import byui.cit260.slip.view.StartProgramView;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Richard
 */
public class Slip {

    private static Game currentGame = new Game();
    private static Player player = new Player();

    public static PrintWriter outFile = null;
    public static BufferedReader inFile = null;

    private static PrintWriter logFile = null;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

            StartProgramView startProgramView = null;
            
        try {
            //open character stream files for end user input and output
            Slip.inFile = new BufferedReader(new InputStreamReader(System.in));
            Slip.outFile = new PrintWriter(System.out, true);

            //open log file
            String filePath = "log.txt";
            Slip.logFile = new PrintWriter(filePath);

            startProgramView = new StartProgramView();
            startProgramView.display();

         
        } catch (Throwable te) {
            System.out.println(te.getMessage());
            te.printStackTrace();
            startProgramView.display();
        

        }  finally {
            try {
                if (Slip.inFile != null) {
                    Slip.inFile.close();
                }

                if (Slip.outFile != null) {
                    Slip.outFile.close();
                }
                
                if (Slip.logFile != null){
                    Slip.logFile.close();
                }

            } catch (IOException ex) {
                Logger.getLogger(Slip.class.getName()).log(Level.SEVERE, null, ex);

            }

        }

    }

    public static Game getCurrentGame() {
        return currentGame;
    }

    public static void setCurrentGame(Game currentgame) {
        Slip.currentGame = currentgame;
    }

    public static Player getPlayer() {
        return player;
    }

    public static void setPlayer(Player player) {
        Slip.player = player;
    }

    public static PrintWriter getOutFile() {
        return outFile;
    }

    public static void setOutFile(PrintWriter outFile) {
        Slip.outFile = outFile;
    }

    public static BufferedReader getInFile() {
        return inFile;
    }

    public static void setInFile(BufferedReader inFile) {
        Slip.inFile = inFile;
    }

    public static PrintWriter getLogFile() {
        return logFile;
    }

    public static void setLogFile(PrintWriter logFile) {
        Slip.logFile = logFile;
    }

}
