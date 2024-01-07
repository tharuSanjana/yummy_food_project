package lk.ijse.yummy_food_project.model;

public class SupModel {
   /* SqlUtil s = new SqlUtil();

    public List<ViewSupIngDto> getAllSupIng() throws SQLException {

        String sql = "SELECT * FROM supplier_ingredients_details";
        ResultSet resultSet = s.test(sql);
        ArrayList<ViewSupIngDto> dtoList = new ArrayList<>();

        while(resultSet.next()){
            dtoList.add(
                    new ViewSupIngDto(resultSet.getString(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getString(4),
                            resultSet.getDouble(5),
                            resultSet.getString(6)

                    )
            );
        }
        return dtoList;

    }
    public boolean saveSupIng(ViewSupIngDto viewDto) throws SQLException {
        String sql = "INSERT INTO supplier_ingredients_details VALUES(?, ?, ?, ? ,? ,?)";
        Boolean test = s.test(sql, viewDto.getSupId(), viewDto.getIngId(), viewDto.getSupName(), viewDto.getIngName(), viewDto.getTotal(), viewDto.getPId());

       return test;

    }*/
    }

