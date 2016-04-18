package com.foc.pmdm.u5.calllog;

import android.database.Cursor;
import android.net.Uri;
import android.provider.CallLog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        try {
            Uri llamadas = Uri.parse("content://call_log/calls/");
            Cursor c = getContentResolver().query(llamadas, new String[]{CallLog.Calls.NUMBER, CallLog.Calls.DATE}, null, null, null);
            //Cursor c=getContentResolver().query(llamadas, null, null, null, null);


            // TODO: Hacer una consulta con resumen del número de llamadas por número (group by)
            // TODO: añadir información de duración de las llamadas

            ListView lv = (ListView) findViewById(R.id.listView);
            TextView tvNoData=(TextView)findViewById(R.id.tvNodata);
            if(c!=null && c.getCount()!=0) {
                tvNoData.setVisibility(View.INVISIBLE);
                lv.setVisibility(View.VISIBLE);
                lv.setAdapter(new miAdaptador(this, c));
            }
            else
            {
                tvNoData.setVisibility(View.VISIBLE);
                lv.setVisibility(View.INVISIBLE);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
