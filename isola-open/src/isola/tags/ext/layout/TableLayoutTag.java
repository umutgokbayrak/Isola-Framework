package isola.tags.ext.layout;

import javax.servlet.jsp.JspException;

import isola.model.core.JsObject;
import isola.model.ext.base.Observable;
import isola.model.ext.container.Panel;
import isola.tags.ext.container.PanelTag;

/**
 * <p>This layout allows you to easily render content into an HTML table. The total number of columns 
 * can be specified, and rowspan and colspan can be used to create complex layouts within the table. 
 * This class is intended to be extended or created via the layout:'table' Ext.Container.layout config, 
 * and should generally not need to be created directly via the new keyword.</p>
 * 
 * <p>Note that when creating a layout via config, the layout-specific config properties must be 
 * passed in via the Ext.Container.layoutConfig object which will then be applied internally to the 
 * layout. In the case of TableLayout, the only valid layout config property is columns. However, the 
 * items added to a TableLayout can supply table-specific config properties of rowspan and colspan, 
 * as explained below.</p>
 * 
 * <p>The basic concept of building up a TableLayout is conceptually very similar to building up a 
 * standard HTML table. You simply add each panel (or "cell") that you want to include along with any 
 * span attributes specified as the special config properties of rowspan and colspan which work exactly 
 * like their HTML counterparts. Rather than explicitly creating and nesting rows and columns as you 
 * would in HTML, you simply specify the total column count in the layoutConfig and start adding panels 
 * in their natural order from left to right, top to bottom. The layout will automatically figure out, 
 * based on the column count, rowspans and colspans, how to position each panel within the table. Just 
 * like with HTML tables, your rowspans and colspans must add up correctly in your overall layout or 
 * you'll end up with missing and/or extra cells! Example usage:</p>
 * 
 * <pre><code>
 * 
 * This code will generate a layout table that is 3 columns by 2 rows
 * with some spanning included.  The basic layout will be:
 * +--------+-----------------+
 * |   A    |   B             |
 * |        |--------+--------|
 * |        |   C    |   D    |
 * +--------+--------+--------+
 * 
 *	&lt;ext:body runOnLoad="true"&gt;
 *		&lt;ext:tableLayout title="Table Layout" columns="3" renderTo="hebelek" width="220" border="true"&gt;
 *			&lt;ext:panel rowSpan="2" border="true" bodyStyle="height:102;"&gt;
 *				&lt;p&gt;Cell A content&lt;/p&gt;
 *			&lt;/ext:panel&gt;
 *			&lt;ext:panel colSpan="2" border="true" bodyStyle="height:50;"&gt;
 *				&lt;p&gt;Cell B content&lt;/p&gt;
 *			&lt;/ext:panel&gt;
 *			&lt;ext:panel border="true" bodyStyle="height:50;"&gt;
 *				&lt;p&gt;Cell C content&lt;/p&gt;
 *			&lt;/ext:panel&gt;
 *			&lt;ext:panel border="true" bodyStyle="height:50;"&gt;
 *				&lt;p&gt;Cell D content&lt;/p&gt;
 *			&lt;/ext:panel&gt;
 *		&lt;/ext:tableLayout&gt;
 *	&lt;/ext:body&gt;
 *	&lt;div id="hebelek"&gt;&lt;/div&gt;
 * </code></pre>
 * 
 * @author Umut Gokbayrak
 *
 */
public class TableLayoutTag extends PanelTag {
	private static final long serialVersionUID = 6121465414450132816L;

	/**
	 * The total number of columns to create in the table for this layout. If not specified, all 
	 * panels added to this layout will be rendered into a single row using a column per panel.
	 */
	private String columns;
	
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
		columns = "0";
	}
	
	/**
	 * 
	 * @param obj
	 */
	protected void prepareConfig(Panel obj) {
		setLayout("table");
		super.prepareConfig(obj);
		
		if (columns != null) {
			if (obj.layoutConfig == null) {
				obj.layoutConfig = new JsObject();
			}
			obj.layoutConfig.put("columns", Integer.parseInt(columns));
		}
	}

	@Override
	protected void prepareEvents(Observable obj) {
		super.prepareEvents(obj);
	}

	public void setColumns(String columns) {
		this.columns = columns;
	}

}
