package com.augusto.foodselect;

//Imporamos las librerías necesarias.
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;

public class AcercaDe extends android.app.Activity implements OnClickListener {
	/*
	 * Definimos la clase "Acerca De", encargada de mostrar
	 * en pantalla las especificaciones de la aplicación.
	*/

	// Definimos los elementos que serán necesarios.
	View btnRegresar; // Botón
	private static final int menuOpcionUno = 1; // Opcion del menu
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	// Evento necesario para crear el layout de la clase.
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acercade_activity);
        
        // Asignamos los elementos a sus ID y a su evento controlador.
        btnRegresar = findViewById(R.id.btnRegresar);
        btnRegresar.setOnClickListener(this);
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

	@Override
	public void onClick(View vista) {
		// Evento a ejecutar en caso de un click en la pantalla.
		if(vista.getId()==findViewById(R.id.btnRegresar).getId()){
			// En el caso que se haga click sobre el botón
			// "Regresar", se ejecutará el evento correspondiente.
			regresar();
		}		
	}
	
	public void regresar(){
		// Evento que regresa al menu principal.
		finish(); // Finaliza la actividad
		Intent i = new Intent(this, MenuPrincipal.class); // Elige la actividad destino.
		startActivity(i); // Ir a la actividad.
	}
}