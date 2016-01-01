package isola.tags.ext.container;import javax.servlet.jsp.JspException;import isola.model.ext.base.Observable;import isola.model.ext.container.ViewPort;import isola.tags.ext.base.ContainerTag;/** *  * <p> * A specialized container representing the viewable application area (the * browser viewport). * </p> *  *  *  * <p> * The Viewport renders itself to the document body, and automatically sizes * itself to the *  * size of the browser viewport and manages window resizing. There may only be * one Viewport *  * created in a page. Inner layouts are available by virtue of the fact that all * Panels *  * added to the Viewport, either through its items, or through the items, or the * add method *  * of any of its child Panels may themselves have a layout. * </p> *  *  *  * <p> * The Viewport does not provide scrolling, so child Panels within the Viewport * should *  * provide for scrolling if needed using the autoScroll config. * </p> *  *  *  * <p> * Example showing a classic application border layout : * </p> *  * <pre> * &lt;code&gt; * 
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
 * &lt;/code&gt; * </pre> *  *  *  * @author Umut Gokbayrak */public class ViewPortTag extends ContainerTag {	private static final long serialVersionUID = -2211136034442056401L;		@Override	public int doEndTag() throws JspException {		ViewPort obj = new ViewPort();		prepareConfig(obj);		// manage listeners		prepareEvents(obj);		// print the output		printOut(obj);		return EVAL_PAGE;	}		@Override	public void clear() {		super.clear();	}		/**	 * 	 * 	 * 	 * @param obj	 */	protected void prepareConfig(ViewPort obj) {		setLayout("border");		super.prepareConfig(obj);	}		@Override	protected void prepareEvents(Observable obj) {		super.prepareEvents(obj);	}}