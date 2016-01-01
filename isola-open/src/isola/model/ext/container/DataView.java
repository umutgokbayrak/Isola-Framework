package isola.model.ext.container;import isola.helpers.JsHelper;import isola.model.ext.constants.XTypes;import isola.model.ext.data.Store;/** *  * <p> * A mechanism for displaying data using custom layout templates and formatting. *  * DataView uses an Ext.XTemplate as its internal templating mechanisma, and is *  * bound to an Ext.data.Store so that as the data in the store changes the view * is *  * automatically updated to reflect the changes. The view also provides built-in *  * behavior for many common events that can occur for its contained items * including *  * click, doubleclick, mouseover, mouseout, etc. as well as a built-in selection *  * model. In order to use these features, an itemSelector config must be * provided *  * for the DataView to determine what nodes it will be working with. * </p> *  *  *  * <p> * The example below binds a DataView to a Ext.data.Store and renders it into *  * an Ext.Panel. * </p> *  *  *  * <pre> * &lt;code&gt; * 
 * var store = new Ext.data.JsonStore({ * 
 *     url: 'get-images.php', * 
 *     root: 'images', * 
 *     fields: [ * 
 *         'name', 'url', * 
 *         {name:'size', type: 'float'}, * 
 *         {name:'lastmod', type:'date', dateFormat:'timestamp'} * 
 *     ] * 
 * }); * 
 * store.load(); * 
 *  * 
 * var tpl = new Ext.XTemplate( * 
 *     '&lt;tpl for=&quot;.&quot;&gt;', * 
 *         '&lt;div class=&quot;thumb-wrap&quot; id=&quot;{name}&quot;&gt;', * 
 *         '&lt;div class=&quot;thumb&quot;&gt;&lt;img src=&quot;{url}&quot; title=&quot;{name}&quot;&gt;&lt;/div&gt;', * 
 *         '&lt;span class=&quot;x-editable&quot;&gt;{shortName}&lt;/span&gt;&lt;/div&gt;', * 
 *     '&lt;/tpl&gt;', * 
 *     '&lt;div class=&quot;x-clear&quot;&gt;&lt;/div&gt;' * 
 * ); * 
 *  * 
 * var panel = new Ext.Panel({ * 
 *     id:'images-view', * 
 *     frame:true, * 
 *     width:535, * 
 *     autoHeight:true, * 
 *     collapsible:true, * 
 *     layout:'fit', * 
 *     title:'Simple DataView', * 
 *  * 
 *     items: new Ext.DataView({ * 
 *         store: store, * 
 *         tpl: tpl, * 
 *         autoHeight:true, * 
 *         multiSelect: true, * 
 *         overClass:'x-view-over', * 
 *         itemSelector:'div.thumb-wrap', * 
 *         emptyText: 'No images to display' * 
 *     }) * 
 * }); * 
 * panel.render(document.body); * 
 * &lt;/code&gt; * </pre> *  *  *  * @author Umut Gokbayrak */public class DataView extends BoxComponent {	private static final long serialVersionUID = -8676595458229093741L;	private static final String TAG = "Ext.DataView";	/**	 * 	 * The text to display in the view when there is no data to display	 * (defaults to '').	 */	public String emptyText;	/**	 * 	 * <strong>This is a required setting.</strong> A simple CSS selector (e.g.	 * 	 * div.some-class or span:first-child) that will be used to determine	 * 	 * what nodes this DataView will be working with.	 */	public String itemSelector;	/**	 * 	 * A string to display during data load operations (defaults to undefined).	 * 	 * If specified, this text will be displayed in a loading div and the	 * 	 * view's contents will be cleared while loading, otherwise the view's	 * 	 * contents will continue to display normally until the new data is	 * 	 * loaded and the contents are replaced.	 */	public String loadingText;	/**	 * 	 * True to allow selection of more than one item at a time, false to	 * 	 * allow selection of only a single item at a time or no selection at all,	 * 	 * depending on the value of singleSelect (defaults to false).	 */	public boolean multiSelect = false;	/**	 * 	 * A CSS class to apply to each item in the view on mouseover (defaults to	 * undefined).	 */	public String overClass;	/**	 * 	 * A CSS class to apply to each selected item in the view (defaults to	 * 'x-view-selected').	 */	public String selectedClass;	/**	 * 	 * True to enable multiselection by clicking on multiple items without	 * requiring the	 * 	 * user to hold Shift or Ctrl, false to force the user to hold Ctrl or Shift	 * to	 * 	 * select more than on item (defaults to false).	 */	public boolean simpleSelect = false;	/**	 * 	 * True to allow selection of exactly one item at a time, false to allow no	 * selection	 * 	 * at all (defaults to false). Note that if multiSelect = true, this value	 * will be ignored.	 */	public boolean singleSelect = false;	/**	 * 	 * The Ext.data.Store to bind this DataView to.	 */	public Store store;	/**	 * 	 * The HTML fragment or an array of fragments that will make up the template	 * used by this	 * 	 * DataView. This should be specified in the same format expected by the	 * constructor	 * 	 * of Ext.XTemplate.	 */	public String tpl;	/**	 * 	 * <p>	 * The registered xtype to create. This config option is not used when	 * passing a	 * 	 * config object into a constructor. This config option is used only when	 * lazy	 * 	 * instantiation is being used, and a child item of a Container is being	 * 	 * specified not as a fully instantiated Component, but as a Component	 * config	 * 	 * object. The xtype will be looked up at render time up to determine what	 * 	 * type of child Component to create.	 * </p>	 * 	 * 	 * 	 * @see XTypes <p>	 *      If you subclass Components to create your own Components, you may	 *      register	 * 	 *      them using Ext.ComponentMgr.registerType in order to be able to take	 *      advantage	 * 	 *      of lazy instantiation and rendering.	 *      </p>	 */	public String xtype = XTypes.dataview;		public DataView() {		super();	}		@Override	protected void _postProcessToString() {		super._postProcessToString();		if (emptyText != null)			put("emptyText", emptyText);		if (itemSelector != null)			put("itemSelector", itemSelector);		if (loadingText != null)			put("loadingText", loadingText);		if (multiSelect)			put("multiSelect", multiSelect);		if (overClass != null)			put("overClass", overClass);		if (selectedClass != null)			put("selectedClass", selectedClass);		if (simpleSelect)			put("simpleSelect", simpleSelect);		if (singleSelect)			put("singleSelect", singleSelect);		if (store != null)			put("store", store);		if (tpl != null)			put("tpl", tpl);		if (xtype != null)			put("xtype", xtype);	}		@Override	public String toString() {		_postProcessToString();		return "new " + TAG + "(" + JsHelper.printJsObject(this) + ")";	}}