package com.augusto.foodselect;

// Importamos las librerías necesarias
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ToggleButton;

public class MenuPrincipal extends Activity implements OnClickListener {
	/*
	 *  Definimos la clase del Menú Principal, encargada de recibir
	 *  al usuario y dirigirlo hacia las opciones de la aplicación.
	 */
	
	// Elementos necesarios a usar en la aplicación.
	View btnIngresar; //Botón
	View btnSalir; // Botón
	View btnAcercaDe; // Botón
	EditText txtbUrl; // Campo de ingreso de texto
	ToggleButton btnModificar; // Botón de dos estados
	AlertDialog.Builder ventanaEmergente; // Ventana Emergente
	private static final int menuOpcionUno = 1; // Opcion del Menu
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_principal_activity); // Cargar el layout
        
        // Asignamos los elementos a sus ID y a su evento controlador.
        btnIngresar = findViewById(R.id.btnIngresar);
        btnIngresar.setOnClickListener(this);
        
        btnSalir = findViewById(R.id.btnSalir);
        btnSalir.setOnClickListener(this);
        
        btnAcercaDe = findViewById(R.id.btnAcercaDe);
        btnAcercaDe.setOnClickListener(this);
        
        btnModificar = (ToggleButton) findViewById(R.id.btnModificar);
        btnModificar.setOnClickListener(this);
        
        txtbUrl = (EditText)findViewById(R.id.txtbUrl);
        controlartxtbUrl(1); // Deshabilitamos el botón
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
    	// Crea el menú.
    	menu.add(Menu.NONE, menuOpcionUno, Menu.NONE, "Salir")
        .setIcon(android.R.drawable.ic_menu_preferences); // Crea una opción.
    	return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	// Acciona en caso de una seleccion en el menu.
        salir(); // Sale del programa.
        return true;
    }

	@Override
	public void onClick(View vista) {
		// Evento que se ejecutará al hacer click sobre la pantalla 
		if(vista.getId()==findViewById(R.id.btnIngresar).getId()){
			// En caso de que se haga clieck en "Ingresar":
			ingresar();
		}
		
		if(vista.getId()==findViewById(R.id.btnAcercaDe).getId()){
			// En caso de que se haga clieck en "Acerca De":
			irAcercaDe();
		}

		if(vista.getId()==findViewById(R.id.btnModificar).getId()){
			// En caso de que se haga clieck en "Modificar":
			if((btnModificar.isChecked())) {
				controlartxtbUrl(0);
		    }
		    else {
		    	controlartxtbUrl(1);
		    }
		}
		
		if(vista.getId()==findViewById(R.id.btnSalir).getId()){
			// En caso de que se haga clieck en "Salir"
			salir();			
		}
	}

	public void ingresar() {
		// Se traslada hacia el formulario.
		finish(); // Finalizar la actividad actual
		String url = txtbUrl.getText().toString(); // Captura la url solicitada.
		Intent i = new Intent(this, Formulario.class); // Selecciona la actividad "Formulario"
		i.putExtra("url", url); // Envía la url.
		startActivity(i); // Inicia la actividad.
	}

	public void salir() {
		// Evento que confirma el deseo de salir y en caso positivo, cierra la aplicación
		// Atributos de la ventana emergente:
		ventanaEmergente = new AlertDialog.Builder(this);
        ventanaEmergente.setTitle("Importante");  
        ventanaEmergente.setMessage("¿Está seguro que desea salir ?");            
        ventanaEmergente.setCancelable(false);  
        ventanaEmergente.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {  
            public void onClick(DialogInterface dialogo1, int id) {
            	// En caso de seleccionar "Confirmar":
            	System.exit(0); // Salir de la aplicación
            }  
        });
        ventanaEmergente.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
        	public void onClick(DialogInterface dialogo1, int id) {
        		// En caso de seleccionar "Cancelar":
            }  
        });
        ventanaEmergente.show(); // Abrir la ventana emergente.
	}
	
	public void irAcercaDe() {
		// Traslada al usuario a la actividad "Acerca De" 
		finish(); // Cierra la actividad
		Intent j = new Intent(this, AcercaDe.class); // Selecciona la actividad "Acerca De"
		startActivity(j); // Ir a la actividad.
	}
	
	public void controlartxtbUrl(int numero) {
		// Modifica el estado del textbox encargado de recoger la url solicitada
		if(numero==0) {
			// Habilita el txtb
			txtbUrl.setEnabled(true);
		}
		if(numero==1) {
			// Deshabilita el txtb
			txtbUrl.setEnabled(false);
		}
	}
}