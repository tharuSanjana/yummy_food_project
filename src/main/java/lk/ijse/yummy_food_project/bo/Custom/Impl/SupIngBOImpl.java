package lk.ijse.yummy_food_project.bo.Custom.Impl;

import lk.ijse.yummy_food_project.DAO.Custom.CustomerDAO;
import lk.ijse.yummy_food_project.DAO.Custom.Impl.SupIngDAOImpl;
import lk.ijse.yummy_food_project.DAO.Custom.SupIngDAO;
import lk.ijse.yummy_food_project.DAO.DAOFactory;
import lk.ijse.yummy_food_project.bo.Custom.SupIngBO;
import lk.ijse.yummy_food_project.dto.ViewSupIngDto;
import lk.ijse.yummy_food_project.entity.ViewSupIng;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SupIngBOImpl implements SupIngBO {
   // SupIngDAO supIngDAO = new SupIngDAOImpl();
    SupIngDAO supIngDAO = (SupIngDAO) DAOFactory.daoFactory().getDAOTypes(DAOFactory.DAOTypes.SUP_ING);

    @Override
    public List<ViewSupIngDto> getAllSupIng() throws SQLException {
        ArrayList<ViewSupIngDto> viewSupIngDtos = new ArrayList<>();
        List<ViewSupIng> allSupIng = supIngDAO.getAllSupIng();
        for (ViewSupIng viewSupIng:allSupIng){
            viewSupIngDtos.add(new ViewSupIngDto(viewSupIng.getSupId(),viewSupIng.getIngId(),viewSupIng.getSupName(),viewSupIng.getIngName(),viewSupIng.getTotal(),viewSupIng.getPId()));
        }
        return viewSupIngDtos;
    }


    @Override
    public boolean saveSupIng(ViewSupIngDto view) throws SQLException {
        return supIngDAO.saveSupIng(new ViewSupIng(view.getSupId(),view.getIngId(),view.getSupName(),view.getIngName(),view.getTotal(),view.getPId()));
    }
}
