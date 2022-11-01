var exec = require('cordova/exec');

exports.Imprimir = function (params, success, error) {
    exec(success, error, 'CordovaIT4RPlugin', 'Imprimir', [params]);
};
