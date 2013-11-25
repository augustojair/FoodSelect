package com.augusto.foodselect;

// Imporamos las librerías necesarias.
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;

@SuppressLint("SetJavaScriptEnabled")
public class Formulario extends android.app.Activity { public static Context appContext;
	/*
	 * Definimos las Clase "Formulario", encargada de mostrar la
	 * encuesta en pantalla.
	 */

	// Definición de Elementos necesarios para usar en la clase.
	String url; // Url a cargar.
	WebView visorWeb; // Visor Web a utilizar.
	WebSettings webSettings; // Configuraciones del WebKit
	private static final int menuOpcionUno = 1; // Opcion del menu
    
	@Override
    protected void onCreate(Bundle savedInstanceState) {
    	// Evento necesario para crear el layout de la clase.
    	super.onCreate(savedInstanceState);
        setContentView(R.layout.formulario_activity);
        
        Bundle extras = getIntent().getExtras();
        url = extras.getString("url"); // Captura de la url obtenida.
        cargarUrl(url); // Ordenar la carga de la url.
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
    	// Crea el menu
    	menu.add(Menu.NONE, menuOpcionUno, Menu.NONE, "Regresar")
        .setIcon(android.R.drawable.ic_menu_preferences); // Creacion de la opcion
    	return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	// Acciona en caso de seleccion en el menu
        regresar();
        return true;
    }
        
	public void regresar(){
		// Evento que regresa al menu principal.
		finish(); // Finaliza la actividad.
		Intent i = new Intent(this, MenuPrincipal.class); // Selecciona la actividad destino.
		startActivity(i); // Ir a la actividad.
	}
	
	public void cargarUrl(String url){
		// Este evento controla el visor y ordena la carga de la url.
        visorWeb = (WebView) findViewById(R.id.wvVisorWeb); // Asigna el controlador al widget.
        webSettings = visorWeb.getSettings(); // Obtener configuraciones
        webSettings.setJavaScriptEnabled(true); // Activar Javascript
        visorWeb.loadUrl(url); // Cargar la url.
	}
}