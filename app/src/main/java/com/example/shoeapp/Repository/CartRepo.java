package com.example.shoeapp.Repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.shoeapp.Dao.CartDAO;
import com.example.shoeapp.Database.CartDatabase;
import com.example.shoeapp.Utils.model.ShoeCart;

import java.lang.reflect.Executable;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class CartRepo {

    private CartDAO cartDAO;

    private LiveData<List<ShoeCart>> allCartItemsLiveData;
    public LiveData<List<ShoeCart>> getGetAllCartItemsLiveData() {
        return allCartItemsLiveData;
    }


    private Executor executor = Executors.newSingleThreadExecutor();

    public CartRepo(Application application){
        cartDAO = CartDatabase.getInstance(application).cartDAO();
        allCartItemsLiveData = cartDAO.getAllCartItems();
    }

    public void insertItem(ShoeCart shoeCart){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                cartDAO.insertCartItem(shoeCart);
            }
        });
    }
    public void deleteCartItem(ShoeCart shoeCart){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                cartDAO.deleteCartItem(shoeCart);
            }
        });
    }
    public void deleteAllItems(){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                cartDAO.deleteALlItems();
            }
        });
    }

    public void updatePrice(int id , double price){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                cartDAO.updatePrice(id, price);
            }
        });
    }

    public void updateQuantity(int id  , int quantity){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                cartDAO.updateQuantity(id , quantity);
            }
        });
    }
}
