package lk.ijse.yummy_food_project.model;

import lk.ijse.yummy_food_project.db.DbConnection;
import lk.ijse.yummy_food_project.dto.IngredientsDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class IngredientsModel {

    /*private PaymentModel pModel = new PaymentModel();

    public boolean saveIngredients(IngredientsDto dto, LocalDate date) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        boolean isSavedPayment = pModel.savePayment(dto.getpId(), dto.getPrice(), date);
        if (isSavedPayment) {
            // boolean isSavedIng = ingModel.saveIngredients(IngredientsDto dto);
            String sql = "INSERT INTO ingredients VALUES(?,?,?,?,?)";
            PreparedStatement pstm = connection.prepareStatement(sql);

            pstm.setString(1, dto.getId());
            pstm.setString(2, dto.getName());
            pstm.setDouble(3, dto.getPrice());
            pstm.setDouble(4, dto.getQty());
            pstm.setString(5, dto.getpId());

            return pstm.executeUpdate() > 0;

        }
       // boolean isSvedDetails = saveDetails(dto.getId(),dto);
        return isSavedPayment;
    }



    public ArrayList<IngredientsDto> getAllIngredients() throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "SELECT * FROM  ingredients";
        PreparedStatement pstm = connection.prepareStatement(sql);
        ResultSet resultSet = pstm.executeQuery();

        ArrayList<IngredientsDto> dtoList = new ArrayList<>();

        while (resultSet.next()) {
            dtoList.add(
                    new IngredientsDto(resultSet.getString(1),
                            resultSet.getString(2),
                            resultSet.getDouble(3),
                            resultSet.getDouble(4),
                            resultSet.getString(5)
                    )
            );
        }
        return dtoList;
    }

    public boolean updateIngredients(IngredientsDto dto) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "UPDATE ingredients SET name = ? ,price = ? ,qty = ?  WHERE ing_id = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1,dto.getName());
        pstm.setDouble(2,dto.getPrice());
        pstm.setDouble(3,dto.getQty());
        pstm.setString(4,dto.getId());


        return pstm.executeUpdate() > 0;

    }
    public IngredientsDto searchIngredientId(String id) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection ();

        String sql = "SELECT * FROM ingredients WHERE ing_id = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, id);

        ResultSet resultSet = pstm.executeQuery();

        IngredientsDto dto = null;

        if(resultSet.next()) {
            String ing_id = resultSet.getString(1);
            String name = resultSet.getString(2);
            double price= Double.parseDouble(resultSet.getString(3));
            double qty = Double.parseDouble(resultSet.getString(4));
            String pId = resultSet.getString(5);
            dto = new IngredientsDto(ing_id, name, price, qty,pId);
        }
        return dto;
    }


    public  boolean saveDetails(String ingId, String supId) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "INSERT INTO supplier_ingredients_details VALUES(?, ?)";
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1, supId);
        pstm.setString(2, ingId);


        return pstm.executeUpdate() > 0;
    }


    public String getGenerateIngredientId() throws SQLException {

        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "SELECT ing_id FROM ingredients ORDER BY ing_id DESC LIMIT 1";
        PreparedStatement pstm = connection.prepareStatement(sql);

        ResultSet resultSet = pstm.executeQuery();
        if(resultSet.next()) {
            return splitIngId(resultSet.getString(1));
        }
        return splitIngId(null);

    }

    private String splitIngId(String currentIngId) {

        if(currentIngId != null) {
            String[] split = currentIngId.split("I0");

            int id = Integer.parseInt(split[1]); //01
            id++;
            return "I00" + id;
        } else {
            return "I001";
        }
    }
    public List<String> getCmbIngId() {
        Connection connection = null;
        List<String> ingIds = new ArrayList<>();
        String query = "SELECT ing_id FROM ingredients";

        try {
            connection = DbConnection.getInstance().getConnection();
            PreparedStatement pstm = connection.prepareStatement(query);
            ResultSet resultSet = pstm.executeQuery();

            while (resultSet.next()) {
                ingIds.add(resultSet.getString("ing_id"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {

            if (connection != null) {
                // connection.close();
            }
        }

        return ingIds;
    }
    public boolean updateIngredeient(IngredientsDto dto, LocalDate date) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        boolean isSavedPayment = pModel.savePayment(dto.getpId(), dto.getPrice(), date);
        if (isSavedPayment) {
            String sql = "UPDATE ingredients SET name = ?  ,price = ? ,qty = ?,p_id WHERE ing_id = ?";
            PreparedStatement pstm = connection.prepareStatement(sql);

            pstm.setString(1,dto.getName());
            pstm.setDouble(2,dto.getPrice());
            pstm.setDouble(3, dto.getQty());
            pstm.setString(4, dto.getpId());
            pstm.setString(5, dto.getId());
            return pstm.executeUpdate() > 0;

        }

        return isSavedPayment;
    }
public List<String> getCmbIngredientId(){

        Connection connection = null;
        List<String> ingIds = new ArrayList<>();
        String query = "SELECT ing_id FROM ingredients";

        try {
            connection = DbConnection.getInstance().getConnection();
            PreparedStatement pstm = connection.prepareStatement(query);
            ResultSet resultSet = pstm.executeQuery();

            while (resultSet.next()) {
                ingIds.add(resultSet.getString("ing_id"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {

            if (connection != null) {
                // connection.close();
            }
        }

        return ingIds;
    }*/

}


