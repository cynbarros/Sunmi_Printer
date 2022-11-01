package br.com.itfast.plugins.it4r;

import android.app.Activity;
import android.content.Context;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaWebView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import br.com.itfast.tectoy.Dispositivo;
import br.com.itfast.tectoy.TecToy;
import br.com.itfast.tectoy.TecToyException;

/**
 * This class echoes a string called from JavaScript.
 */
public class CordovaIT4RPlugin extends CordovaPlugin {

	private Activity mActivity;
    private Context mContext;
    private CordovaWebView webView;
	private TecToy tectoy;
	
	
	@Override
    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
        super.initialize(cordova, webView);
        this.webView = webView;
        mActivity = cordova.getActivity();
        mContext = cordova.getActivity().getApplicationContext();

        tectoy = new TecToy(Dispositivo.V2_PRO, mContext);
    }


    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("Imprimir")) {
           JSONObject params = args.getJSONObject(0);
           String strTexto = params.getString("texto");
           tectoy.imprimir(strTexto);
           return true;
        }
        return false;
    }

    private void coolMethod(String message, CallbackContext callbackContext) {
        if (message != null && message.length() > 0) {
            callbackContext.success(message);
        } else {
            callbackContext.error("Expected one non-empty string argument.");
        }
    }
}
