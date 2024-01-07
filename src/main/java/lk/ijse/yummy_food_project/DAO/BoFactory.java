package lk.ijse.yummy_food_project.DAO;

import lk.ijse.yummy_food_project.bo.Custom.Impl.*;

public class BoFactory {

   public static BoFactory boFactory;
    private BoFactory(){

    }
    public static BoFactory boFactory(){
        return boFactory == null? boFactory = new BoFactory():boFactory;
    }

    public void getBo(){

    }

    public enum BOTypes{
        CUSTOMER,EMPLOYEE,FOOD,INGREDIENTS,LOGIN,ORDER,ORDER_DETAIL,PAYMENT,SUP_ING,SUPPLIER,USER
    }
    public SuperBO getBoTypes(BOTypes boTypes){
        switch (boTypes){
            case CUSTOMER :
                return new CustomerBOImpl();
            case EMPLOYEE:
                return new EmployeeBOImpl();
            case FOOD:
                return  new FoodBOImpl();
            case INGREDIENTS:
                return  new IngredientsBOImpl();
            case LOGIN:
                return  new LoginBOImpl();
            case ORDER:
                return new OrderBOImpl();
            case ORDER_DETAIL:
                return new OrderDetailBOImpl();
            case PAYMENT:
                return new PaymentBOImpl();
            case SUP_ING:
                return new SupIngBOImpl();
            case SUPPLIER:
                return new SupplierBOImpl();
            case USER:
                return new UserBOImpl();
            default:
                return null;

        }

    }
}
