package ro.pub.cs.systems.eim.practicaltest01var05;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;



interface Constants {

    final public static String TAG                  = "activitylifecycle";

    final public static String CREDENTIAL_FILE      = "credentials.xml";
    final public static String CREDENTIAL_TAG       = "credential";
    final public static String USERNAME_TAG         = "username";
    final public static String PASSWORD_TAG         = "password";

    final public static String USERNAME_EDIT_TEXT   = "usernameEditText";
    final public static String PASSWORD_EDIT_TEXT   = "passwordEditText";
    final public static String REMEMBER_ME_CHECKBOX = "rememberMeCheckbox";

    final public static String TIMES_PRESSED_TAG         = "TIMES_PRESSED";
    final public static String TEXT_TAG         = "TEXT_TAG";
    final public static int  SECONDARY_ACTIVITY_REQUEST_CODE = 0;
    final public static int TIMES_PRESSED = 0;

    final public static boolean DEBUG               = true;

}

public class PracticalTestVar05MainActivity extends AppCompatActivity {

    private Button navigate, topLeft, topRight, center, bottomLeft, bottomRight;
    private EditText text;
    private int timesPressed = 0;

    private GenericButtonClickListener genericButtonClickListener = new GenericButtonClickListener();
    private class GenericButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            if (view.getId() == R.id.button) {
                Intent intent = new Intent(getApplicationContext(), PracticalTest01Var05SecondaryActivity.class);
                intent.putExtra(Constants.TEXT_TAG, text.getText());
                startActivity(intent);
            } else {
                text.setText(text.getText().toString() + ((Button)view).getText().toString() + ", ");
                timesPressed++;
            }

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activituy_practical_test01_var05_main);

        text = (EditText)findViewById(R.id.editTextTextPersonName);
        navigate = (Button)findViewById(R.id.button);
        topLeft = (Button)findViewById(R.id.button4);
        topRight = (Button)findViewById(R.id.button2);
        center = (Button)findViewById(R.id.button3);
        bottomLeft = (Button)findViewById(R.id.button5);
        bottomRight = (Button)findViewById(R.id.button6);

        topLeft.setOnClickListener(genericButtonClickListener);
        topRight.setOnClickListener(genericButtonClickListener);
        center.setOnClickListener(genericButtonClickListener);
        bottomLeft.setOnClickListener(genericButtonClickListener);
        bottomRight.setOnClickListener(genericButtonClickListener);

        if (savedInstanceState == null) {
            Log.d(Constants.TAG, "onCreate() method was invoked without a previous state");
        } else {
            Log.d(Constants.TAG, "onCreate() method was invoked with a previous state");
            if (savedInstanceState.containsKey(Constants.TIMES_PRESSED_TAG)) {
                timesPressed = savedInstanceState.getInt(Constants.TIMES_PRESSED_TAG);
                Log.d(Constants.TAG, "TIMES PRESSED:" + timesPressed);
//                Toast.makeText(this,
//                        timesPressed,
//                        Toast.LENGTH_LONG).show();
            }
        }
    }

    @Override
    public void onRestart() {
        super.onRestart();
        Log.d(Constants.TAG, "onRestart() method was invoked");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(Constants.TAG, "onStart() method was invoked");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(Constants.TAG, "onResume() method was invoked");
//        Toast.makeText(getApplicationContext(),
//                timesPressed,
//                Toast.LENGTH_LONG).show();
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(Constants.TAG, "onPause() method was invoked");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(Constants.TAG, "onStop() method was invoked");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(Constants.TAG, "onDestroy() method was invoked");
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt(Constants.TIMES_PRESSED_TAG, timesPressed);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState.containsKey(Constants.TIMES_PRESSED_TAG)) {
            timesPressed = savedInstanceState.getInt(Constants.TIMES_PRESSED_TAG);
            Log.d(Constants.TAG, "onRestoreInstanceState() method was invoked" + timesPressed);
//            Toast.makeText(this,
//                    timesPressed,
//                    Toast.LENGTH_LONG).show();
        }

    }
}