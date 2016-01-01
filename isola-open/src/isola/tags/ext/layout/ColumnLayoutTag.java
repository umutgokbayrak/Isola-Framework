package isola.tags.ext.layout;

import javax.servlet.jsp.JspException;

import isola.model.ext.base.Observable;
import isola.model.ext.container.Panel;
import isola.tags.ext.container.PanelTag;

/**
 * <p>This is the layout style of choice for creating structural layouts in a multi-column format 
 * where the width of each column can be specified as a percentage or fixed width, but the height 
 * is allowed to vary based on the content. This class is intended to be extended or created via 
 * the layout:'column' Ext.Container.layout config, and should generally not need to be created 
 * directly via the new keyword.</p>
 * 
 * <p>ColumnLayout does not have any direct config options (other than inherited ones), but it does 
 * support a specific config property of columnWidth that can be included in the config of any panel 
 * added to it. The layout will use the width (if pixels) or columnWidth (if percent) of each panel 
 * during layout to determine how to size each panel. If width or columnWidth is not specified for 
 * a given panel, its width will default to the panel's width (or auto).</p>
 * 
 * <p>The width property is always evaluated as pixels, and must be a number greater than or equal 
 * to 1. The columnWidth property is always evaluated as a percentage, and must be a decimal value 
 * greater than 0 and less than 1 (e.g., .25).</p>
 * 
 * <p>The basic rules for specifying column widths are pretty simple. The logic makes two passes 
 * through the set of contained panels. During the first layout pass, all panels that either have a 
 * fixed width or none specified (auto) are skipped, but their widths are subtracted from the overall 
 * container width. During the second pass, all panels with columnWidths are assigned pixel widths 
 * in proportion to their percentages based on the total remaining container width. In other words, 
 * percentage width panels are designed to fill the space left over by all the fixed-width or 
 * auto-width panels. Because of this, while you can specify any number of columns with different 
 * percentages, the columnWidths must always add up to 1 (or 100%) when added together, otherwise 
 * your layout may not render as expected. Example usage:</p>
 * 
 * <code><pre>
 *	&lt;ext:body runOnLoad="true"&gt;
 *		&lt;ext:columnLayout width="800" renderTo="hebelek" height="100" border="true"&gt;
 *			&lt;ext:panel title="Column 1" columnWidth=".25"&gt;
 *				Column 1
 *			&lt;/ext:panel&gt;
 *			&lt;ext:panel title="Column 2" columnWidth=".6"&gt;
 *				Column 2
 *			&lt;/ext:panel&gt;
 *			&lt;ext:panel title="Column 3" columnWidth=".15"&gt;
 *				Column 3
 *			&lt;/ext:panel&gt;
 *		&lt;/ext:columnLayout&gt;
 *	&lt;/ext:body&gt;
 *	&lt;div id="hebelek"&gt;&lt;/div&gt;
 * </pre></code>
 * 
 * <p>Mix of width and columnWidth -- all columnWidth values values must add
 * up to 1. The first column will take up exactly 120px, and the last two
 * columns will fill the remaining container width.</p>
 * 
 * @author Umut Gokbayrak
 */
public class ColumnLayoutTag extends PanelTag {
	private static final long serialVersionUID = -1604401675964631847L;

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
		setLayout("column");
		super.prepareConfig(obj);
	}

	@Override
	protected void prepareEvents(Observable obj) {
		super.prepareEvents(obj);
	}

}
