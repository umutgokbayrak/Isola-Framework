package isola.tags.ext.grid;

import javax.servlet.jsp.JspException;

import javolution.text.TextBuilder;

import isola.model.ext.grid.RowExpander;
import isola.tags.ext.base.ObservableTag;

public class RowExpanderTag extends ObservableTag {
	private static final long serialVersionUID = 7104563422940131389L;

	public RowExpanderTag() {
		super();
	}
	
	@Override
	public int doEndTag() throws JspException {
		TextBuilder tb = new TextBuilder();
		tb.append("new Ext.Template(");
		tb.append("'").append(getBodyContent().getString().trim().replace("\n", "").replace("  ", "").replace("\t", "").replace("\r", "").replace("'", "\\'")).append("'");
		tb.append(")");
		String tpl = tb.toString();

		RowExpander expander = new RowExpander();
		if (tpl != null) {
			expander.tpl = tpl;
		}
		printOut(expander);
		clear();
		return EVAL_PAGE;
	}
	
	@Override
	public void clear() {
	}
}
