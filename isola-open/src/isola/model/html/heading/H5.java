package isola.model.html.heading;import isola.helpers.ElementParserHtml;import isola.model.html.core.Container;/** *  *  *  * @author Umut Gokbayrak *  *  */public class H5 extends Container {	private static final String tag = "h5";	/**	 * 	 * @deprecated This attribute specifies the position of an IMG, OBJECT, or	 *             APPLET with respect to its context.	 * 	 *             The following values for align concern the object's position	 *             with respect to surrounding text:	 * 	 *             <ul>	 * 	 *             <li>bottom: means that the bottom of the object should be	 *             vertically aligned with	 * 	 *             the current baseline. This is the default value.</li>	 * 	 *             <li>middle: means that the center of the object should be	 *             vertically aligned with	 * 	 *             the current baseline.</li>	 * 	 *             <li>top: means that the top of the object should be	 *             vertically aligned with the	 * 	 *             top of the current text line.</li>	 * 	 *             </ul>	 * 	 * 	 * 	 *             Two other values, left and right, cause the image to float to	 *             the current left or right margin.	 */	private String align;		public H5() {		super();		setId(tag + (Math.random() * 1000));	}		public H5(String id) {		super(id);	}		public H5(String id, String value) {		super(id);		addChild(value);	}		public String getAlign() {		return align;	}		/**	 * 	 * @deprecated This attribute specifies the position of an IMG, OBJECT, or	 *             APPLET with respect to its context.	 * 	 *             The following values for align concern the object's position	 *             with respect to surrounding text:	 * 	 *             <ul>	 * 	 *             <li>bottom: means that the bottom of the object should be	 *             vertically aligned with	 * 	 *             the current baseline. This is the default value.</li>	 * 	 *             <li>middle: means that the center of the object should be	 *             vertically aligned with	 * 	 *             the current baseline.</li>	 * 	 *             <li>top: means that the top of the object should be	 *             vertically aligned with the	 * 	 *             top of the current text line.</li>	 * 	 *             </ul>	 * 	 * 	 * 	 *             Two other values, left and right, cause the image to float to	 *             the current left or right margin.	 * 	 * 	 * 	 * @param align	 */	public void setAlign(String align) {		this.align = align;	}		@Override	public String toString() {		return ElementParserHtml.getToStringOut(this);	}		public String getTag() {		return tag;	}}