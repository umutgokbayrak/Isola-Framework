package isola.tags.ext.form;

import javax.servlet.jsp.JspException;

import isola.model.core.JsFunction;
import isola.model.ext.base.Observable;
import isola.model.ext.form.SplitButton;

/**
 * <p>A split button that provides a built-in dropdown arrow that can fire an event 
 * separately from the default click event of the button. Typically this would be 
 * used to display a dropdown menu that provides additional options to the 
 * primary button action, but any custom handler can provide the arrowclick 
 * implementation. Example usage:</p>
 * 
 * <code><pre>
 *	&lt;ext:formPanel url="deneme.jsp" id="myForm" renderTo="form-ct" width="400" bodyStyle="background-color:#EEEEEE;" border="false"&gt;
 *		&lt;ext:textArea name="area" fieldLabel="Text Area"/&gt;
 *		&lt;ext:splitButton text="Split Button" handler="alert('this is the handler');"&gt;
 *			&lt;ext:menu&gt;
 *				&lt;ext:menuTextItem text="Text Item" /&gt;
 *				&lt;ext:menuCheckItem text="Check Item" checked="true"/&gt;
 *				&lt;ext:menuSeparator/&gt;
 *				&lt;ext:menuDateItem /&gt;
 *				&lt;ext:menuColorItem /&gt;
 *			&lt;/ext:menu&gt;
 *			&lt;ext:menuTextItem /&gt;
 *		&lt;/ext:splitButton&gt;
 *		&lt;ext:button type="submit" text="Go!" /&gt;
 *	&lt;/ext:formPanel&gt;
 * </pre></code>
 * 
 * @author Umut Gokbayrak
 */
public class SplitButtonTag extends ButtonTag {
	private static final long serialVersionUID = -4223095929994877987L;

	public String arrowHandler;
	public String arrowTooltip;
	public String clickEvent;

	private String onArrowClick;

	@Override
	public int doEndTag() throws JspException {
		SplitButton obj = new SplitButton();
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
		arrowHandler= null;
		arrowTooltip = clickEvent = onArrowClick = null;
	}
	
	/**
	 * 
	 * @param obj
	 */
	protected void prepareConfig(SplitButton obj) {
		super.prepareConfig(obj);

		if (arrowHandler != null) {
			obj.arrowHandler = new JsFunction(arrowHandler);
		}
		obj.arrowTooltip = arrowTooltip;
		obj.clickEvent = clickEvent;
	}

	@Override
	protected void prepareEvents(Observable obj) {
		super.prepareEvents(obj);

		if (onArrowClick != null) {
			obj.listeners.put("arrowclick", new JsFunction(onArrowClick));
		}
	}

	/**
	 * A function called when the arrow button is clicked (can be used instead of click event)
	 */
	public void setArrowHandler(String arrowHandler) {
		this.arrowHandler = arrowHandler;
	}

	/**
	 * The title attribute of the arrow
	 */
	public void setArrowTooltip(String arrowTooltip) {
		this.arrowTooltip = arrowTooltip;
	}

	/**
	 * The type of event to map to the button's event handler (defaults to 'click')
	 */
	public void setClickEvent(String clickEvent) {
		this.clickEvent = clickEvent;
	}

	/**
	 * <p>Fires when this button's arrow is clicked </p>
	 * Listeners will be called with the following arguments:
	 * <ul>
	 * <li><strong>this</strong> : MenuButton</li>
	 * <li><strong>e</strong> : (EventObject) The click event</li>
     * </ul>
	 * @param onArrowClick
	 */
	public void setOnArrowClick(String onArrowClick) {
		this.onArrowClick = onArrowClick;
	}
}
