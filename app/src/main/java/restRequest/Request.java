package restRequest;

import android.app.Activity;
import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by pelleria on 23/03/17.
 */

public abstract class Request extends Activity{
    RequestQueue queue = Volley.newRequestQueue(this);
    String ulr = "localhost:8080";

}
