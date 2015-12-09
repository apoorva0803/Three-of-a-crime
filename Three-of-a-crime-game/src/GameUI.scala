
import scala.swing._
import scala.util.Random
import java.awt.Color
import java.awt.Font
import Game._
import scala.swing.event._



/**
 * UI for Game
 * @author apoorva
 */


object GameUI extends SimpleSwingApplication {

	var input1:Int = -1
			var realPerp1:Int = -1
			var realPerp2:Int = -1
			var realPerp3:Int = -1
			var obscurePerp1:Int = -1
			var obscurePerp2:Int = -1
			var obscurePerp3:Int = -1
			var count:Int=0

			def start(){

	var r = new Random()
	realPerp1 = Game.generateRandom(r)  
	realPerp2 = Game.generatePerp2(realPerp1, r)
	realPerp3 = Game.generatePerp3(realPerp1, realPerp2, r)

	obscurePerp1 = Game.generateRandom(r)  
	obscurePerp2 = Game.generatePerp2(obscurePerp1, r)
	obscurePerp3 = Game.generatePerp3(obscurePerp1, obscurePerp2, r)

	count=0;
	if((realPerp1==obscurePerp1 || realPerp1==obscurePerp2 || realPerp1==obscurePerp3 )&&
			(realPerp2==obscurePerp1 || realPerp2==obscurePerp2 || realPerp2==obscurePerp3)&&
			(realPerp3==obscurePerp1 || realPerp3==obscurePerp2 || realPerp3==obscurePerp3)){
		start();
	}else {
		if(realPerp1==obscurePerp1 || realPerp1==obscurePerp2 || realPerp1==obscurePerp3 )
			count += 1
			if(realPerp2==obscurePerp1 || realPerp2==obscurePerp2 || realPerp2==obscurePerp3 )      
				count += 1
				if(realPerp3==obscurePerp1 || realPerp3==obscurePerp2 || realPerp3==obscurePerp3 )      
					count += 1
	}

}

/**
 * Create a frame and add labels to it
 */
def top = new MainFrame {
	title = "3 of a Crime"
			val button = new Button {
		text = "Play!!!"
	}

	val restartButton = new Button {
		text = "Play Next Game"
	}
	start();
	println("Actual Preperators : " + realPerp1 + "  "+realPerp2 +" "+realPerp3)

	var label = new Label {
		text="  "
	} 

	label.peer.setFont(new Font("Arial", 2, 14))
	label.peer.setForeground(Color.RED)
	val labelPlayer1 = new Label {
		text = " Player 1  "
	}


	var spcLbl1:Label = new Label ("   ")
		var spcLbl2:Label = new Label ("   ")
	var criminalsLbl:Label = new Label ("Criminals are 0 1 2 3 4 5 6 7")
		var randomCriminalsLbl:Label = new Label ("Computer Generated criminals " + obscurePerp1+" "+ obscurePerp2 +" "+ obscurePerp3);
	var actualPerpetratorLbl:Label = new Label ("No of actual perpetrators are : " + count)
	var passLbl:Label = new Label ("Press 8 to pass")
	var beginLbl:Label = new Label ("************Game Begins*************")

	criminalsLbl.peer.setFont(new Font("Arial", 0, 12))
	criminalsLbl.peer.setForeground(Color.blue.darker())
	randomCriminalsLbl.peer.setFont(new Font("Arial", 0, 12))
	randomCriminalsLbl.peer.setForeground(Color.blue.darker())
	actualPerpetratorLbl.peer.setFont(new Font("Arial", 0, 12))
	actualPerpetratorLbl.peer.setForeground(Color.blue.darker())
	passLbl.peer.setFont(new Font("Arial", 0, 12))
	passLbl.peer.setForeground(Color.blue.darker())
	beginLbl.peer.setFont(new Font("Arial", 0, 12))
	beginLbl.peer.setForeground(Color.blue.darker())



	val label1 = new Label {
		text = "   "
	}

	val labelPlayer2 = new Label {
		text = " Player 2  "
	}

	val labelPlayer3 = new Label {
		text = " Player 3  "
	}
	val label2 = new Label {
		text = "   "
	}
	object player3a extends TextField { columns = 4 }
	object player3b extends TextField { columns = 4 }

	object player2a extends TextField { columns = 4 }
	object player2b extends TextField { columns = 4 }
	object player1a extends TextField { columns = 4 }
	object player1b extends TextField { columns = 4 }


	contents = new BoxPanel(Orientation.Vertical) {

		contents += label
				contents += criminalsLbl
				contents += randomCriminalsLbl
				contents += actualPerpetratorLbl
				contents += passLbl
				contents += beginLbl
				contents += labelPlayer1
				contents += player1a
				contents += player1b
				if(count<2) player1b.peer.setEnabled(false)
				else player1b.peer.setEnabled(true)
				contents += label1
				contents += labelPlayer2
				contents += player2a
				contents += player2b
				if(count<2) player2b.peer.setEnabled(false)
				else player2b.peer.setEnabled(true)
				contents += label2
				contents += labelPlayer3
				contents += player3a
				contents += player3b
				if(count<2) player3b.peer.setEnabled(false)
				else player3b.peer.setEnabled(true)

				contents += spcLbl1
				contents += button
				contents += spcLbl2
				contents += restartButton

				border = Swing.EmptyBorder(30, 30, 10, 30)
	}


	var input1a:Int = -1
			var input1b:Int = -1
			var input2a:Int = -1
			var input2b:Int = -1
			var input3a:Int = -1
			var input3b:Int = -1

			listenTo(player1a, player1b,player2a, player2b,player3a, player3b)
			reactions += {
			case EditDone(`player1a`) =>
			var inputStr=player1a.text
			if(inputStr!=null || inputStr.length()>0)
				input1a = inputStr.trim().toInt
				else input1a=8
			case EditDone(`player1b`) =>
			var inputStr=player1b.text
			if(inputStr!=null|| inputStr.length()>0)
				input1b = inputStr.trim().toInt
				else input1b=8
			case EditDone(`player2a`) =>
			var inputStr=player2a.text
			if(inputStr!=null || inputStr.length()>0)
				input2a = inputStr.trim().toInt
				else input2a=8
			case EditDone(`player2b`) =>
			var inputStr=player2b.text
			if(inputStr!=null || inputStr.length()>0)
				input2b = inputStr.trim().toInt
				else input2b=8
			case EditDone(`player3a`) =>
			var inputStr=player3a.text
			if(inputStr!=null || inputStr.length()>0)
				input3a = inputStr.trim().toInt
				else input3a=8
			case EditDone(`player3b`) =>
			var inputStr=player3b.text
			if(inputStr!=null || inputStr.length()>0)
				input3b = inputStr.trim().toInt
				else input3b=8          
				}     

		listenTo(button,restartButton)
		reactions += {
		case ButtonClicked(`button`) =>


		if(count==0 ){

			player1a.peer.setText(" ")
			player1b.peer.setText(" ")
			player2a.peer.setText(" ")
			player2b.peer.setText(" ")      
			player3a.peer.setText(" ")
			player3b.peer.setText(" ")

			top.peer.repaint();
			randomCriminalsLbl.text = "Computer Generated criminals " + obscurePerp1+" "+ obscurePerp2 +" "+ obscurePerp3
					actualPerpetratorLbl.text="No of actual perpetrators are : " + count
					label.text=" "
					if(count<2 ){
						player1b.peer.setEnabled(false)
						player2b.peer.setEnabled(false)
						player3b.peer.setEnabled(false)
					}
					else{
						player1b.peer.setEnabled(true)
						player2b.peer.setEnabled(true)
						player3b.peer.setEnabled(true)
					}

		}



		if(count==1 && input1a==8 && input2a==8 && input3a==8){

			player1a.peer.setText(" ")
			player1b.peer.setText(" ")
			player2a.peer.setText(" ")
			player2b.peer.setText(" ")      
			player3a.peer.setText(" ")
			player3b.peer.setText(" ")

			top.peer.repaint();
			randomCriminalsLbl.text = "Computer Generated criminals " + obscurePerp1+" "+ obscurePerp2 +" "+ obscurePerp3
					actualPerpetratorLbl.text="No of actual perpetrators are : " + count
					label.text="  "
					if(count<2 ){
						player1b.peer.setEnabled(false)
						player2b.peer.setEnabled(false)
						player3b.peer.setEnabled(false)
					}
					else{
						player1b.peer.setEnabled(true)
						player2b.peer.setEnabled(true)
						player3b.peer.setEnabled(true)
					}

		}
		if(count==2 && (input1a==8 || input1b==8) && (input2a==8 || input2b==8) && (input3a==8 || input3b==8)){
			player1a.peer.setText(" ")
			player1b.peer.setText(" ")
			player2a.peer.setText(" ")
			player2b.peer.setText(" ")      
			player3a.peer.setText(" ")
			player3b.peer.setText(" ")
			top.peer.repaint();
			label.text="  "
					randomCriminalsLbl.text = "Computer Generated criminals " + obscurePerp1+" "+ obscurePerp2 +" "+ obscurePerp3
					actualPerpetratorLbl.text="No of actual perpetrators are : " + count

					if(count<2 ){
						player1b.peer.setEnabled(false)
						player2b.peer.setEnabled(false)
						player3b.peer.setEnabled(false)
					}
					else{
						player1b.peer.setEnabled(true)
						player2b.peer.setEnabled(true)
						player3b.peer.setEnabled(true)
					}

		}
		var result:String=Game.helperMethod(input1a,input1b,input2a,input2b,input3a,input3b,count)
				label.peer.setText(result);
		label.text=result


		case ButtonClicked(`restartButton`) =>
		player1a.peer.setText(" ")
		player1b.peer.setText(" ")
		player2a.peer.setText(" ")
		player2b.peer.setText(" ")      
		player3a.peer.setText(" ")
		player3b.peer.setText(" ")

		label.text= "  "
		top.peer.repaint();
		randomCriminalsLbl.text = "Computer Generated criminals " + obscurePerp1+" "+ obscurePerp2 +" "+ obscurePerp3
		actualPerpetratorLbl.text="No of actual perpetrators are : " + count

				if(count<2){
					player1b.peer.setEnabled(false)
					player2b.peer.setEnabled(false)
					player3b.peer.setEnabled(false)
				}
		if(count==2){
			player1b.peer.setEnabled(true)
			player2b.peer.setEnabled(true)
			player3b.peer.setEnabled(true)
		}
		label.text="  "
				}
}
}  