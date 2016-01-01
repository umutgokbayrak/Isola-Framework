package isola.model.html.basic;import isola.constants.MimeTypes;import isola.model.html.core.Element;/** *  *  *  * @author Umut Gokbayrak *  *  */public abstract class Style extends Element {	protected static final String tag = "style";	/**	 * 	 * This attribute specifies the intended destination medium for style	 * information.	 * 	 * It may be a single media descriptor or a comma-separated list. The	 * default	 * 	 * value for this attribute is "screen".	 */	private String media;	/**	 * 	 * This attribute specifies the style sheet language of the element's	 * contents	 * 	 * and overrides the default style sheet language. The style sheet language	 * is	 * 	 * specified as a content type (e.g., "text/css"). Authors must supply a	 * value	 * 	 * for this attribute; there is no default value for this attribute.	 * 	 * 	 * 	 * @see MimeTypes	 */	private String type;		public Style() {		super();		setType(MimeTypes.text_css);	}		public String getMedia() {		return media;	}		/**	 * 	 * This attribute specifies the intended destination medium for style	 * information.	 * 	 * It may be a single media descriptor or a comma-separated list. The	 * default	 * 	 * value for this attribute is "screen".	 * 	 * 	 * 	 * @param media	 */	public void setMedia(String media) {		this.media = media;	}		public String getType() {		return type;	}		/**	 * 	 * This attribute specifies the style sheet language of the element's	 * contents	 * 	 * and overrides the default style sheet language. The style sheet language	 * is	 * 	 * specified as a content type (e.g., "text/css"). Authors must supply a	 * value	 * 	 * for this attribute; there is no default value for this attribute.	 * 	 * 	 * 	 * @see MimeTypes	 * 	 * @param type	 */	public void setType(String type) {		this.type = type;	}		@Override	public String toString() {		return "<style type=\"text/css\">" + getCode() + "</style>";	}		public abstract String getTag();		/**	 * 	 * This method must be implemented by all scripts.	 */	public abstract String getCode();}