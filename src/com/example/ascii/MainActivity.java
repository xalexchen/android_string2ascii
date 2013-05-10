package com.example.ascii;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button btn = (Button) findViewById(R.id.button1);
		btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				EditText edit = (EditText) findViewById(R.id.editText1);
				TextView tv = (TextView) findViewById(R.id.textView1);
				String s = edit.getEditableText().toString();				
				char[] chars = s.toCharArray();
				StringBuffer convert = new StringBuffer();
				convert.append("public class Message {\n");
				convert.append("	public static void main(String[] args) {\n");
				
				StringBuffer ascii = new StringBuffer();
				ascii.append(Integer.valueOf(chars[0]));
				for(int i=1;i<chars.length;i++){
					ascii.append(","+Integer.valueOf(chars[i]));
					System.out.println(","+(int)chars[i]);
				}
				convert.append("		int[] encrypt = {"+ascii.toString()+"};\n");
				convert.append("		for (int i=0;i<encrypt.length;i++) { \n");
				convert.append("		    System.out.print((char)encrypt[i]);");
				convert.append("		}\n");
				convert.append("	}\n");
				convert.append("}\n");
				tv.setText(convert.toString());
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
