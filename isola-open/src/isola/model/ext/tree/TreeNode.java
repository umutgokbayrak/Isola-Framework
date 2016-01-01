package isola.model.ext.tree;import isola.helpers.JsHelper;import isola.model.core.JsFunction;import isola.model.core.JsObject;import isola.model.ext.data.Node;/** *  *  *  * @author Umut Gokbayrak */public class TreeNode extends Node {	private static final long serialVersionUID = -8771073857112906339L;	private static final String TAG = "Ext.tree.TreeNode";	/**	 * 	 * False to not allow this node to have child nodes (defaults to true)	 */	public boolean allowChildren = true;	/**	 * 	 * False to make this node undraggable if draggable = true (defaults to	 * true)	 */	public boolean allowDrag = true;	/**	 * 	 * False if this node cannot have child nodes dropped on it (defaults to	 * true)	 */	public boolean allowDrop = true;	/**	 * 	 * True to render a checked checkbox for this node, false to render an	 * unchecked checkbox	 * 	 * (defaults to undefined with no checkbox rendered)	 */	public boolean checked = false;	/**	 * 	 * A css class to be added to the node	 */	public String cls;	/**	 * 	 * true to start the node disabled	 */	public boolean disabled = false;	/**	 * 	 * True to make this node draggable (defaults to false)	 */	public boolean draggable = false;	/**	 * 	 * If set to true, the node will always show a plus/minus icon, even when	 * empty	 */	public boolean expandable = false;	/**	 * 	 * true to start the node expanded	 */	public boolean expanded = false;	/**	 * 	 * URL of the link used for the node (defaults to #)	 */	public String href;	/**	 * 	 * target frame for the link	 */	public String hrefTarget;	/**	 * 	 * The path to an icon for the node. The preferred way to do this is to use	 * the cls or	 * 	 * iconCls attributes and add the icon via a CSS background image.	 */	public String icon;	/**	 * 	 * A css class to be added to the nodes icon element for applying css	 * background images	 */	public String iconCls;	/**	 * 	 * False to not allow this node to act as a drop target (defaults to true)	 */	public boolean isTarget = true;	/**	 * 	 * An Ext QuickTip for the node	 */	public String qtip;	/**	 * 	 * An Ext QuickTip config for the node (used instead of qtip)	 */	public JsObject qtipCfg;	/**	 * 	 * True for single click expand on this node	 */	public boolean singleClickExpand = false;	/**	 * 	 * The text for this node	 */	public String text;	/**	 * 	 * A UI class to use for this node (defaults to Ext.tree.TreeNodeUI)	 */	public JsFunction uiProvider;		public TreeNode() {		super();	}		@Override	protected void _postProcessToString() {		super._postProcessToString();		if (!allowChildren)			put("allowChildren", allowChildren);		if (!allowDrag)			put("allowDrag", allowDrag);		if (!allowDrop)			put("allowDrop", allowDrop);		if (checked)			put("checked", checked);		if (cls != null)			put("cls", cls);		if (disabled)			put("disabled", disabled);		if (draggable)			put("draggable", draggable);		if (expandable)			put("expandable", expandable);		if (expanded)			put("expanded", expanded);		if (href != null)			put("href", href);		if (hrefTarget != null)			put("hrefTarget", hrefTarget);		if (icon != null)			put("icon", icon);		if (iconCls != null)			put("iconCls", iconCls);		if (!isTarget)			put("isTarget", isTarget);		if (qtip != null)			put("qtip", qtip);		if (qtipCfg != null)			put("qtipCfg", qtipCfg);		if (singleClickExpand)			put("singleClickExpand", singleClickExpand);		if (text != null)			put("text", text);		if (uiProvider != null)			put("uiProvider", uiProvider);	}		@Override	public String toString() {		_postProcessToString();		return "new " + TAG + "(" + JsHelper.printJsObject(this) + ")";	}}