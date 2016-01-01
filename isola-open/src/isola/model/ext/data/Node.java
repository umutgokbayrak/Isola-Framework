package isola.model.ext.data;import isola.helpers.JsHelper;import isola.model.ext.base.Observable;/** *  *  *  * @author Umut Gokbayrak */public class Node extends Observable {	private static final long serialVersionUID = -3290896080409258646L;	private static final String TAG = "Ext.data.Node";	/**	 * 	 * The id for this node. If one is not specified, one is generated.	 */	public String id;	/**	 * 	 * true if this node is a leaf and does not have children	 */	public boolean leaf = false;		@Override	protected void _postProcessToString() {		super._postProcessToString();		if (id != null)			put("id", id);		if (leaf)			put("leaf", leaf);	}		@Override	public String toString() {		_postProcessToString();		return "new " + TAG + "(" + JsHelper.printJsObject(this) + ")";	}}