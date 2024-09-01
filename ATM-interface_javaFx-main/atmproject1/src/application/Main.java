package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.geometry.Side;

import java.io.FileInputStream;
import java.io.IOException;

public class Main extends Application {
    Stage stage;
    String u ="abc",pw="123",checku,checkp,checks,rname,rpass,accno;
    int ball,bal,wd,dp,i;
    
    @Override
    public void start(Stage primarystage) throws IOException {
        stage = primarystage;
        Scene scene = LoginScene();
        stage.setTitle("Hello!");
        stage.setMaximized(true);
        stage.setScene(scene);
        stage.show();
        //System.out.printf(stage.widthProperty()+" "+stage.heightProperty());

    }
    Scene LoginScene(){
        BorderPane bp = new BorderPane();
        GridPane gp = new GridPane();

        //label
        Label ln1 = new Label("WELCOME TO CSD BANK");
        ln1.setFont(Font.font("timesnewroman", FontWeight.BOLD, FontPosture.REGULAR, 40));
        ln1.setTextFill(Color.BROWN);
        Label lna = new Label("UserName:");
        lna.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));

        Label lpass = new Label("Password:");
        lpass.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));

        //Label llas = new Label("Login As:");
        //llas.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
        Label lpass2 = new Label("Password:");
        lpass2.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));

        Label Lo = new Label("Login");
        Lo.setTextFill(Color.WHITE);
        Lo.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 70));

        Button b1 = new Button("Login");
        b1.setAlignment(Pos.CENTER);
        b1.setMinSize(200,50);
        b1.setTextFill(Color.WHITE);
        b1.setStyle("-fx-background-color: #47AB11");

        Label t1 = new Label("No account- click here to register");
        t1.setTextFill(Color.BLUE);

        //textfields
        TextField tna = new TextField();
        tna.setFont(Font.font("verdana", FontPosture.REGULAR, 20));
        tna.setPromptText("Name");

        //passwordfield
        PasswordField pf = new PasswordField();
        pf.setPromptText("Password");
        pf.setFont(Font.font("verdana", FontPosture.REGULAR, 20));
        
        Label lblmessage = new Label();
        lblmessage.setFont(Font.font("verdana", FontPosture.REGULAR, 30));

        //ComboBox cb = new ComboBox();
        //cb.getItems().addAll("Admin","student");
        //cb.setStyle("-fx-font-size: 20");
        //cb.setMinWidth(260);
        PasswordField cb = new PasswordField();
        cb.setPromptText("Password");
        cb.setFont(Font.font("verdana", FontPosture.REGULAR, 20));

        VBox vb = new VBox();
        vb.getChildren().addAll(Lo, gp,b1,t1);
        vb.setAlignment(Pos.CENTER);
        vb.setSpacing(20);

        gp.setHgap(20);
        gp.setVgap(20);
        gp.addRow(0,ln1);
        gp.addRow(3,lna, tna);
        //gp.addRow(3,lpass2,cb);
        gp.addRow(4,lpass, pf);
        gp.addRow(5,lblmessage);
        gp.setAlignment(Pos.TOP_CENTER);

        bp.setCenter(vb);
        bp.setAlignment(vb, Pos.TOP_CENTER);
        Image image = null;
        try {
            FileInputStream file = new FileInputStream("C://Users//Hxtreme//Downloads//—Pngtree—pink classical hand drawn landscape_979789.jpg");
            image = new Image(file);
        }catch (Exception e){
           
        }
        Background background = new Background(new BackgroundImage(image,BackgroundRepeat.REPEAT,BackgroundRepeat.NO_REPEAT,new BackgroundPosition(Side.LEFT,0,true,Side.BOTTOM,0,true),new BackgroundSize(BackgroundSize.AUTO,BackgroundSize.AUTO,true,true,false,true)));
        bp.setBackground(background);
        b1.setOnAction(new EventHandler<ActionEvent>() {
        	public void handle(ActionEvent event) {
        		checku=tna.getText().toString();
                checkp=pf.getText().toString();
                if((checku.equals(u) && checkp.equals(pw) ) || (checku.equals(rname) && checkp.equals(rpass))) {
                	lblmessage.setText("Congratulations !");
                	lblmessage.setTextFill(Color.GREEN);
                	if(checku.equals(u)) {
                		bal=10000;
                	}
                	b1.setOnMouseClicked(e->switchScenes(homeScene()));
                }
                else if(checku.isEmpty()) {
                	lblmessage.setText("Fill all details ");
                	lblmessage.setTextFill(Color.RED);
                }
                else {
                	lblmessage.setText("Incorrect Credentials");
                	lblmessage.setTextFill(Color.RED);
                }
                pf.setText("");
                tna.setText("");
        	}
        	
        	});
        
        
        
        t1.setOnMouseClicked(e->switchScenes(registerScene()));
        Scene scene = new Scene(bp, 1550.4000244140625, 830.4000244140625);
        return scene;
       
        //t1.setOnMouseClicked(e->switchScenes(registerScene()));
        //Scene scene1 = new Scene(bp, 960, 540);
        //return scene1;
    }

    Scene registerScene(){
        BorderPane bp = new BorderPane();
        GridPane gp = new GridPane();

        Label lna = new Label("UserName:");
        lna.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));

        Label lpass = new Label("Password:");
        lpass.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));

        Label lemail = new Label("Email:");
        lemail.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));

        Label llas = new Label("Confirm Password:");
        llas.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));

        Label Lo = new Label("Register");
        Lo.setTextFill(Color.BROWN);
        Lo.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 40));
       
        Label lna1 = new Label("Account No:");
        lna1.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));


        Button b1 = new Button("Sign In");
        b1.setAlignment(Pos.CENTER);
        b1.setMinSize(200,50);
        b1.setTextFill(Color.WHITE);
        b1.setStyle("-fx-background-color: #47AB11");

        Button t1 = new Button("Already Registered - click to Login");
        t1.setTextFill(Color.BLUE);

        //textfields
        TextField tna = new TextField();
        tna.setFont(Font.font("verdana", FontPosture.REGULAR, 20));
        tna.setPromptText("Name");
       
        TextField tna1 = new TextField();
        tna1.setFont(Font.font("verdana", FontPosture.REGULAR, 20));
        tna1.setPromptText("XXXX XXXX XXXX XXXX");
       
        TextField tn2 = new TextField();
        tn2.setFont(Font.font("verdana", FontPosture.REGULAR, 20));
        tn2.setPromptText("example@gmail.com");

        //passwordfield
        PasswordField pf = new PasswordField();
        pf.setPromptText("re-Enter Password");
        pf.setFont(Font.font("verdana", FontPosture.REGULAR, 20));

        PasswordField cb = new PasswordField();
        cb.setPromptText("Password");
        cb.setFont(Font.font("verdana", FontPosture.REGULAR, 20));
        Label lblmessage = new Label();
        lblmessage.setFont(Font.font("verdana", FontPosture.REGULAR, 30));

        VBox vb = new VBox();
        vb.getChildren().addAll(Lo, gp,b1,t1);
        vb.setAlignment(Pos.CENTER);
        vb.setSpacing(20);

        gp.setHgap(20);
        gp.setVgap(20);
        gp.addRow(0,lna1,tna1);
        gp.addRow(1,lna, tna);
        gp.addRow(2,lemail,tn2);
        gp.addRow(3,lpass,cb );
        gp.addRow(4,llas, pf);
        gp.addRow(5, lblmessage);
        gp.setAlignment(Pos.TOP_CENTER);

        bp.setCenter(vb);
        bp.setAlignment(vb, Pos.TOP_CENTER);
        
        Image image = null;
        try {
            FileInputStream file = new FileInputStream("C://Users//Hxtreme//Downloads//—Pngtree—pink classical hand drawn landscape_979789.jpg");
            image = new Image(file);
        }catch (Exception e){

        }
        //Background background = new Background(new BackgroundImage(image,BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT));
        Background background = new Background(new BackgroundImage(image,BackgroundRepeat.REPEAT,BackgroundRepeat.NO_REPEAT,new BackgroundPosition(Side.LEFT,0,true,Side.BOTTOM,0,true),new BackgroundSize(BackgroundSize.AUTO,BackgroundSize.AUTO,true,true,false,true)));
        bp.setBackground(background);
        //Scene scene1 = new Scene(bp, 1550.4000244140625, 830.4000244140625);
        //return scene1;
        
        //t1.setOnAction(new EventHandler<ActionEvent>() {
        	//public void handle(ActionEvent event) {
        		
                //if(!(rname.isEmpty())) {
                 //t1.setOnMouseClicked(e->switchScenes(LoginScene()));
                //}
        	//}
        	
        	//});
        t1.setOnMouseClicked(e->switchScenes(LoginScene()));
        b1.setOnAction(new EventHandler<ActionEvent>() {
        	public void handle(ActionEvent event) {
        		rname=tna.getText().toString();
        		checku=rname;
        		accno=tna1.getText().toString();
                rpass=cb.getText().toString();
        		checks=cb.getText().toString();
                checkp=pf.getText().toString();
                if(checks.equals(checkp)) {
                	if(checks.isEmpty()|| accno.isEmpty()|| rname.isEmpty()) {
                    	lblmessage.setText("FILL ALL DETAILS");
                    	lblmessage.setTextFill(Color.RED);
                    }
                	else {
                	lblmessage.setText("Congratulations !");
                	lblmessage.setTextFill(Color.GREEN);
                	ball=0;
                	b1.setOnMouseClicked(e->switchScenes(homeScene()));
                	}
                }
                
                else {
                	lblmessage.setText("Incorrect password");
                	lblmessage.setTextFill(Color.RED);
                }
                pf.setText("");
                cb.setText("");
        	}
        	
        	});
        
        Scene scene = new Scene(bp, 1550.4000244140625, 830.4000244140625);
        return scene;
    }
    public void switchScenes1(Scene scene1){
        stabge.setMaximized(true);
        stage.setScene(scene1);
    }
    Scene homeScene(){
        BorderPane bp = new BorderPane();
        GridPane gp = new GridPane();

        //label
        Label lna = new Label("Cash Withdraw ->");
        lna.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));

        Label lpass = new Label("Cash Deposit    ->");
        lpass.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));

        Label lemail = new Label("Check balance  ->");
        lemail.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));

        //Label ll = new Label(" ");
        //ll.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));

        Label L1 = new Label("HOME");
        //Lo.setTextFill(Color.WHITE);
        L1.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 50));

        Button b1 = new Button("WITHDRAW");
        Button b2 = new Button("DEPOSIT");
        Button b3 = new Button("CHECK BALANCE");
        Button b5 = new Button("LOGOUT");
        Button b4 = new Button("Exit");
        //b1.setAlignment(Pos.CENTER);
        b1.setMinSize(200,50);
        b1.setTextFill(Color.WHITE);
        b1.setStyle("-fx-background-color: #00008B");
       
        b2.setMinSize(200,50);
        b2.setTextFill(Color.WHITE);
        b2.setStyle("-fx-background-color: #00008B");
       
        b3.setMinSize(200,50);
        b3.setTextFill(Color.WHITE);
        b3.setStyle("-fx-background-color: #00008B");
       
        b4.setMinSize(200,50);
        b4.setTextFill(Color.WHITE);
        b4.setStyle("-fx-background-color: #FFA500");
       
        b5.setMinSize(200,50);
        b5.setTextFill(Color.WHITE);
        b5.setStyle("-fx-background-color: #FFA500");


        VBox vb = new VBox();
        vb.getChildren().addAll( gp,b1);
        vb.setAlignment(Pos.CENTER);
        vb.setSpacing(20);

        gp.setHgap(20);
        gp.setVgap(20);
        gp.addRow(0,L1);
        gp.addRow(2,lna, b1);
        gp.addRow(3,lpass,b2);
        gp.addRow(4,lemail,b3);
        gp.addRow(5,b5,b4);
        gp.setAlignment(Pos.TOP_CENTER);

        bp.setCenter(vb);
        bp.setAlignment(vb, Pos.TOP_CENTER);
        Image image = null;
        try {
            FileInputStream file = new FileInputStream("C://Users//Hxtreme//Downloads//img4java.jpg");
            image = new Image(file);
        }catch (Exception e){

        }
        //Background background = new Background(new BackgroundImage(image,BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT));
        Background background = new Background(new BackgroundImage(image,BackgroundRepeat.REPEAT,BackgroundRepeat.NO_REPEAT,new BackgroundPosition(Side.LEFT,0,true,Side.BOTTOM,0,true),new BackgroundSize(BackgroundSize.AUTO,BackgroundSize.AUTO,true,true,false,true)));
        bp.setBackground(background);
        //Scene scene1 = new Scene(bp, 1550.4000244140625, 830.4000244140625);
        //return scene;
        b2.setOnMouseClicked(e->switchScenes(depositScene()));
        b1.setOnMouseClicked(e->switchScenes(withdrawScene()));
        b3.setOnMouseClicked(e->switchScenes(BalScene()));
        b5.setOnMouseClicked(e->switchScenes(LoginScene()));
        b4.setOnMouseClicked(e->switchScenes(exitScene()));
        Scene scene = new Scene(bp, 1550.4000244140625, 830.4000244140625);
        return scene;
    }
    public void switchScenes(Scene scene){
        stage.setMaximized(true);
        stage.setScene(scene);
    }
    Scene withdrawScene(){
        BorderPane bp = new BorderPane();
        GridPane gp = new GridPane();

        //label
        Label lna = new Label("ENTER THE AMOUNT ");
        lna.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
       
        TextField tna = new TextField();
        tna.setFont(Font.font("verdana", FontPosture.REGULAR, 20));
        tna.setPromptText("AMOUNT");

        //Label lpass = new Label("Cash Deposit    ->");
        //lpass.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));

        //Label lemail = new Label("Check balance  ->");
        //lemail.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));

        //Label ll = new Label(" ");
        //ll.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));

        Label L1 = new Label("CASH WITHDRAWAL");
        //Lo.setTextFill(Color.WHITE);
        L1.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 50));
        
        Label lblmessage = new Label();
        lblmessage.setFont(Font.font("verdana", FontPosture.REGULAR, 30));


        Button b1 = new Button("CONFIRM");
        Button b2 = new Button("HOME");
        Button b3 = new Button("EXIT");
        //Button b4 = new Button("Exit");
        //b1.setAlignment(Pos.CENTER);
        b1.setMinSize(200,50);
        b1.setTextFill(Color.WHITE);
        b1.setStyle("-fx-background-color: #00008B");
       
        b2.setMinSize(200,50);
        b2.setTextFill(Color.WHITE);
        b2.setStyle("-fx-background-color: #00008B");
       
        b3.setMinSize(200,50);
        b3.setTextFill(Color.WHITE);
        b3.setStyle("-fx-background-color: #FFA500");
       
        //b4.setMinSize(200,50);
        //b4.setTextFill(Color.WHITE);
       // b4.setStyle("-fx-background-color: #FFA500");


        VBox vb = new VBox();
        vb.getChildren().addAll( gp,b1);
        vb.setAlignment(Pos.CENTER);
        vb.setSpacing(20);

        gp.setHgap(20);
        gp.setVgap(20);
        gp.addRow(0,L1);
        gp.addRow(2,lna,tna);
        gp.addRow(3,b1);
        gp.addRow(4,b2);
        gp.addRow(5,b3);
        gp.addRow(6, lblmessage);
        gp.setAlignment(Pos.TOP_CENTER);

        bp.setCenter(vb);
        bp.setAlignment(vb, Pos.TOP_CENTER);
        Image image = null;
        try {
            FileInputStream file = new FileInputStream("C://Users//Hxtreme//Downloads//img3.jpg");
            image = new Image(file);
        }catch (Exception e){

        }
        //Background background = new Background(new BackgroundImage(image,BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT));
        Background background = new Background(new BackgroundImage(image,BackgroundRepeat.REPEAT,BackgroundRepeat.NO_REPEAT,new BackgroundPosition(Side.LEFT,0,true,Side.BOTTOM,0,true),new BackgroundSize(BackgroundSize.AUTO,BackgroundSize.AUTO,true,true,false,true)));
        bp.setBackground(background);
        b1.setOnAction(new EventHandler<ActionEvent>() {
        	public void handle(ActionEvent event) {
        		i = Integer.parseInt(tna.getText());
        		if(checku.equals(u)) {
                  if(bal>=i) {
                	lblmessage.setText("Congratulations !");
                	lblmessage.setTextFill(Color.GREEN);
                	bal=bal-i;
                	b1.setOnMouseClicked(e->switchScenes(homeScene()));
                  }
                  else {
                	lblmessage.setText("Insufficient Balance");
                	lblmessage.setTextFill(Color.RED);
                  }
        		}
        		else if(checku.equals(rname)) {
                    if(ball>=i) {
                  	lblmessage.setText("Congratulations !");
                  	lblmessage.setTextFill(Color.GREEN);
                  	ball=ball-i;
                  	b1.setOnMouseClicked(e->switchScenes(homeScene()));
                    }
                    else {
                  	lblmessage.setText("Insufficient Balance");
                  	lblmessage.setTextFill(Color.RED);
                    }
          		}
                tna.setText("");
        	}
        	
        	});
        
        
        b2.setOnMouseClicked(e->switchScenes(homeScene()));
        b3.setOnMouseClicked(e->switchScenes(exitScene()));
        Scene scene = new Scene(bp, 1550.4000244140625, 830.4000244140625);
        return scene;
        //Scene scene = new Scene(bp, 1550.4000244140625, 830.4000244140625);
        //return scene;
    }
    //public void switchScenes(Scene scene){
        //stage.setMaximized(true);
        //stage.setScene(scene);
    //}
    Scene depositScene(){
        BorderPane bp = new BorderPane();
        GridPane gp = new GridPane();

        //label
        Label lna = new Label("ENTER THE AMOUNT ");
        lna.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
       
        TextField tna = new TextField();
        tna.setFont(Font.font("verdana", FontPosture.REGULAR, 20));
        tna.setPromptText("AMOUNT");

        //Label lpass = new Label("Cash Deposit    ->");
        //lpass.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));

        //Label lemail = new Label("Check balance  ->");
        //lemail.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));

        //Label ll = new Label(" ");
        //ll.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));

        Label L1 = new Label("CASH DEPOSIT");
        //Lo.setTextFill(Color.WHITE);
        L1.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 50));
        Label lblmessage = new Label();
        lblmessage.setFont(Font.font("verdana", FontPosture.REGULAR, 30));

        Button b1 = new Button("CONFIRM");
        Button b2 = new Button("HOME");
        Button b3 = new Button("EXIT");
        //Button b4 = new Button("Exit");
        //b1.setAlignment(Pos.CENTER);
        b1.setMinSize(200,50);
        b1.setTextFill(Color.WHITE);
        b1.setStyle("-fx-background-color: #00008B");
       
        b2.setMinSize(200,50);
        b2.setTextFill(Color.WHITE);
        b2.setStyle("-fx-background-color: #00008B");
       
        b3.setMinSize(200,50);
        b3.setTextFill(Color.WHITE);
        b3.setStyle("-fx-background-color: #FFA500");
       
        //b4.setMinSize(200,50);
        //b4.setTextFill(Color.WHITE);
       // b4.setStyle("-fx-background-color: #FFA500");


        VBox vb = new VBox();
        vb.getChildren().addAll( gp,b1);
        vb.setAlignment(Pos.CENTER);
        vb.setSpacing(20);

        gp.setHgap(20);
        gp.setVgap(20);
        gp.addRow(0,L1);
        gp.addRow(2,lna,tna);
        gp.addRow(3,b1);
        gp.addRow(4,b2);
        gp.addRow(5,b3);
        gp.addRow(6, lblmessage);
        gp.setAlignment(Pos.TOP_CENTER);

        bp.setCenter(vb);
        bp.setAlignment(vb, Pos.TOP_CENTER);
        Image image = null;
        try {
            FileInputStream file = new FileInputStream("C://Users//Hxtreme//Downloads//img3.jpg");
            image = new Image(file);
        }catch (Exception e){

        }
        //Background background = new Background(new BackgroundImage(image,BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT));
        Background background = new Background(new BackgroundImage(image,BackgroundRepeat.REPEAT,BackgroundRepeat.NO_REPEAT,new BackgroundPosition(Side.LEFT,0,true,Side.BOTTOM,0,true),new BackgroundSize(BackgroundSize.AUTO,BackgroundSize.AUTO,true,true,false,true)));
        bp.setBackground(background);
        b1.setOnAction(new EventHandler<ActionEvent>() {
        	public void handle(ActionEvent event) {
        		i = Integer.parseInt(tna.getText());
                if(i>=0) {
                	lblmessage.setText("Deposited!");
                	lblmessage.setTextFill(Color.GREEN);
                	if(checku.equals(u)) {
                	  bal=bal+i;
                	}
                	else if(checku.equals(rname)) {
                		ball=ball+i;
                	}
                	b1.setOnMouseClicked(e->switchScenes(homeScene()));
                }
                else {
                	lblmessage.setText("Invalid input");
                	lblmessage.setTextFill(Color.RED);
                }
                tna.setText("");
        	}
        	
        	});
        b2.setOnMouseClicked(e->switchScenes(homeScene()));
        b3.setOnMouseClicked(e->switchScenes(exitScene()));
        Scene scene = new Scene(bp, 1550.4000244140625, 830.4000244140625);
        return scene;
        //Scene scene = new Scene(bp, 1550.4000244140625, 830.4000244140625);
        //return scene;
    }
   
    Scene BalScene() {
    	BorderPane bp = new BorderPane();
        GridPane gp = new GridPane();

        Label lna = new Label("BALANCE AMOUNT  -");
        lna.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
        Label L1 = new Label();
        L1.setFont(Font.font("verdana", FontPosture.REGULAR, 20));
        Label L2= new Label();
        L2.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
        L2.setTextFill(Color.GREEN);
        Label L3= new Label();
        L3.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
        L3.setTextFill(Color.BLUE);
        Label lna1 = new Label("USER NAME             -");
        lna1.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
        Label lna2 = new Label("Account no.             -");
        lna2.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
        if(checku.equals(u)) {
        	L1.setText(u);
        	L2.setText("Rs +"+bal);
        	L3.setText("XXXX XXXX XXXX 4567");
        }
        else{
        	L1.setText(rname);
        	L2.setText("Rs +"+ball);
        	L3.setText("XXXX XXXX XXXX "+accno);
        }
        
        Button b2 = new Button("HOME");
        Button b1 = new Button("EXIT");
        
        b2.setMinSize(200,50);
        b2.setTextFill(Color.WHITE);
        b2.setStyle("-fx-background-color: #00008B");
        b1.setMinSize(200,50);
        b1.setTextFill(Color.WHITE);
        b1.setStyle("-fx-background-color: #FFA500");
        VBox vb = new VBox();
        vb.getChildren().addAll( gp,b2);
        vb.setAlignment(Pos.CENTER);
        vb.setSpacing(20);

        gp.setHgap(20);
        gp.setVgap(20);
        gp.addRow(0,lna1,L1);
        gp.addRow(1, lna2,L3);
        gp.addRow(2,lna,L2);
        
        gp.addRow(4,b2);
        gp.addRow(5,b1);
        gp.setAlignment(Pos.TOP_CENTER);

        bp.setCenter(vb);
        bp.setAlignment(vb, Pos.TOP_CENTER);
        Image image = null;
        try {
            FileInputStream file = new FileInputStream("C://Users//Hxtreme//Downloads//img java12.jpg");
            image = new Image(file);
        }catch (Exception e){

        }
        Background background = new Background(new BackgroundImage(image,BackgroundRepeat.REPEAT,BackgroundRepeat.NO_REPEAT,new BackgroundPosition(Side.LEFT,0,true,Side.BOTTOM,0,true),new BackgroundSize(BackgroundSize.AUTO,BackgroundSize.AUTO,true,true,false,true)));
        bp.setBackground(background);
        b2.setOnMouseClicked(e->switchScenes(homeScene()));
        b1.setOnMouseClicked(e->switchScenes(exitScene()));
        Scene scene = new Scene(bp, 1550.4000244140625, 830.4000244140625);
        return scene;
       


       

    }
    Scene exitScene(){
        BorderPane bp = new BorderPane();
        GridPane gp = new GridPane();

        Label L1 = new Label("THANK YOU");
        //Lo.setTextFill(Color.WHITE);
        L1.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 50));


        VBox vb = new VBox();
        vb.getChildren().addAll( gp);
        vb.setAlignment(Pos.CENTER);
        vb.setSpacing(20);

        gp.setHgap(20);
        gp.setVgap(20);
        gp.addRow(0,L1);
        gp.setAlignment(Pos.TOP_CENTER);

        bp.setCenter(vb);
        bp.setAlignment(vb, Pos.TOP_CENTER);
        Image image = null;
        try {
            FileInputStream file = new FileInputStream("C://Users//Hxtreme//Downloads//javaproject11.jpg");
            image = new Image(file);
        }catch (Exception e){

        }
        Background background = new Background(new BackgroundImage(image,BackgroundRepeat.REPEAT,BackgroundRepeat.NO_REPEAT,new BackgroundPosition(Side.LEFT,0,true,Side.BOTTOM,0,true),new BackgroundSize(BackgroundSize.AUTO,BackgroundSize.AUTO,true,true,false,true)));
        bp.setBackground(background);
        Scene scene = new Scene(bp, 1550.4000244140625, 830.4000244140625);
        return scene;
        //Scene scene = new Scene(bp, 1550.4000244140625, 830.4000244140625);
        //return scene;
    }




    public static void main(String[] args) {
        launch();
    }
}