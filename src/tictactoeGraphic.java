import javafx.application.Application;
import java.util.Random;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import testttiing.clickCircle.clickEventHandler;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import java.util.ArrayList;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.ToggleGroup;
import javafx.animation.AnimationTimer;
import javafx.scene.input.MouseEvent;
public class tictactoeGraphic extends Application {
	Block block;
	int turn=0;
	Pane root;
	ArrayList<Block> blocklist = new ArrayList<Block>(){};
//	,block2,block3,block4,block5,block6,block7,block8,block9;

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
	     
//	      block1 = new Rectangle(0,0,80,80);
//	      block2 = new Rectangle(0,0,80,80);
//	      block3 = new Rectangle(0,0,80,80);
//	      block4 = new Rectangle(0,0,80,80);
//	      block5 = new Rectangle(0,0,80,80);
//	      block6 = new Rectangle(0,0,80,80);
//	      block7 = new Rectangle(0,0,80,80);
//	      block8 = new Rectangle(0,0,80,80);
//	      block9 = new Rectangle(0,0,80,80);
//	      block10 = new Rectangle(0,0,80,80);
//	      block11= new Rectangle(0,0,80,80);
//	      block12= new Rectangle(0,0,80,80);
//	      block13= new Rectangle(0,0,80,80);
//	      block14= new Rectangle(0,0,80,80);
//	      block15= new Rectangle(0,0,80,80);
//	      block16= new Rectangle(0,0,80,80);
//	      block17= new Rectangle(0,0,80,80);
//	      block18= new Rectangle(0,0,80,80);
//	      block19= new Rectangle(0,0,80,80);
//	      block20= new Rectangle(0,0,80,80);  
//	      block21= new Rectangle(0,0,80,80);
//	      block22= new Rectangle(0,0,80,80);
//	      block23= new Rectangle(0,0,80,80);
//	      block24= new Rectangle(0,0,80,80);
//	      System.out.println("fd");
		     root = new Pane();
		     VBox column = new VBox(5);
	     for (int x = 0 ; x < 3 ; x++) {
	    	 HBox row = new HBox(7);
	    	 for (int y = 0 ; y < 3 ; y++) {
	    	     block = new Block(300,300);
	    	     eachBlockEventHandler med = new eachBlockEventHandler();
	    	     block.setOnMouseClicked(med);
	    		 row.getChildren().add(block);
	    		 blocklist.add(block);
	    		 
	    	 }   
	    	 column.getChildren().add(row);
	     }
	     root.getChildren().add(column);

		 Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("TicTacToe");
		primaryStage.show();
	}
	
    private class eachBlockEventHandler implements EventHandler<MouseEvent>{
        @Override
		public void handle(MouseEvent o) {
        	 Block block =(Block) o.getSource();
        	turn++;
        	if(turn%2==1) {
	       
	          block.setBlockText("X");
	       }
        	else {
        		 block.setBlockText("O");
        	}
        	block.setDisable(true);
        	o.consume();
        	System.out.println(blocklist.get(2).getBlockText());
	
		 boolean check = false;
         
		 for ( int y = 0 , x = 0  ; y < 9  ; y+=3,x++) {
               if(blocklist.get(y).getBlockText().equalsIgnoreCase("X")&&
                  blocklist.get(y+1).getBlockText().equalsIgnoreCase("X")  &&
                  blocklist.get(y+2).getBlockText().equalsIgnoreCase("X")) {
                        check = true;
                        Line line = new Line(0,150+(x*300),900,150+(x*300));
                        line.setStroke(Color.WHITE);
                        line.setStrokeWidth(15);
                        root.getChildren().add(line);}}
		  for ( int  x = 0  ; x < 3  ; x++) {
                if(blocklist.get(x).getBlockText().equalsIgnoreCase("X")&&
                       blocklist.get(x+3).getBlockText().equalsIgnoreCase("X")  &&
                       blocklist.get(x+6).getBlockText().equalsIgnoreCase("X")) {
                         check = true;	 
                         Line line = new Line(150+(x*300),0,150+(x*300),900);
                         line.setStroke(Color.WHITE);
                         line.setStrokeWidth(15);
                         root.getChildren().add(line);
               
               }}  	 
               if(blocklist.get(0).getBlockText().equalsIgnoreCase("X")&&
                       blocklist.get(4).getBlockText().equalsIgnoreCase("X")  &&
                       blocklist.get(8).getBlockText().equalsIgnoreCase("X")) {
                         check = true;	 
                         Line line = new Line(0,0,900,900);
                         line.setStroke(Color.WHITE);
                         line.setStrokeWidth(15);
                         root.getChildren().add(line);
               }
               else if(blocklist.get(2).getBlockText().equalsIgnoreCase("X")&&
                       blocklist.get(4).getBlockText().equalsIgnoreCase("X")  &&
                       blocklist.get(6).getBlockText().equalsIgnoreCase("X")) {
                         check = true;	 
                         Line line = new Line(0,900,900,0);
                         line.setStroke(Color.WHITE);
                         line.setStrokeWidth(15);
                         root.getChildren().add(line);}
               
               
               
             	 for ( int y = 0 , x = 0  ; y < 9  ; y+=3,x++) {
                     if(blocklist.get(y).getBlockText().equalsIgnoreCase("O")&&
                        blocklist.get(y+1).getBlockText().equalsIgnoreCase("O")  &&
                        blocklist.get(y+2).getBlockText().equalsIgnoreCase("O")) {
                              check = true;
                              Line line = new Line(0,150+(x*300),900,150+(x*300));
                              line.setStroke(Color.WHITE);
                              line.setStrokeWidth(15);
                              root.getChildren().add(line);}}
             	for ( int  x = 0  ; x < 3  ; x++) {
                      if(blocklist.get(x).getBlockText().equalsIgnoreCase("O")&&
                             blocklist.get(x+3).getBlockText().equalsIgnoreCase("O")  &&
                             blocklist.get(x+6).getBlockText().equalsIgnoreCase("O")) {
                               check = true;	 
                               Line line = new Line(150+(x*300),0,150+(x*300),900);
                               line.setStroke(Color.WHITE);
                               line.setStrokeWidth(15);
                               root.getChildren().add(line);
                     
                     }}  	 
                     if(blocklist.get(0).getBlockText().equalsIgnoreCase("O")&&
                             blocklist.get(4).getBlockText().equalsIgnoreCase("O")  &&
                             blocklist.get(8).getBlockText().equalsIgnoreCase("O")) {
                               check = true;	 
                               Line line = new Line(0,0,900,900);
                               line.setStroke(Color.WHITE);
                               line.setStrokeWidth(15);
                               root.getChildren().add(line);
                     }
                     else if(blocklist.get(2).getBlockText().equalsIgnoreCase("O")&&
                             blocklist.get(4).getBlockText().equalsIgnoreCase("O")  &&
                             blocklist.get(6).getBlockText().equalsIgnoreCase("O")) {
                               check = true;	 
                               Line line = new Line(0,900,900,0);
                               line.setStroke(Color.WHITE);
                               line.setStrokeWidth(15);
                               root.getChildren().add(line);}   
    	
        }
   
        }
    private class Block extends Group{
    	private Rectangle rect;
    	private Text text;
    	public Block(double height, double width) {
    		rect = new Rectangle(0,0,height,width);
    		text = new Text(100,180,"");
    		
    		this.getChildren().addAll(rect,text);
    	}
    	
    	public void setBlockText(String text) {
    		this.text.setText(text);
    		this.text.setFont(Font.font("", FontWeight.BOLD , 150));
    		this.text.setFill(Color.WHITE);
    	}
    	public String getBlockText() {
    		return this.text.getText();
    	}
    }
    
    }
