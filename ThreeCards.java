package application;

/**
 * Program: Programming Exercise_8_Ex3 
 * File: ThreeCards.java
 * Summary: This is programming exercise 14.3 from the textbook. 
 * 			It displays 3 cards randomly selected from a deck of 52.
 * Author: Erica Morgan
 * Date: 4/5/2018 
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

// Extend Application class
public class ThreeCards extends Application {
	// Create ArrayList
	static ArrayList<Integer> cardList = new ArrayList<>();
	static int[] threeNumbers = new int[3];
	
	public static void main(String[] args) {
		numbers();
		Collections.shuffle(cardList);
		randomThree(threeNumbers);
		Application.launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) {
		//create the pane with padding between nodes
		HBox pane = new HBox(5);
		//pad pane's outside borders
		pane.setPadding(new Insets(5,5,5,5));
		//center the pane
		pane.setAlignment(Pos.CENTER);
		
		//use the ArrayList to pull in the card images
		for(int i = 0; i < threeNumbers.length; i++) {
			Image card = new Image("image/card/" + (threeNumbers[i]) + ".png");
			pane.getChildren().add(new ImageView(card));
		}
		//set and show the scene
		Scene scene = new Scene(pane);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Exercise 14.3");
		primaryStage.show();
	}
	
	public static void randomThree(int[] threeNumbers) {
		//randomize selection
		Random random = new Random();
		int num;
		int index = 0;
		//out of the max 52 cards, when the number is more than 49, remove a number so you end with 3.
		for (int i = 52; i > 49; i--) {
			num = random.nextInt(i);
			threeNumbers[index] = cardList.get(num);
			cardList.remove(num);
			index++;
		}
	}
	//make the total card list equal 52
	public static void numbers() {
		for (int i = 1; i < 52; i++) {
			cardList.add(i);
		}
	}
	
}
