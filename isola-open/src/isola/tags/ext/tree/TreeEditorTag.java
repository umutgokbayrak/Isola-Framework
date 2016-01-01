package isola.tags.ext.tree;import javax.servlet.jsp.JspException;import isola.model.ext.base.Observable;import isola.model.ext.tree.TreeEditor;import isola.tags.ext.form.EditorTag;/** *  * Provides editor functionality for inline tree node editing. Any valid * Ext.form.Field can be *  * used as the editor field. *  *  *  * @author Umut Gokbayrak */public class TreeEditorTag extends EditorTag {	private static final long serialVersionUID = 2133270881887838110L;	private String alignment;	private String cls;	private String editDelay;	private String hideEl;	private String maxWidth;	private String shim;		@Override	public int doEndTag() throws JspException {		TreeEditor obj = new TreeEditor();		prepareConfig(obj);		// manage listeners		prepareEvents(obj);		// print the output		printOut(obj);		return EVAL_PAGE;	}		@Override	public void clear() {		super.clear();		alignment = cls = null;		editDelay = "350";		hideEl = "false";		maxWidth = "250";		shim = "false";	}		/**	 * 	 * 	 * 	 * @param obj	 */	protected void prepareConfig(TreeEditor obj) {		super.prepareConfig(obj);		obj.alignment = alignment;		obj.cls = cls;		if (editDelay != null) {			try {				obj.editDelay = Integer.parseInt(editDelay);			} catch (Exception e) {			}		}		if (hideEl != null) {			try {				obj.hideEl = Boolean.valueOf(hideEl);			} catch (Exception e) {			}		}		if (maxWidth != null) {			try {				obj.maxWidth = Integer.parseInt(maxWidth);			} catch (Exception e) {			}		}		if (shim != null) {			try {				obj.shim = Boolean.valueOf(shim);			} catch (Exception e) {			}		}	}		@Override	protected void prepareEvents(Observable obj) {		super.prepareEvents(obj);	}		/**	 * 	 * The position to align to (see Ext.Element.alignTo for more details,	 * defaults to "l-l").	 */	public void setAlignment(String alignment) {		this.alignment = alignment;	}		/**	 * 	 * CSS class to apply to the editor (defaults to	 * "x-small-editor x-tree-editor")	 */	public void setCls(String cls) {		this.cls = cls;	}		/**	 * 	 * The number of milliseconds between clicks to register a double-click that	 * will trigger	 * 	 * editing on the current node (defaults to 350). If two clicks occur on the	 * same node	 * 	 * within this time span, the editor for the node will display, otherwise it	 * will be processed	 * 	 * as a regular click.	 */	public void setEditDelay(String editDelay) {		this.editDelay = editDelay;	}		/**	 * 	 * True to hide the bound element while the editor is displayed (defaults to	 * false)	 */	public void setHideEl(String hideEl) {		this.hideEl = hideEl;	}		/**	 * 	 * The maximum width in pixels of the editor field (defaults to 250). Note	 * that if the maxWidth	 * 	 * would exceed the containing tree element's size, it will be automatically	 * limited for you to	 * 	 * the container width, taking scroll and client offsets into account prior	 * to each edit.	 */	public void setMaxWidth(String maxWidth) {		this.maxWidth = maxWidth;	}		/**	 * 	 * True to shim the editor if selects/iframes could be displayed beneath it	 * (defaults to false)	 */	public void setShim(String shim) {		this.shim = shim;	}}