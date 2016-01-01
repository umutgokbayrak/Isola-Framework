package isola.model.ext.layout;import isola.helpers.JsHelper;/** *  * <p> * This is a multi-pane, application-oriented UI layout style that supports * multiple nested *  * panels, automatic split bars between regions and built-in expanding and * collapsing of *  * regions. This class is intended to be extended or created via the * layout:'border' *  * Ext.Container.layout config, and should generally not need to be created * directly via the *  * new keyword. * </p> *  *  *  * <p> * BorderLayout does not have any direct config options (other than inherited * ones). All configs *  * available for customizing the BorderLayout are at the * Ext.layout.BorderLayout.Region and *  * Ext.layout.BorderLayout.SplitRegion levels. Example usage: * </p> *  *  *  * <pre> * &lt;code&gt; * 
 * var border = new Ext.Panel({ * 
 *     title: 'Border Layout', * 
 *     layout:'border', * 
 *     items: [{ * 
 *         title: 'South Panel', * 
 *         region: 'south', * 
 *         height: 100, * 
 *         minSize: 75, * 
 *         maxSize: 250, * 
 *         margins: '0 5 5 5' * 
 *     },{ * 
 *         title: 'West Panel', * 
 *         region:'west', * 
 *         margins: '5 0 0 5', * 
 *         cmargins: '5 5 0 5', * 
 *         width: 200, * 
 *         minSize: 100, * 
 *         maxSize: 300 * 
 *     },{ * 
 *         title: 'Main Content', * 
 *         region:'center', * 
 *         margins: '5 5 0 0' * 
 *     }] * 
 * }); * 
 * &lt;/code&gt; * </pre> *  *  *  * Items added to the border layout has some extra config attributes and border * layout is configured by them. *  * These are: *  * <ul> *  * <li> *  * <strong>animFloat</strong> : Boolean<br/> *  * When a collapsed region's bar is clicked, the region's panel will be * displayed as a floated panel *  * that will close again once the user mouses out of that panel (or clicks out * if autoHide = false). *  * Setting animFloat to false will prevent the open and close of these floated * panels from being *  * animated (defaults to true). *  * </li> *  * <li> *  * <strong>autoHide</strong> : Boolean<br/> *  * When a collapsed region's bar is clicked, the region's panel will be * displayed as a floated panel. *  * If autoHide is true, the panel will automatically hide after the user mouses * out of the panel. *  * If autoHide is false, the panel will continue to display until the user * clicks outside of the panel *  * (defaults to true). *  * </li> *  * <li> *  * <strong>cmargins</strong> : Object<br/> *  * An object containing margins to apply to the region's collapsed element in * the format *  * {left: (left margin), top: (top margin), right: (right margin), bottom: * (bottom margin)} *  * </li> *  * <li> *  * <strong>collapseMode</strong> : String<br/> *  * By default, collapsible regions are collapsed by clicking the expand/collapse * tool button that *  * renders into the region's title bar. Optionally, when collapseMode is set to * 'mini' the region's *  * split bar will also display a small collapse button in the center of the bar. * In 'mini' mode *  * the region will collapse to a thinner bar than in normal mode. By default * collapseMode is undefined, *  * and the only two supported values are undefined and 'mini'. Note that if a * collapsible region does *  * not have a title bar, then collapseMode must be set to 'mini' in order for * the region to be *  * collapsible by the user as the tool button will not be rendered. *  * </li> *  * <li> *  * <strong>collapsible</strong> : Boolean<br/> *  * True to allow the user to collapse this region (defaults to false). If true, * an expand/collapse *  * tool button will automatically be rendered into the title bar of the region, * otherwise the button *  * will not be shown. Note that a title bar is required to display the toggle * button -- if no region *  * title is specified, the region will only be collapsible if collapseMode is * set to 'mini'. *  * </li> *  * <li> *  * <strong>floatable</strong> : Boolean<br/> *  * True to allow clicking a collapsed region's bar to display the region's panel * floated above the *  * layout, false to force the user to fully expand a collapsed region by * clicking the expand button *  * to see it again (defaults to true). *  * </li> *  * <li> *  * <strong>margins</strong> : Object<br/> *  * An object containing margins to apply to the region in the format *  * {left: (left margin), top: (top margin), right: (right margin), bottom: * (bottom margin)} *  * </li> *  * <li> *  * <strong>minHeight</strong> : Number<br/> *  * The minimum allowable height in pixels for this region (defaults to 50) *  * </li> *  * <li> *  * <strong>minWidth</strong> : Number<br/> *  * The minimum allowable width in pixels for this region (defaults to 50) *  * </li> *  * <li> *  * <strong>split</strong> : Boolean</br> *  * True to display a Ext.SplitBar between this region and its neighbor, allowing * the user to resize *  * the regions dynamically (defaults to false). When split = true, it is common * to specify a minSize *  * and maxSize for the region. *  * </li> *  * </ul> *  *  *  * <p> * If split is enabled then the items added have some more extra config options. * These are: * </p> *  *  *  * <ul> *  * <li> *  * <strong>collapsibleSplitTip</strong> : String<br/> *  * The tooltip to display when the user hovers over a collapsible region's split * bar (defaults to *  * "Drag to resize. Double click to hide."). Only applies if useSplitTips = * true. *  * </li> *  * <li> *  * <strong>splitTip</strong> : String<br/> *  * The tooltip to display when the user hovers over a non-collapsible region's * split bar *  * (defaults to "Drag to resize."). Only applies if useSplitTips = true. *  * </li> *  * <li> *  * <strong>useSplitTips</strong> : Boolean<br/> *  * True to display a tooltip when the user hovers over a region's split bar * (defaults to false). *  * The tooltip text will be the value of either splitTip or collapsibleSplitTip * as appropriate. *  * </li> *  * </ul> *  *  *  * @author Umut Gokbayrak */public class BorderLayout extends ContainerLayout {	private static final long serialVersionUID = -2006851617283280583L;	private static final String TAG = "Ext.layout.BorderLayout";	/**	 * 	 * An optional extra CSS class that will be added to the container (defaults	 * to ''). This can	 * 	 * be useful for adding customized styles to the container or any of its	 * children using	 * 	 * standard CSS rules.	 */	public String extraCls;	/**	 * 	 * True to hide each contained item on render (defaults to false).	 */	public boolean renderHidden = false;		/**
	 * 
	 */	public BorderLayout() {		super();	}		@Override	protected void _postProcessToString() {		super._postProcessToString();		if (extraCls != null)			put("extraCls", extraCls);		if (renderHidden)			put("renderHidden", renderHidden);	}		@Override	public String toString() {		_postProcessToString();		return "new " + TAG + "(" + JsHelper.printJsObject(this) + ")";	}}