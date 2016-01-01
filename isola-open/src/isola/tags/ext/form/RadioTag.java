package isola.tags.ext.form;

import javax.servlet.jsp.JspException;

import isola.model.ext.base.Observable;
import isola.model.ext.form.Radio;

/**
 * <p>Single radio field. Same as CheckBox, but provided as a convenience for automatically 
 * setting the input type. Radio grouping is handled automatically by the browser if you 
 * give each radio in a group the same name.</p>
 * 
 * <code><pre>
 * &lt;p&gt;To group radio boxes horizantally, a column layout should be used. Example:&lt;/p&gt;
 *	&lt;ext:formPanel url="deneme.jsp" id="myForm" renderTo="form-ct" width="400" border="false"&gt;
 *		&lt;ext:columnLayout&gt;
 *			&lt;ext:panel columnWidth=".33" border="false"&gt;
 *				&lt;ext:radio name="rb1" value="1" boxLabel="Radio 1"/&gt;
 *			&lt;/ext:panel&gt;
 *			&lt;ext:panel columnWidth=".34" border="false"&gt;
 *				&lt;ext:radio name="rb1" value="2" boxLabel="Radio 2"/&gt;
 *			&lt;/ext:panel&gt;
 *			&lt;ext:panel columnWidth=".33" border="false"&gt;
 *				&lt;ext:radio name="rb1" value="3" boxLabel="Radio 3"/&gt;
 *			&lt;/ext:panel&gt;
 *		&lt;/ext:columnLayout&gt;
 *		&lt;ext:button type="submit" text="Go!" /&gt;
 *	&lt;/ext:formPanel&gt;
 * </pre></code>
 * 
 * @author Umut Gokbayrak
 */
public class RadioTag extends CheckBoxTag {
	private static final long serialVersionUID = 2131663608737248940L;

	@Override
	public int doEndTag() throws JspException {
		Radio obj = new Radio();
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
	protected void prepareConfig(Radio obj) {
		if (getId() == null) {
			setId(getName() + Math.random());
		}
		super.prepareConfig(obj);
	}

	@Override
	protected void prepareEvents(Observable obj) {
		super.prepareEvents(obj);
	}

}
