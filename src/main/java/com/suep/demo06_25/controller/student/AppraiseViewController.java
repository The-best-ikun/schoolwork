package com.suep.demo06_25.controller.student;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class AppraiseViewController {
    @FXML
    private Label tno;//显示教师工号
    @FXML
    private  Label name;//显示教师姓名
    @FXML
    private TextField textField;//显示评价分数
    @FXML
    private TextArea textArea;//显示具体评价
    @FXML
    private TableView tableView;//表格
    @FXML
    private Button button;//提交评价按钮
}
