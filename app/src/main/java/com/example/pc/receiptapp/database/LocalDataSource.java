package com.example.pc.receiptapp.database;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

public class LocalDataSource {

    public static void save(RealmReceipt realmReceipt) {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        realm.copyToRealmOrUpdate(realmReceipt); // Persist unmanaged objects
        realm.commitTransaction();
        realm.close();
    }

    public static List<RealmReceipt> getAll() {
        Realm realm = Realm.getDefaultInstance();
        final RealmResults<RealmReceipt> receiptRealmResults = realm.where(RealmReceipt.class).findAll();

        List<RealmReceipt> realmReceipts = new ArrayList<>();
        List<RealmReceipt> copiedResult = realm.copyFromRealm(receiptRealmResults);
        realm.close();

        realmReceipts.addAll(copiedResult);
        return realmReceipts;
    }

    public static void delete(RealmReceipt realmReceipt) {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        final RealmResults<RealmReceipt> receiptRealmResults =
                realm.where(RealmReceipt.class).equalTo("id", realmReceipt.getId()).findAll();
        receiptRealmResults.deleteAllFromRealm();
        realm.commitTransaction();
        realm.close();
    }
}
