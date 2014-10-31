/*** This is the Android Java Source File ***/
package com.archethought.cordovaplugins.buffers;

import org.apache.cordova.*;
//import org.apache.cordova.CallbackContext;
//import org.apache.cordova.CordovaPlugin;
//import org.apache.cordova.CordovaResourceApi;
//import org.apache.cordova.PluginResult;

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
    
    /*** Cordova Magic Functions ***/
    
    @Override
    public void initialize( final CordovaInterface cordova, CordovaWebView webView) {
        super.initialize(cordova, webView);
        
        // Initialization of the goodies.
        // Defaulting the buffer to 300.  May increase this later.
        this.max = 300;
        this.buffer = new ArrayList<String>( max);
    }
    
    @Override
    public boolean execute( String action, JSONArray args, final CallbackContext callbackContext) throws JSONException {
        // These if statements call the actual functions.  There must be one for each public function.
        // Push function
        if( "push".equals( action)) {
            this.push( args.getString( 0), callbackContext);
            return true;
        }
        // Pop function
        else if( "pop".equals( action)) {
            this.pop( callbackContext);
            return true;
        }
        // Peek function
        else if( "peek".equals( action)) {
            this.peek( callbackContext);
            return true;
        }
        // Count function
        else if( "count".equals( action)) {
            this.count( callbackContext);
            return true;
        }
        // Capacity function
        else if( "capacity".equals( action)) {
            this.capacity( callbackContext);
            return true;
        }
        // Clear function
        else if( "clear".equals( action)) {
            this.clear( callbackContext);
            return true;
        }
        // Set Capacity function
        else if( "setCapacity".equals( action)) {
            this.setCapacity( args.getInt( 0), callbackContext);
            return true;
        }
        
        // This is needed to be PC ( programmatically correct).
        return false;
    }
    
    // Make another constructor here that allows a number of items to be set.
    
    /*** PUBLIC FUNCTIONS ***/
    
    /***
     * Push function
     *   Remove the first item from the buffer if the buffer is full.
     *   Add an item to the end of the buffer.
     ***/
    public void push( String newItem, CallbackContext callbackContext) {
        // If full, remove the first item.
        if( this.isFull()) {
            this.buffer.remove( 0);
        }
        // Now add the new item to the end.
        this.buffer.add( newItem);
        callbackContext.success();
        return;
    }
    
    /***
     * Pop function
     *   Return the item at the beginning of the buffer and remove it.
     *   Value ( String) is returned using the callback context.
     ***/
    public void pop( CallbackContext callbackContext) {
        // If empty, return an empty string
        if( this.isEmpty) {
            // This should probably throw an error instead of returning an empty string.
            callbackContext.success( "");
        } else {
            // Save the first item off the list.
            String temp = this.buffer.get( 0);
            // Remove the first item.
            this.buffer.remove( 0);
            // Return that item.
            callbackContext.success( temp);
        }
        return;
    }
    
    /***
     * Peek function
     *   Return the item at the beginning of the buffer without removing it.
     *   Value ( String) is returned using the callback context.
     ***/
    public void peek( CallbackContext callbackContext) {
        // If empty, return an empty string
        if( this.isEmpty) {
            // This should probably throw an error instead of returning an empty string.
            callbackContext.success( "");
        } else {
            // Save the first item off the list.
            String temp = this.buffer.get( 0);
            // Return that item.
            callbackContext.success( temp);
        }
        return;
    }
    
    /***
     * Count function
     *   Return the number of item in the buffer.
     *   Value ( int) is returned using the callback context.
     ***/
    public void count( CallbackContext callbackContext) {
        callbackContext.success( this.buffer.size());
        return;
    }
    
    /***
     * Capacity function
     *   Return the number of items the buffer can hold.
     *   Value ( int) is returned using the callback context.
     ***/
    public void capacity( CallbackContext callbackContext) {
        callbackContext.success( this.max);
        return;
    }
    
    /***
     * Clear function
     *   Reset the buffer to an empty state.
     ***/
    public void clear( CallbackContext callbackContext) {
        this.buffer = new ArrayList<String>( this.max);
        callbackContext.success();
        return;
    }
    
    /***
     * Set Capacity function
     *   Change the number of items the buffer can hold.
     ***/
    public void setCapacity( int newCapacity, CallbackContext callbackContext) {
        this.max = newCapacity;
        this.buffer.ensureCapacity( this.max);
        callbackContext.success();
        return;
    }
    
    /*** PRIVATE FUNCTIONS ***/
    
    /***
     * Check If Full function
     *   Return true if the buffer is full.
     ***/
    private boolean isFull() {
        // Compare the size (number of items in the buffer) to the max allowed.
        return this.buffer.size() == this.max;
    }
    
    /***
     * Check If Empty function
     *   Return true if the buffer is empty.
     ***/
    private boolean isEmpty() {
        // Compare the size (number of items in the buffer) to 0.
        return this.buffer.size() == 0;
    }
}
