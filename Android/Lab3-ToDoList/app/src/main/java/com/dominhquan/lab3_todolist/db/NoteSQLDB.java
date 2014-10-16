package com.dominhquan.lab3_todolist.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class NoteSQLDB extends SQLiteOpenHelper {

	public NoteSQLDB(Context context) {
		super(context, Note.DB_NAME, null, Note.DB_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase sqlDB) {
		String sqlQuery =
				String.format("CREATE TABLE %s (" +
                                "_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                "%s TEXT)", Note.TABLE,
                        Note.Columns.TASK);
		sqlDB.execSQL(sqlQuery);
	}

	@Override
	public void onUpgrade(SQLiteDatabase sqlDB, int i, int i2) {
		sqlDB.execSQL("DROP TABLE IF EXISTS "+ Note.TABLE);
		onCreate(sqlDB);
	}
}
