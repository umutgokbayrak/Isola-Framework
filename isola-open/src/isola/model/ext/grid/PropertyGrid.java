package isola.model.ext.grid;import isola.helpers.JsHelper;import isola.model.core.JsObject;/** *  * <p> * A specialized grid implementation intended to mimic the traditional property * grid *  * as typically seen in development IDEs. Each row in the grid represents a * property *  * of some object, and the data is stored as a set of name/value pairs in *  * Ext.grid.PropertyRecords. * </p> *  *  *  * <p> * Example usage: * </p> *  * <code><pre> * var grid = new Ext.grid.PropertyGrid({ *     title: 'Properties Grid', *     autoHeight: true, *     width: 300, *     renderTo: 'grid-ct', *     source: { *         "(name)": "My Object", *         "Created": new Date(Date.parse('10/15/2006')), *         "Available": false, *         "Version": .01, *         "Description": "A test object" *     } * }); * </pre></code> *  *  *  * @author Umut Gokbayrak */public class PropertyGrid extends EditorGridPanel {	private static final long serialVersionUID = 2992522274272068289L;	private static final String TAG = "Ext.grid.PropertyGrid";	/**	 * 	 * <p>	 * An object containing name/value pairs of custom editor type definitions	 * that allow	 * 	 * the grid to support additional types of editable fields. By default, the	 * grid supports	 * 	 * strongly-typed editing of strings, dates, numbers and booleans using	 * built-in form	 * 	 * editors, but any custom type can be supported and associated with a	 * custom input control	 * 	 * by specifying a custom editor. The name of the editor type should	 * correspond with the	 * 	 * name of the property that will use the editor. Example usage:	 * </p>	 * 	 * 	 * 	 * <pre>	 * &lt;code&gt;	 * 
	 * var grid = new Ext.grid.PropertyGrid({	 * 
	 *     ...	 * 
	 *     customEditors: {	 * 
	 *         'Start Time': new Ext.grid.GridEditor(new Ext.form.TimeField({selectOnFocus:true}))	 * 
	 *     },	 * 
	 *     source: {	 * 
	 *         'Start Time': '10:00 AM'	 * 
	 *     }	 * 
	 * });	 * 
	 * &lt;/code&gt;	 * </pre>	 * 	 * 	 */	public JsObject customEditors;	/**	 * 	 * <p>	 * Sets the source data object containing the property data. The data object	 * can contain	 * 	 * one or more name/value pairs representing all of the properties of an	 * object to display	 * 	 * in the grid, and this data will automatically be loaded into the grid's	 * store. The values	 * 	 * should be supplied in the proper data type if needed, otherwise string	 * type will be assumed.	 * 	 * If the grid already contains data, this method will replace any existing	 * data. See also the	 * 	 * source config value. Example usage:	 * </p>	 * 	 * <pre>	 * &lt;code&gt;	 * 
	 * {	 * 
	 * &quot;(name)&quot;: &quot;My Object&quot;,	 * 
	 * 	&quot;Created&quot;: new Date(Date.parse('10/15/2006')),  // date type	 * 
	 * 	&quot;Available&quot;: false,  // boolean type	 * 
	 * 	&quot;Version&quot;: .01,      // decimal type	 * 
	 * 	&quot;Description&quot;: &quot;A test object&quot;	 * 
	 * }	 * 
	 * &lt;/code&gt;	 * </pre>	 */	public JsObject source;		public PropertyGrid() {		super();	}		@Override	protected void _postProcessToString() {		super._postProcessToString();		if (customEditors != null)			put("customEditors", customEditors);		if (source != null)			put("customEditors", customEditors);		put("xtype", null);	}		@Override	public String toString() {		_postProcessToString();		return "new " + TAG + "(" + JsHelper.printJsObject(this) + ")";	}}