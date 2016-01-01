package isola.model.ext.data;import isola.helpers.JsHelper;/** *  * <p> * Data reader class to create an Array of Ext.data.Record objects from a *  * JSON response based on mappings in a provided Ext.data.Record constructor. *  * Example code: * </p> *  *  *  * <pre> * &lt;code&gt; * 
 * var Employee = Ext.data.Record.create([ * 
 *    {name: 'name', mapping: 'name'},     // &quot;mapping&quot; property not needed if it's the same as &quot;name&quot; * 
 *   {name: 'occupation'}                 // This field will use &quot;occupation&quot; as the mapping. * 
 * ]); * 
 *  * 
 * var myReader = new Ext.data.JsonReader({ * 
 *   totalProperty: &quot;results&quot;,    // The property which contains the total dataset size (optional) * 
 *   root: &quot;rows&quot;,                // The property which contains an Array of row objects * 
 *   id: &quot;id&quot;                     // The property within each row object that provides an ID for the record (optional) * 
 * }, Employee); * 
 * &lt;/code&gt; * </pre> *  *  *  * <p> * This would consume a JSON file like this: * </p> *  * <pre> * &lt;code&gt; * 
 * { 'results': 2, 'rows': [ * 
 *   { 'id': 1, 'name': 'Bill', occupation: 'Gardener' }, * 
 *   { 'id': 2, 'name': 'Ben', occupation: 'Horticulturalist' } ] * 
 * } * 
 * &lt;/code&gt; * </pre> *  *  *  * <p> * It is possible to change a JsonReader's metadata at any time by including a * MetaData *  * property in the data object. If this is detected in the object, a Store * object using *  * this Reader will fire its metachange event. * </p> *  *  *  * <p> * The MetaData property may contain any of the configuration options for this * class. *  * Additionally, it may contain a fields property which the JsonReader will use * that as an *  * argument to Ext.data.Record.create to configure the layout of the Records * which it *  * will produce. * </p> *  *  *  * <p> * Using the MetaData property, and the Store's metachange event, it is possible * to have *  * a Store-driven control initialize itself. The metachange event handler may * interrogate the *  * MetaData property (which may contain any user-defined properties needed) and * the *  * MetaData.fields property to perform any configuration required. * </p> *  *  *  * <p> * To use this facility to send the same data as the above example without * having to code *  * the creation of the Record constructor, you would create the JsonReader like * this: * </p> *  *  *  * <pre> * &lt;code&gt; * 
 * var myReader = new Ext.data.JsonReader(); * 
 * &lt;/code&gt; * </pre> *  *  *  * <p> * The first data packet from the server would configure the reader by * containing a *  * metaData property as well as the data: * </p> *  *  *  * <pre> * &lt;code&gt; * 
 * { * 
 * 'metaData': { * 
 *   totalProperty: 'results', * 
 *   root: 'rows', * 
 *   id: 'id', * 
 *   fields: [ * 
 *     {name: 'name'}, * 
 *     {name: 'occupation'} ] * 
 *  }, * 
 * 'results': 2, 'rows': [ * 
 *   { 'id': 1, 'name': 'Bill', occupation: 'Gardener' }, * 
 *   { 'id': 2, 'name': 'Ben', occupation: 'Horticulturalist' } ] * 
 * } * 
 * &lt;/code&gt; * </pre> *  *  *  * @author Umut Gokbayrak */public class JsonReader extends DataReader {	private static final long serialVersionUID = -3139713203341701262L;	private static final String TAG = "Ext.data.JsonReader";	/**	 * 	 * Name of the property within a row object that contains a record	 * identifier value.	 */	public String id;	/**	 * 	 * name of the property which contains the Array of row objects.	 */	public String root;	/**	 * 	 * Name of the property from which to retrieve the success attribute used by	 * forms.	 */	public String successProperty;	/**	 * 	 * Name of the property from which to retrieve the total number of records	 * in the	 * 	 * dataset. This is only needed if the whole dataset is not passed in one	 * go, but	 * 	 * is being paged from the remote server.	 */	public String totalProperty;		@Override	protected void _postProcessToString() {		super._postProcessToString();		if (id != null)			put("id", id);		if (root != null)			put("root", root);		if (successProperty != null)			put("successProperty", successProperty);		if (totalProperty != null)			put("totalProperty", totalProperty);	}		@Override	public String toString() {		_postProcessToString();		return "new " + TAG + "(" + JsHelper.printJsObject(this) + ")";	}}