package lk.ijse.yummy_food_project.DAO;

import lk.ijse.yummy_food_project.DAO.Custom.Impl.*;
import lk.ijse.yummy_food_project.bo.Custom.Impl.*;

public class DAOFactory {
    public static DAOFactory daoFactory;
    private DAOFactory(){

    }
    public static DAOFactory daoFactory(){
        return daoFactory == null? daoFactory = new DAOFactory():daoFactory;
    }

    public void getDAO(){

    }

    public enum DAOTypes{
        CUSTOMER,EMPLOYEE,FOOD,INGREDIENTS,LOGIN,ORDER,ORDER_DETAIL,PAYMENT,SUP_ING,SUPPLIER,USER
    }
    public SuperDAO getDAOTypes(DAOFactory.DAOTypes daoTypes){
        switch (daoTypes){
            case CUSTOMER :
                return  new CustomerDAOImpl();
            case EMPLOYEE:
                return new EmployeeDAOImpl();
            case FOOD:
                return  new FoodDAOImpl();
            case INGREDIENTS:
                return  new IngredientsDAOImpl();
            case LOGIN:
                return  new LoginDAOImpl();
            case ORDER:
                return new OrderDAOImpl();
            case ORDER_DETAIL:
                return new OrderDetailDAOImpl();
            case PAYMENT:
                return new PaymentDAOImpl();
            case SUP_ING:
                return new SupIngDAOImpl();
            case SUPPLIER:
                return new SupplierDAOImpl();
            case USER:
                return new UserDAOImpl();
            default:
                return null;

        }

    }
}
