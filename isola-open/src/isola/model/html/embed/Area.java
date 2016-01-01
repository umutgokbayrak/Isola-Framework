package isola.model.html.embed;import isola.helpers.ElementParserHtml;import isola.helpers.JsGenerator;import isola.model.html.core.Container;/** *  *  *  * @author Umut Gokbayrak *  *  */public class Area extends Container {	private static final String tag = "area";	/**	 * 	 * @deprecated This attribute specifies the position of an IMG, OBJECT, or	 *             APPLET with respect to its context.	 * 	 *             The following values for align concern the object's position	 *             with respect to surrounding text:	 * 	 *             <ul>	 * 	 *             <li>bottom: means that the bottom of the object should be	 *             vertically aligned with	 * 	 *             the current baseline. This is the default value.</li>	 * 	 *             <li>middle: means that the center of the object should be	 *             vertically aligned with	 * 	 *             the current baseline.</li>	 * 	 *             <li>top: means that the top of the object should be	 *             vertically aligned with the	 * 	 *             top of the current text line.</li>	 * 	 *             </ul>	 * 	 * 	 * 	 *             Two other values, left and right, cause the image to float to	 *             the current left or right margin.	 */	private String align;	/**	 * 	 * For user agents that cannot display images, forms, or applets, this	 * attribute specifies	 * 	 * alternate text. The language of the alternate text is specified by the	 * lang attribute.	 */	private String alt;	/**	 * 	 * This attribute specifies the position and shape on the screen. The number	 * and order of	 * 	 * values depends on the shape being defined. Possible combinations:	 * 	 * <ul>	 * 	 * <li>rect: left-x, top-y, right-x, bottom-y.</li>	 * 	 * <li>circle: center-x, center-y, radius. Note. When the radius value is a	 * percentage value,	 * 	 * user agents should calculate the final radius value based on the	 * associated object's	 * 	 * width and height. The radius should be the smaller value of the two.</li>	 * 	 * <li>poly: x1, y1, x2, y2, ..., xN, yN. The first x and y coordinate pair	 * and the last	 * 	 * should be the same to close the polygon. When these coordinate values are	 * not the same,	 * 	 * user agents should infer an additional coordinate pair to close the	 * polygon.</li>	 * 	 * </ul>	 * 	 * 	 * 	 * Coordinates are relative to the top, left corner of the object. All	 * values are lengths.	 * 	 * All values are separated by commas.	 */	private String coords;	/**	 * 	 * This attribute specifies the location of a Web resource, thus defining a	 * link between	 * 	 * the current element (the source anchor) and the destination anchor	 * defined by	 * 	 * this attribute.	 */	private String href;	/**	 * 	 * When set, this boolean attribute specifies that a region has no	 * associated link.	 */	private String noHref;	/**	 * 	 * The onblur event occurs when an element loses focus either by the	 * pointing device or	 * 	 * by tabbing navigation. It may be used with the same elements as onfocus.	 */	private String onBlur;	/**	 * 	 * The onfocus event occurs when an element receives focus either by the	 * pointing device	 * 	 * or by tabbing navigation. This attribute may be used with the following	 * elements:	 * 	 * A, AREA, LABEL, INPUT, SELECT, TEXTAREA, and BUTTON.	 */	private String onFocus;	/**	 * 	 * This attribute specifies the shape of a region. Possible values:	 * 	 * <ul>	 * 	 * <li>default: Specifies the entire region.</li>	 * 	 * <li>rect: Define a rectangular region.</li>	 * 	 * <li>circle: Define a circular region.</li>	 * 	 * <li>poly: Define a polygonal region.</li>	 * 	 * </ul>	 */	private String shape;	/**	 * 	 * This attribute specifies the position of the current element in the	 * tabbing order	 * 	 * for the current document. This value must be a number between 0 and	 * 32767.	 * 	 * User agents should ignore leading zeros.	 */	private String tabIndex;	/**	 * 	 * This attribute specifies the name of a frame where a document is to be	 * opened.	 */	private String target;	/**	 * 	 * This attribute assigns an access key to an element. An access key is a	 * single	 * 	 * character from the document character set. Note. Authors should consider	 * the	 * 	 * input method of the expected reader when specifying an accesskey.	 */	private String accessKey;		public Area() {		super();	}		public Area(String href, String title, String alt, String shape, String coords) {		super();		setHref(href);		setTitle(title);		setAlt(alt);		setShape(shape);		setCoords(coords);	}		public String getAlign() {		return align;	}		/**	 * 	 * @deprecated This attribute specifies the position of an IMG, OBJECT, or	 *             APPLET with respect to its context.	 * 	 *             The following values for align concern the object's position	 *             with respect to surrounding text:	 * 	 *             <ul>	 * 	 *             <li>bottom: means that the bottom of the object should be	 *             vertically aligned with	 * 	 *             the current baseline. This is the default value.</li>	 * 	 *             <li>middle: means that the center of the object should be	 *             vertically aligned with	 * 	 *             the current baseline.</li>	 * 	 *             <li>top: means that the top of the object should be	 *             vertically aligned with the	 * 	 *             top of the current text line.</li>	 * 	 *             </ul>	 * 	 * 	 * 	 *             Two other values, left and right, cause the image to float to	 *             the current left or right margin.	 * 	 * 	 * 	 * @param align	 */	public void setAlign(String align) {		this.align = align;	}		public String getAlt() {		return alt;	}		/**	 * 	 * For user agents that cannot display images, forms, or applets, this	 * attribute specifies	 * 	 * alternate text. The language of the alternate text is specified by the	 * lang attribute.	 * 	 * 	 * 	 * @param alt	 */	public void setAlt(String alt) {		this.alt = alt;	}		public String getCoords() {		return coords;	}		/**	 * 	 * This attribute specifies the position and shape on the screen. The number	 * and order of	 * 	 * values depends on the shape being defined. Possible combinations:	 * 	 * <ul>	 * 	 * <li>rect: left-x, top-y, right-x, bottom-y.</li>	 * 	 * <li>circle: center-x, center-y, radius. Note. When the radius value is a	 * percentage value,	 * 	 * user agents should calculate the final radius value based on the	 * associated object's	 * 	 * width and height. The radius should be the smaller value of the two.</li>	 * 	 * <li>poly: x1, y1, x2, y2, ..., xN, yN. The first x and y coordinate pair	 * and the last	 * 	 * should be the same to close the polygon. When these coordinate values are	 * not the same,	 * 	 * user agents should infer an additional coordinate pair to close the	 * polygon.</li>	 * 	 * </ul>	 * 	 * 	 * 	 * Coordinates are relative to the top, left corner of the object. All	 * values are lengths.	 * 	 * All values are separated by commas.	 * 	 * 	 * 	 * @param coords	 */	public void setCoords(String coords) {		this.coords = coords;	}		public String getHref() {		return href;	}		/**	 * 	 * This attribute specifies the location of a Web resource, thus defining a	 * link between	 * 	 * the current element (the source anchor) and the destination anchor	 * defined by	 * 	 * this attribute.	 * 	 * 	 * 	 * @param href	 */	public void setHref(String href) {		this.href = href;	}		public String getNoHref() {		return noHref;	}		/**	 * 	 * When set, this boolean attribute specifies that a region has no	 * associated link.	 * 	 * 	 * 	 * @param noHref	 */	public void setNoHref(String noHref) {		this.noHref = noHref;	}		public String getOnBlur() {		return onBlur;	}		/**	 * 	 * The onblur event occurs when an element loses focus either by the	 * pointing device or	 * 	 * by tabbing navigation. It may be used with the same elements as onfocus.	 * 	 * 	 * 	 * @param onBlur	 */	public void setOnBlur(String onBlur) {		this.onBlur = onBlur;	}		public String getOnFocus() {		return onFocus;	}		/**	 * 	 * The onfocus event occurs when an element receives focus either by the	 * pointing device	 * 	 * or by tabbing navigation. This attribute may be used with the following	 * elements:	 * 	 * A, AREA, LABEL, INPUT, SELECT, TEXTAREA, and BUTTON.	 * 	 * 	 * 	 * @param onFocus	 */	public void setOnFocus(String onFocus) {		this.onFocus = onFocus;	}		public String getShape() {		return shape;	}		/**	 * 	 * This attribute specifies the shape of a region. Possible values:	 * 	 * <ul>	 * 	 * <li>default: Specifies the entire region.</li>	 * 	 * <li>rect: Define a rectangular region.</li>	 * 	 * <li>circle: Define a circular region.</li>	 * 	 * <li>poly: Define a polygonal region.</li>	 * 	 * </ul>	 * 	 * 	 * 	 * @param shape	 */	public void setShape(String shape) {		this.shape = shape;	}		public String getTabIndex() {		return tabIndex;	}		/**	 * 	 * This attribute specifies the position of the current element in the	 * tabbing order	 * 	 * for the current document. This value must be a number between 0 and	 * 32767.	 * 	 * User agents should ignore leading zeros.	 * 	 * 	 * 	 * @param tabIndex	 */	public void setTabIndex(String tabIndex) {		this.tabIndex = tabIndex;	}		public String getTarget() {		return target;	}		/**	 * 	 * This attribute specifies the name of a frame where a document is to be	 * opened.	 * 	 * 	 * 	 * @param target	 */	public void setTarget(String target) {		this.target = target;	}		public String getAccessKey() {		return accessKey;	}		/**	 * 	 * This attribute assigns an access key to an element. An access key is a	 * single	 * 	 * character from the document character set. Note. Authors should consider	 * the	 * 	 * input method of the expected reader when specifying an accesskey.	 * 	 * 	 * 	 * @param accessKey	 */	public void setAccessKey(String accessKey) {		this.accessKey = accessKey;	}		@Override	public String toString() {		return ElementParserHtml.getToStringOut(this);	}		public String getTag() {		return tag;	}		/**	 * 	 * To set the focus on the element. It will only work for form input	 * elements.	 * 	 * 	 * 	 * @throws Exception	 */	public void focus() throws Exception {		getJsOut().append(JsGenerator.focus(this.getId()));	}}