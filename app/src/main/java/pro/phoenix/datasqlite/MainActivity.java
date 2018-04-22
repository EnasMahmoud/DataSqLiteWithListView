package pro.phoenix.datasqlite;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    /* V2
     * 0- Design Contract Class.
     * 1- Connect Database , Create Class extends SqliteOpenHelper.
     * 2- row items  XML.
     * 3- ListView
     * 4- Adapter extends CursorAdapter
     * 5- obj Helper , obj SQLiteDatabase , obj Adapter
     * */

    ListView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyHelper myHelper = new MyHelper(this);
        /*SQLiteDatabase sqlLiteDBW = myHelper.getWritableDatabase();

        ContentValues values= new ContentValues();

        values.put(StudentContract.StudentData.NAME , "Ahmed");
        values.put(StudentContract.StudentData.GENDER , StudentContract.StudentData.MALE);
        sqlLiteDBW.insert(StudentContract.StudentData.TABLE_NAME , null , values);

        values.put(StudentContract.StudentData.NAME , "Mohamed");
        values.put(StudentContract.StudentData.GENDER , StudentContract.StudentData.MALE);
        sqlLiteDBW.insert(StudentContract.StudentData.TABLE_NAME , null , values);

        values.put(StudentContract.StudentData.NAME , "Enas");
        values.put(StudentContract.StudentData.GENDER , StudentContract.StudentData.FEMALE);
        sqlLiteDBW.insert(StudentContract.StudentData.TABLE_NAME , null , values);

        values.put(StudentContract.StudentData.NAME , "Esraa");
        values.put(StudentContract.StudentData.GENDER , StudentContract.StudentData.FEMALE);
         sqlLiteDBW.insert(StudentContract.StudentData.TABLE_NAME , null , values);
*/

        SQLiteDatabase sqlLiteDBR = myHelper.getReadableDatabase();
        Cursor c = sqlLiteDBR.query(StudentContract.StudentData.TABLE_NAME , null , null , null , null ,null ,null);
        list = findViewById(R.id.memberList);
        StudentAdapter obj = new StudentAdapter( this , c);
        list.setAdapter(obj);
    }
}
