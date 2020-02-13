package main.infrastructure;

import main.human_resources.Employee;
import main.infrastructure.lhc.experiment.IBlock;
import main.infrastructure.lhc.experiment.IExperiment;
import main.infrastructure.security.EmployeeIDCard;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseManager {
    private final String driverName = "jdbc:hsqldb:";

    private Connection connection;

    public void setupConnection() {
        System.out.println("--- setupConnection");

        try {
            Class.forName("org.hsqldb.jdbcDriver");
            String databaseURL = driverName + Configuration.instance.dataBaseFile;
            connection = DriverManager.getConnection(databaseURL, Configuration.instance.username, Configuration.instance.password);
            System.out.println("connection : " + connection);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public synchronized void update(String sqlStatement) {
        try {
            Statement statement = connection.createStatement();
            int result = statement.executeUpdate(sqlStatement);

            if (result == -1) {
                System.out.println("error executing " + sqlStatement);
            }

            statement.close();
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        }
    }

    public void createEmployeeTable() {
        String sql = "CREATE TABLE employee (" +
                "id INTEGER NOT NULL, " +
                "name VARCHAR(256) NOT NULL, " +
                "iris VARCHAR(8000) NOT NULL, " +
                "cardId VARCHAR(256), " +
                "fingerPrint VARCHAR(256) NOT NULL, " +
                "PRIMARY KEY (id))";
        update(sql);
    }

    public void createIDCardTable() {
        String sql = "CREATE TABLE idcard (" +
                "id VARCHAR(256) NOT NULL, " +
                "validFrom DATE NOT NULL, " +
                "validDate DATE NOT NULL, " +
                "iris VARCHAR(8000) NOT NULL, " +
                "isLocked BOOLEAN NOT NULL, " +
                "permissions VARCHAR(256) NOT NULL, " +
                "invalidPwdCnt INT NOT NULL, " +
                "personId INT NULL, " +
                "password VARCHAR(256) NOT NULL, " +
                "fingerPrint VARCHAR(256) NOT NULL, " +
                "PRIMARY KEY (id))";
        update(sql);
    }

    public void createExperimentTable() {
        String sql = "CREATE TABLE experiment (" +
                "id VARCHAR(256) NOT NULL, " +
                "dateTimeStamp VARCHAR(256) NOT NULL, " +
                "isHiggsBosonFound BOOLEAN NOT NULL, " +
                "protonId1 INT NOT NULL, " +
                "protonId2 INT NOT NULL, " +
                "PRIMARY KEY (id))";
        update(sql);
        this.createBlockTable();
    }

    private void createBlockTable() {
        String sql = "CREATE TABLE block (" +
                "id VARCHAR(256) NOT NULL, " +
                "structure VARCHAR(256) NOT NULL, " +
                "experimentId VARCHAR(256) NOT NULL, " +
                "PRIMARY KEY (id))";
        update(sql);
    }

    public void insertEmployee(Employee employee) {
        String sql = "INSERT INTO employee VALUES (" +
                employee.getDataBaseString() + ")";
        update(sql);
    }

    public void insertIDCard(EmployeeIDCard idCard) {
        String sql = "INSERT INTO idcard VALUES (" +
                idCard + ")";
        update(sql);
    }

    public void insertExperiment(IExperiment experiment) {
        String sql = "INSERT INTO experiment VALUES (" +
                experiment.getSQLString() + ")";
        update(sql);

        for (int i = 0; i < 200000; i++) {
            this.insertBlock(experiment.getBlock(i), experiment);
        }
    }

    private void insertBlock(IBlock block, IExperiment experiment) {
        String sql = "INSERT INTO block VALUES (" +
                block + ", '" + experiment.getID() + "')";
        update(sql);
    }
}
