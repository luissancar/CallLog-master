package com.foc.pmdm.u5.calllog;

/**
 * Created by javacasm on 11/12/2015.
 */

import android.app.Activity;
import android.database.Cursor;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;



public class miAdaptador extends BaseAdapter {

    private Activity actividad;
    private Cursor cursor;
    public miAdaptador(Activity act,Cursor c)
    {
        this.actividad=act;
        this.cursor=c;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return cursor.getCount();
    }

    @Override
    public Object getItem(int arg0) {
        // TODO Auto-generated method stub
        return "Objeto "+arg0;
    }

    @Override
    public long getItemId(int arg0) {
        // TODO Auto-generated method stub
        return arg0;
    }

    @Override
    public View getView(int arg0, View arg1, ViewGroup arg2) {
        // TODO Auto-generated method stub
        LayoutInflater li= actividad.getLayoutInflater();
        View view=li.inflate(R.layout.layout_fila, null,true);
        TextView tvTelefono=(TextView)view.findViewById(R.id.tvTelefono);
        TextView tvFecha=(TextView)view.findViewById(R.id.tvFecha);
        cursor.moveToPosition(arg0);
        tvTelefono.setText("Tfno:"+cursor.getString(0));
        tvFecha.setText("Fecha:"+ DateFormat.format("dd/MM/yy k:m ", cursor.getLong(1)));
        return view;
    }

}
