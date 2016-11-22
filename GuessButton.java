import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import javax.swing.JOptionPane;
/**
 * Write a description of class GuessButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GuessButton extends Actor
{
    /**
     * Constructor for objects of class LessThanButton
     */
    public GuessButton()
    {
        GreenfootImage image = new GreenfootImage("guess.png");
        image.scale(90,90);
        setImage(image);
    }

    public void act()
    {
      MouseInfo mouseInfo = Greenfoot.getMouseInfo();
      if(Greenfoot.mouseClicked(this)){
          if(getWorldOfType(GamePlayWorld.class).backgroundMusic!=null){
              getWorldOfType(GamePlayWorld.class).backgroundMusic.stop();
            }
          Greenfoot.playSound("button_click.mp3");
          getWorldOfType(GamePlayWorld.class).operator="guess";
          GameEngine gameEngine = getWorldOfType(GamePlayWorld.class).gameEngine;
          gameEngine.enterendInput = getWorldOfType(GamePlayWorld.class).enteredNumber;
          gameEngine.computerGuess = getWorldOfType(GamePlayWorld.class).computerGuess;
          gameEngine.computerGuess = getWorldOfType(GamePlayWorld.class).computerGuess;
          if(gameEngine.enterendInput <1 )
            JOptionPane.showMessageDialog(null, "Please Enter a number to guess");
          else if(gameEngine.enterendInput==gameEngine.computerGuess){
            Message sampleMessage = new Message();
            Greenfoot.playSound("congratulations.mp3");
            sampleMessage.setText("Cogratulations!!!!.Your Guess is Right");
            getWorld().addObject(sampleMessage, 300, 300);
          }
          else{
              
            Message sampleMessage = new Message();
            sampleMessage.setText("Sorry. Your guess is wrong");
            getWorld().addObject(sampleMessage, 300, 300);
            Greenfoot.delay(50);
            getWorld().removeObject(sampleMessage);
            Greenfoot.setWorld(new GameOver());
            
            
          }
          LabelBox box = getWorldOfType(GamePlayWorld.class).getObjects(LabelBox.class).get(0);
          box.updateImage("");
        }   
    }  
}
