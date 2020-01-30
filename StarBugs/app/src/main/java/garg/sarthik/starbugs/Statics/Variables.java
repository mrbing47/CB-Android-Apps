package garg.sarthik.starbugs.Statics;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.messaging.FirebaseMessaging;

import garg.sarthik.starbugs.POJO.User;

public class Variables {

    public static FirebaseFirestore db;
    public static FirebaseMessaging fcm;
    public static FirebaseAuth fireAuth;
    public static FirebaseUser fireUser;

    public static CollectionReference colUser;
    public static  CollectionReference colCamera;

    public static User user;


}
