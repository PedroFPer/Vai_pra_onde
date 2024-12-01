package com.ducks.vai_pra_onde.Geral.DAO;
import com.google.firebase.firestore.FirebaseFirestore;
public class ConnectionDB {
    public static FirebaseFirestore connect() {
        return FirebaseFirestore.getInstance();
    }
}