package multimidias;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    // socororo
    @Override
    public void start(Stage stage) throws Exception {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("layout.fxml"));

        Parent root = fxmlLoader.load();

        Scene scene = new Scene(root);

        Text text = new Text();
        text.setText("Bem vindo ao aplicativo de vídeo aulas, selecione a aula que deseja realizar: ");
        text.setX(50);
        text.setY(50);
        text.setFont(Font.font("DejaVu Sans Mono", 20));
        text.setFill(Color.GREENYELLOW);

        stage.setFullScreen(true);
        stage.setTitle("Trabalho de Multimídias");
        stage.setScene(scene);
        stage.show();

    }

}
