package com.example.javafxworkshop;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.IntegerStringConverter;

import java.time.LocalDate;

public class HelloController {
    private BorderPane root;
    private TableView<Position> tableView;

    public HelloController(){

        root = new BorderPane();
        //header bar
        Label label = new Label("Portfolio");

        //labels for market loss and profit loss
        Label marketValue = new Label("Market Value");
        Label profitLoss = new Label("Profit Loss");

        //header bar label added to hbox
        HBox portfolioBox = new HBox();
        //making vbox
        VBox vBox  = new VBox();
        vBox.setAlignment(Pos.CENTER);
        portfolioBox.getChildren().addAll(label);
        //setting vbox spacing
        vBox.setSpacing(10);

        //making buttons

        Button close = new Button("Close");
        Button buy = new Button("Buy");
        buy.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                buy.setBackground(Background.fill(Color.LIMEGREEN));
            }
        });
        buy.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                buy.setBackground(Background.fill(Color.GREEN));
            }
        });
        buy.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                buy.setBackground(Background.fill(Color.WHITE));
            }
        });
        Button sell = new Button("Sell");
        Button open = new Button("Open");


        //Styling buttons
        close.setTextFill(Color.BLACK);
        close.setBackground(Background.fill(Color.RED));
        sell.setTextFill(Color.BLACK);
        sell.setBackground(Background.fill(Color.RED));
        buy.setTextFill(Color.BLACK);
        buy.setBackground(Background.fill(Color.GREEN));
        open.setTextFill(Color.BLACK);
        open.setBackground(Background.fill(Color.GREEN));

        //menus
        MenuBar menu =new MenuBar();
        Menu fileMenu =new Menu("File");
        Menu editMenu =new Menu("Edit");
        MenuItem openMenuItem = new MenuItem("Open");
        MenuItem closeMenuItem = new MenuItem("Close");
        fileMenu.getItems().addAll(openMenuItem,closeMenuItem);
        MenuItem spell = new MenuItem("SpellCheck");
        editMenu.getItems().add(spell);
        menu.getMenus().addAll(fileMenu,editMenu);

        //setting dropshadow
        DropShadow x = new DropShadow();
        x.setRadius(5.0);
        x.setBlurType(BlurType.THREE_PASS_BOX);
        close.setEffect(x);
        buy.setEffect(x);
        sell.setEffect(x);
        open.setEffect(x);

        //buttonbar
        ButtonBar barOfButtons = new ButtonBar();
        barOfButtons.getButtons().addAll(open,close,buy,sell);

        //setting spacing
        portfolioBox.setSpacing(50);
        //adding to hbox
        HBox marketandprofitloss = new HBox(marketValue,profitLoss);
        marketandprofitloss.setSpacing(50);
        marketandprofitloss.setAlignment(Pos.BASELINE_LEFT);
        portfolioBox.setAlignment(Pos.BASELINE_RIGHT);
        BorderPane.setMargin(marketandprofitloss,new Insets(10));

        portfolioBox.getChildren().setAll(marketandprofitloss,barOfButtons);
        vBox.getChildren().addAll(menu, label,portfolioBox);
        tableView = createTableView();
        this.createPositions();
        //set top to vbox
        root.setTop(vBox);
        root.setCenter(tableView);

    }
    private TableView<Position> createTableView(){
        TableView<Position> table = new TableView<Position>();
        table.getSelectionModel().selectionModeProperty().set(SelectionMode.SINGLE);

        TableColumn<Position, String> tickerColumn = new TableColumn<Position,String>("Ticker");
        tickerColumn.setCellValueFactory(new PropertyValueFactory<Position,String>("symbol"));
        tickerColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        TableColumn<Position,Integer> sharesColumn =new TableColumn<Position, Integer>("Shares");
        sharesColumn.setCellValueFactory(new PropertyValueFactory<Position, Integer>("shares"));
        sharesColumn.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));

        TableColumn<Position,Double> avgPriceColumn =new TableColumn<Position, Double>("AveragePrice");
        avgPriceColumn.setCellValueFactory(new PropertyValueFactory<Position, Double>("averagePrice"));
        avgPriceColumn.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));

        TableColumn<Position,Double> totalCostColumn =new TableColumn<Position, Double>("TotalCost");
        totalCostColumn.setCellValueFactory(new PropertyValueFactory<Position, Double>("totalCost"));
        totalCostColumn.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));

        TableColumn<Position,Double> marketValueColumn =new TableColumn<Position, Double>("MarketValue");
        marketValueColumn.setCellValueFactory(new PropertyValueFactory<Position, Double>("marketValue"));
        marketValueColumn.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));

        TableColumn<Position,Double> lastPriceColumn =new TableColumn<Position, Double>("LastPrice");
        lastPriceColumn.setCellValueFactory(new PropertyValueFactory<Position, Double>("lastPrice"));
        lastPriceColumn.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));

        TableColumn<Position,Double> profitAndLossColumn =new TableColumn<Position, Double>("ProfitLoss");
        profitAndLossColumn.setCellValueFactory(new PropertyValueFactory<Position, Double>("profitAndLoss"));
        profitAndLossColumn.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));


        TableColumn<Position,Double> percentProfitLossColumn =new TableColumn<Position, Double>("PercentProfitLoss");
        percentProfitLossColumn.setCellValueFactory(new PropertyValueFactory<Position, Double>("percentProfitLoss"));
        percentProfitLossColumn.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));

        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        table.getColumns().addAll(tickerColumn,sharesColumn,avgPriceColumn,totalCostColumn,marketValueColumn,profitAndLossColumn,percentProfitLossColumn,lastPriceColumn);




        return table;
    }
    public void createPositions(){
        Position pos1 = new Position("aapl", LocalDate.now(), 123,200);
        Position pos2 = new Position("amzn", LocalDate.now(), 234,120);
        Position pos3 = new Position("tsla", LocalDate.now(), 324,50);
        Position pos4 = new Position("msft", LocalDate.now(), 321,150);
        tableView.getItems().addAll(pos1,pos2,pos3,pos4);
    }

    public BorderPane getRoot(){
        return root;
    }
}
