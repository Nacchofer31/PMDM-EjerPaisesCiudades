package nach.com.dam2.pmdm_ejerpaisesciudades;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends Activity {

    Spinner ciudades, paises;
    ArrayAdapter<String> adap_paises,adap_ciudades;
    ArrayList<String> ac;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Declaramos los objetos spinner.
        ciudades = (Spinner) findViewById(R.id.ciudadesSP);
        paises = (Spinner) findViewById(R.id.paisesSP);
        ac = new ArrayList<String>();

        //Rellenamos nuestro primer spinner
        String array_paises[]=getResources().getStringArray(R.array.Paises);
        adap_paises = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,array_paises);
        adap_ciudades = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item);
        paises.setAdapter(adap_paises);

        paises.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0: //Ninguno
                        adap_ciudades.clear();
                        break;
                    case 1: //España
                        ac = new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.ciudades_España)));
                        break;
                    case 2: //Francia
                        ac = new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.ciudades_Francia)));
                        break;
                    case 3: //Italia
                        ac = new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.ciudades_Italia)));
                        break;
                    case 4: //Alemania
                        ac = new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.ciudades_Alemania)));
                        break;
                }
                adap_ciudades.clear();
                adap_ciudades.addAll(ac);
                ciudades.setAdapter(adap_ciudades);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

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
