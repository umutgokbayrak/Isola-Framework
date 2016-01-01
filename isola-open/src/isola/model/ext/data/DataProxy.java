package isola.model.ext.data;import isola.helpers.JsHelper;import isola.model.ext.base.Observable;/** *  * <p> * This class is an abstract base class for implementations which provide * retrieval *  * of unformatted data objects. * </p> *  *  *  * <p> * DataProxy implementations are usually used in conjunction with an * implementation of *  * Ext.data.DataReader (of the appropriate type which knows how to parse the * data object) *  * to provide a block of Ext.data.Records to an Ext.data.Store. * </p> *  *  *  * <p> * Custom implementations must implement the load method as described in *  * Ext.data.HttpProxy.load. * </p> *  *  *  * @author Umut Gokbayrak */public class DataProxy extends Observable {	private static final long serialVersionUID = -7676791220469540030L;	private static final String TAG = "Ext.data.DataProxy";		@Override	protected void _postProcessToString() {		super._postProcessToString();	}		@Override	public String toString() {		_postProcessToString();		return "new " + TAG + "(" + JsHelper.printJsObject(this) + ")";	}}