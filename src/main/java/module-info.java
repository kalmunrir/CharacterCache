module com.kalmunrir.charactercache {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.kalmunrir.charactercache to javafx.fxml;
    exports com.kalmunrir.charactercache;
}