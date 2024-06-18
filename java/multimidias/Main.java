package multimidias;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Group root = new Group();
        Scene scene = new Scene(root, Color.BLACK);

        Text text = new Text();
        text.setText("Bem vindo ao aplicativo de vídeo aulas, selecione a aula que deseja realizar: ");
        text.setX(50);
        text.setY(50);

        stage.setFullScreen(true);
        stage.setTitle("Trabalho de Multimídias");
        stage.setScene(scene);
        stage.show();
        // dasda
    }

}
