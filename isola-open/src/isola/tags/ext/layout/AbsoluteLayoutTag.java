package isola.tags.ext.layout;

import javax.servlet.jsp.JspException;

import isola.model.ext.base.Observable;
import isola.model.ext.container.Panel;
import isola.tags.ext.container.PanelTag;

/**
 * Inherits the anchoring of Ext.layout.AnchorLayout and adds the ability for x/y 
 * positioning using the standard x and y component config options.
 * Usage:
 * <pre><code>
 *	&lt;ext:body runOnLoad="true"&gt;
 *		&lt;ext:absoluteLayout renderTo="hebelek" width="400" height="400" bodyStyle="background-color:black;"&gt;
 *			&lt;ext:panel bodyStyle="background-color:red;color:white;" x="100" y="50" width="100" height="100"&gt;
 *				This is a sample content
 *			&lt;/ext:panel&gt;
 *		&lt;/ext:absoluteLayout&gt;
 *	&lt;/ext:body&gt;
 *	&lt;div id="hebelek"&gt;&lt;/div&gt;
 * </code></pre>
 * 
 * @author Umut Gokbayrak
 */
public class AbsoluteLayoutTag extends PanelTag {
	private static final long serialVersionUID = 5846584734895810857L;

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
		setLayout("absolute");
		super.prepareConfig(obj);
	}

	@Override
	protected void prepareEvents(Observable obj) {
		super.prepareEvents(obj);
	}

}
