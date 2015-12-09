
import scala.util.Random
import GameUI._
/**
 * Algo
 * 1. Generate actual criminals
 * 2. Generate random criminals
 * 3. If no of perpetrator is one : user will give one input
 * 4. If no of perpetrator are two : user will give two input
 * 5. Check with the real criminals and give the winner
 * @author apoorva
 */
object Game {
  
  /**
   * Matches the number of perpetrators  
   */
  def helperMethod(input1a:Int, input1b:Int, input2a:Int, input2b:Int, input3a:Int, input3b:Int , count:Int):String={


      var result:String = "   "
          count match{
          case 1=>  var player1Won:Boolean = playerOutputForOne(GameUI.realPerp1, GameUI.realPerp2, GameUI.realPerp3 ,"Player 1",input1a)
              if(player1Won) result ="Player 1 WINS!!!!!!!!!!";
              else{
                var player2Won:Boolean = playerOutputForOne(GameUI.realPerp1, GameUI.realPerp2, GameUI.realPerp3 ,"Player 2",input2a)
                    if(player2Won) result ="Player 2 WINS!!!!!!!!!!"
                    else{
                      var player3Won:Boolean = playerOutputForOne(GameUI.realPerp1, GameUI.realPerp2, GameUI.realPerp3 ,"Player 3",input3a)
                          if(player3Won) result= "Player 3 WINS!!!!!!!!!!"
                          else result= "Tie"

                    }
              }
          case 2=>  var player1Won:Boolean = playerOutputForTwo(GameUI.realPerp1, GameUI.realPerp2, GameUI.realPerp3 ,"Player 1",input1a,input1b) 
              if(player1Won) result ="Player 1 WINS!!!!!!!!!!";
              else{
                var player2Won:Boolean = playerOutputForTwo(GameUI.realPerp1, GameUI.realPerp2, GameUI.realPerp3 ,"Player 2",input2a,input2b)
                    if(player2Won) result ="Player 2 WINS!!!!!!!!!!"
                    else{
                      var player3Won:Boolean = playerOutputForTwo(GameUI.realPerp1, GameUI.realPerp2, GameUI.realPerp3 ,"Player 3",input3a,input3b)
                          if(player3Won) result= "Player 3 WINS!!!!!!!!!!"
                          else result ="Tie"

                    }
              }
          case _=> GameUI.start();
  }  
  return result
  }

/**
 * For one perpetrator
 */
  def playerOutputForOne(realPerp1:Int, realPerp2:Int, realPerp3:Int , playerNumber:String,player:Int):Boolean ={
      var isWon:Boolean = false;

  if(player != 8 && (player==realPerp1 || player==realPerp2 || player==realPerp3) ){
    isWon = true
        println(playerNumber + " WINS!!!!!!!!!!!!!!!!!!")
  }
  return isWon
  }

/**
 * For two perpetrator
 */
  def playerOutputForTwo(realPerp1:Int, realPerp2:Int, realPerp3:Int , playerNumber:String,input1:Int,input2:Int):Boolean ={
      var isWon:Boolean = false;

  if((input1 != 8 && input2!=8) && (input1==realPerp1 || input1==realPerp2 || input1==realPerp3 ) 
      && (input2==realPerp1 || input2==realPerp2 || input2==realPerp3)){
    isWon = true
        println(playerNumber + " WINS!!!!!!!!!!!!!!!!!!")
  }
  return isWon
  }

/**
 * Generate random number
 */
  def generateRandom(input:Random) : Int ={
      return input.nextInt(8);
  }

  
  def generatePerp2(perp1:Int , rand:Random) : Int ={

      var perp2:Int = generateRandom(rand)
          while(perp1==perp2){
            perp2 = generateRandom(rand)
          } 
  return perp2;
  }

  def generatePerp3(perp1:Int , perp2:Int, rand:Random) : Int ={
      var perp3:Int = generateRandom(rand)
          while(perp3==perp2 || perp3==perp1){
            perp3 = generateRandom(rand)
          }
  return perp3
  }
}