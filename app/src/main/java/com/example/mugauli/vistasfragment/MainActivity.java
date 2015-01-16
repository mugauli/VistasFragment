package com.example.mugauli.vistasfragment;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.Toast;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.app.Activity;
import android.app.FragmentManager;

import com.google.android.gms.tagmanager.Container;

import java.sql.Array;
import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {


    public static String[] arrayDatos = {"","",""} ;
    public static ArrayList<String> dataSurvey = new ArrayList<String>();
    public static String cadenaEnvio="";

    public int cont=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnAbrir = (Button) findViewById(R.id.button2);
        btnAbrir.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                if(cont == 0) {

                    getSupportFragmentManager().beginTransaction().replace(R.id.container, new PlaceholderFragment()).commit();
                    cont++;
                }else if(cont == 1)
                {
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, new PlaceholderFragmentTrueFalse()).commit();
                    cont++;
                }else if(cont==2) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, new PlaceholderFragmentRango()).commit();
                    cont++;
                }else if(cont == 3)
                {
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, new PlaceholderFragmentOpen()).commit();
                    cont++;

                }
                else if(cont == 4)
                {
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, new PlaceholderFragmentFinalDatos()).commit();
                    cont=-1;

                }

                TextView textMain = (TextView)findViewById(R.id.textViewMain);
                textMain.setText(cadenaEnvio);

            }
        });
        Button btnCerrar = (Button) findViewById(R.id.btnCerrar);
        btnCerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                View a  = (View)findViewById(R.id.container);
                a.clearAnimation();

            }
        });

    /*    if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }*/
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

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }
        @Override
        public void onStart() {
            // TODO Auto-generated method stub
            super.onStart();
            Button btnGetText = (Button) getActivity().findViewById(
                    R.id.btnMain);
            btnGetText.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View arg0) {
                    // TODO Auto-generated method stub
                    EditText lbl = (EditText) getActivity().findViewById(
                            R.id.editTextMain);

                    cadenaEnvio += "tipo&"+lbl.getText().toString()+"|";


                }
            });
        }

    }

    public static class PlaceholderFragmentTrueFalse extends Fragment {

        public PlaceholderFragmentTrueFalse() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_true_false, container, false);
            return rootView;
        }




    }
    public static class PlaceholderFragmentRango extends Fragment {

        public PlaceholderFragmentRango() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_rango, container, false);

            return rootView;
        }
        @Override
        public void onStart() {
            // TODO Auto-generated method stub
            super.onStart();
            Button btnGetText = (Button) getActivity().findViewById(
                    R.id.btnRango);
            btnGetText.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View arg0) {
                    // TODO Auto-generated method stub
                    EditText lbl = (EditText) getActivity().findViewById(
                            R.id.editTextRango);

                    cadenaEnvio += "tipo&"+lbl.getText().toString()+"|";


                }
            });
        }



    }
    public static class PlaceholderFragmentOpen extends Fragment {

        public PlaceholderFragmentOpen() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_open, container, false);
            return rootView;
        }


    }

    public static class PlaceholderFragmentFinalDatos extends Fragment {

        public PlaceholderFragmentFinalDatos() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_final_datos, container, false);
            return rootView;
        }


    }
}
