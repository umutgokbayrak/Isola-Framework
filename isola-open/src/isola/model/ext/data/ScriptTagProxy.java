package isola.model.ext.data;import isola.helpers.JsHelper;/** *  * <p> * An implementation of Ext.data.DataProxy that reads a data object from a URL * which may *  * be in a domain other than the originating domain of the running page. * </p> *  *  *  * <p> * Note that if you are retrieving data from a page that is in a domain that is * NOT the *  * same as the originating domain of the running page, you must use this class, * rather than *  * HttpProxy. * </p> *  *  *  * <p> * The content passed back from a server resource requested by a ScriptTagProxy * is *  * executable JavaScript source code that is used as the source inside a * <script> tag. * </p> *  *  *  * <p> * In order for the browser to process the returned data, the server must wrap * the data *  * object with a call to a callback function, the name of which is passed as a * parameter *  * by the ScriptTagProxy. Below is a Java example for a servlet which returns * data for *  * either a ScriptTagProxy, or an HttpProxy depending on whether the callback * name was *  * passed: * </p> *  *  *  * <pre> * &lt;code&gt; * 
 * boolean scriptTag = false; * 
 * String cb = request.getParameter(&quot;callback&quot;); * 
 * if (cb != null) { * 
 *     scriptTag = true; * 
 *     response.setContentType(&quot;text/javascript&quot;); * 
 * } else { * 
 *     response.setContentType(&quot;application/x-json&quot;); * 
 * } * 
 * Writer out = response.getWriter(); * 
 * if (scriptTag) { * 
 *     out.write(cb + &quot;(&quot;); * 
 * } * 
 * out.print(dataBlock.toJsonString()); * 
 * if (scriptTag) { * 
 *     out.write(&quot;);&quot;); * 
 * } * 
 * &lt;/code&gt; * </pre> *  *  *  * @author Umut Gokbayrak */public class ScriptTagProxy extends DataProxy {	private static final long serialVersionUID = -1618808764342804059L;	private static final String TAG = "Ext.data.ScriptTagProxy";	/**	 * 	 * <p>	 * (Optional) The name of the parameter to pass to the server which tells	 * the server the	 * 	 * name of the callback function set up by the load call to process the	 * returned data object.	 * 	 * Defaults to "callback".	 * </p>	 * 	 * 	 * 	 * <p>	 * The server-side processing must read this parameter value, and generate	 * javascript	 * 	 * output which calls this named function passing the data object as its	 * only parameter.	 * </p>	 */	public String callbackParam;	/**	 * 	 * (Optional) Defaults to true. Disable cacheing by adding a unique	 * parameter name to the request.	 */	public boolean nocache = true;	/**	 * 	 * (Optional) The number of milliseconds to wait for a response. Defaults to	 * 30 seconds.	 */	public int timeout = 30000;	/**	 * 	 * The URL from which to request the data object.	 */	public String url;		@Override	protected void _postProcessToString() {		super._postProcessToString();		if (callbackParam != null)			put("callbackParam", callbackParam);		if (!nocache)			put("nocache", nocache);		if (timeout != 30000)			put("timeout", timeout);		if (url != null)			put("url", url);	}		@Override	public String toString() {		_postProcessToString();		return "new " + TAG + "(" + JsHelper.printJsObject(this) + ")";	}}