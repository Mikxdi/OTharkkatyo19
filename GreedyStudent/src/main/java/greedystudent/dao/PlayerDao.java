/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package greedystudent.dao;
import java.sql.*; 
import greedystudent.domain.Player;

/**
 *
 * Class responsible of database connections
 * and database usage
 */
public class PlayerDao {
    private final String url;
    /**
     * Creates database constructor
     */
    public PlayerDao() {
        this.url = "jdbc:sqlite:players.db";
        initDatabase();
    }
    private Connection connect() {
        Connection conn = null;

        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
    
    /**
     * Initializes database with given specs
     */
    private void initDatabase() {

        String sql = "CREATE TABLE IF NOT EXISTS Players ("
                + "id INTEGER PRIMARY KEY, "
                + "name VARCHAR(20), "
                + "levelspassed INTEGER);";

        try (Connection conn = this.connect();
            Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            stmt.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    /**
     * Saves player to database if doesnt exist and returns player contructor
     * 
     * @param name Username in game
     * @return Returns Player to Ui
     */
    public Player addOrGetPlayer(String name) {
        String sql = "SELECT * FROM Players WHERE "
                + "Players.name == ? ;";
        try (Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            ResultSet rs = pstmt.executeQuery();
            if (!rs.next()) {
                sql = "INSERT INTO Players (name, levelspassed) "
                        + "VALUES (?,?)";
                try (Connection conne = this.connect();
                PreparedStatement pstmt2 = conne.prepareStatement(sql)) {
                    pstmt2.setString(1, name);
                    pstmt2.setInt(2, 0);
                    pstmt2.executeUpdate();
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
                Player player = new Player(name, 0);
                return player;
            } else {
                Player player = new Player(rs.getString("name"), rs.getInt("levelspassed"));
                return player;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    
    /** 
     * Updates how many levels player has succesfully passed
     * @param player Player who is currently active
     */
    public void updatePlayer(Player player) {
        String sql = "UPDATE Players SET levelspassed = ? "
                + "WHERE name = ?;";
        try (Connection conne = this.connect();
        PreparedStatement pstmt2 = conne.prepareStatement(sql)) {
            pstmt2.setInt(1, player.getLevelsPassed());
            pstmt2.setString(2, player.getName());
            pstmt2.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
