package source.ibmiot;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void sendData(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.edit_message);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
        // Do something in response to button
    }

    /*SocketIO socket = new SocketIO("http://127.0.0.1:3001/");
    socket.connect(new IOCallback() {
        @Override
        public void onMessage(JSONObject json, IOAcknowledge ack) {
            try {
                System.out.println("Server said:" + json.toString(2));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onMessage(String data, IOAcknowledge ack) {
            System.out.println("Server said: " + data);
        }

        @Override
        public void onError(SocketIOException socketIOException) {
            System.out.println("an Error occured");
            socketIOException.printStackTrace();
        }

        @Override
        public void onDisconnect() {
            System.out.println("Connection terminated.");
        }

        @Override
        public void onConnect() {
            System.out.println("Connection established");
        }

        @Override
        public void on(String event, IOAcknowledge ack, Object... args) {
            System.out.println("Server triggered event '" + event + "'");
        }
    });

    // This line is cached until the connection is establisched.
    socket.send("Hello Server!");
    */
}
