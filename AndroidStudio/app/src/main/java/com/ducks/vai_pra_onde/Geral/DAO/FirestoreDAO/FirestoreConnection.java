package com.ducks.vai_pra_onde.DAO.FirestoreDAO;
import com.google.firebase.firestore.FirebaseFirestore;
public class FirestoreConnection {
    public static FirebaseFirestore getConnection() {
        return FirebaseFirestore.getInstance();
    }
}