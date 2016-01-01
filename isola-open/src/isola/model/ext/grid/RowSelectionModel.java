package isola.model.ext.grid;
import isola.helpers.JsHelper;/** *  * <p> * The default SelectionModel used by Ext.grid.Grid. It supports multiple * selections and *  * keyboard selection/navigation. The objects stored as selections and returned * by *  * getSelected, and getSelections are the Records which provide the data for the * selected *  * rows. * </p> *  *  *  * @author Umut Gokbayrak */
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
