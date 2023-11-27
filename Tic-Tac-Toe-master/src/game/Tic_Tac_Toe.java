
package game;

import game.type.pieces;
public class Tic_Tac_Toe {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        board Board = new board(3,3);
        player player1 = new player(pieces.O);
        player player2 = new player(pieces.X);
        
        
        game_engine engine = new game_engine(Board,player1,player2);
        
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Gui_Main_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Gui_Main_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Gui_Main_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Gui_Main_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        Gui_game_play GamePlay = new Gui_game_play(engine);
     
    }
    
}
