/*** This is the Android Java Source File ***/
package com.archethought.cordovaplugins.buffers;

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
public class Circular extends CordovaPlugin {
    /***
     * Class Variables
     ***/
    private ArrayList<String> buffer; // String array for the circular buffer.
    private int max; // Maximum number of items to allow in the buffer.
    
    /***
     * Constructor.
     ***/
    public Circular() {
        // This constructor defaults to 10 items.
        // FIXME: Make this constructor default to 2/s * 60s * 30m items.
        this.max = 10;
        this.buffer = new ArrayList<String>( this.max);
    }
    
    // Make another constructor here that allows a number of items to be set.
    
    /*** PUBLIC FUNCTIONS ***/
    
    /***
     * Push function
     *   Remove the first item from the buffer if the buffer is full.
     *   Add an item to the end of the buffer.
     ***/
    public void push( String newItem) {
        // If full, remove the first item.
        if( isFull()) {
            this.buffer.remove( 0);
        }
        // Now add the new item to the end.
        this.buffer.add( newItem);
        return;
    }
    
    /***
     * Pop function
     *   Return the string at the beginning of the buffer and remove it.
     ***/
    public String pop() {
        // Save the first item off the list.
        String temp = this.buffer[ 0];
        // Remove the first item.
        this.buffer.remove( 0);
        // Return that item.
        return temp;
    }
    
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
     * Size function
     *   Return the number of items the buffer can hold.
     ***/
    
    /***
     * Clear function
     *   Reset the buffer to an empty state.
     ***/
    
    /*** PRIVATE FUNCTIONS ***/
    
    /***
     * Check If Full function
     *   Return true if the buffer is full.
     ***/
    private boolean isFull() {
        // Compare the size (number of items in the buffer) to the max allowed.
        return this.buffer.size() == this.max;
    }
}
