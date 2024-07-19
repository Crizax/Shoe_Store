package com.example.shoeapp.Viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.shoeapp.Repository.CartRepo;
import com.example.shoeapp.Utils.model.ShoeCart;

import java.util.List;

public class CartViewModel extends AndroidViewModel {

    private CartRepo cartRepo;
    public CartViewModel(@NonNull Application application) {
        super(application);
        cartRepo = new CartRepo(application);
    }
    public LiveData<List<ShoeCart>> getAllCartItems(){
        return cartRepo.getGetAllCartItemsLiveData();
    }

    public void insertCartItem(ShoeCart shoeCart){
        cartRepo.insertItem(shoeCart);
    }

    public void deleteCartItem(ShoeCart shoeCart){
        cartRepo.deleteCartItem(shoeCart);
    }

    public void updatePrice(int id , double price){
        cartRepo.updatePrice(id , price);
    }

    public void updateQuantity(int id , int quantity){
        cartRepo.updateQuantity(id , quantity);
    }

    public void deleteAllCartItems(){
        cartRepo.deleteAllItems();
    }
}
