package isola.model.ext.grid;import isola.helpers.JsHelper;import isola.model.core.JsObject;/** *  * <p> * This is a utility class that can be passed into a Ext.grid.ColumnModel as a * column *  * config that provides an automatic row numbering column. Usage: * </p> *  *  *  * <pre> * &lt;code&gt; * 
 * // This is a typical column config with the first column providing row numbers * 
 * var colModel = new Ext.grid.ColumnModel([ * 
 *   new Ext.grid.RowNumberer(), * 
 *   {header: &quot;Name&quot;, width: 80, sortable: true}, * 
 *   {header: &quot;Code&quot;, width: 50, sortable: true}, * 
 *   {header: &quot;Description&quot;, width: 200, sortable: true} * 
 * ]); * 
 * &lt;/code&gt; * </pre> *  *  *  * @author Umut Gokbayrak */public class RowNumberer extends JsObject {	private static final long serialVersionUID = 3805998253985372470L;	private static final String TAG = "Ext.grid.RowNumberer";	/**	 * 	 * Any valid text or HTML fragment to display in the header cell for the	 * 	 * row number column (defaults to '').	 */	public String header;	/**	 * 	 * True if the row number column is sortable (defaults to false).	 */	public boolean sortable = false;	/**	 * 	 * The default width in pixels of the row number column (defaults to 23).	 */	public int width = 23;		/**
	 * 
	 */	public RowNumberer() {		super();	}		@Override	protected void _postProcessToString() {		super._postProcessToString();		if (header != null)			put("header", header);		if (sortable)			put("sortable", sortable);		if (width != 23)			put("width", width);	}		@Override	public String toString() {		_postProcessToString();		return "new " + TAG + "(" + JsHelper.printJsObject(this) + ")";	}}