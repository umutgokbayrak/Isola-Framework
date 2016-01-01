package isola.tags.ext.layout;

import javax.servlet.jsp.JspException;

import isola.model.ext.base.Observable;
import isola.model.ext.container.Panel;
import isola.tags.ext.container.PanelTag;

/**
 * <p>This is a base class for layouts that contain a single item that automatically expands 
 * to fill the layout's container. This class is intended to be extended or created via the 
 * layout:'fit' Ext.Container.layout config, and should generally not need to be created 
 * directly via the new keyword.</p>
 * 
 * <p>FitLayout does not have any direct config options (other than inherited ones). To fit 
 * a panel to a container using FitLayout, simply set layout:'fit' on the container and add 
 * a single panel to it. If the container has multiple panels, only the first one will be 
 * displayed. Example usage:</p>
 * 
 * <pre><code>
 *	&lt;ext:body runOnLoad="true"&gt;
 *		&lt;ext:fitLayout title="Fit Layout" renderTo="hebelek" width="500" height="500"&gt;
 *			&lt;ext:panel border="false" bodyStyle="background-color:#000000;color:white;"&gt;
 *				&lt;p&gt;This is the inner panel content&lt;/p&gt;
 *			&lt;/ext:panel&gt;
 *		&lt;/ext:fitLayout&gt;
 *	&lt;/ext:body&gt;
 *	&lt;div id="hebelek"&gt;&lt;/div&gt;
 * </code></pre>
 * 
 * @author Umut Gokbayrak
 */
public class FitLayoutTag extends PanelTag {
	private static final long serialVersionUID = -8275147240699887086L;

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
		setLayout("fit");
		super.prepareConfig(obj);
	}

	@Override
	protected void prepareEvents(Observable obj) {
		super.prepareEvents(obj);
	}

}
