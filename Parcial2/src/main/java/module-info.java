module co.edu.uniquindio.poo.parcial2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens co.edu.uniquindio.poo.parcial2 to javafx.fxml;
    exports co.edu.uniquindio.poo.parcial2;
    exports co.edu.uniquindio.poo.parcial2.logica;
    opens co.edu.uniquindio.poo.parcial2.logica to javafx.fxml;
    exports co.edu.uniquindio.poo.parcial2.Estructuras;
    opens co.edu.uniquindio.poo.parcial2.Estructuras to javafx.fxml;
}