package com.example.chocolatecafe;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.app.ListActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends ListActivity { // MainActivity extends ListActivity

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.setTitle("Chocolate Cafe"); // Setting Title
        // Initializing string array with today's special
        String [] special = {"Chocolate Mousse", "Chocolate Cake", "Chocolate Macaron", "Chocolate Cafe Website"};
        /* Converting data from array into list items using Adapter below
         setListAdapter displays data on screen by connecting ListActivity's ListView object to the array data
         SetListAdapter contains info to connect on screen info list with special array */
        setListAdapter(new ArrayAdapter<String>(this, R.layout.activity_main, R.id.dessert, special)); // custom layout is referenced in activity_main.xml
    }
    protected void onListItemClick(ListView i, View v, int position, long id) { // onListItemClick method is called when an item in list is selected
        // When a dessert is selected, the "position" of the item is passed from the onListItemClick method
        // the onListItemClick detects the selection's position
        switch (position) { // the position is determined by the switch position
            // The position integer executes the corresponding case
            case 0:
                startActivity(new Intent(MainActivity.this, Mouse.class));
                break; // the statement within a case ends with break statement by exiting
            case 1: // If chocolate cake is selected, case 1 is true. So the program execute this statement
                startActivity(new Intent(MainActivity.this, Cake.class));
                break;
            case 2:
                startActivity(new Intent(MainActivity.this, Macaron.class)); // If choice 3 is selected, StartActivity will launch Maracon class
                break;
            case 3:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.chocolatharlem.com")));
                /* If the 4th choice is selected, the user is routed to the cafe website
                 Intents sends and receives activities and services like opening a webpage in a browser
                 intent sends the browser the URI, URI then identifies the web resources
                 ACTION_VIEW displays the site */
                break;
        }

    }
}