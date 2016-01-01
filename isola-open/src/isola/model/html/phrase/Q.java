package isola.model.html.phrase;import isola.helpers.ElementParserHtml;import isola.model.html.core.Container;/** *  *  *  * @author Umut Gokbayrak *  *  */public class Q extends Container {	private static final String tag = "q";		public Q() {		super();		setId(tag + (Math.random() * 1000));	}		public Q(String id) {		super(id);	}		/**	 * 	 * The value of this attribute is a URI that designates a source document or	 * message.	 * 	 * This attribute is intended to give information about the source from	 * which the	 * 	 * quotation was borrowed.	 */	private String cite;		public String getTag() {		return tag;	}		public String getCite() {		return cite;	}		/**	 * 	 * The value of this attribute is a URI that designates a source document or	 * message.	 * 	 * This attribute is intended to give information about the source from	 * which the	 * 	 * quotation was borrowed.	 * 	 * 	 * 	 * @param cite	 */	public void setCite(String cite) {		this.cite = cite;	}		@Override	public String toString() {		return ElementParserHtml.getToStringOut(this);	}}