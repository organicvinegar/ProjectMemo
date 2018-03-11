package com.example.msi.project_memo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MakeMemo extends AppCompatActivity {

    EditText title;
    EditText container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_memo);

        title = (EditText)findViewById(R.id.editText);
        container = (EditText)findViewById(R.id.editText2);

        Button save = (Button)findViewById(R.id.button2);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplication(), MainActivity.class);
                intent.putExtra("title", title.getText().toString());
                intent.putExtra("container", container.getText().toString());
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}
