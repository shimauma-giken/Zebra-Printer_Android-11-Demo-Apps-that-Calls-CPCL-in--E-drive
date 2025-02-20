package com.example.myapplication;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.zebra.sdk.comm.BluetoothConnectionInsecure;
import com.zebra.sdk.comm.Connection;
import com.zebra.sdk.printer.SGD;
import com.zebra.sdk.printer.ZebraPrinter;
import com.zebra.sdk.printer.ZebraPrinterFactory;

import java.nio.charset.Charset;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        String theBtMacAddress = "04:7F:0E:7E:EE:9D";
        //sgdOverBluetooth(theBtMacAddress);
        Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Log.v("ZZZ", "btn clicked");
               sgdOverBluetooth(theBtMacAddress);
           }
       }
        );

    }

    private void sgdOverBluetooth(final String theBtMacAddress){
        new Thread(new Runnable() {
            public void run() {
                try {

                    // Instantiate insecure connection for given Bluetooth&reg; MAC Address.
                    Connection thePrinterConn = new BluetoothConnectionInsecure(theBtMacAddress);

                    // Initialize
                    Looper.prepare();

                    // Open the connection - physical connection is established here.
                    thePrinterConn.open();

                    String fileRun = SGD.DO("file.run", "AAAVS01.PRN",thePrinterConn);
                    Log.v("ZZZ", "SGD file.run is " + fileRun);

                    // Make sure the data got to the printer before closing the connection
                    Thread.sleep(500);

                    // Close the insecure connection to release resources.
                    thePrinterConn.close();

                    Looper.myLooper().quit();

                } catch (Exception e) {

                    // Handle communications error here.
                    e.printStackTrace();

                }
            }
        }).start();

    }


}