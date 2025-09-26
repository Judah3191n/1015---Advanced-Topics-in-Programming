package org.example.demo2;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import static javafx.application.Application.launch;

// ---------- Item class ----------
class GameItem {
    double x, y, speedX, speedY;

    GameItem(double x, double y, double speedX, double speedY) {
        this.x = x;
        this.y = y;
        this.speedX = speedX;
        this.speedY = speedY;
    }
}

// ---------- Vehicle class ----------
class Vehicle extends GameItem {
    Vehicle(double x, double y, double speedX, double speedY) {
        super(x, y, speedX, speedY);
    }

    public void move(double maxWidth, double maxHeight, double width, double height) {
        x += speedX;
        y += speedY;

        //bounce on edges
        if(x<=0){
            x=0;
            speedX *= -1;
        } else if(x+width>=maxWidth){
            x = maxWidth-width;
            speedX *= -1;
        }

        if(y<=0){
            y = 0;
            speedY *= -1;
        }else if(y+height>=maxHeight){
            y = maxHeight-height;
            speedY *= -1;
        }
    }
}

// ---------- Car class ----------
class Car extends Vehicle {
    double width = 60;
    double height = 30;

    Car(double x, double y, double speedX, double speedY) {
        super(x, y, speedX, speedY);
    }

    public void render(GraphicsContext gc){
        gc.setFill(Color.RED);
        gc.fillRect(x, y, width, height);
    }
}

// ---------- Main Application ----------
public class MyJavaFX extends Application {
    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
        int width = 500;
        int height = 300;

        //Drawing canvas
        Canvas canvas = new Canvas(width, height);
        GraphicsContext gc = canvas.getGraphicsContext2D();


        //Start, stop buttons as scene
        Button startButton = new Button("Start");//create 2 buttons
        Button stopButton = new Button("Stop");
        Button fastButton = new Button("Faster");//create 2 buttons
        Button slowButton = new Button("Slower");
        Button bigButton = new Button("Bigger");//create 2 buttons
        Button smallButton = new Button("Smaller");
        HBox buttonHBox = new HBox(10,startButton,stopButton,fastButton, slowButton,bigButton,smallButton);//add space between buttons

        //Layout
        BorderPane root = new BorderPane();
        root.setTop(buttonHBox);
        root.setCenter(canvas);
        canvas.widthProperty().bind(root.widthProperty());
        canvas.heightProperty().bind(root.heightProperty().subtract(buttonHBox.heightProperty()));
        Scene scene = new Scene(root,width,height);

        //car object
        Car car = new Car(width/2,height/2,4,5);

        //animation
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                //clear screen
                gc.clearRect(0, 0, width, height);

                //move car
                car.move(canvas.getWidth(), canvas.getHeight(), car.width, car.height);
                car.render(gc);
            }
        };


        startButton.setOnAction(e -> {timer.start();});
        stopButton.setOnAction(e -> {timer.stop();});
        fastButton.setOnAction(e -> {car.speedX+=5;car.speedY+=5;});
        slowButton.setOnAction(e -> {car.speedY-=5;car.speedX-=5;});
        bigButton.setOnAction(e -> {car.width +=5;car.height +=5;});
        smallButton.setOnAction(e -> {car.width -=5;car.height -=5;});

        //stage setup
        primaryStage.setTitle("Primary Stage");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}