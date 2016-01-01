package isola.model.ext.misc;import isola.helpers.JsHelper;import isola.model.ext.base.Observable;/** *  * Provides AJAX-style update for Element object. Usage: *  * <pre> * &lt;code&gt; * 
 * // Get it from a Ext.Element object * 
 * var el = Ext.get(&quot;foo&quot;); * 
 * var mgr = el.getUpdater(); * 
 * mgr.update({ * 
 *   url: &quot;http://myserver.com/index.php&quot;,  * 
 *   params: { * 
 *     param1: &quot;foo&quot;, * 
 *     param2: &quot;bar&quot; * 
 *   } * 
 * }); * 
 * ... * 
 * mgr.formUpdate(&quot;myFormId&quot;, &quot;http://myserver.com/index.php&quot;); * 
 *  * 
 * // or directly (returns the same Updater instance) * 
 * var mgr = new Ext.Updater(&quot;myElementId&quot;); * 
 * mgr.startAutoRefresh(60, &quot;http://myserver.com/index.php&quot;); * 
 * mgr.on(&quot;update&quot;, myFcnNeedsToKnow); * 
 *  * 
 * // short handed call directly from the element object * 
 * Ext.get(&quot;foo&quot;).load({ * 
 *   url: &quot;bar.php&quot;,  * 
 *   scripts: true, * 
 *   params: &quot;param1=foo&amp;param2=bar&quot;, * 
 *   text: &quot;Loading Foo...&quot; * 
 * }); * 
 * &lt;/code&gt; * </pre> *  *  *  * @author Umut Gokbayrak */public class Updater extends Observable {	private static final long serialVersionUID = -2814330561233014655L;	private static final String TAG = "Ext.Updater";		public Updater() {		super();	}		@Override	protected void _postProcessToString() {		super._postProcessToString();	}		@Override	public String toString() {		_postProcessToString();		return "new " + TAG + "(" + JsHelper.printJsObject(this) + ")";	}}