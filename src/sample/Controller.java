package sample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label labal_field;

    @FXML
    private Button clear_btn;

    @FXML
    private Button plus_minus_btn;

    @FXML
    private Button percent_btn;

    @FXML
    private Button del_btn;

    @FXML
    private Button btn_7;

    @FXML
    private Button btn_8;

    @FXML
    private Button btn_9;

    @FXML
    private Button mult_btn;

    @FXML
    private Button btn_4;

    @FXML
    private Button btn_5;

    @FXML
    private Button btn_6;

    @FXML
    private Button minus_btn;

    @FXML
    private Button btn_1;

    @FXML
    private Button btn_2;

    @FXML
    private Button btn_3;

    @FXML
    private Button plus_btn;

    @FXML
    private Button btn_0;

    @FXML
    private Button comma_btn;

    @FXML
    private Button equal_btn;

    String str_num = "";
    private  float first_num;
    private char operation;

    @FXML
    void initialize() {
        btn_0.setOnAction(Event -> {
            addNumber(0);
        });
        btn_1.setOnAction(Event -> {
            addNumber(1);
        });
        btn_2.setOnAction(Event -> {
            addNumber(2);
        });
        btn_3.setOnAction(Event -> {
            addNumber(3);
        });
        btn_4.setOnAction(Event -> {
            addNumber(4);
        });
        btn_5.setOnAction(Event -> {
            addNumber(5);
        });
        btn_6.setOnAction(Event -> {
            addNumber(6);
        });
        btn_7.setOnAction(Event -> {
            addNumber(7);
        });
        btn_8.setOnAction(Event -> {
            addNumber(8);
        });
        btn_9.setOnAction(Event -> {
            addNumber(9);
        });
        plus_btn.setOnAction(event -> {
            mathAction('+');
        });
        minus_btn.setOnAction(event -> {
            mathAction('-');
        });
        mult_btn.setOnAction(event -> {
            mathAction('*');
        });
        del_btn.setOnAction(event -> {
            mathAction('/');
        });
        equal_btn.setOnAction(event -> {
            if(this.operation == '+' || this.operation == '-' || this.operation == '/' || this.operation == '*')
                equalMethod();
        });
        comma_btn.setOnAction(event -> {
            if(!this.str_num.contains(".")){
                this.str_num += ".";
                labal_field.setText(str_num);
            }
        });
        percent_btn.setOnAction(event ->{
            if(this.str_num != ""){
                float num = Float.parseFloat(this.str_num) * 0.1f;
                this.str_num = Float.toString(num);
                labal_field.setText(str_num);
            }

        });
        plus_minus_btn.setOnAction(event ->{
            if(this.str_num != ""){
                float num = Float.parseFloat(this.str_num) * -1;
                this.str_num = Float.toString(num);
                labal_field.setText(str_num);
            }

        });
        clear_btn.setOnAction(event -> {
            labal_field.setText("0");
            this.str_num = "";
            this.first_num = 0;
            this.operation = 'A';

        });

    }
    void equalMethod(){
        float res = 0;
        switch (this.operation){
            case '+':
                res = this.first_num + Float.parseFloat(this.str_num);
                break;
            case '-':
                res = this.first_num - Float.parseFloat(this.str_num);
                break;
            case '/':
                if (Integer.parseInt(this.str_num) != 0)
                    res = this.first_num / Float.parseFloat(this.str_num);
                else
                    res= 0;
                break;
            case '*':
                res = this.first_num * Float.parseFloat(this.str_num);
                break;
        }

        labal_field.setText(Float.toString(res));
        this.str_num = "";
        this.operation = 'A';
        this.first_num = 0;
    }

    void mathAction(char operation) {
        if(this.operation != '+' && this.operation != '-' && this.operation != '/' && this.operation != '*') {
            this.first_num = Float.parseFloat(this.str_num);
            labal_field.setText(String.valueOf(operation));
            this.str_num = "";
            this.operation = operation;
        }
    }


    void addNumber(int number){
        this.str_num += Integer.toString(number);
        labal_field.setText(str_num);// передача в лэйбл переконвертированый инт в инт переписанный в строку
    }
}

