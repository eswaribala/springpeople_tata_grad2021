package com.Tata.ShoppersDen.Entity;

import com.Tata.ShoppersDen.Dao.DatabaseAccess;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.sql.SQLException;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper=false)
public final class Admin extends Person{
    private String adminName;
    private String adminId;
    private String adminPassword;
    private DatabaseAccess databaseAccess;

    public List<Transaction> getAllTransactions(){
        return databaseAccess.getAllTransaction();
    }

    public boolean addProduct(Product product){
        try{
            databaseAccess.addProduct(product);
            return true;
        }
        catch (SQLException error){
            error.printStackTrace();
        }
        return false;
    }

    public boolean addCategory(Category category){
        try{
            databaseAccess.addCategory(category);
        }
        catch (SQLException error){
            error.printStackTrace();
        }
        return false;
    }

    public boolean clearAllData(){
        return databaseAccess.clearAllData();
    }

    public void deleteCategory(Category category) throws SQLException {
        databaseAccess.removeCategory(category);
    }

    public void deleteProduct(Product product) throws SQLException{
        databaseAccess.removeProduct(product);
    }
}
