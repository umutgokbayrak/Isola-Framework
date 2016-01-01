package isola.tags.ext.form;

import javax.servlet.jsp.JspException;

import isola.model.core.JsFunction;
import isola.model.ext.base.Observable;
import isola.model.ext.form.Button;
import isola.model.ext.menu.Menu;
import isola.tags.ext.base.ComponentTag;


/**
 * 
 * @author Umut Gokbayrak
 */
public class ButtonTag extends ComponentTag {
	private static final long serialVersionUID = 2282039799323006810L;

	private String clickEvent;
	private String disabled;
	private String enableToggle;
	private String handleMouseEvents;
	private String hidden;
	private String icon;
	private String iconCls;	
	private String menuAlign;
	private String minWidth;
	private String pressed;
	private String repeat;
	private String scope;
	private String tabIndex;
	private String text;
	private String toggleGroup;
	private String tooltip;
	private String type;

	private Menu menu;
	private String handler;

	private String onClick;
	private String onMenuHide;
	private String onMenuShow;
	private String onMenuTriggerOut;
	private String onMenuTriggerOver;
	private String onMouseOut;
	private String onMouseOver;
	private String onToggle;

	@Override
	public int doEndTag() throws JspException {
		Button obj = new Button();
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
		clickEvent = null;
		disabled = enableToggle = hidden = "false";
		handleMouseEvents = "true";
		icon = iconCls = menuAlign = null;
		minWidth = "0";
		pressed = repeat = "false";
		scope = null;
		tabIndex = "0";
		text = toggleGroup = tooltip = type = null;
		menu = null;
		handler = null;
		onClick = onMenuHide = onMenuShow = onMenuTriggerOut = onMenuTriggerOver = null;
		onMouseOut = onMouseOver = onToggle = null;
	}
	
	/**
	 * 
	 * @param obj
	 */
	protected void prepareConfig(Button obj) {
		super.prepareConfig(obj);

		obj.clickEvent = clickEvent;

		if (disabled != null) {
			try {
				obj.disabled = Boolean.valueOf(disabled);
			} catch (Exception e) {}
		}

		if (enableToggle != null) {
			try {
				obj.enableToggle = Boolean.valueOf(enableToggle);
			} catch (Exception e) {}
		}
		
		if (handleMouseEvents != null) {
			try {
				obj.handleMouseEvents = Boolean.valueOf(handleMouseEvents);
			} catch (Exception e) {}
		}

		if (hidden != null) {
			try {
				obj.hidden = Boolean.valueOf(hidden);
			} catch (Exception e) {}
		}

		obj.icon = icon;
		obj.iconCls = iconCls;
		obj.menuAlign = menuAlign;

		if (minWidth != null) {
			try {
				obj.minWidth = Integer.valueOf(minWidth);
			} catch (Exception e) {}
		}

		if (pressed != null) {
			try {
				obj.pressed = Boolean.valueOf(pressed);
			} catch (Exception e) {}
		}

		if (repeat != null) {
			try {
				obj.repeat = Boolean.valueOf(repeat);
			} catch (Exception e) {}
		}

		obj.scope = scope;

		if (tabIndex != null) {
			try {
				obj.tabIndex = Integer.valueOf(tabIndex);
			} catch (Exception e) {}
		}

		obj.text = text;
		obj.toggleGroup = toggleGroup;
		obj.tooltip = tooltip;
		obj.type = type;

		if (menu != null) {
			obj.menu = menu;
		}
		
		if (handler != null) {
			obj.handler = new JsFunction(handler);
		}
	}

	@Override
	protected void prepareEvents(Observable obj) {
		super.prepareEvents(obj);

		if (onClick != null) {
			obj.listeners.put("click", new JsFunction(onClick));
		}
		if (onMenuHide != null) {
			obj.listeners.put("menuhide", new JsFunction(onMenuHide));
		}
		if (onMenuShow != null) {
			obj.listeners.put("menushow", new JsFunction(onMenuShow));
		}
		if (onMenuTriggerOut != null) {
			obj.listeners.put("menutriggerout", new JsFunction(onMenuTriggerOut));
		}
		if (onMenuTriggerOver != null) {
			obj.listeners.put("menutriggerover", new JsFunction(onMenuTriggerOver));
		}
		if (onMouseOut != null) {
			obj.listeners.put("mouseout", new JsFunction(onMouseOut));
		}
		if (onMouseOver != null) {
			obj.listeners.put("mouseover", new JsFunction(onMouseOver));
		}
		if (onToggle != null) {
			obj.listeners.put("toggle", new JsFunction(onToggle));
		}
	}

	/**
	 * The type of event to map to the button's event handler (defaults to 'click')
	 */
	public void setClickEvent(String clickEvent) {
		this.clickEvent = clickEvent;
	}

	/**
	 * True to start disabled (defaults to false)
	 */
	public void setDisabled(String disabled) {
		this.disabled = disabled;
	}

	/**
	 * True to enable pressed/not pressed toggling (defaults to false)
	 */
	public void setEnableToggle(String enableToggle) {
		this.enableToggle = enableToggle;
	}

	/**
	 * False to disable visual cues on mouseover, mouseout and mousedown (defaults to true)
	 */
	public void setHandleMouseEvents(String handleMouseEvents) {
		this.handleMouseEvents = handleMouseEvents;
	}

	/**
	 * True to start hidden (defaults to false)
	 */
	public void setHidden(String hidden) {
		this.hidden = hidden;
	}

	/**
	 * The path to an image to display in the button (the image will be set as the 
	 * background-image CSS property of the button by default, so if you want a mixed 
	 * icon/text button, set cls:"x-btn-text-icon")
	 */
	public void setIcon(String icon) {
		this.icon = icon;
	}

	/**
	 * A css class which sets a background image to be used as the icon for this button
	 */
	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}

	/**
	 * The position to align the menu to (see Ext.Element.alignTo for more details, 
	 * defaults to 'tl-bl?').
	 */
	public void setMenuAlign(String menuAlign) {
		this.menuAlign = menuAlign;
	}

	/**
	 * The minimum width for this button (used to give a set of buttons a common width)
	 */
	public void setMinWidth(String minWidth) {
		this.minWidth = minWidth;
	}

	/**
	 * True to start pressed (only if enableToggle = true)
	 */
	public void setPressed(String pressed) {
		this.pressed = pressed;
	}

	/**
	 * True to repeat fire the click event while the mouse is down. This can also be an 
	 * Ext.util.ClickRepeater config object (defaults to false).
	 */
	public void setRepeat(String repeat) {
		this.repeat = repeat;
	}

	/**
	 * The scope of the handler
	 */
	public void setScope(String scope) {
		this.scope = scope;
	}

	/**
	 * Set a DOM tabIndex for this button (defaults to undefined)
	 */
	public void setTabIndex(String tabIndex) {
		this.tabIndex = tabIndex;
	}

	/**
	 * Set a DOM tabIndex for this button (defaults to undefined)
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * The group this toggle button is a member of (only 1 per group can be 
	 * pressed, only applies if enableToggle = true)
	 */
	public void setToggleGroup(String toggleGroup) {
		this.toggleGroup = toggleGroup;
	}

	/**
	 * The tooltip for the button - can be a string or QuickTips config object
	 */
	public void setTooltip(String tooltip) {
		this.tooltip = tooltip;
	}

	/**
	 * submit, reset or button - defaults to 'button'
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * Standard menu attribute consisting of a reference to a menu object, a menu id or 
	 * a menu config blob (defaults to undefined).
	 */
	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	/**
	 * <p>Fires when this button is clicked </p>
	 * Listeners will be called with the following arguments:
	 * <ul>
	 * <li><strong>this</strong>: Button</li>
	 * <li><strong>e</strong>:(EventObject) The click event</li>
	 * </ul>
	 * @param onClick
	 */
	public void setOnClick(String onClick) {
		this.onClick = onClick;
	}

	/**
	 * <p>If this button has a menu, this event fires when it is hidden</p>
	 * Listeners will be called with the following arguments:
	 * <ul>
	 * <li><strong>this</strong>: Button</li>
	 * <li><strong>menu</strong>: Menu</li>
	 * </ul>
	 * @param onMenuHide
	 */
	public void setOnMenuHide(String onMenuHide) {
		this.onMenuHide = onMenuHide;
	}

	/**
	 * <p>If this button has a menu, this event fires when it is shown </p>
	 * Listeners will be called with the following arguments:
	 * <ul>
	 * <li><strong>this</strong>: Button</li>
	 * <li><strong>menu</strong>: Menu</li>
	 * </ul>
	 * @param onMenuShow
	 */
	public void setOnMenuShow(String onMenuShow) {
		this.onMenuShow = onMenuShow;
	}

	/**
	 * <p>If this button has a menu, this event fires when the mouse leaves the menu triggering element </p>
	 * Listeners will be called with the following arguments:
	 * <ul>
	 * <li><strong>this</strong>: Button</li>
	 * <li><strong>menu</strong>: Menu</li>
	 * <li><strong>e</strong>: EventObject</li>
	 * </ul>
	 * @param onMenuTriggerOut
	 */
	public void setOnMenuTriggerOut(String onMenuTriggerOut) {
		this.onMenuTriggerOut = onMenuTriggerOut;
	}

	/**
	 * <p>If this button has a menu, this event fires when the mouse enters the menu triggering element </p>
	 * Listeners will be called with the following arguments:
	 * <ul>
	 * <li><strong>this</strong>: Button</li>
	 * <li><strong>menu</strong>: Menu</li>
	 * <li><strong>e</strong>: EventObject</li>
	 * </ul>
	 * @param onMenuTriggerOver
	 */
	public void setOnMenuTriggerOver(String onMenuTriggerOver) {
		this.onMenuTriggerOver = onMenuTriggerOver;
	}

	/**
	 * <p>Fires when the mouse exits the button </p>
	 * Listeners will be called with the following arguments:
	 * <ul>
	 * <li><strong>this</strong>: Button</li>
	 * <li><strong>e</strong>:(Event) The event object</li>
	 * </ul>
	 * @param onMouseOut
	 */
	public void setOnMouseOut(String onMouseOut) {
		this.onMouseOut = onMouseOut;
	}

	/**
	 * <p>Fires when the mouse hovers over the button</p>
	 * Listeners will be called with the following arguments:
	 * <ul>
	 * <li><strong>this</strong>: Button</li>
	 * <li><strong>e</strong>:(Event) The event object</li>
	 * </ul>
	 * @param onMouseOver
	 */
	public void setOnMouseOver(String onMouseOver) {
		this.onMouseOver = onMouseOver;
	}

	/**
	 * <p>Fires when the "pressed" state of this button changes (only if enableToggle = true) </p>
	 * Listeners will be called with the following arguments:
	 * <ul>
	 * <li><strong>this</strong>: Button</li>
	 * <li><strong>pressed</strong>: Boolean</li>
	 * </ul>
	 * @param onToggle
	 */
	public void setOnToggle(String onToggle) {
		this.onToggle = onToggle;
	}

	/**
	 * A function called when the button is clicked (can be used instead of click event)
	 */
	public void setHandler(String handler) {
		this.handler = handler;
	}
	
}
