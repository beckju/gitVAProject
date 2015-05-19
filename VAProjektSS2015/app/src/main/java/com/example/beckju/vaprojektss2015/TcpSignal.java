package com.example.beckju.vaprojektss2015;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by beckju on 18.05.15.
 */

public class TcpSignal extends Activity {

    TextView TcpResponse;
    EditText TextAddress, TextPort;
    Button TcpBtnConnect, TcpBtnClear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.tcpsignal_layout);

        TcpResponse = (TextView) findViewById(R.id.TcpRespView);
        TextAddress = (EditText) findViewById(R.id.TcpDestAdr);
        TextPort = (EditText) findViewById(R.id.TcpDestPrt);
        TcpBtnConnect = (Button) findViewById(R.id.TcpCnctBtn);
        TcpBtnClear = (Button) findViewById(R.id.TcpClrBtn);

    }

    public void onClickTcpClear(View view) {

        TextAddress.setText("");
        TextPort.setText("");
    }

    public void onClickTcpConnect(View view) {
        MyClientTask myClientTask = new MyClientTask(
                TextAddress.getText().toString(),
                Integer.parseInt(TextPort.getText().toString()));
        myClientTask.execute();

    }


    public class MyClientTask extends AsyncTask<Void, Void, Void> {

        String dstAddress;
        int dstPort;
        String response = "";

        MyClientTask(String addr, int port) {
            dstAddress = addr;
            dstPort = port;
        }

        @Override
        protected Void doInBackground(Void... arg0) {

            Socket socket = null;

            try {
                socket = new Socket(dstAddress, dstPort);

                ByteArrayOutputStream byteArrayOutputStream =
                        new ByteArrayOutputStream(1024);
                byte[] buffer = new byte[1024];

                int bytesRead;
                InputStream inputStream = socket.getInputStream();

/*
* notice:
* inputStream.read() will block if no data return
*/
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    byteArrayOutputStream.write(buffer, 0, bytesRead);
                    response += byteArrayOutputStream.toString("UTF-8");
                }

            } catch (UnknownHostException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                response = "UnknownHostException: " + e.toString();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                response = "IOException: " + e.toString();
            } finally {
                if (socket != null) {
                    try {
                        socket.close();
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            TcpResponse.setText(response);
            super.onPostExecute(result);
        }

    }
}