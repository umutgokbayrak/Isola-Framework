package isola.tags.ext.form;

import javax.servlet.jsp.JspException;

import isola.model.core.JsArray;
import isola.model.core.JsFunction;
import isola.model.ext.base.Observable;
import isola.model.ext.form.CycleButton;

/**
 * <p>A specialized SplitButton that contains a menu of Ext.menu.CheckItem elements. 
 * The button automatically cycles through each menu item on click, raising the 
 * button's change event (or calling the button's changeHandler function, if 
 * supplied) for the active menu item. Clicking on the arrow section of the button 
 * displays the dropdown menu just like a normal SplitButton. Example usage:</p>
 * 
 * <code><pre>
 *	&lt;ext:cycleButton&gt;
 *		&lt;ext:menuCheckItem text="Test 1" handler="alert('test1 clicked');"/&gt;
 *		&lt;ext:menuCheckItem checked="true" text="Test 2" handler="alert('test2 clicked');"/&gt;
 *	&lt;/ext:cycleButton&gt;
 * </pre></code>
 * 
 * @author Umut Gokbayrak
 */
public class CycleButtonTag extends SplitButtonTag {
	private static final long serialVersionUID = 5985134038222268812L;

	private String changeHandler;
	private String prependText;
	private String showText;
	private JsArray items;
	
	private String onChange;
	
	
	@Override
	public int doEndTag() throws JspException {
		CycleButton obj = new CycleButton();
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
		changeHandler = null;
		prependText = null;
		showText = "false";
		onChange = null;
		items = null;
	}
	
	/**
	 * 
	 * @param obj
	 */
	protected void prepareConfig(CycleButton obj) {
		setShowText("true");
		super.prepareConfig(obj);

		if (changeHandler != null) {
			obj.changeHandler = new JsFunction(changeHandler);
		}
		obj.prependText = prependText;
		
		if (showText != null) {
			try {
				obj.showText = Boolean.valueOf(showText);
			} catch (Exception e) {}
		}
		
		if (items != null && items.size() > 0) {
			obj.put("items", items);
		}
	}

	@Override
	protected void prepareEvents(Observable obj) {
		super.prepareEvents(obj);

		if (onChange != null) {
			obj.listeners.put("change", new JsFunction(onChange));
		}
	}

	/**
	 * A callback function that will be invoked each time the active menu item in the 
	 * button's menu has changed. If this callback is not supplied, the SplitButton 
	 * will instead fire the change event on active item change. The changeHandler 
	 * function will be called with the following argument list: (SplitButton this, 
	 * Ext.menu.CheckItem item)
	 */
	public void setChangeHandler(String changeHandler) {
		this.changeHandler = changeHandler;
	}

	/**
	 * A static string to prepend before the active item's text when displayed as 
	 * the button's text (only applies when showText = true, defaults to '')
	 */
	public void setPrependText(String prependText) {
		this.prependText = prependText;
	}

	/**
	 * True to display the active item's text as the button text (defaults to true)
	 */
	public void setShowText(String showText) {
		this.showText = showText;
	}

	/**
	 * <p>Fires after the button's active menu item has changed. Note that if a changeHandler function 
	 * is set on this CycleButton, it will be called instead on active item change and this change event 
	 * will not be fired.</p>
	 * Listeners will be called with the following arguments:
	 * <ul>
	 * <li><strong>this </strong>: Ext.CycleButton</li>
	 * <li><strong>item </strong>:(Ext.menu.CheckItem) The menu item that was selected</li>
	 * </ul>
	 * @param onChange
	 */
	public void setOnChange(String onChange) {
		this.onChange = onChange;
	}

	public JsArray getItems() {
		if (items == null) {
			items = new JsArray();
		}
		return items;
	}

	public void setItems(JsArray items) {
		this.items = items;
	}

}
