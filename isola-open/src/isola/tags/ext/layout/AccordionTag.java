package isola.tags.ext.layout;

import javax.servlet.jsp.JspException;

import isola.model.core.JsObject;
import isola.model.ext.base.Observable;
import isola.model.ext.container.Panel;
import isola.tags.ext.container.PanelTag;

/**
 * <p>This is a layout that contains multiple panels in an expandable accordion style such 
 * that only one panel can be open at any given time. Each panel has built-in support for 
 * expanding and collapsing. This class is intended to be extended or created via the 
 * layout:'accordion' Ext.Container.layout config, and should generally not need to be created 
 * directly via the new keyword.</p>
 * 
 * <p>Note that when creating a layout via config, the layout-specific config properties must 
 * be passed in via the Ext.Container.layoutConfig object which will then be applied internally 
 * to the layout. Example usage:</p>
 * 
 * <pre><code>
 *	&lt;ext:body runOnLoad="true"&gt;
 *		&lt;ext:accordion renderTo="hebelek" animate="true" width="200" height="600" title="Accordion Layout" border="true"&gt;
 *			&lt;ext:panel title="Settings"&gt;
 *				This is the settings pane
 *			&lt;/ext:panel&gt;
 *			&lt;ext:panel title="Preferences"&gt;
 *				This is the preferences pane
 *			&lt;/ext:panel&gt;
 *		&lt;/ext:accordion&gt;
 *	&lt;/ext:body&gt;
 *	&lt;div id="hebelek"&gt;&lt;/div&gt;
 * </code></pre>
 * 
 * @author Umut Gokbayrak
 */
public class AccordionTag extends PanelTag {
	private static final long serialVersionUID = 7259981879210167354L;

	private String activeOnTop;
	private String animate;
	private String autoWidth;
	private String collapseFirst;
	private String fill;
	private String hideCollapseTool;
	private String sequence;
	private String titleCollapse;
	
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
		activeOnTop = animate = "false";
		autoWidth = "true";
		collapseFirst = "false";
		fill = "true";
		hideCollapseTool = sequence = "false";
		titleCollapse = "true";
	}
	
	/**
	 * 
	 * @param obj
	 */
	protected void prepareConfig(Panel obj) {
		setLayout("accordion");
		super.prepareConfig(obj);
		
		if (obj.layoutConfig == null) {
			obj.layoutConfig = new JsObject();
		}
		
		if (activeOnTop != null) {
			try {
				obj.layoutConfig.put("activeOnTop", Boolean.valueOf(activeOnTop));
			} catch (Exception e) {}
		}

		if (animate != null) {
			try {
				obj.layoutConfig.put("animate", Boolean.valueOf(animate));
			} catch (Exception e) {}
		}

		if (animate != null) {
			try {
				obj.layoutConfig.put("animate", Boolean.valueOf(animate));
			} catch (Exception e) {}
		}

		if (autoWidth != null) {
			try {
				obj.layoutConfig.put("autoWidth", Boolean.valueOf(autoWidth));
			} catch (Exception e) {}
		}

		if (collapseFirst != null) {
			try {
				obj.layoutConfig.put("collapseFirst", Boolean.valueOf(collapseFirst));
			} catch (Exception e) {}
		}

		if (fill != null) {
			try {
				obj.layoutConfig.put("fill", Boolean.valueOf(fill));
			} catch (Exception e) {}
		}

		if (hideCollapseTool != null) {
			try {
				obj.layoutConfig.put("hideCollapseTool", Boolean.valueOf(hideCollapseTool));
			} catch (Exception e) {}
		}

		if (sequence != null) {
			try {
				obj.layoutConfig.put("sequence", Boolean.valueOf(sequence));
			} catch (Exception e) {}
		}

		if (titleCollapse != null) {
			try {
				obj.layoutConfig.put("titleCollapse", Boolean.valueOf(titleCollapse));
			} catch (Exception e) {}
		}
	}

	@Override
	protected void prepareEvents(Observable obj) {
		super.prepareEvents(obj);
	}

	/**
	 * True to swap the position of each panel as it is expanded so that it becomes the first item 
	 * in the container, false to keep the panels in the rendered order. This is NOT compatible 
	 * with "animate:true" (defaults to false).
	 */
	public void setActiveOnTop(String activeOnTop) {
		this.activeOnTop = activeOnTop;
	}

	/**
	 * True to slide the contained panels open and closed during expand/collapse using animation, 
	 * false to open and close directly with no animation (defaults to false). Note: to defer to 
	 * the specific config setting of each contained panel for this property, set this to undefined 
	 * at the layout level.
	 */
	public void setAnimate(String animate) {
		this.animate = animate;
	}

	/**
	 * True to set each contained item's width to 'auto', false to use the item's current width 
	 * (defaults to true).
	 */
	public void setAutoWidth(String autoWidth) {
		this.autoWidth = autoWidth;
	}

	/**
	 * True to make sure the collapse/expand toggle button always renders first (to the left of) 
	 * any other tools in the contained panels' title bars, false to render it last 
	 * (defaults to false).
	 */
	public void setCollapseFirst(String collapseFirst) {
		this.collapseFirst = collapseFirst;
	}

	/**
	 * True to adjust the active item's height to fill the available space in the container, 
	 * false to use the item's current height, or auto height if not explicitly set 
	 * (defaults to true).
	 */
	public void setFill(String fill) {
		this.fill = fill;
	}

	/**
	 * True to hide the contained panels' collapse/expand toggle buttons, false to display them 
	 * (defaults to false). When set to true, titleCollapse should be true also.
	 */
	public void setHideCollapseTool(String hideCollapseTool) {
		this.hideCollapseTool = hideCollapseTool;
	}

	/**
	 * Experimental. If animate is set to true, this will result in each animation running in 
	 * sequence.
	 */
	public void setSequence(String sequence) {
		this.sequence = sequence;
	}

	/**
	 * True to allow expand/collapse of each contained panel by clicking anywhere on the title 
	 * bar, false to allow expand/collapse only when the toggle tool button is clicked (defaults 
	 * to true). When set to false, hideCollapseTool should be false also.
	 */
	public void setTitleCollapse(String titleCollapse) {
		this.titleCollapse = titleCollapse;
	}
}
