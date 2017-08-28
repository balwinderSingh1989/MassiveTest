package com.massive.deliveries.test.data.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.massive.deliveries.test.data.network.model.Deliveries;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Balwinder Rajput on 24-08-2017.
 * Copyright (c) 2017 L&T Technology Services. All rights reserved.
 */

public class DeliverableDAO  {


    private static final String TAG = "DeliverableDAO";

    DbOpenHelper mDbmanager;

    DeliverableDAO(DbOpenHelper dbOpenHelper)
    {
        this.mDbmanager = dbOpenHelper;
    }

    public  List<Deliveries> getData() {

        SQLiteDatabase sqLiteDatabase = null;

        Deliveries deleiveries;
        List<Deliveries> lstDeliveries = new ArrayList<>();

        Cursor cursor = null;
        try {
            sqLiteDatabase = mDbmanager.getWritableDatabase();
            String selectQuery = "SELECT  * FROM " + TableMaster.tblDeliveries.TABLE_NAME;
            cursor = sqLiteDatabase.rawQuery(selectQuery, null);

            if (cursor.moveToFirst()) {
                do {
                    deleiveries = new Deliveries();
                    deleiveries.setImageUrl(cursor.getString(cursor.getColumnIndex(TableMaster.tblDeliveries.IMAGEURL)));
                    deleiveries.setDescription(cursor.getString(cursor.getColumnIndex(TableMaster.tblDeliveries.DESCRIPTION)));

                    Deliveries.Location localtion = new Deliveries.Location();
                    localtion.setLat( Double.parseDouble(cursor.getString(cursor.getColumnIndex(TableMaster.tblDeliveries.LAT))));
                    localtion.setLng( Double.parseDouble(cursor.getString(cursor.getColumnIndex(TableMaster.tblDeliveries.LON))));
                    localtion.setAddress(cursor.getString(cursor.getColumnIndex(TableMaster.tblDeliveries.ADDRESS)));
                    deleiveries.setLocation(localtion);

                    lstDeliveries.add(deleiveries);
                } while (cursor.moveToNext());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (cursor != null)
                cursor.close();
            sqLiteDatabase.close();
        }
        return lstDeliveries;
    }

    public void insertData(List<Deliveries> data) {
        insertDevice(data);
    }

    public void insertDevice(List<Deliveries> lstdeliveries) {

        SQLiteDatabase sqLiteDatabase = null;
        sqLiteDatabase = mDbmanager.getWritableDatabase();
        sqLiteDatabase.delete(TableMaster.tblDeliveries.TABLE_NAME,null,null);

        ContentValues contentValues = new ContentValues();
        for (Deliveries mDeliveries: lstdeliveries) {
        contentValues.put(TableMaster.tblDeliveries.DESCRIPTION, mDeliveries.getDescription());
        contentValues.put(TableMaster.tblDeliveries.IMAGEURL, mDeliveries.getImageUrl());
        contentValues.put(TableMaster.tblDeliveries.ADDRESS, mDeliveries.getLocation().getAddress());
        contentValues.put(TableMaster.tblDeliveries.LAT, mDeliveries.getLocation().getLat());
        contentValues.put(TableMaster.tblDeliveries.LON, mDeliveries.getLocation().getLng());
       if( sqLiteDatabase.insert(TableMaster.tblDeliveries.TABLE_NAME, null, contentValues) > 0)
           Log.d(TAG, "inserted");
        }
        sqLiteDatabase.close();

    }






}
