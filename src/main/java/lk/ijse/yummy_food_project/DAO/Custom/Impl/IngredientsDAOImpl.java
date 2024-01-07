package lk.ijse.yummy_food_project.DAO.Custom.Impl;

import lk.ijse.yummy_food_project.DAO.BoFactory;
import lk.ijse.yummy_food_project.DAO.Custom.IngredientsDAO;
import lk.ijse.yummy_food_project.DAO.Custom.PaymentDAO;
import lk.ijse.yummy_food_project.DAO.SqlUtil;
import lk.ijse.yummy_food_project.bo.Custom.PaymentBO;
import lk.ijse.yummy_food_project.db.DbConnection;
import lk.ijse.yummy_food_project.dto.IngredientsDto;
import lk.ijse.yummy_food_project.entity.Ingredients;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class IngredientsDAOImpl implements IngredientsDAO {

    SqlUtil s = new SqlUtil();
   // private BOFactory BoFactory;
     PaymentDAO paymentDAO = new PaymentDAOImpl();
  // PaymentBO paymentBO = (PaymentBO) BoFactory.boFactory().getBoTypes(BoFactory.BOTypes.PAYMENT);
    @Override
    public boolean saveIngredients(Ingredients entity, LocalDate date) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        boolean isSavedPayment = paymentDAO.savePayment(entity.getpId(), entity.getPrice(), date);
        if (isSavedPayment) {
            // boolean isSavedIng = ingModel.saveIngredients(IngredientsDto dto);
            String sql = "INSERT INTO ingredients VALUES(?,?,?,?,?)";
            PreparedStatement pstm = connection.prepareStatement(sql);

            pstm.setString(1, entity.getId());
            pstm.setString(2, entity.getName());
            pstm.setDouble(3, entity.getPrice());
            pstm.setDouble(4, entity.getQty());
            pstm.setString(5, entity.getpId());

            return pstm.executeUpdate() > 0;

        }
        // boolean isSvedDetails = saveDetails(dto.getId(),dto);
        return isSavedPayment;
    }


    @Override
    public ArrayList<Ingredients> getAllIngredients() throws SQLException {
        String sql = "SELECT * FROM  ingredients";
        ResultSet resultSet = s.test(sql);

        ArrayList<Ingredients> dtoList = new ArrayList<>();

        while (resultSet.next()) {
            dtoList.add(
                    new Ingredients(resultSet.getString(1),
                            resultSet.getString(2),
                            resultSet.getDouble(3),
                            resultSet.getDouble(4),
                            resultSet.getString(5)
                    )
            );
        }
        return dtoList;
    }

    @Override
    public IngredientsDto searchIngredientId(String id) throws SQLException {
        String sql = "SELECT * FROM ingredients WHERE ing_id = ?";
        ResultSet resultSet = s.test(sql, id);

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

    @Override
    public String getGenerateIngredientId() throws SQLException {
        String sql = "SELECT ing_id FROM ingredients ORDER BY ing_id DESC LIMIT 1";
        ResultSet resultSet = s.test(sql);

        if(resultSet.next()) {
            return splitIngId(resultSet.getString(1));
        }
        return splitIngId(null);


    }


    private String splitIngId(String currentIngId) {

        /*if(currentIngId != null) {
            String[] split = currentIngId.split("I0");

            int id = Integer.parseInt(split[1]); //01
            id++;
            return "I00" + id;
        } else {
            return "I001";
        }*/
        if(currentIngId != null) {
            String[] split = currentIngId.split("I0");

            int id = Integer.parseInt(split[1]);
            id++;
            if (id<10){
                return "I00" + id;}
            else {
                return "I0"+id;
            }
        } else {
            return "I001";
        }
    }
    @Override
    public List<String> getCmbIngId() {

        List<String> ingIds = new ArrayList<>();


        try {
            String sql = "SELECT ing_id FROM ingredients";
            ResultSet resultSet = s.test(sql);
            while (resultSet.next()) {
                ingIds.add(resultSet.getString("ing_id"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {


        }

        return ingIds;
    }
    @Override
    public boolean updateIngredeient(Ingredients entity, LocalDate date) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        boolean isSavedPayment = paymentDAO.savePayment(entity.getpId(), entity.getPrice(), date);
        if (isSavedPayment) {
            String sql = "UPDATE ingredients SET name = ?  ,price = ? ,qty = ?,p_id WHERE ing_id = ?";
            PreparedStatement pstm = connection.prepareStatement(sql);

            pstm.setString(1,entity.getName());
            pstm.setDouble(2,entity.getPrice());
            pstm.setDouble(3, entity.getQty());
            pstm.setString(4, entity.getpId());
            pstm.setString(5, entity.getId());
            return pstm.executeUpdate() > 0;

        }

        return isSavedPayment;
    }

    @Override
    public ArrayList getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean save(Ingredients dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(Ingredients dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean exist(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public String getGenerate() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public Ingredients search(String newValue) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public List<String> getCmbId() throws SQLException {
        return null;
    }
}
