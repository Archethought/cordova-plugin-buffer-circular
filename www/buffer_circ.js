/*** This is the javascript interface that the app uses. ***/
//
// Use jsdoc to generate documentation.

// The following line causes a jsdoc error.
// Use the jsdoc option -l to ignore the error.
var exec = cordova.require('cordova/exec');

/** @module com.archethought.cordovaplugins.buffers.Circular */

/** Push an item into of the buffer.
* @param {string} string - A string that is to be pushed onto the buffer.
* @example
buffer_circ.push( string);
*/
exports.push = function( string) {
    exec( null, null, 'buffer_circ', 'push', [ string]);
};

/** Pop an item out of the buffer.
* @param {resultCallback} resultCallback - The function that will handle the result.
* @example
buffer_circ.pop(
    function( item) {
        console.log('Popped item: ' + item);
    }
);
*/
exports.pop = function( resultCallback) {
    exec( resultCallback, null, 'buffer_circ', 'pop', []);
};

/** Peek at the next item out of the buffer.
* @param {resultCallback} resultCallback - The function that will handle the result.
* @example
buffer_circ.peek(
    function( item) {
        console.log('Peeking at item: ' + item);
    }
);
*/
exports.peek = function( resultCallback) {
    exec( resultCallback, null, 'buffer_circ', 'peek', []);
};

/** Get the number of items in the buffer.
* @param {resultCallback} resultCallback - The function that will handle the result.
* @example
buffer_circ.count(
    function( number) {
        console.log('Number of items: ' + item);
    }
);
*/
exports.count = function( resultCallback) {
    exec( resultCallback, null, 'buffer_circ', 'count', []);
};

/** Get the number of items the buffer can hold.
* @param {resultCallback} resultCallback - The function that will handle the result.
* @example
buffer_circ.capacity(
    function( number) {
        console.log('Max number of items: ' + item);
    }
);
*/
exports.capacity = function( resultCallback) {
    exec( resultCallback, null, 'buffer_circ', 'capacity', []);
};

/** Clear the buffer out.
* @example
buffer_circ.clear();
*/
exports.clear = function() {
    exec( null, null, 'buffer_circ', 'clear', []);
};

/** Set the number of item the buffer can hold.
* @param {number} maxCapacity - A string that is to be pushed onto the buffer.
* @example
buffer_circ.setCapacity( maxCapacity);
*/
exports.setCapacity = function( maxCapacity) {
    exec( null, null, 'buffer_circ', 'setCapacity', [ maxCapacity]);
};
