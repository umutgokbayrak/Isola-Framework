package isola.model.ext.container;import isola.helpers.JsHelper;import isola.model.ext.base.Container;import isola.model.ext.constants.XTypes;/** *  * <p> * A specialized container representing the viewable application area (the * browser viewport). * </p> *  *  *  * <p> * The Viewport renders itself to the document body, and automatically sizes * itself to the *  * size of the browser viewport and manages window resizing. There may only be * one Viewport *  * created in a page. Inner layouts are available by virtue of the fact that all * Panels *  * added to the Viewport, either through its items, or through the items, or the * add method *  * of any of its child Panels may themselves have a layout. * </p> *  *  *  * <p> * The Viewport does not provide scrolling, so child Panels within the Viewport * should *  * provide for scrolling if needed using the autoScroll config. * </p> *  *  *  * <p> * Example showing a classic application border layout : * </p> *  * <pre> * &lt;code&gt; * 
 * new Ext.Viewport({ * 
 *     layout: 'border', * 
 *     defaults: { * 
 *         activeItem: 0 * 
 *     }, * 
 *     items: [{ * 
 *         region: 'north', * 
 *         html: '&lt;h1 class=&quot;x-panel-header&quot;&gt;Page Title&lt;/h1&gt;', * 
 *         autoHeight: true, * 
 *         border: false, * 
 *         margins: '0 0 5 0' * 
 *     }, { * 
 *         region: 'west', * 
 *         collapsible: true, * 
 *         title: 'Navigation', * 
 *         xtype: 'treepanel', * 
 *         width: 200, * 
 *         autoScroll: true, * 
 *         split: true, * 
 *         loader: new Ext.tree.TreeLoader(), * 
 *         root: new Ext.tree.AsyncTreeNode({ * 
 *             expanded: true, * 
 *             children: [{ * 
 *                 text: 'Menu Option 1', * 
 *                 leaf: true * 
 *             }, { * 
 *                 text: 'Menu Option 2', * 
 *                 leaf: true * 
 *             }, { * 
 *                 text: 'Menu Option 3', * 
 *                 leaf: true * 
 *             }] * 
 *         }), * 
 *         rootVisible: false, * 
 *         listeners: { * 
 *             click: function(n) { * 
 *                 Ext.Msg.alert('Navigation Tree Click', 'You clicked: &quot;' + n.attributes.text + '&quot;'); * 
 *             } * 
 *         } * 
 *     }, { * 
 *         region: 'center', * 
 *         xtype: 'tabpanel', * 
 *         items: { * 
 *             title: 'Default Tab', * 
 *             html: 'The first tab\'s content. Others may be added dynamically' * 
 *         } * 
 *     }, { * 
 *         region: 'south', * 
 *         title: 'Information', * 
 *         collapsible: true, * 
 *         html: 'Information goes here', * 
 *         split: true, * 
 *         height: 100, * 
 *         minHeight: 100 * 
 *     }] * 
 * }); * 
 * &lt;/code&gt; * </pre> *  *  *  * @author Umut Gokbayrak */public class ViewPort extends Container {	private static final long serialVersionUID = 3330496504440548633L;	private static final String TAG = "Ext.Viewport";	/**	 * 	 * <p>	 * The registered xtype to create. This config option is not used when	 * passing a	 * 	 * config object into a constructor. This config option is used only when	 * lazy	 * 	 * instantiation is being used, and a child item of a Container is being	 * 	 * specified not as a fully instantiated Component, but as a Component	 * config	 * 	 * object. The xtype will be looked up at render time up to determine what	 * 	 * type of child Component to create.	 * </p>	 * 	 * 	 * 	 * @see XTypes <p>	 *      If you subclass Components to create your own Components, you may	 *      register	 * 	 *      them using Ext.ComponentMgr.registerType in order to be able to take	 *      advantage	 * 	 *      of lazy instantiation and rendering.	 *      </p>	 */	public String xtype = "viewport";		public ViewPort() {		super();	}		protected void _postProcessToString() {		super._postProcessToString();		if (xtype != null)			put("xtype", xtype);	}		@Override	public String toString() {		_postProcessToString();		return "new " + TAG + "(" + JsHelper.printJsObject(this) + ")";	}}