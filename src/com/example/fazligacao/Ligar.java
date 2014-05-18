package com.example.fazligacao;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Ligar extends Activity{
	
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
		
	}
}
