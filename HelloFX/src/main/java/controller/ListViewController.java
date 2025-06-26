package controller;

import javafx.beans.Observable;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import javafx.beans.value.ChangeListener;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

public class ListViewController extends BaseController implements Initializable {

    @FXML
    private ListView<String> myListView;

    @FXML
    private Label myLabel;

    String[] food = {"pizza", "sushi", "ramen", "burger"};

    String currentFood;

    @FXML
    private TreeView<String> myTreeView;

    @FXML
    private Label treeLabel;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        myListView.getItems().addAll(food);
        myListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                currentFood = myListView.getSelectionModel().getSelectedItem();
                myLabel.setText(currentFood);
            }
        });

        TreeItem<String> rootItem = new TreeItem<>("Files", new ImageView(new Image(getClass().getResource("/images/folder.png").toExternalForm())));
        TreeItem<String> BranchItem1 = new TreeItem<>("Pictures");
        TreeItem<String> BranchItem2 = new TreeItem<>("Videos");
        TreeItem<String> BranchItem3 = new TreeItem<>("Musics");

        TreeItem<String> LeafItem1 = new TreeItem<>("Picture1");
        TreeItem<String> LeafItem2 = new TreeItem<>("Picture2");
        TreeItem<String> LeafItem3 = new TreeItem<>("Video1");
        TreeItem<String> LeafItem4 = new TreeItem<>("Video2");
        TreeItem<String> LeafItem5 = new TreeItem<>("Music1");
        TreeItem<String> LeafItem6 = new TreeItem<>("Music2");

        myTreeView.setRoot(rootItem);
        rootItem.getChildren().addAll(BranchItem1, BranchItem2, BranchItem3);

        BranchItem1.getChildren().addAll(LeafItem1, LeafItem2);
        BranchItem2.getChildren().addAll(LeafItem3, LeafItem4);
        BranchItem3.getChildren().addAll(LeafItem5, LeafItem6);

//        myTreeView.setShowRoot(false);
    }

    public void selectItem() {
        TreeItem<String> item = myTreeView.getSelectionModel().getSelectedItem();
        if (item != null) {
            treeLabel.setText(item.getValue());
        }
    }


}
