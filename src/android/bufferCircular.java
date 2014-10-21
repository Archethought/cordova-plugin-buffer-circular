/*** This is the Android Java Source File ***/
package com.archethought.cordova.buffer.circular;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaResourceApi;
import org.apache.cordova.PluginResult;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

/***
 * This class called by CordovaActivity to store strings in a circular buffer.
 ***/
public class CircularBuffer extends CordovaPlugin {
    
    public static String TAG = "CircularBuffer";
    
    ArrayList<String> buffer; // String array for the circular buffer.
    
    /***
     * Constructor.
     ***/
    public CircularBuffer() {
        this.buffer = new ArrayList<String>(); // Make the buffer array.
        this.first = 0; // Make the pointer to the beginning of the buffer.
        this.last = 0; // Make the pointer to the end of the buffer.
    }
    
    /***
     * Push function
     *   Add an string to the end of the buffer.
     ***/
    
    /***
     * Pop function
     *   Return the string at the beginning of the buffer and remove it.
     ***/
    
    /***
     * Peek function
     *   Return the string at the beginning of the buffer without removing it.
     ***/
    
    /***
     * Count function
     *   Return the number of strings in the buffer.
     *   - If first and last are equal, the buffer is empty.
     ***/
    
    /***
     * Clear function
     *   Reset the buffer to an empty state.
     ***/
}
