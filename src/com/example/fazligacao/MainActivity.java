package com.example.fazligacao;


import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {
// Constante para identificar a sub-activity lançada 
	private static final int SELECIONAR_CONTATO = 1;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Button ok = (Button) findViewById(R.id.btLigar);
		Button agenda = (Button) findViewById(R.id.btAgenda);
		final EditText tFone = (EditText) findViewById(R.id.txtFone);
		TextView txtNome = (TextView) findViewById(R.id.txtNome);
	
		
		ok.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
			
				String tel = "tel:"+tFone.getText().toString();
				Uri uri = Uri.parse(tel);
				Intent i = new Intent(Intent.ACTION_CALL, uri);
				startActivity(i);
					
				
				}   

			});
		

		agenda.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				// Visualiza a lista de contatos
				Uri uri = Uri.parse("content://com.android.contacts/contacts/");
				Intent i = new Intent(Intent.ACTION_PICK, uri);
				startActivityForResult(i, SELECIONAR_CONTATO);
				
				
			}
		});
		
	}
		
	
		// Método que recebe o retorno da intent chamada
		protected void onActivityResult(int requestCode, int resulTCode, Intent intent){
			// Recebe uma intent de retorno o qual podemos recuperar os dados, ou seja.
			// Ao retornar da intent chamada o Android traz uma nova intent como retorno e então podemos manipular os dados de retorno 
			EditText tFone = (EditText) findViewById(R.id.txtFone);
			TextView tNome = (TextView) findViewById(R.id.txtNome);
			//Uri que identifica o contato
			Uri uri = intent.getData();
			//Buscar o contato o banco de dados utilizando a Uri do contato selecionado
			//Cursor c = getContentResolver().query(uri, null, null, null, null);
			//Posiciona o cursor
			//c.moveToNext();
			//Recupera o nome do contato
			//int nameColumn = c.getColumnIndexOrThrow(ContactsContract.Contacts.DISPLAY_NAME);
			//tNome.setText(c.getString(nameColumn));
			//int foneColumn = c.getColumnIndexOrThrow(ContactsContract.Contacts.);
			//tFone.setText(c.getString(foneColumn));
			//c.close();
			
			// Solicita o Android para visualizar o contato 
			startActivity(new Intent(Intent.ACTION_VIEW, uri));
	}



}
