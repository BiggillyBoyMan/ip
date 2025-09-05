package Nami.ui;

import Nami.Nami;
import Nami.exception.DukeException;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.layout.Region;
import Nami.NamiGUI;

import java.io.IOException;

public class Main extends Application {

    private ScrollPane scrollPane;
    private VBox dialogContainer;
    private TextField userInput;
    private Button sendButton;
    private Scene scene;
    private NamiGUI nami;

    // sample avatars (put images in src/main/resources/images/)
    private final Image userImage = new Image(
            this.getClass().getResourceAsStream("/images/DaUser.png"));
    private final Image namiImage = new Image(
            this.getClass().getResourceAsStream("/images/DaDuke.png"));

    @Override
    public void start(Stage stage) throws DukeException, IOException {

        nami = new NamiGUI();
        // --- Setting up required components ---
        scrollPane = new ScrollPane();
        dialogContainer = new VBox();
        scrollPane.setContent(dialogContainer);

        userInput = new TextField();
        sendButton = new Button("Send");

        AnchorPane mainLayout = new AnchorPane();
        mainLayout.getChildren().addAll(scrollPane, userInput, sendButton);

        scene = new Scene(mainLayout);
        stage.setScene(scene);
        stage.show();

        // --- Add one sample dialog box (will wire real logic in next steps) ---
        sendButton.setOnMouseClicked((event) -> {
            handleUserInput();
        });
        userInput.setOnAction((event) -> {
            handleUserInput();
        });

        dialogContainer.heightProperty().addListener((observable) -> scrollPane.setVvalue(1.0));


        // --- Formatting the window to look like the mockup ---
        stage.setTitle("Nami");
        stage.setResizable(false);
        stage.setMinHeight(600.0);
        stage.setMinWidth(400.0);

        mainLayout.setPrefSize(400.0, 600.0);

        scrollPane.setPrefSize(385, 535);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        scrollPane.setVvalue(1.0);
        scrollPane.setFitToWidth(true);

        dialogContainer.setPrefHeight(Region.USE_COMPUTED_SIZE);

        userInput.setPrefWidth(325.0);
        sendButton.setPrefWidth(55.0);

        AnchorPane.setTopAnchor(scrollPane, 1.0);

        AnchorPane.setBottomAnchor(sendButton, 1.0);
        AnchorPane.setRightAnchor(sendButton, 1.0);

        AnchorPane.setLeftAnchor(userInput, 1.0);
        AnchorPane.setBottomAnchor(userInput, 1.0);

        sendButton.setOnAction(e -> handleUserInput());
        userInput.setOnAction(e -> handleUserInput());

        String welcome = """
        ______________________________________
        Hello! I'm Nami

        What can I do for you?
        ______________________________________
        """;
        dialogContainer.getChildren().add(
                DialogBox.getDukeDialog(welcome, namiImage)  // Nami (left) bubble
        );

        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    private void handleUserInput() {
        String userText = userInput.getText().trim();
        if (userText.isEmpty()) return;

        String namiText = nami.getResponse(userText);

        dialogContainer.getChildren().addAll(
                DialogBox.getUserDialog(userText, userImage),
                DialogBox.getDukeDialog(namiText, namiImage)
        );
        userInput.clear();

        if (nami.shouldExit()) {
            // allow the goodbye bubble to render, then close
            new Thread(() -> {
                try { Thread.sleep(250); } catch (InterruptedException ignored) {}
                Platform.runLater(Platform::exit);
            }).start();
        }
    }
}
