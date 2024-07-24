module com.kalmunrir.charactercache {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.xerial.sqlitejdbc;
    requires java.sql;
    requires unirest.java;
    requires org.json;
    opens com.kalmunrir.charactercache to javafx.fxml;
    exports com.kalmunrir.charactercache;
    exports com.kalmunrir.charactercache.Database.Models;
}