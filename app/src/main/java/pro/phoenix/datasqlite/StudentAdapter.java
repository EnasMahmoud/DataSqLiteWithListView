package pro.phoenix.datasqlite;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

/**
 * Created by ANNAS on 1/9/2018.
 */

public class StudentAdapter extends CursorAdapter {

    public StudentAdapter(Context context, Cursor c) {
        super(context, c, 0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.item_list , parent , false);
    }


    @Override
    public void bindView(View view, Context context, Cursor cursor) {

        TextView idView , nameView , genderView;
        idView = view.findViewById(R.id.idView);
        nameView = view.findViewById(R.id.nameView);
        genderView = view.findViewById(R.id.genderView);

        idView.setText(cursor.getInt(0)+"");
        nameView.setText(cursor.getString(1)+"");
        genderView.setText(cursor.getInt(2)+"");
    }
}
