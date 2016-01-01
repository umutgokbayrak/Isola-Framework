package isola.tags.ext.layout;

import javax.servlet.jsp.JspException;

import isola.model.ext.base.Observable;
import isola.model.ext.container.Panel;
import isola.tags.ext.container.PanelTag;

/**
 * <p>This is a multi-pane, application-oriented UI layout style that supports multiple nested 
 * panels, automatic split bars between regions and built-in expanding and collapsing of 
 * regions. This class is intended to be extended or created via the layout:'border' 
 * Ext.Container.layout config, and should generally not need to be created directly via the 
 * new keyword.</p>
 * 
 * <p>BorderLayout does not have any direct config options (other than inherited ones). All configs 
 * available for customizing the BorderLayout are at the Ext.layout.BorderLayout.Region and 
 * Ext.layout.BorderLayout.SplitRegion levels. Complex Example:</p>
 * 
 * <pre><code>
 * &lt;ext:body runOnLoad="true"&gt;
 * 	&lt;ext:borderLayout renderTo="hebelek" border="true" width="900" height="600"&gt;
 * 		&lt;ext:treePanel rootVisible="true" lines="true" region="west" split="true" width="200" autoScroll="true" animate="true" enableDD="true" title="Folder Tree"&gt;
 * 			&lt;ext:asyncTreeNode text="Root Node" id="source" draggable="false" /&gt;
 * 			&lt;ext:treeLoader url="servlet/TreeLoaderServlet" method="post" /&gt;
 * 		&lt;/ext:treePanel&gt;
 * 		&lt;ext:borderLayout region="center" split="true"&gt;
 * 			&lt;ext:gridPanel region="north" height="300" forceFit="true" border="true" checkboxEnabled="true"&gt;
 * 				&lt;ext:jsonStore url="servlet/JsonSampleServlet" root="result"&gt;
 * 					&lt;ext:httpParam name="action" value="env"/&gt;
 * 					&lt;ext:storeMapping name="name"/&gt;
 * 					&lt;ext:storeMapping name="value"/&gt;
 * 				&lt;/ext:jsonStore&gt;
 * 				&lt;ext:columnModel&gt;
 * 					&lt;ext:gridColumn dataIndex="name" header="Name" /&gt;
 * 					&lt;ext:gridColumn dataIndex="value" header="Value" /&gt;
 * 				&lt;/ext:columnModel&gt;
 * 			&lt;/ext:gridPanel&gt;
 * 			&lt;ext:borderLayout region="center" split="true" border="false"&gt;
 * 				&lt;ext:panel region="north" height="40" bodyStyle="background-color:#f8f8f8;" contentEl="msgHead" style="border-top: 1px solid #eeeeee; border-bottom:1px solid #eeeeee;"&gt;
 * 				&lt;/ext:panel&gt;
 * 				&lt;ext:panel region="center" split="true" border="true"&gt;
 * 					This is the center pane
 * 				&lt;/ext:panel&gt;
 * 			&lt;/ext:borderLayout&gt;
 * 		&lt;/ext:borderLayout&gt;
 * 	&lt;/ext:borderLayout&gt;
 * &lt;/ext:body&gt;
 * 
 * &lt;div id="hebelek"&gt;&lt;/div&gt;
 * 
 * &lt;div id="msgHead"&gt;
 * 	&lt;b&gt;From:&lt;/b&gt;Test User&lt;br/&gt;
 * 	&lt;b&gt;Subject:&lt;/b&gt;Test Subject
 * &lt;/div&gt;
 * </code></pre>
 * 
 * Items added to the border layout has some extra config attributes and border layout is configured by them. 
 * These are: 
 * <ul>
 * 	<li>
 * 		<strong>animFloat</strong> : Boolean<br/>
 *		When a collapsed region's bar is clicked, the region's panel will be displayed as a floated panel 
 *		that will close again once the user mouses out of that panel (or clicks out if autoHide = false). 
 *		Setting animFloat to false will prevent the open and close of these floated panels from being 
 *		animated (defaults to true).
 *	</li>
 *	<li>
 *		<strong>autoHide</strong> : Boolean<br/>
 * 		When a collapsed region's bar is clicked, the region's panel will be displayed as a floated panel. 
 * 		If autoHide is true, the panel will automatically hide after the user mouses out of the panel. 
 * 		If autoHide is false, the panel will continue to display until the user clicks outside of the panel 
 * 		(defaults to true).
 *	</li>
 *	<li>
 *		<strong>cmargins</strong> : Object<br/>
 *		An object containing margins to apply to the region's collapsed element in the format 
 *		{left: (left margin), top: (top margin), right: (right margin), bottom: (bottom margin)}
 *	</li>
 *	<li>
 *		<strong>collapseMode</strong> : String<br/>
 *		By default, collapsible regions are collapsed by clicking the expand/collapse tool button that 
 *		renders into the region's title bar. Optionally, when collapseMode is set to 'mini' the region's 
 *		split bar will also display a small collapse button in the center of the bar. In 'mini' mode 
 *		the region will collapse to a thinner bar than in normal mode. By default collapseMode is undefined, 
 *		and the only two supported values are undefined and 'mini'. Note that if a collapsible region does 
 *		not have a title bar, then collapseMode must be set to 'mini' in order for the region to be 
 *		collapsible by the user as the tool button will not be rendered.
 *	</li>
 *	<li>
 *		<strong>collapsible</strong> : Boolean<br/>
 * 		True to allow the user to collapse this region (defaults to false). If true, an expand/collapse 
 * 		tool button will automatically be rendered into the title bar of the region, otherwise the button 
 * 		will not be shown. Note that a title bar is required to display the toggle button -- if no region 
 * 		title is specified, the region will only be collapsible if collapseMode is set to 'mini'.
 * 	</li>
 * 	<li>
 * 		<strong>floatable</strong> : Boolean<br/>
 * 		True to allow clicking a collapsed region's bar to display the region's panel floated above the 
 * 		layout, false to force the user to fully expand a collapsed region by clicking the expand button 
 * 		to see it again (defaults to true).
 * 	</li>
 * 	<li>
 * 		<strong>margins</strong> : Object<br/>
 * 		An object containing margins to apply to the region in the format 
 * 		{left: (left margin), top: (top margin), right: (right margin), bottom: (bottom margin)}
 * 	</li>
 * 	<li>
 * 		<strong>minHeight</strong> : Number<br/>
 * 		The minimum allowable height in pixels for this region (defaults to 50)
 * 	</li>
 * 	<li>
 * 		<strong>minWidth</strong> : Number<br/>
 * 		The minimum allowable width in pixels for this region (defaults to 50)
 * 	</li>
 * 	<li>
 * 		<strong>split</strong> : Boolean</br>
 * 		True to display a Ext.SplitBar between this region and its neighbor, allowing the user to resize 
 * 		the regions dynamically (defaults to false). When split = true, it is common to specify a minSize 
 * 		and maxSize for the region.
 * 	</li>
 * </ul>
 * 
 * <p>If split is enabled then the items added have some more extra config options. These are:</p>
 * 
 * <ul>
 * 	<li>
 * 		<strong>collapsibleSplitTip</strong> : String<br/>
 * 		The tooltip to display when the user hovers over a collapsible region's split bar (defaults to 
 * 		"Drag to resize. Double click to hide."). Only applies if useSplitTips = true.
 * 	</li>
 * 	<li>
 * 		<strong>splitTip</strong> : String<br/>
 * 		The tooltip to display when the user hovers over a non-collapsible region's split bar 
 * 		(defaults to "Drag to resize."). Only applies if useSplitTips = true.
 * 	</li>
 * 	<li>
 * 		<strong>useSplitTips</strong> : Boolean<br/>
 * 		True to display a tooltip when the user hovers over a region's split bar (defaults to false). 
 * 		The tooltip text will be the value of either splitTip or collapsibleSplitTip as appropriate.
 * 	</li>
 * </ul>
 * 
 * @author Umut Gokbayrak
 */
public class BorderLayoutTag extends PanelTag {
	private static final long serialVersionUID = 1071068733723826130L;

	@Override
	public int doEndTag() throws JspException {
		Panel obj = new Panel();
		prepareConfig(obj);

		// manage listeners
		prepareEvents(obj);

		// print the output
		printOut(obj);

		return EVAL_PAGE;
	}

	@Override
	public void clear() {
		super.clear();
	}
	
	/**
	 * 
	 * @param obj
	 */
	protected void prepareConfig(Panel obj) {
		setLayout("border");
		super.prepareConfig(obj);
	}

	@Override
	protected void prepareEvents(Observable obj) {
		super.prepareEvents(obj);
	}

}
