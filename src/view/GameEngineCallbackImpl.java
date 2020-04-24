package view;

import java.util.logging.Level;
import java.util.logging.Logger;

import model.interfaces.DicePair;
import model.interfaces.Die;
import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.interfaces.GameEngineCallback;

/**
 * 
 * Skeleton example implementation of GameEngineCallback showing Java logging behaviour
 * 
 * @author Caspar Ryan
 * @see view.interfaces.GameEngineCallback
 * 
 */
public class GameEngineCallbackImpl implements GameEngineCallback
{
   private static final Logger logger = Logger.getLogger(GameEngineCallback.class.getName());

   public GameEngineCallbackImpl()
   {
      // FINE shows rolling output, INFO only shows result
      logger.setLevel(Level.FINE);
   }

   @Override
   public void playerDieUpdate(Player player, Die die, GameEngine gameEngine)
   {
      // intermediate results logged at Level.FINE
//      logger.log(Level.FINE, "Intermediate data to log .. String.format() is good here!");
      // TODO: complete this method to log results
	   logger.log(Level.FINE, String.format("%s, %s", player, die));
   }

   @Override
   public void playerResult(Player player, DicePair result, GameEngine gameEngine)
   {
      // final results logged at Level.INFO
//      logger.log(Level.INFO, "Result data to log .. String.format() is good here!");
      // TODO: complete this method to log results
	  logger.log(Level.INFO, String.format("%s, %s", player, result));
	      
   }


   // TODO implement rest of interface
   @Override
   public void houseDieUpdate(Die die, GameEngine gameEngine) {
	   logger.log(Level.INFO, String.format("House Die %s", die));
   }
   
   @Override
   public void houseResult(DicePair result, GameEngine gameEngine) {
	   logger.log(Level.INFO, String.format("House Result %s", result));
   }
}
