package isola.tags.ext.menu;import javax.servlet.jsp.JspException;import isola.model.ext.base.Observable;import isola.model.ext.menu.ColorMenu;/** *  * A menu containing a Ext.menu.ColorItem component (which provides a basic * color picker). *  *  *  * @author Umut Gokbayrak */public class ColorMenuTag extends MenuTag {	private static final long serialVersionUID = 1254871752534564010L;		@Override	public int doEndTag() throws JspException {		ColorMenu obj = new ColorMenu();		prepareConfig(obj);		// manage listeners		prepareEvents(obj);		// print the output		printOut(obj);		return EVAL_PAGE;	}		@Override	public void clear() {		super.clear();	}		/**	 * 	 * 	 * 	 * @param obj	 */	protected void prepareConfig(ColorMenu obj) {		super.prepareConfig(obj);	}		@Override	protected void prepareEvents(Observable obj) {		super.prepareEvents(obj);	}}