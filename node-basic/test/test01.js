"use strict";

var func = function() {
    var v1 = null;
    
    var f1 = function(value) {
        v1 = value;
    };

    var f2 = function() {
        console.log(v1);
    };

    return [f1, f2];
};

var f = func();

f[0](100);
f[1]();
