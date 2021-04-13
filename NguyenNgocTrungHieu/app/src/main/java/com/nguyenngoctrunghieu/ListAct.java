package com.nguyenngoctrunghieu;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import androidx.appcompat.app.AppCompatActivity;

import database.DBHelper;

public class ListAct extends AppCompatActivity {
    private DBHelper db;
    private Cursor c;
    private SimpleCursorAdapter adapter;

    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.list_activity);

        db = new DBHelper(this);
        ListView lvActivity =(ListView)findViewById(R.id.lvActivity);

        c = db.getActivity();

        adapter = new SimpleCursorAdapter(this, R.layout.item_activity, c, new String[]{
                DBHelper.ID,DBHelper.NAME, DBHelper.QUANTITY}, new int[]{R.id.tvId, R.id.tvName1,R.id.tvQuantity2}, CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);
lvActivity.setAdapter(adapter);

lvActivity.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Cursor cursor =(Cursor) adapter.getItem(position);
        int _id = cursor.getInt(cursor.getColumnIndex(DBHelper.ID));
        String name = cursor.getString(cursor.getColumnIndex(DBHelper.NAME));
        String quantity = cursor.getString(cursor.getColumnIndex(DBHelper.QUANTITY));

        Intent intent = new Intent(ListAct.this,null);
        intent.putExtra(DBHelper.ID,_id);
        intent.putExtra(DBHelper.NAME,name);
        intent.putExtra(DBHelper.QUANTITY,quantity);
        startActivity(intent);

    }
});
    }
@Override
    protected void onStart(){
        super.onStart();
        c = db.getAllActivity();
        adapter.changeCursor(c);
        adapter.notifyDataSetChanged();
        db.close();
}
}
