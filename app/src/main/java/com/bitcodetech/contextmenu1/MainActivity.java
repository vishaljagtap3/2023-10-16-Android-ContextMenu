package com.bitcodetech.contextmenu1;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final int MENU_PASTE = 1;
    private static final int MENU_APPEND = 2;
    private static final int MENU_UPPER = 3;
    private static final int MENU_COPY = 4;
    private static final int MENU_CUT = 5;
    private TextView txt;
    private EditText edt;

    private String text = "";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        txt = findViewById(R.id.txt);
        edt = findViewById(R.id.edt);

        registerForContextMenu(txt);
        registerForContextMenu(edt);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View view, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, view, menuInfo);
        mt("onCreateContentMenu");

        if(view == txt) {
            menu.add(1, MENU_PASTE, 0, "Paste");
            menu.add(1, MENU_APPEND, 0, "Append");
            menu.add(1, MENU_UPPER, 0, "Upper");
        }

        if(view == edt) {
            menu.add(2, MENU_COPY, 0, "Copy");
            menu.add(2, MENU_CUT, 0, "Cut");
        }
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case MENU_PASTE:
                txt.setText(text);
                break;
            case MENU_APPEND:
                txt.append(text);
                break;
            case MENU_UPPER:
                txt.setText(txt.getText().toString().toUpperCase());
                break;
            case MENU_COPY:
                text = edt.getText().toString();
                break;
            case MENU_CUT:
                text = edt.getText().toString();
                edt.setText("");
                break;

        }
        return super.onContextItemSelected(item);
    }

    private void mt(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }
}
