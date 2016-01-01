package isola.model.ext.data;import isola.helpers.JsHelper;/** *  * <p> * Data reader class to create an Array of Ext.data.Record objects from an * Array. *  * Each element of that Array represents a row of data fields. The fields are * pulled *  * into a Record object using as a subscript, the mapping property of the field *  * definition if it exists, or the field's ordinal position in the definition. * </p> *  *  *  * <pre> * &lt;code&gt; * 
 * var Employee = Ext.data.Record.create([ * 
 *   {name: 'name', mapping: 1},         // &quot;mapping&quot; only needed if an &quot;id&quot; field is present which * 
 *   {name: 'occupation', mapping: 2}    // precludes using the ordinal position as the index. * 
 * ]); * 
 *  * 
 * var myReader = new Ext.data.ArrayReader({ * 
 *   id: 0                     // The subscript within row Array that provides an ID for the Record (optional) * 
 * }, Employee); * 
 * &lt;/code&gt; * </pre> *  *  *  * @author Umut Gokbayrak */public class ArrayReader extends DataReader {	private static final long serialVersionUID = 5938618727314282247L;	private static final String TAG = "Ext.data.ArrayReader";	/**	 * 	 * (optional) The subscript within row Array that provides an ID for the	 * Record	 */	public String id;		@Override	protected void _postProcessToString() {		super._postProcessToString();		if (id != null)			put("id", id);	}		@Override	public String toString() {		_postProcessToString();		return "new " + TAG + "(" + JsHelper.printJsObject(this) + ")";	}}