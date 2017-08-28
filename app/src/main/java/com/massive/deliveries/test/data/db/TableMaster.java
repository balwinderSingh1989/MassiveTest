package com.massive.deliveries.test.data.db;

/**
 * Created by Balwinder Rajput on 24-08-2017.
 * Copyright (c) 2017 L&T Technology Services. All rights reserved.
 */

public class TableMaster {


    public static final String TYPE_TEXT = " TEXT ",
            TYPE_INTEGER = " INTEGER ",
                _ID = "_id";
    public static final String _id = _ID + TYPE_INTEGER
            + " PRIMARY KEY AUTOINCREMENT ";

    public  interface tblDeliveries {

        String TABLE_NAME = "tblDeliveries",
                DESCRIPTION = "mac",
                IMAGEURL = "imageUrl",
                LAT="lat",
                LON= "long",
                ADDRESS= "address";

        String CREATE_TABLE = "create TABLE IF NOT EXISTS " + TABLE_NAME
                + "(" + DESCRIPTION + TYPE_TEXT + ", "
                + IMAGEURL + TYPE_TEXT + ", "
                + LAT + TYPE_TEXT + ", "
                + LON + TYPE_TEXT + ", "
                + ADDRESS + TYPE_TEXT + ")";
    }



}
