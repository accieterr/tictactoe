package com.github.accieterr.tictactoeFX;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.util.Pair;

public class Controller {
	
	@FXML
	private GridPane gPane;
	
	private int turn = 1;
	private Button[][] buttonGrid = new Button[3][3];
	private String[][] symbolGrid = {{" "," "," "},{" "," "," "},{" "," "," "}};
	
	public void initialize()
	{
		for(int i=0;i<3;i++)
			for(int j=0;j<3;j++)
			{
				Button add = new Button();
				add.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
				Pair<Integer,Integer> id = new Pair<Integer,Integer>(i,j);
				
				add.setOnAction(new EventHandler<ActionEvent>() {
					
					@Override
					public void handle(ActionEvent event) {
						performButtonAction(id);
					}
					
				});
				gPane.add(add, j, i);
				buttonGrid[i][j] = add;
			}
	}
	
	private ImageView returnView(boolean isX)
	{
		if(isX)
		{
			ImageView x = new ImageView(new Image("/x.png"));
			x.setFitHeight(75);
		    x.setFitWidth(75);
		    x.setPreserveRatio(true);
		    return x;
		}
		else
		{
			ImageView y = new ImageView(new Image("/circle.png"));
			y.setFitHeight(65);
		    y.setFitWidth(65);
		    y.setPreserveRatio(true);
		    return y;
		}
	}
	
	private void performButtonAction(Pair<Integer,Integer> id)
	{
		if(turn%2==1) buttonGrid[id.getKey()][id.getValue()].setGraphic(returnView(true));
		else buttonGrid[id.getKey()][id.getValue()].setGraphic(returnView(false));
		updateGameLogic(id);
	}
	
	private void updateGameLogic(Pair<Integer,Integer> coords)
	{
		//update symbolGrid and values of turn and coordinates
		int x = coords.getKey();
		int y = coords.getValue();
		if(turn%2==1) symbolGrid[x][y] = "X";
		else symbolGrid[x][y] = "O";
		turn++;
		
		
		
	}
	
}
