package com.sagaraharasgama.it17387972;

import android.provider.BaseColumns;

public final class UserProfile implements BaseColumns {

    private UserProfile() {
    }


    public static class Users {

        public static String getDatabaseName() {
            return DATABASE_NAME;
        }

        public static String getColumnNameUserid() {
            return COLUMN_NAME_USERID;
        }

        public static String getColumnNameUsername() {
            return COLUMN_NAME_USERNAME;
        }

        public static String getColumnNameUsergender() {
            return COLUMN_NAME_USERGENDER;
        }

        public static String getColumnNameUserdob() {
            return COLUMN_NAME_USERDOB;
        }

        public static String getColumnNameUserpassword() {
            return COLUMN_NAME_USERPASSWORD;
        }

        public static final String DATABASE_NAME = "userInfo";
        public static final String COLUMN_NAME_USERID = "userID";
        public static final String COLUMN_NAME_USERNAME = "userName";
        public static final String COLUMN_NAME_USERGENDER = "userGender";
        public static final String COLUMN_NAME_USERDOB = "userDOB";
        public static final String COLUMN_NAME_USERPASSWORD = "userPassword";
    }
}

