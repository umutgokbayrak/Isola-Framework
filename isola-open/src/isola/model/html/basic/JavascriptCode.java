package isola.model.html.basic;import isola.constants.MimeTypes;public abstract class JavascriptCode extends Script {	/**	 * 	 * Default constructor	 */	public JavascriptCode() {		super(MimeTypes.text_javascript);	}		/**	 * 	 * This method must be implemented by all scripts.	 */	public abstract String getCode();}