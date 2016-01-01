package isola.tags.ext.menu;import javax.servlet.jsp.JspException;import isola.model.ext.base.Observable;import isola.model.ext.menu.Separator;/** *  * Adds a separator bar to a menu, used to divide logical groups of menu items. * Generally you *  * will add one of these by using "-" in you call to add() or in your items * config rather than *  * creating one directly. *  *  *  * @author Umut Gokbayrak */public class SeparatorTag extends BaseItemTag {	private static final long serialVersionUID = 2390087656141386134L;	private String hideOnClick;	private String itemCls;		@Override	public int doEndTag() throws JspException {		Separator obj = new Separator();		prepareConfig(obj);		// manage listeners		prepareEvents(obj);		// print the output		printOut(obj);		return EVAL_PAGE;	}		@Override	public void clear() {		super.clear();		hideOnClick = "false";		itemCls = null;	}		/**	 * 	 * 	 * 	 * @param obj	 */	protected void prepareConfig(Separator obj) {		super.prepareConfig(obj);		if (hideOnClick != null) {			try {				obj.hideOnClick = Boolean.valueOf(hideOnClick);			} catch (Exception e) {			}		}		obj.itemCls = itemCls;	}		@Override	protected void prepareEvents(Observable obj) {		super.prepareEvents(obj);	}		/**	 * 	 * True to hide the containing menu after this item is clicked (defaults to	 * false)	 */	public void setHideOnClick(String hideOnClick) {		this.hideOnClick = hideOnClick;	}		/**	 * 	 * The default CSS class to use for separators (defaults to "x-menu-sep")	 */	public void setItemCls(String itemCls) {		this.itemCls = itemCls;	}}