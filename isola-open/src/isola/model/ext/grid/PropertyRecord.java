package isola.model.ext.grid;import isola.helpers.JsHelper;import isola.model.core.JsObject;/** *  * A specific Ext.data.Record type that represents a name/value pair and is made * to work *  * with the Ext.grid.PropertyGrid. Typically, PropertyRecords do not need to be * created *  * directly as they can be created implicitly by simply using the appropriate * data configs *  * either via the Ext.grid.PropertyGrid.source config property or by calling *  * Ext.grid.PropertyGrid.setSource. However, if the need arises, these records * can also be *  * created explicitly as shwon below. Example usage: *  *  *  * <pre> * &lt;code&gt; * 
 * var rec = new Ext.grid.PropertyRecord({ * 
 *   name: 'Birthday', * 
 *   value: new Date(Date.parse('05/26/1972')) * 
 * }); * 
 *  * 
 * // Add record to an already populated grid * 
 * grid.store.addSorted(rec); * 
 * &lt;/code&gt; * </pre> *  *  *  * @author Umut Gokbayrak */public class PropertyRecord extends JsObject {	private static final long serialVersionUID = -7186107631512094783L;	private static final String TAG = "Ext.grid.PropertyRecord";		/**
	 * 
	 */	public PropertyRecord() {		super();	}		@Override	protected void _postProcessToString() {		super._postProcessToString();	}		@Override	public String toString() {		_postProcessToString();		return "new " + TAG + "(" + JsHelper.printJsObject(this) + ")";	}}