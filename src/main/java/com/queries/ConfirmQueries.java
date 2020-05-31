package com.queries;

import com.entities.Confirm;
import com.project4.utils.Database;

import java.sql.SQLException;

public class ConfirmQueries {

    public void insertConfirmation(Confirm confirm) throws SQLException, ClassNotFoundException {
        Database db = new Database();
        db.openConnection();
        db.executeUpdate("INSERT INTO confirm VALUES " + confirm.toInsertValue());
        db.closeConnection();
    }
}
