package tictac;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.scene.control.Button;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
public class WindowController extends Controller{

    @FXML
    private Button b00,b01,b02,b10,b11,b12,b20,b21,b22;
    @FXML
    private Text message;
    private String winX="Player 1 Won",winO="Player 2 Won";
    private String turnX="Player 1's Turn with X",turnO="Player 2's Turn with O";
    private Image image1 = new Image(new FileInputStream("x.png"));
    private Image image2 = new Image(new FileInputStream("o.jpg"));
    private ImageView img1 = new ImageView(image1);
    private ImageView img2 = new ImageView(image2);
    private int turn=1;
    private int [][] A=new int[3][3];

    public WindowController() throws FileNotFoundException,Exception{

    }
    @FXML
    void imageHandle1(ActionEvent event) {  
        ImageView img;//create new instance so it doesn't take/steal the img          
        if(turn==1){
            img=new ImageView(image1);
            turn=2;
            A[Character.getNumericValue(((Button)event.getSource()).getId().charAt(1))]
                 [Character.getNumericValue(((Button)event.getSource()).getId().charAt(2))]=5;
            ((Button)event.getSource()).setGraphic((ImageView)img);//set the button pressed to the created image
            if(checkWinner()){
                message.setText(winX);                
            }else{
                message.setText(turnO);  
            }
        }else{
            img=new ImageView(image2);
            turn=1;
            A[Character.getNumericValue(((Button)event.getSource()).getId().charAt(1))]
                 [Character.getNumericValue(((Button)event.getSource()).getId().charAt(2))]=2;
            ((Button)event.getSource()).setGraphic((ImageView)img);//set the button pressed to the created image
            if(checkWinner()){
                message.setText(winO);                
            }else{
                message.setText(turnX);  
            }
        }                 
       
    }   
    private boolean checkWinner(){
       
        int diag1=0,diag2=0;
        for(int i=0;i<3;i++){
            int line=0,column=0;
            for(int j=0;j<3;j++){
                line+=A[i][j];
                column+=A[j][i];
                if(i==j){
                    diag1+=A[i][j];;
                }
                if(i==j){
                    diag1+=A[i][j];;
                }
                if(i+j==2){
                    diag2+=A[i][j];;
                }
            }
            if(line==15||line==6||column==15||column==6)
                return true;
        }
        if(diag1==15||diag1==6||diag2==15||diag2==6)
                return true;

        return false;
    }
    @FXML
    void newGame(ActionEvent event){
        A=new int[3][3];
        turn=1;
        b00.setGraphic(null);
        b01.setGraphic(null);
        b02.setGraphic(null);
        b10.setGraphic(null);
        b11.setGraphic(null);
        b12.setGraphic(null);
        b20.setGraphic(null);
        b21.setGraphic(null);
        b22.setGraphic(null);
        message.setText(turnX); 
        
    }
}
