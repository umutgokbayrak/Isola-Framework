package isola.tags.ext.form;

import javax.servlet.jsp.JspException;

import isola.model.core.JsFunction;
import isola.model.ext.base.Observable;
import isola.model.ext.form.ColorPalette;
import isola.tags.ext.base.ComponentTag;

/**
 * Simple color palette class for choosing colors. The palette can be rendered to any container.
 * Here's an example of typical usage:
 * 
 * <pre><code>
 * var cp = new Ext.ColorPalette({value:'993300'});  // initial selected color
 * cp.render('my-div');
 * cp.on('select', function(palette, selColor) {
 * 		// do something with selColor
 * });
 * </code></pre>
 * 
 * @author Umut Gokbayrak
 */
public class ColorPaletteTag extends ComponentTag {
	private static final long serialVersionUID = 3786844275723059291L;

	private String allowReselect;
	private String itemCls;
	private String tpl;
	private String value;

	private String onSelect;

	@Override
	public int doEndTag() throws JspException {
		ColorPalette obj = new ColorPalette();
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
		allowReselect = "false";
		itemCls = tpl = value = onSelect = null;
	}
	
	/**
	 * 
	 * @param obj
	 */
	protected void prepareConfig(ColorPalette obj) {
		super.prepareConfig(obj);

		if (allowReselect != null) {
			try {
				obj.allowReselect = Boolean.valueOf(allowReselect);
			} catch (Exception e) {}
		}

		obj.itemCls = itemCls;
		obj.tpl = tpl;
		obj.value = value;
	}

	@Override
	protected void prepareEvents(Observable obj) {
		super.prepareEvents(obj);

		if (onSelect != null) {
			obj.listeners.put("select", new JsFunction(onSelect));
		}
	}

	/**
	 * If set to true then reselecting a color that is already selected fires the 
	 * selection event
	 */
	public void setAllowReselect(String allowReselect) {
		this.allowReselect = allowReselect;
	}

	/**
	 * The CSS class to apply to the containing element (defaults to "x-color-palette")
	 */
	public void setItemCls(String itemCls) {
		this.itemCls = itemCls;
	}

	/**
	 * An existing XTemplate instance to be used in place of the default template for rendering the 
	 * component.
	 */
	public void setTpl(String tpl) {
		this.tpl = tpl;
	}

	/**
	 * The initial color to highlight (should be a valid 6-digit color hex code without the # 
	 * symbol). Note that the hex codes are case-sensitive.
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * <p>Selects the specified color in the palette (fires the select event) </p>
	 * <strong>Parameters:</strong>
	 * <ul>
	 * <li>color :(String) A valid 6-digit color hex code (# will be stripped if included)</li>
	 * </ul>
	 * <strong>Returns:</strong>
	 * <ul>
	 * <li>void</li>
	 * </ul>
	 * @param onSelect
	 */
	public void setOnSelect(String onSelect) {
		this.onSelect = onSelect;
	}

}
