package isola.model.ext.layout;import isola.helpers.JsHelper;/** *  * <p> * This is a layout that contains multiple panels in an expandable accordion * style such *  * that only one panel can be open at any given time. Each panel has built-in * support for *  * expanding and collapsing. This class is intended to be extended or created * via the *  * layout:'accordion' Ext.Container.layout config, and should generally not need * to be created *  * directly via the new keyword. * </p> *  *  *  * <p> * Note that when creating a layout via config, the layout-specific config * properties must *  * be passed in via the Ext.Container.layoutConfig object which will then be * applied internally *  * to the layout. Example usage: * </p> *  *  *  * <pre> * &lt;code&gt; * 
 * var accordion = new Ext.Panel({ * 
 *     title: 'Accordion Layout', * 
 *     layout:'accordion', * 
 *     defaults: { * 
 *         // applied to each contained panel * 
 *         bodyStyle: 'padding:15px' * 
 *     }, * 
 *     layoutConfig: { * 
 *         // layout-specific configs go here * 
 *         titleCollapse: false, * 
 *         animate: true, * 
 *         activeOnTop: true * 
 *     }, * 
 *     items: [{ * 
 *         title: 'Panel 1', * 
 *         html: '&lt;p&gt;Panel content!&lt;/p&gt;' * 
 *     },{ * 
 *         title: 'Panel 2', * 
 *         html: '&lt;p&gt;Panel content!&lt;/p&gt;' * 
 *     },{ * 
 *         title: 'Panel 3', * 
 *         html: '&lt;p&gt;Panel content!&lt;/p&gt;' * 
 *     }] * 
 * }); * 
 * &lt;/code&gt; * </pre> *  *  *  * @author Umut Gokbayrak */public class Accordion extends FitLayout {	private static final long serialVersionUID = 5668884597792758117L;	private static final String TAG = "Ext.layout.Accordion";	/**	 * 	 * True to swap the position of each panel as it is expanded so that it	 * becomes the first item	 * 	 * in the container, false to keep the panels in the rendered order. This is	 * NOT compatible	 * 	 * with "animate:true" (defaults to false).	 */	public boolean activeOnTop = false;	/**	 * 	 * True to slide the contained panels open and closed during expand/collapse	 * using animation,	 * 	 * false to open and close directly with no animation (defaults to false).	 * Note: to defer to	 * 	 * the specific config setting of each contained panel for this property,	 * set this to undefined	 * 	 * at the layout level.	 */	public boolean animate = false;	/**	 * 	 * True to set each contained item's width to 'auto', false to use the	 * item's current width	 * 	 * (defaults to true).	 */	public boolean autoWidth = true;	/**	 * 	 * True to make sure the collapse/expand toggle button always renders first	 * (to the left of)	 * 	 * any other tools in the contained panels' title bars, false to render it	 * last	 * 	 * (defaults to false).	 */	public boolean collapseFirst = false;	/**	 * 	 * True to adjust the active item's height to fill the available space in	 * the container,	 * 	 * false to use the item's current height, or auto height if not explicitly	 * set	 * 	 * (defaults to true).	 */	public boolean fill = true;	/**	 * 	 * True to hide the contained panels' collapse/expand toggle buttons, false	 * to display them	 * 	 * (defaults to false). When set to true, titleCollapse should be true also.	 */	public boolean hideCollapseTool = false;	/**	 * 	 * Experimental. If animate is set to true, this will result in each	 * animation running in	 * 	 * sequence.	 */	public boolean sequence = false;	/**	 * 	 * True to allow expand/collapse of each contained panel by clicking	 * anywhere on the title	 * 	 * bar, false to allow expand/collapse only when the toggle tool button is	 * clicked (defaults	 * 	 * to true). When set to false, hideCollapseTool should be false also.	 */	public boolean titleCollapse = true;		/**
	 * 
	 */	public Accordion() {		super();	}		@Override	protected void _postProcessToString() {		super._postProcessToString();		if (activeOnTop)			put("activeOnTop", activeOnTop);		if (animate)			put("animate", animate);		if (!autoWidth)			put("autoWidth", autoWidth);		if (collapseFirst)			put("collapseFirst", collapseFirst);		if (!fill)			put("fill", fill);		if (hideCollapseTool)			put("hideCollapseTool", hideCollapseTool);		if (sequence)			put("sequence", sequence);		if (!titleCollapse)			put("titleCollapse", titleCollapse);	}		@Override	public String toString() {		_postProcessToString();		return "new " + TAG + "(" + JsHelper.printJsObject(this) + ")";	}}