package com.example.iker.ikasprueba;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.Parse;
import com.parse.ParseObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Parse.enableLocalDatastore(this);
        Parse.initialize(this);




        EditText nom = (EditText) findViewById(R.id.editTextNombre);
        String Nombre = nom.getText().toString();

        //nom.requestFocus();
        EditText ape = (EditText) findViewById(R.id.editTextApellido);
        String Apellido = ape.getText().toString();
        Button boton = (Button) findViewById(R.id.button);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText nom = (EditText) findViewById(R.id.editTextNombre);
                String Nombre = nom.getText().toString();

                EditText ape = (EditText) findViewById(R.id.editTextApellido);
                String Apellido = ape.getText().toString();

                EditText m = (EditText) findViewById(R.id.editTextDistancia);
                String metros = m.getText().toString();
                //int medida = Integer.parseInt(metros);

                ParseObject objeto = new ParseObject("objeto");
                objeto.put("Nombre", Nombre);
                objeto.put("Apellido", Apellido);
                objeto.put("Metros", metros);
                objeto.saveInBackground();

                Toast toa1 = Toast.makeText(getApplicationContext(),"DATOS ALMACENADOS",Toast.LENGTH_LONG);
                toa1.show();
                nom.setText("");
                ape.setText("");
                m.setText("");
            }
        });





    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
