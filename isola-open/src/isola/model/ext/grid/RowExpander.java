package isola.model.ext.grid;

import isola.helpers.JsHelper;
import isola.model.core.JsFunction;
import isola.model.ext.base.Observable;

public class RowExpander extends Observable {
	private static final long serialVersionUID = -3582834375199909129L;
	private static final String TAG = "Ext.grid.RowExpander";
	
	/**
	 * The template used for processing the Row Expander
	 */
	public String tpl;

	public RowExpander() {
		super();
	}
	
	@Override
	protected void _postProcessToString() {
		super._postProcessToString();
		if (tpl != null) {
			put("tpl", new JsFunction(tpl));
		}
	}
	
	@Override
	public String toString() {
		_postProcessToString();
		return "new " + TAG + "(" + JsHelper.printJsObject(this) + ")";
	}
}
