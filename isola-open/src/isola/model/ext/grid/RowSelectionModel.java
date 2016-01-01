package isola.model.ext.grid;
import isola.helpers.JsHelper;
public class RowSelectionModel extends AbstractSelectionModel {
	private static final long serialVersionUID = -3805566845842716233L;
	private static final String TAG = "Ext.grid.RowSelectionModel";
	
	/**
	 * True to allow selection of only one row at a time (defaults to false)
	 */
	public boolean singleSelect = false;
	
	public RowSelectionModel() {
		super();
	}
	
	@Override
	protected void _postProcessToString() {
		super._postProcessToString();
		if (singleSelect) put("singleSelect", singleSelect);
	}
	
	@Override
	public String toString() {
		_postProcessToString();
		return "new " + TAG + "(" + JsHelper.printJsObject(this) + ")";
	}
}