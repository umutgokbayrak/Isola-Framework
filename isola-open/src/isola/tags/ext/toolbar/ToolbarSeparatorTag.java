package isola.tags.ext.toolbar;import javax.servlet.jsp.JspException;import isola.model.ext.toolbar.ToolbarSeparator;/** *  * <p> * A simple class that adds a vertical separator bar between toolbar items. * Example usage: * </p> *  *  *  * @author Umut Gokbayrak */public class ToolbarSeparatorTag extends ToolbarItemTag {	private static final long serialVersionUID = -9066675393701442139L;		@Override	public int doEndTag() throws JspException {		ToolbarSeparator obj = new ToolbarSeparator();		// print the output		printOut(obj);		return EVAL_PAGE;	}		@Override	public void clear() {		// do nothing	}}