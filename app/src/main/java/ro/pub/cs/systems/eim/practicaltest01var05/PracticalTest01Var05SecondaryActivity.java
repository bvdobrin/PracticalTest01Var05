package ro.pub.cs.systems.eim.practicaltest01var05;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

interface Constants2 {

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
    final public static int TIMES_PRESSED = 0;

    final public static boolean DEBUG               = true;

}

public class PracticalTest01Var05SecondaryActivity extends AppCompatActivity {

    private Button okButton, cancelButton;
    private TextView text;

    private ButtonClickListener buttonClickListener = new ButtonClickListener();
    private class ButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.button7:
                    setResult(RESULT_OK, null);
                    break;
                case R.id.button8:
                    setResult(RESULT_CANCELED, null);
                    break;
            }
            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var05_secondary);

        text = (TextView) findViewById(R.id.textView);
        Intent intent = getIntent();
        if (intent != null && intent.getExtras().containsKey(Constants.TEXT_TAG)) {
            String str = intent.getStringExtra(Constants.TEXT_TAG);
            text.setText(str);
        }

        okButton = (Button)findViewById(R.id.button7);
        okButton.setOnClickListener(buttonClickListener);
        cancelButton = (Button)findViewById(R.id.button8);
        cancelButton.setOnClickListener(buttonClickListener);
    }
}