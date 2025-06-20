package hellofx;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.net.URL;

public class SceneTutorialOne extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Group root = new Group();
        Scene scene = new Scene(root, 600, 600, Color.SKYBLUE);

        URL iconURL = getClass().getResource("/images/brand.png");
        if (iconURL == null) {
            throw new RuntimeException("Icon resource not found");
        }
        Image icon = new Image(iconURL.toExternalForm());

        stage.setTitle("Hello World");
        stage.getIcons().add(icon);

        Text text = new Text("Hello World");
        text.setX(50);
        text.setY(50);
        text.setFont(Font.font("Comic Sans MS", 24));
        text.setFill(Color.DARKGREEN);

        Line line = new Line();
        line.setStartX(200);
        line.setStartY(200);
        line.setEndX(500);
        line.setEndY(200);
        line.setStrokeWidth(5);
        line.setStroke(Color.RED);
        line.setOpacity(0.5);
        line.setRotate(45);


        Rectangle rectangle = new Rectangle();
        rectangle.setX(100);
        rectangle.setY(100);
        rectangle.setWidth(100);
        rectangle.setHeight(100);
        rectangle.setFill(Color.RED);
        rectangle.setStroke(Color.BLACK);
        rectangle.setStrokeWidth(5);
        rectangle.setOpacity(0.5);

        Polygon triangle = new Polygon();
        triangle.getPoints().addAll(
                200.0,200.0,
                300.0, 300.0,
                200.0, 300.0
        );
        triangle.setFill(Color.YELLOW);


        Circle circle = new Circle();
        circle.setCenterX(350);
        circle.setCenterY(350);
        circle.setRadius(50);
        circle.setFill(Color.ORANGE);


        URL img1URL = getClass().getResource("/images/img1.jpg");
        if (img1URL == null) {
            throw new RuntimeException("Image resource not found");
        }
        Image img1 = new Image(img1URL.toExternalForm());

        ImageView imageView = new ImageView(img1);
        imageView.setX(400);
        imageView.setY(400);

        imageView.setFitWidth(180);
        imageView.setPreserveRatio(true);



        // Adding elements to the root node
        root.getChildren().add(text);
        root.getChildren().add(line);
        root.getChildren().add(rectangle);
        root.getChildren().add(triangle);
        root.getChildren().add(circle);
        root.getChildren().add(imageView);



        stage.setScene(scene);
        stage.show();
    }
}